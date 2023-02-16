package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: putuo
 * @description: 首页数据接口
 * @author: hui
 * @create: 2023-02-16 10:39
 **/

@RestController
@RequestMapping("/index")
public class IndexController {
    /** 
    * @Description: 当天top20新词热词
    * @Param: 
    * @return: 
    * @Author: hui
    * @Date: 2023/2/16
    */
    @PostMapping("new-hot-word-top20")
    public JSONObject newWordHotWord(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_CSFW_DTXCTOP20_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }
}
