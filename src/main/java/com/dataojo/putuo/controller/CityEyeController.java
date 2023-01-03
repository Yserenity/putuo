package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/city-eye")
public class CityEyeController {
    @GetMapping("/first-menu")
    public JSONObject firstMenu(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668757277096";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    @PostMapping("/video-list")
    public JSONObject videoList(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DB_WGGL_ZSZY_ZTFLSPLB_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }
}
