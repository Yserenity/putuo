package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.common.Result;
import com.dataojo.putuo.entity.Position;
import com.dataojo.putuo.util.InterTest;
import com.dataojo.putuo.util.ReadExcel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/map")
public class MapController {
    /**
    * @program:
    * @description:
    * @author: hlh
    * @date: 2022/10/17 19:22
    */
    @PostMapping
    public Result test(){
        Map map = new HashMap();
        List list1 = new ArrayList();
        List<Position> list  = ReadExcel.readExcel("C:\\Users\\胡崚晖\\Desktop\\test2.xls","");
        for (int i = 0; i < list.size(); i++){
            Position position = list.get(i);
            String s = "http://158.10.0.222/wk/proxy/Search/api/Address/Search?keyWord=" + position.getAddress() + "&pageSize=10&area=普陀区&pageIndex=5";
            JSONObject jsonObject = JSONObject.parseObject(InterTest.get(s,map));
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            if(jsonArray.size() > 0 ){
                position.setCoordx(jsonArray.getJSONObject(0).getString("originalX"));
                position.setCoordy(jsonArray.getJSONObject(0).getString("originalY"));
                list1.add(position);
            }
        }
    return Result.OK("",list1);
    }
}
