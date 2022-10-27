package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fire-fighting")
public class FireFightingController {
    /**
    * @program:
    * @description:接处警总览
    * @author: hlh
    * @date: 2022/10/27 11:32
    */
    @GetMapping("/police-count")
    public JSONObject policeCountOverview(HttpServletRequest request){
        String baseUrl = "http://156.0.15.2:9005/xfService/PTXF/getThisMonthPoliceInformation";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("startTime") != null){
            queryMap.put("startTime",request.getParameter("startTime"));
        }
        if (request.getParameter("endTime") != null){
            queryMap.put("endTime",request.getParameter("endTime"));
        }
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
        return jsonObject;
    }

    /**
    * @program:
    * @description:警情类型分布
    * @author: hlh
    * @date: 2022/10/27 11:36
    */
    @GetMapping("/police-type")
    public JSONObject policeTypeOverview(HttpServletRequest request){
        String baseUrl = "http://156.0.15.2:9005/xfService/PTXF/getFiveYearsPoliceInformation";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("street") != null){
            queryMap.put("street",request.getParameter("street"));
        }
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
        return jsonObject;
    }

    /**
    * @program:
    * @description:事件明细信息
    * @author: hlh
    * @date: 2022/10/27 11:38
    */
    @GetMapping("/police-info")
    public JSONObject policeInfoOverview(HttpServletRequest request){
        String baseUrl = "http://156.0.15.2:9005/xfService/alarm/getAlarmEntry";
        Map<String, String> queryMap = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
        return jsonObject;
    }

    /**
    * @program:
    * @description:起火TOP5
    * @author: hlh
    * @date: 2022/10/27 11:43
    */
    @GetMapping("/fire-risk-TOP5")
    public JSONObject fireRiskTop(HttpServletRequest request){
        String baseUrl = "http://156.0.15.2:9005/xfService/PTXF/getOneyearsFRCount";
        Map<String, String> queryMap = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
        return jsonObject;
    }

    /**
    * @program:
    * @description:各种类型每月的警情数量
    * @author: hlh
    * @date: 2022/10/27 11:57
    */
    @GetMapping("/alert-analyse")
    public JSONObject alertAnalyse(HttpServletRequest request){
        String baseUrl = "http://156.0.15.2:9005/xfService/PTXF/getTwoyearsFRCount";
        Map<String, String> queryMap = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
        return jsonObject;
    }
}
