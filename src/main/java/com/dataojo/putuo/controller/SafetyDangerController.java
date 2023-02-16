package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: putuo
 * @description: 安全隐患接口
 * @author: hui
 * @create: 2023-02-08 17:42
 **/

@RestController
@RequestMapping("/safety-production")
public class SafetyDangerController {
    /**
    * @Description:安全生产排查隐患清单
    * @Author: hui
    * @Date: 2023/2/8
    */
    @PostMapping("list")
    public JSONObject list(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_FL_GGAQ_PTQ_AQFXPCZZXX_LIST_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
    * @Description: 安全隐患概览-年
    * @Author: hui
    * @Date: 2023/2/8
    */
    @PostMapping("safety-danger-overview-year")
    public JSONObject safetyDangerOverviewYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853411162";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患企业top5-年
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-company-top5-year")
    public JSONObject dangerCompanyTop5Year(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853523713";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患分布-年
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-distribution-year")
    public JSONObject dangerDistributionYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853461825";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患街道分布-年
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-distribution-street-year")
    public JSONObject dangerDistributionStreetYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853494225";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患趋势-年
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-trend-year")
    public JSONObject dangerTrendYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853568426";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 安全生产概览-年
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("overview-year")
    public JSONObject overviewYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171675997927983";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患等级-年
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-level-year")
    public JSONObject dangerLevelYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171675864607756";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 上报隐患处置趋势-年
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("order-danger-trend-year")
    public JSONObject orderDangerTrendYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171675864633319";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患企业top5-月
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-company-top5-month")
    public JSONObject dangerCompanyTop5Month(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853305729";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患街道分布-月
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-distribution-street-month")
    public JSONObject dangerDistributionStreetMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853270642";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 安全隐患概览-月
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("safety-danger-overview-month")
    public JSONObject safetyDangerOverviewMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853214070";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患类型分布-月
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-type-street-month")
    public JSONObject dangerTypeStreetMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675853247355";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 安全生产概览-月
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("overview-month")
    public JSONObject overviewMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171675863593316";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 隐患数量top5公司-月
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-count-company-top5-month")
    public JSONObject dangerCountCompanyTop5Month(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171675864000813";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 企业自行上报隐患-月
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("danger-report-company-month")
    public JSONObject dangerReportCompanyMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171675863695267";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 安全生产概览-日
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("overview-day")
    public JSONObject overviewDay(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675860922981";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 企业自行上报隐患-日
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("company-report-danger-day")
    public JSONObject companyReportDangerDay(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161675861045748";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 企业自行上报隐患详情-日
     * @Author: hui
     * @Date: 2023/2/8
     */
    @PostMapping("company-report-danger-detail-day")
    public JSONObject companyReportDangerDetailDay(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/SDB_DB_GGAQ_QYZXSBAJXQ_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }
}
