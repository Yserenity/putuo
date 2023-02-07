package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: putuo
 * @description: 弹窗接口
 * @author: hui
 * @create: 2023-02-06 20:58
 **/

@RestController
@RequestMapping("/pop-up")
public class PopUpController {
    /** 
    * @Description: 部件大小类型
    * @Author: hui
    * @Date: 2023/2/6
    */
    @PostMapping("/unit")
    public JSONObject unit(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/CDB_FL_DZ_BJDXL_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }

    /**
     * @Description: 街道乡镇
     * @Author: hui
     * @Date: 2023/2/6
     */
    @PostMapping("/street")
    public JSONObject street(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/CDB_FL_DZ_JDXZ_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }

    /**
     * @Description: 居委会
     * @Author: hui
     * @Date: 2023/2/6
     */
    @PostMapping("/neighborhood")
    public JSONObject neighborhood(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/CDB_FL_DZ_JWH_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }

    /**
     * @Description: 责任网格
     * @Author: hui
     * @Date: 2023/2/6
     */
    @PostMapping("/duty-grid")
    public JSONObject dutyGrid(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/CDB_FL_WGGL_ZRWG_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }

}
