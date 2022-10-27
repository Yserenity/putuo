package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/camera")
public class CameraController {
    /**
    * @program:
    * @description:
    * @author: hlh
    * @date: 2022/10/26 13:43
    */
    @PostMapping("/test")
    public JSONObject population(HttpServletResponse response){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_GGAQ_JCDWSP_A_D/v1";
        String data = "";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,data));
        return jsonObject;
    }
}
