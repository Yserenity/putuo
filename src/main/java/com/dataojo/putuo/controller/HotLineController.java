package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hot-line")
public class HotLineController {
    /**
     * 工单分布街道柱状图-日
     * @return
     */
    @PostMapping("/order-distribution-street-histogram-day")
    public JSONObject orderDistributionStreetHistogramDay(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161669257384878";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 工单类型TOP5-日
     * @return
     */
    @PostMapping("/order-type-top5-day")
    public JSONObject orderTypeTop5Day(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161669257437629";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 工单类型分布街道-日
     * @return
     */
    @PostMapping("/order-type-distribution-street-day")
    public JSONObject orderTypeDistributionStreetDay(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_CSFW_SMRXAJTJB_XZ_D_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    /**
     * 工单受理趋势小时-日
     * @return
     */
    @PostMapping("/order-acceptance-tendency-hour-day")
    public JSONObject orderAcceptanceTendencyHourDay(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_CSFW_RGDSLQS_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    /**
     * 工单处置概览-日
     * @return
     */
    @PostMapping("/order-dispose-overview-day")
    public JSONObject orderDisposeOverviewDay(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161669257341220";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 委办5率统计-月
     * @return
     */
    @PostMapping("/charter-5rate-total-month")
    public JSONObject charter5RateTotalMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171669272394467";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 街镇5率统计-月
     * @return
     */
    @PostMapping("/street-5rate-total-month")
    public JSONObject street5RateTotalMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171669272508513";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 委办受理分布-月
     * @return
     */
    @PostMapping("/charter-dispose-distribution-month")
    public JSONObject charterDisposeDistributionMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171669271824663";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 街镇受理分布-月
     * @return
     */
    @PostMapping("/street-dispose-distribution-month")
    public JSONObject streetDisposeDistributionMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171669271945592";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 热线工单类型-月
     * @return
     */
    @PostMapping("/hotline-order-type-month")
    public JSONObject hotlineOrderTypeMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171669271565482";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 热线工单类型街道TOP5-月
     * @return
     */
    @PostMapping("/hotline-order-type-street-top5-month")
    public JSONObject hotlineOrderTypeStreetTop5Month(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/SDB_STS_CSFW_SMRXAJTJB_XZ_M_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    /**
     * 市民热线-月
     * @return
     */
    @PostMapping("/citizen-hot-line-month")
    public JSONObject citizenHotLineMonth(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171669272247892";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 工单类型TOP5-年
     * @return
     */
    @PostMapping("/order-type-top5-year")
    public JSONObject orderTypeTop5Year(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669269455922";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 街道趋势图-年
     * @return
     */
    @PostMapping("/tendencyChart-street-year")
    public JSONObject tendencyChartStreetYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669269254838";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 街道受理分布-年
     * @return
     */
    @PostMapping("/dispose-distribution-street-year")
    public JSONObject disposeDistributionStreetYear(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669269317946";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 工单类型街道-年
     * @return
     */
    @PostMapping("/order-type-street-year")
    public JSONObject orderTypeStreetYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_CSFW_SMRXAJTJB_XZ_Y_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    /**
     * 市民热线-年
     * @return
     */
    @PostMapping("/citizen-hot-line-year")
    public JSONObject citizenHotLineYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669269050413";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 委办趋势图-年
     * @return
     */
    @PostMapping("/charter-tendencyChart-year")
    public JSONObject charterTendencyChartYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669269176289";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 委办受理分布-年
     * @return
     */
    @PostMapping("/charter-dispose-distribution-year")
    public JSONObject charterDisposesDistributionYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669269354529";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 一级页面数据信息
     * @param request
     * @return
     */
    @PostMapping("/index")
    public JSONObject index(HttpServletRequest request){
        String baseUrl = "http://156.0.15.36:8080/api/th1/monitor/theme/count";
        return JSONObject.parseObject(InterTest.getResponseByMingzhu(baseUrl,InterTest.readRequestStream(request)));
    }

    /**
     * 热线撒点-日
     * @param request
     * @return
     */
    @PostMapping("/hotline-point-day")
    public JSONObject hotlinePointDay(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/SDB_DTL_CSFW_DRAJLBMX_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    /**
     * 热线基线-年
     * @param request
     * @return
     */
    @PostMapping("/hotline-base-line-year")
    public JSONObject hotlineBaseLineYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DB_RXGL_SMRXCZL_2021NJS_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }
}
