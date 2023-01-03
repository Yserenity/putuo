package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.common.Result;
import com.dataojo.putuo.entity.CaseHistogram;
import com.dataojo.putuo.entity.GridCollectYear;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grid")
public class GridController {

    @PostMapping("/street-area-rank")
    public JSONObject streetAreaRank(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DB_WGGL_WGPQJZPM_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    @PostMapping("/area-rank")
    public JSONObject areaRank(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DB_WGGL_WGPQPM_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    @PostMapping("/annual-mean-data")
    public JSONObject annualMeanData(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DB_WGGL_WGSJNDPJZSJ_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }

    /**
     * 日-案件上报概览
     * @param request
     */
    @PostMapping("/case-report-overview")
    public JSONObject caseReportOverview(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668849373917";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

//    /**
//     * 日-案件受理情况_街道
//     * @param request
//     */
//    @PostMapping("/case-acceptance-status-street")
//    public JSONObject caseAcceptanceStatusStreet(HttpServletRequest request){
//        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668850481912";
//        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
//    }
//
//    /**
//     * 日-案件受理总数_委办
//     * @param request
//     */
//    @PostMapping("/case-acceptance-total-charter")
//    public JSONObject caseAcceptanceTotal(HttpServletRequest request){
//        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668850302667";
//        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
//    }

    /**
     * 案件受理概览-日
     * @param request
     * @return
     */
    @PostMapping("/case-dispose-overview-day")
    public JSONObject caseDisposeOverviewDay(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161669375169497";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 日-案件上报情况柱状图_街镇
     * @param request
     */
    @PostMapping("/case-report-status-histogram")
    public JSONObject caseReportStatusHistogram(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668851050830";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 日-受理案件分类top10
     * @param request
     */
    @PostMapping("/case-acceptance-top10")
    public JSONObject caseAcceptanceTOP10(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668850899232";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

//    /**
//     * 日-案件受理情况柱状图-委办
//     * @param request
//     */
//    @PostMapping("/case-acceptance-status-histogram-charter")
//    public JSONObject caseAcceptanceStatusHistogramCharter(HttpServletRequest request){
//        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668851286983";
//        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
//    }

//    /**
//     * 日-案件受理情况柱状图
//     * @param request
//     */
//    @PostMapping("/case-acceptance-status-histogram")
//    public JSONObject caseAcceptanceStatusHistogram(HttpServletRequest request){
//        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161668851173923";
//        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
//    }

    /**
     * 日-案件受理情况柱状图-总
     * @param request
     */
    @PostMapping("/case-acceptance-status-histogram-total-day")
    public Result<List> caseAcceptanceStatusHistogramTotalDay(HttpServletRequest request){
        //0全部，1街镇，2委办
        String type = JSONObject.parseObject(InterTest.readRequestStream(request)).getString("type");
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare161669375464091";
        JSONArray array = JSONObject.parseObject(InterTest.getResponse(baseUrl,"")).getJSONArray("data");
        List<CaseHistogram> list = array.toJavaList(CaseHistogram.class);
        List result = list.stream().filter(a -> a.getBZ_ZD().equals(type)).collect(Collectors.toList());
        return Result.OK("",result);
    }

    /**
     * 月-街道案件及时结案率
     * @param request
     */
    @PostMapping("/case-timely-closure-rate-street-month")
    public JSONObject caseTimelyClosureRateStreetMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669012012659";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 月-街道案件及时结案率趋势图
     * @param request
     */
    @PostMapping("/case-timely-closure-rate-street-tendencyChart-month")
    public JSONObject caseTimelyClosureRateStreetTendencyChartMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669012639872";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 月-街道案件处置情况
     * @param request
     */
    @PostMapping("/case-dispose-status-street-month")
    public JSONObject caseDisposeStatusStreetMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669011929658";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }
    /**
     * 月-委办局案件及时结案率排行
     * @param request
     */
    @PostMapping("/case-timely-closure-rate-rank-charter-month")
    public JSONObject caseTimelyClosureRateRankCharterMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669011868065";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }
    /**
     * 月-委办案件及时结案率趋势图
     * @param request
     */
    @PostMapping("/case-timely-closure-rate-charter-tendencyChart-month")
    public JSONObject caseTimelyClosureRateCharterTendencyChartMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669012603389";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }
    /**
     * 月-委办案件处置情况
     * @param request
     */
    @PostMapping("/case-dispose-status-charter-month")
    public JSONObject caseDisposeStatusCharterMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669011814233";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }
    /**
     * 月-案件上报情况
     * @param request
     */
    @PostMapping("/case-report-status-month")
    public JSONObject caseReportStatusMonth(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare171670411132752";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }
    /**
     * 年-街道案件及时结案率排行
     * @param request
     */
    @PostMapping("/case-timely-closure-rate-street-rank-year")
    public JSONObject caseTimelyClosureRateStreetRankYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669000792170";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-案件上报分布
     * @param request
     */
    @PostMapping("/case-report-distribution-year")
    public JSONObject caseReportDistributionYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669000439366";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-案件上报趋势图
     * @param request
     */
    @PostMapping("/case-report-tendencyChart-year")
    public JSONObject caseReportTendencyChartYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669000379964";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-委办局案件及时结案率排行
     * @param request
     */
    @PostMapping("/case-timely-closure-rate-rank-charter-year")
    public JSONObject caseTimelyClosureRateRankCharterYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669000750386";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-街镇案件处置率趋势图
     * @param request
     */
    @PostMapping("/case-dispose-rate-tendencyChart-year")
    public JSONObject caseDisposeRateTendencyChartYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669000698671";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-上报案件概览
     * @param request
     */
    @PostMapping("/case-report-overview-year")
    public JSONObject caseReportOverviewYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669000054192";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-委办案件处置率趋势图
     * @param request
     */
    @PostMapping("/case-dispose-rate-tendencyChart-charter-year")
    public JSONObject caseDisposeRateTendencyChartCharterYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669000645099";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-标准案件排名
     * @param request
     */
    @PostMapping("/standard-case-rank-year")
    public JSONObject standardCaseRankYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669379031735";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-其他案件排名
     * @param request
     */
    @PostMapping("/other-case-rank-year")
    public JSONObject otherCaseRankYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669379085030";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    /**
     * 年-上报案件排名
     * @param request
     */
    @PostMapping("/dispose-case-rank-year")
    public JSONObject disposeCaseRankYear(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361669378938113";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }

    @PostMapping("/collect-data-year")
    public Result<List> collectDataYear(HttpServletRequest request){
        JSONObject jsonObject = JSONObject.parseObject(InterTest.readRequestStream(request));
        //0全部，1街镇，2委办
        String type = jsonObject.getString("type");
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_SDB_STS_CSFW_WGXCAJB_Y_ZH_A_D/v1";
        jsonObject.remove("type");
        JSONArray array = JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toString())).getJSONArray("data");
        List<GridCollectYear> list = array.toJavaList(GridCollectYear.class);
        List result = list.stream().filter(a -> a.getBZ_ZD().equals(type)).collect(Collectors.toList());
        return Result.OK("",result);
    }

    /**
     * 日-网格明细
     * @param request
     */
    @PostMapping("/grid-detail-day")
    public JSONObject gridDetailDay(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/SDB_DTL_CSFW_DRWGAJMX_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,InterTest.readRequestStream(request)));
    }


    /**
     * 季-网格巡查一级指标
     * @param request
     */
    @PostMapping("/grid-fisrt-quarter")
    public JSONObject gridFirstQuarter(HttpServletRequest request){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/cityos/hue/v1/datashare/exec/datashare361670321318986";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,""));
    }
}
