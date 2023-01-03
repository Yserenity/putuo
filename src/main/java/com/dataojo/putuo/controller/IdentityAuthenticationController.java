package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/identity")
public class IdentityAuthenticationController {
    /**
     * 验证token正确性
     * @param request
     * @return
     */
    @GetMapping("/unified-portal")
    public JSONObject cityOperation(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/api/cityos/user/web/v2/open/authentication/token/validity";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("token") != null){
            queryMap.put("token",request.getParameter("token"));
        }
        JSONObject jsonObject = JSONObject.parseObject(InterTest.identityByGet(baseUrl,queryMap));
        return jsonObject;
    }
}
