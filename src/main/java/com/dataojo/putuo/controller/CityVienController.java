package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/city-vien")
public class CityVienController {
    /**
    * @program:
    * @description:城市之脉
    * @author: hlh
    * @date: 2022/10/26 14:08
    */
    @PostMapping
    public JSONObject cityVien(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_JTYS_CSZM_A_D_1/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
     * 拥堵道路top3
     * @param jsonObject
     * @return
     */
    @PostMapping("/congested-roads-TOP3")
    public JSONObject congestedRoadsTOP3(@RequestBody JSONObject jsonObject){
        String body = jsonObject.toJSONString();
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_JTYS_YDDLTOP3_A_D_BAK/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,body));
    }

    /**
     * 共享单车密度TOP3
     * @param jsonObject
     * @return
     */
    @PostMapping("/bike-sharing-TOP3")
    public JSONObject bikeSharingTOP3(@RequestBody JSONObject jsonObject){
        String body = jsonObject.toJSONString();
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DB_JTYS_HIST_BIKE_STATION_GD_A_D_1/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,body));
    }

    /**
     * 进出站人数TOP3
     * @param request
     * @return
     */
    @PostMapping("/arrivals-number-TOP3")
    public JSONObject arrivalsNumberTOP3(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DB_JTYS_HIST_RAILSTATION_FLOW_BYDAY_A_D_1/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /** 
    * @Description: 轨道站点数据天汇总
    * @Param: jsonObject
    * @return: jsonObject
    * @Author: hui
    * @Date: 2023/1/11
    */
    @PostMapping("/site-data-day")
    public JSONObject siteDataDay(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/SDB_DB_JTYS_HIST_RAILSTATION_5MFLOW_D_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }

    /** 
    * @Description: 轨道站点数据小时汇总
    * @Param: jsonObject
    * @return: jsonObject
    * @Author: hui
    * @Date: 2023/1/11
    */
    @PostMapping("/site-data-hour")
    public JSONObject siteDataHour(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DB_JTYS_HIST_RAILSTATION_5MFLOW_H_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }
}
