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
    public static String token = null;
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

    /**
    * @Description:获取token保持并返回
    * @Author: hui
    * @Date: 2023/2/8
    */
    @GetMapping("/get-token")
    public static Map<String,String> token(HttpServletRequest request){
        Map<String,String> map = new HashMap();
        if(request.getParameter("token") != null){
            if(request.getParameter("token").equals(IdentityAuthenticationController.token)){
                map.put("token",token);
                return map;
            }else{
                IdentityAuthenticationController.token = request.getParameter("token");
                map.put("token",token);
                return map;
            }
        }else if(token == null || "".equals(token)){
            map.put("message","无token");
        }
        map.put("token",token);
        return map;
    }
}
