package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
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
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_JTYS_CSZM_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
     * 拥堵道路top3
     * @param request
     * @return
     */
    @PostMapping("/congested-roads-TOP3")
    public JSONObject congestedRoadsTOP3(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_JTYS_YDDLTOP3_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
     * 共享单车密度TOP3
     * @param request
     * @return
     */
    @PostMapping("/bike-sharing-TOP3")
    public JSONObject bikeSharingTOP3(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DB_JTJ_HIST_BIKE_STATION_GD_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
     * 进出站人数TOP3
     * @param request
     * @return
     */
    @PostMapping("/arrivals-number-TOP3")
    public JSONObject arrivalsNumberTOP3(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DB_JTYS_HIST_RAILSTATION_FLOW_BYDAY_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }
}
