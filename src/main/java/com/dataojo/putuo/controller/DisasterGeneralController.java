package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: putuo
 * @description: 灾普接口
 * @author: hui
 * @create: 2023-02-24 14:49
 **/

@RestController
@RequestMapping("/disaster-general")
public class DisasterGeneralController {
    /** 
    * @Description: 保险和再保险企业减灾能力
    * @Param: 无参数
    * @return: json格式
    * @Author: hui
    * @Date: 2023/2/24
    */
    @PostMapping("/insurance-company")
    public JSONObject insuranceCompany(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_BXHZBXQYJZNL_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 大型商场
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/superstore")
    public JSONObject superstore(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSDXSC_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 公共文化场所
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/public-cultural-place")
    public JSONObject publicCulturalPlace(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSGGWHCS_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 加油加气加氢站
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/petrol-station")
    public JSONObject petrolStation(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_JYJQJJZ_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 救灾物资储备库
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/disaster-pool")
    public JSONObject disasterPool(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_JZWZCBK_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 旅游景区
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/tourist-attraction")
    public JSONObject touristAttraction(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSLYJQ_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 可燃物载量分布图
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/combustible-distribution")
    public JSONObject combustibleDistribution(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_PTQKRWZLFBT_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 普陀区重要火源点分布图
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/fire-position-distribution")
    public JSONObject firePositionDistribution(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_PTQZYHYDFBT_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 社会组织减灾能力
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/social-organization-reduce-disaster")
    public JSONObject socialOrganizationReduceDisaster(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_SHZZJZNL_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 社区行政村减灾能力
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/regime-reduce-disaster")
    public JSONObject regimeReduceDisaster(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_SQXZCJZNL_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 提供住宿的社会服务机构
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/accommodate-social-organization")
    public JSONObject accommodateSocialOrganization(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSSHFWJG_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 体育场馆
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/stadium")
    public JSONObject stadium(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSTYCG_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 危化油气行业救援队伍与装备
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/oil-gas-rescue-team-and-equip")
    public JSONObject oilGasRescueTeamAndEquip(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_WHYQHYJYDWYZB_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 危险化学品企业
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/chemical-company")
    public JSONObject chemicalCompany(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_WXHXPQY_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 乡镇街道减灾能力
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/street-rescue")
    public JSONObject streetRescue(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_FL_YJGLJ_XZJDJZNL_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 星级酒店
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/starred-hotel")
    public JSONObject starredHotel(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSXJJD_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 学校
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/school")
    public JSONObject school(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSXX_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 医疗卫生机构
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/hospital")
    public JSONObject hospital(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSYLWSJG_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 应急避难场所
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/shelter")
    public JSONObject shelter(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_FL_YJGLJ_YJBNCS_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 政府灾害管理能力
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/government-disaster-manager")
    public JSONObject governmentDisasterManager(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_FL_YJGLJ_ZFZHGLNL_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 政府专职救援队伍
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/government-rescue")
    public JSONObject governmentRescue(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_FL_YJGLJ_ZFZZJYDW_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }

    /**
     * @Description: 宗教活动场所
     * @Param: 无参数
     * @return: json格式
     * @Author: hui
     * @Date: 2023/2/28
     */
    @PostMapping("/religion-stage")
    public JSONObject religionStage(){
        String baseUrl = "http://172.23.56.68/gatehub/rsdb_test-00001/api/datashare/share/api/RSDB_CDB_DTL_YJGLJ_GGFWSSZJHDCS_A_D/v1";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,null));
    }
}
