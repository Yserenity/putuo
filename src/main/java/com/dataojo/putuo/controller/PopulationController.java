package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/population")
//@CrossOrigin(origins = "http://localhost:8181")
public class PopulationController {
    @PostMapping("/test")
    public JSONObject population(HttpServletRequest request, HttpServletResponse response){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/CDB_DB_WGGL_POPULATION_MANAGE_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        System.out.println("a方法调用成功");
        return "1111";
    }
}
