package com.dataojo.putuo.configuration;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.common.Result;
import com.dataojo.putuo.controller.FireFightingController;
import com.dataojo.putuo.entity.Fire;
import com.dataojo.putuo.util.InterTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class StaticScheduleTask {

    private FireFightingController fireFightingController;

    public static Result result = null;

    public static Result fireList = null;
    @Scheduled(cron = "0 0 14/4 * * ?")
    public static Result fireFightingCount(){
        String baseUrl = "http://10.208.75.21:9005/xfService/PTXF/getFiveYearsPoliceInformationMonth";
        Map<String, String> queryMap = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
        //获取data
//        JSONObject jsonObject1 = JSONObject.parseObject("");
        Map<String,Object> map = new HashMap<>();
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        //循环获取社会救助、抢险救援、火警的数据
        jsonArray.stream().forEach(array->{
            JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(array);
            //按照yearAndMonth分组
            List<Fire> list = jsonObject1.getJSONArray("list").toJavaList(Fire.class);
            List<Fire> fireList = new ArrayList<>();
            //排序、分组、循环总和数量、添加
            list.stream().sorted(Comparator.comparing(Fire::getYearAndMonth))
                    .collect(Collectors.groupingBy(Fire::getYearAndMonth, Collectors.toList()))
                    .forEach((id,transfer)->{
                        transfer.stream()
                                .reduce((a,b)->new Fire(a.getYearAndMonth(),a.getCounts()+ b.getCounts(),null,a.getCaseType()))
                                .ifPresent(fireList::add);
                    });
            map.put(list.get(0).getCaseType(),fireList);
        });
        result = Result.OK("",map);
        return Result.OK("",map);
    }
}
