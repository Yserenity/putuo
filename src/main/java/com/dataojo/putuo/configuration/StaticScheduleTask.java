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

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class StaticScheduleTask {

    private FireFightingController fireFightingController;

    public static Result result = null;

    public static Result fireList = null;

    public static Result resultList = null;

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

    @Scheduled(cron = "0 2 14/4 * * ?")
    public Result policeCountByStreet(){
        //请求地址
        String baseUrl = "http://10.208.75.21:9005/xfService/PTXF/getFiveYearsPoliceInformationMonth";
        String[] strs = new String[]{"0705","0714","0715","0716","0717","0720","0721","0722","0723","0724"};
        //循环获取每个街镇的火警、抢险、社会救助的数量
        Map<String, String> queryMap = new HashMap();
        Map<String,Object> streetMap = new HashMap<>();
        List resultList = new ArrayList();
        //存储一个街镇的数据
        Arrays.stream(strs).forEach(s -> {
            Map<String,Object> map = new HashMap<>();
            queryMap.put("street",s);
            JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            jsonArray.stream().forEach(array ->{
                JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(array);
                List<Fire> list = jsonObject1.getJSONArray("list").toJavaList(Fire.class);
                int count = list.stream().filter(fire -> "2022".equals(fire.getYearAndMonth().substring(0,4)))
                        .map(Fire::getCounts)
                        .reduce((a,b) -> a + b)
                        .get();
                map.put(jsonObject1.getString("name"),count);
            });
            streetMap.put(s,map);
        });
        resultList.add(streetMap);
        StaticScheduleTask.resultList = Result.OK("",resultList);
        return StaticScheduleTask.resultList;
    }
}
