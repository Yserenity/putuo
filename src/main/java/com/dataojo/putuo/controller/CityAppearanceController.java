package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/city-appearance")
public class CityAppearanceController {
    /**
    * @program:
    * @description:调用处置力量
    * @author: hlh
    * @date: 2022/10/25 20:15
    */
    @PostMapping("/disposal-power")
    public JSONObject disposalPower(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_GGAQ_JDZB_A_D_DAMENG/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }
    /**
    * @program:
    * @description:街镇数据
    * @author: hlh
    * @date: 2022/10/26 13:58
    */
    @PostMapping("/street-down")
    public JSONObject streetDown(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/TDB_DTL_TSZL_CYZP_JTSJ_A_D_1/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }
    /**
    * @program:
    * @description:区域人口
    * @author: hlh
    * @date: 2022/10/26 14:02
    */
    @PostMapping("/area-population")
    public JSONObject areaPopulation(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/TDB_DTL_TSZL_CYZP_JTSJ_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }
}
