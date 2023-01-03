package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: putuo
 * @description: 智能搜索相关api
 * @author: hui
 * @create: 2022-12-26 14:39
 **/
@RestController
@RequestMapping("/AI-Searching")
public class AISearchingController {
    /**
    * @Description:地图综合全文检索
    * @Param:
    * @return:
    * @Author: hui
    * @Date: 2022/12/26
    */
    @PostMapping("/full-text-search")
    public JSONObject fullTextSearch(@RequestBody JSONObject jsonObject){
        String body = jsonObject.toJSONString();
        String baseUrl = "http://172.23.56.68/api/cityos/cityos-unidom-search/v1/mapxysearch/globalSearch";
        return JSONObject.parseObject(InterTest.getResponseByZhiSou(baseUrl,body));
    }

    /**
    * @Description:获取事件类型、案例类型及IOT类型下拉列表
    * @Param:
    * @return:
    * @Author: hui
    * @Date: 2022/12/27
    */
    @GetMapping("/drop-down-list")
    public JSONObject dropDownList(HttpServletRequest request){
        String code = request.getParameter("moduleCode");
        String type = null;
        Map<String, String> queryMap = new HashMap();
        if ("1".equals(code)){
            type = "m_event";
        }else if ("2".equals(code)){
            type = "m_iot";
        }else if ("3".equals(code)){
            type = "m_case";
        }
        String baseUrl = "http://172.23.56.68/api/cityos/cityos-unidom-search/v1/mapxysearch/mapBizTypeList/" + type;
        return JSONObject.parseObject(InterTest.getResponseByZhiSouGet(baseUrl,queryMap));
    }

    /** 
    * @Description: 详情搜索
    * @Param: 
    * @return: 
    * @Author: hui
    * @Date: 2022/12/27
    */
    @GetMapping("/detail-search")
    public JSONObject detailSearch(HttpServletRequest request){
        String code = request.getParameter("moduleCode");
        String type = null;
        String id = request.getParameter("esId");
        Map<String, String> queryMap = new HashMap();
        if ("1".equals(code)){
            type = "m_event";
        }else if ("2".equals(code)){
            type = "m_iot";
        }else if ("3".equals(code)){
            type = "m_case";
        }
        String baseUrl = "http://172.23.56.68/api/cityos/cityos-unidom-search/v1/mapxysearch/moduleDetail/" + type + "/" + id;
        return JSONObject.parseObject(InterTest.getResponseByZhiSouGet(baseUrl,queryMap));
    }

    /**
    * @Description: 模块检索
    * @Param:
    * @return:
    * @Author: hui
    * @Date: 2022/12/27
    */
    @GetMapping("/module-search")
    public JSONObject moduleSearch(@RequestBody JSONObject jsonObject,HttpServletRequest request){
        String body = jsonObject.toJSONString();
        String code = request.getParameter("moduleCode");
        String type = null;
        if ("1".equals(code)){
            type = "m_event";
        }else if ("2".equals(code)){
            type = "m_iot";
        }else if ("3".equals(code)){
            type = "m_case";
        }
        String baseUrl = "http://172.23.56.68/api/cityos/cityos-unidom-search/v1/mapxysearch/moduleSearch/" + type;
        return JSONObject.parseObject(InterTest.getResponseByZhiSou(baseUrl,body));
    }

    /** 
    * @Description: 地图近邻检索
    * @Param: 
    * @return: 
    * @Author: hui
    * @Date: 2022/12/27
    */
    @PostMapping("/neighbour-search")
    public JSONObject neighbourSearch(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/api/cityos/cityos-unidom-search/v1/mapxysearch/knnSearch";
        String body = jsonObject.toJSONString();
        return JSONObject.parseObject(InterTest.getResponseByZhiSou(baseUrl,body));
    }
}
