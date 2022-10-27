package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/city-police")
public class CityPoliceController {
    /**
    * @program:
    * @description:扫码异常
    * @author: hlh
    * @date: 2022/10/26 13:43
    */
    @PostMapping("/code-exception")
    public JSONObject codeException(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_YLWS_SMYCSJXX_A_D_2/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
    * @program:
    * @description:采样点核酸采送
    * @author: hlh
    * @date: 2022/10/26 13:53
    */
    @PostMapping("/sample-position")
    public JSONObject samplePosition(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_YLWS_CYDHSCSSJMX_A_D_MYXQL/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
    * @program:
    * @description:核酸异常
    * @author: hlh
    * @date: 2022/10/26 13:55
    */
    @PostMapping("/NAT-exception")
    public JSONObject natException(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_YLWS_PTHSYCSJXX_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
    * @program:
    * @description:疫情防控
    * @author: hlh
    * @date: 2022/10/26 14:00
    */
    @PostMapping("/epidemic-prevention")
    public JSONObject epidemicPrevention(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_STB_DTL_YLWS_YQFK_HSSJ_A_D_MYSQL/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
    * @program:
    * @description:城市之警
    * @author: hlh
    * @date: 2022/10/26 14:04
    */
    @PostMapping
    public JSONObject cityPolice(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_TDB_DTL_TSZL_CYZP_JTSJ_A_D_R_2/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }
}
