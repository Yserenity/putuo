package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.common.Result;
import com.dataojo.putuo.entity.StreetNATCount;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_STB_DTL_YLWS_SMYCSJXX_A_D/v1";
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
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_YLWS_CYDHSCSSJMX_A_D/v1";
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
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_YLWS_PTHSYCSJXX_A_D_dameng/v1";
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
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_YLWS_YQFK_HSSJ_A_D/v1";
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
//        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_TDB_DTL_TSZL_CYZP_JTSJ_A_D_R_2/v1";
//        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        String s = "{\n" +
                "    \"code\": 0,\n" +
                "    \"message\": \"success\",\n" +
                "     \"data\": [\n" +
                "        {\n" +
                "            \"FXYH\": \"754\",\n" +
                "            \"HJ\": \"39\",\n" +
                "            \"DATA_DATE\": \"20221020\",\n" +
                "            \"RDCY\": \"核酸检测、施工、政府、采样、幼儿园、学校、孩子、垃圾、噪音扰民\",\n" +
                "            \"XFZS\": \"116\",\n" +
                "            \"QZZZ\": \"47\",\n" +
                "            \"QXJY\": \"64\",\n" +
                "            \"YJZB\": \"城市之警\",\n" +
                "            \"ZLAJWL\": \"3557\",\n" +
                "            \"FXCD\": \"6\",\n" +
                "            \"ZGYH\": \"463\",\n" +
                "            \"JYAJ\": \"6062\",\n" +
                "            \"BZAJ\": \"4703\",\n" +
                "            \"SHAQ\": \"36\",\n" +
                "            \"YJZS\": \"110\",\n" +
                "            \"AISF\": \"1929\",\n" +
                "            \"JZTS\": \"23\",\n" +
                "            \"SGZN\": \"44\",\n" +
                "            \"YQXG\": \"15\",\n" +
                "            \"JXTS\": \"10\",\n" +
                "            \"JAL\": \"2.2363\",\n" +
                "            \"JSJAL\": \"3\",\n" +
                "            \"ZNYJZS\": \"5486\",\n" +
                "            \"PBAJ\": \"28\",\n" +
                "            \"ZGL\": \"170.16\",\n" +
                "            \"SHRDZS\": \"26\",\n" +
                "\t\"M_FXYH\": \"22624\",\n" +
                "            \"M_HJ\": \"1173\",\n" +
                "            \"M_XFZS\": \"3482\",\n" +
                "            \"M_QZZZ\": \"1411\",\n" +
                "            \"M_QXJY\": \"1925\",\n" +
                "            \"M_ZLAJWL\": \"106714\",\n" +
                "            \"M_FXCD\": \"187\",\n" +
                "            \"M_ZGYH\": \"13898\",\n" +
                "            \"M_SHQZ\": \"1959\",\n" +
                "            \"M_JYAJ\": \"181865\",\n" +
                "            \"M_BZAJ\": \"141096\",\n" +
                "            \"M_SHAQ\": \"1084\",\n" +
                "            \"M_YJZS\": \"3300\",\n" +
                "            \"M_AISF\": \"57873\",\n" +
                "            \"M_JZTS\": \"690\",\n" +
                "            \"M_SGZN\": \"1328\",\n" +
                "            \"M_YQXG\": \"457\",\n" +
                "            \"M_JXTS\": \"306\",\n" +
                "            \"M_JAL\": \"2.6795\",\n" +
                "            \"M_JSJAL\": \"3.3546\",\n" +
                "            \"M_ZNYJZS\": \"164582\",\n" +
                "            \"M_PBAJ\": \"841\",\n" +
                "            \"M_ZM_GL\": \"170.16\",\n" +
                "            \"M_SHRDZS\": \"782\",\n" +
                "\t\t\t\"Q_FXYH\": \"67862\",\n" +
                "            \"Q_HJ\": \"3511\",\n" +
                "            \"Q_XFZS\": \"10432\",\n" +
                "            \"Q_QZZZ\": \"4130\",\n" +
                "            \"Q_QXJY\": \"5766\",\n" +
                "            \"Q_ZLAJWL\": \"313002\",\n" +
                "            \"Q_FXCD\": \"553\",\n" +
                "            \"Q_ZGYH\": \"40981\",\n" +
                "            \"Q_SHQZ\": \"5580\",\n" +
                "            \"Q_JYAJ\": \"545586\",\n" +
                "            \"Q_BZAJ\": \"423277\",\n" +
                "            \"Q_SHAQ\": \"3341\",\n" +
                "            \"Q_YJZS\": \"9785\",\n" +
                "            \"Q_AISF\": \"173162\",\n" +
                "            \"Q_JZTS\": \"2017\",\n" +
                "            \"Q_SGZN\": \"3991\",\n" +
                "            \"Q_YQXG\": \"1355\",\n" +
                "            \"Q_JXTS\": \"963\",\n" +
                "            \"Q_JAL\": \"2.4651\",\n" +
                "            \"Q_Q_JSJAL\": \"3.1568\",\n" +
                "            \"Q_ZNYJZS\": \"493742\",\n" +
                "            \"Q_PBAJ\": \"2522\",\n" +
                "            \"Q_ZGL\": \"170.16\",\n" +
                "            \"Q_SHRDZS\": \"2634\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"detailMsg\": \"\",\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        return jsonObject;
    }

    /**
     * @program:
     * @description:工单明细
     * @author: hlh
     * @date: 2022/10/26 14:04
     */
    @PostMapping("/order-detail")
    public JSONObject orderDetail(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_ZWFW_DM_CSZP_GDMXSJ_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
     * @program:
     * @description:事件流程
     * @author: hlh
     * @date: 2022/10/26 14:04
     */
    @PostMapping("/issue-flow-count")
    public JSONObject issueFlowCount(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_CSFW_DM_PDSJSLTJ_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    @PostMapping("/street-chart")
    public Result streetNatCount(HttpServletRequest request){
        String baseUrl = "";
        List list = new ArrayList();
        String[] names = new String[]{"桃浦镇","真如镇街道","万里街道","长征镇","长风新村街道","曹杨新村街道","石泉路街道","甘泉路街道","长寿路街道","宜川路街道"};
        String[] coordxs = new String[]{"-10043.6097272015","-7327.3055928346","-6230.44013493727","-9016.28753766398","-6910.33404431796","-6097.87111489178","-4960.95897967728","-3838.06335208088","-3649.16488061092","-2908.1276238173"};
        String[] coordys = new String[]{"5229.7854004824","2457.47684004453","3884.41824051588","330.878321080696","-715.135870138399","624.469965525916","2052.79421195499","3499.4091445041","891.6977221791","2484.4069334443"};
        int[] counts = new int[]{202446,162501,150681,140681,128663,103429,99045,105469,128891,93603};
        Double[] times = new Double[]{4.15,4.36,4.67,4.97,5.12,5.33,5.75,6.01,6.11,6.43};
        for(int i = 0; i < names.length; i++){
            StreetNATCount streetNATCount = new StreetNATCount();
            streetNATCount.setSjzb(names[i]);
            streetNATCount.setCoordx(coordxs[i]);
            streetNATCount.setCoordy(coordys[i]);
            streetNATCount.setCount(counts[i]);
            streetNATCount.setTime(times[i]);
            list.add(streetNATCount);
        }
        return Result.OK("",list);
    }

    /**
     * @program:
     * @description:扫码异常柱状图
     * @author: hlh
     * @date: 2022/10/26 13:43
     */
    @PostMapping("/code-exception-month")
    public JSONObject codeExceptionMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_STB_STS_YLWS_SMYCSLXXB_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    /**
     * @description:街镇间隔时间
     * @param request
     * @return
     */
    @PostMapping("/street-interval-time")
    public JSONObject streetIntervalTime(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DTL_YLWS_JZHSCSJGSJ_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    @PostMapping("/NAT-count")
    public JSONObject natCount(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_YLWS_BYHSCYSLBHQS_A_D/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
        return jsonObject;
    }

    @PostMapping("/emergency-warning")
    public JSONObject emergencyWarning(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_DB_YJGL_YJSXXXB_D_A/v1";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
        return jsonObject;
    }
}
