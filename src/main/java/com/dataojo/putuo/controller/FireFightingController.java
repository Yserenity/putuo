package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.common.Result;
import com.dataojo.putuo.configuration.StaticScheduleTask;
import com.dataojo.putuo.entity.Fire;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fire-fighting")
public class FireFightingController {
    /**
    * @program:
    * @description:接处警总览
    * @author: hlh
    * @date: 2022/10/27 11:32
    */
    @GetMapping("/police-count")
    public JSONObject policeCountOverview(HttpServletRequest request){
        String baseUrl = "http://10.208.75.21:9002/xfService/PTXF/getThisMonthPoliceInformation";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("startTime") != null){
            queryMap.put("startTime",request.getParameter("startTime"));
        }
        if (request.getParameter("endTime") != null){
            queryMap.put("endTime",request.getParameter("endTime"));
        }
        return JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
    }

    /**
    * @program:
    * @description:警情类型分布
    * @author: hlh
    * @date: 2022/10/27 11:36
    */
    @GetMapping("/police-type")
    public JSONObject policeTypeOverview(HttpServletRequest request){
        String baseUrl = "http://10.208.75.21:9002/xfService/PTXF/getFiveYearsPoliceInformation";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("street") != null){
            queryMap.put("street",request.getParameter("street"));
        }
        return JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
    }

    /**
    * @program:
    * @description:事件明细信息
    * @author: hlh
    * @date: 2022/10/27 11:38
    */
    @GetMapping("/police-info")
    public JSONObject policeInfoOverview(HttpServletRequest request){
        String baseUrl = "http://10.208.75.21:9002/xfService/alarm/getAlarmEntry";
        Map<String, String> queryMap = new HashMap();
        if(!"".equals(request.getParameter("startTime"))){
            queryMap.put("startTime",request.getParameter("startTime"));
        }
        if(!"".equals(request.getParameter("endTime"))){
            queryMap.put("endTime",request.getParameter("endTime"));
        }
        //因为param的编码和格式问题，需要使用HttpClients的请求，而不能使用HttpURLConnection的请求
        JSONObject jsonObject = JSONObject.parseObject(InterTest.chineseByGet(baseUrl,queryMap));
        return jsonObject;
    }

    /**
    * @program:
    * @description:起火TOP5
    * @author: hlh
    * @date: 2022/10/27 11:43
    */
    @GetMapping("/fire-risk-TOP5")
    public JSONObject fireRiskTop(HttpServletRequest request){
        String baseUrl = "http://10.208.75.21:9002/xfService/PTXF/getOneyearsFRCount";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("code") != null){
            queryMap.put("code",request.getParameter("code"));
        }
        if (request.getParameter("street") != null){
            queryMap.put("street",request.getParameter("street"));
        }
        if (request.getParameter("startTime") != null){
            queryMap.put("startTime",request.getParameter("startTime").replace("$","+"));
        }
        if (request.getParameter("endTime") != null){
            queryMap.put("endTime",request.getParameter("endTime").replace("$","+"));
        }
        JSONObject jsonObject = JSONObject.parseObject(InterTest.chineseByGet(baseUrl,queryMap));
        return jsonObject;
    }

    /**
    * @program:
    * @description:各种类型每月的警情数量
    * @author: hlh
    * @date: 2022/10/27 11:57
    */
    @GetMapping("/alert-analyse")
    public JSONObject alertAnalyse(HttpServletRequest request){
        String baseUrl = "http://10.208.75.21:9002/xfService/PTXF/getTwoyearsFRCount";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("startTime") != null){
            queryMap.put("startTime",request.getParameter("startTime"));
        }
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
        return jsonObject;
    }

    /**
     * @description:本年各月警情数量
     * @return
     */
    @GetMapping("/police-type-count-month")
    public Result fireCountByMonth(){
        //定时任务，该接口响应慢，第一次请求后将结果数据放在内存当中
        Result result = StaticScheduleTask.result;
        if (result != null){
            return result;
        }else {
            String baseUrl = "http://10.208.75.21:9002/xfService/PTXF/getFiveYearsPoliceInformationMonth";
            Map<String, String> queryMap = new HashMap();
            JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
            //获取data
//        JSONObject jsonObject1 = JSONObject.parseObject("");
            Map<String,Object> map = new HashMap<>();
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            //获取当年年份
            String thisYear = new SimpleDateFormat("yyyy").format(new Date().getTime());
            //循环获取社会救助、抢险救援、火警的数据，筛选出当年的数据
            jsonArray.stream().forEach(array->{
                JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(array);
                //按照yearAndMonth分组
                List<Fire> list = jsonObject1.getJSONArray("list").toJavaList(Fire.class);
                List<Fire> fireList = new ArrayList<>();
                //排序、分组、循环总和数量、添加
                list.stream().filter(fire -> thisYear.equals(fire.getYearAndMonth().substring(0,4)))
                        .collect(Collectors.toList())
                        .stream()
                        .sorted(Comparator.comparing(Fire::getYearAndMonth))
                        .collect(Collectors.groupingBy(Fire::getYearAndMonth, Collectors.toList()))
                        .forEach((id,transfer)->{
                            transfer.stream()
                                    .reduce((a,b)->new Fire(a.getYearAndMonth(),a.getCounts()+ b.getCounts(),null,a.getCaseType()))
                                    .ifPresent(fireList::add);
                        });
                map.put(list.get(0).getCaseType(),fireList);
            });
            StaticScheduleTask.result = Result.OK("",map);
            return Result.OK("",map);
        }
    }

    @GetMapping("/police-count-month")
    public Result policCountByMonth(){
        //定时任务，该接口响应慢，第一次请求后将结果数据放在内存当中
        Result result = StaticScheduleTask.fireList;
        Map map = new HashMap();
        if(result != null){
            return result;
        }else{
            //获取'本年各月警情数量'接口的结果
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(fireCountByMonth());
            String[] strs = new String[]{"社会救助","抢险救援","火灾"};
            List<Fire> fireList = new ArrayList<>();
            int count = 0;
            //循环三个对象、获取每个数组的长度，求和
            for(int j = 0; j < strs.length; j++){
                for (int i = 0; i < jsonObject.getJSONObject("result").getJSONArray(strs[j]).size(); i++){
                    count = count + Integer.parseInt(jsonObject.getJSONObject("result").getJSONArray(strs[j]).getJSONObject(i).get("counts").toString());
                    fireList.add(new Fire((String) jsonObject.getJSONObject("result").getJSONArray(strs[0]).getJSONObject(i).get("yearAndMonth"),count,null,null));
                    count = 0;
                }
                map.put(strs[j],fireList);
                fireList = new ArrayList<>();
            }
            StaticScheduleTask.fireList = Result.OK("",fireList);
            return Result.OK("",map);
        }
    }

    @GetMapping("/police-count-by-street")
    public Result policeCountByStreet(){
        //请求地址
        String baseUrl = "http://10.208.75.21:9002/xfService/PTXF/getFiveYearsPoliceInformationMonth";
        String[] strs = new String[]{"0705","0714","0715","0716","0717","0720","0721","0722","0723","0724"};
        //循环获取每个街镇的火警、抢险、社会救助的数量
        Map<String, String> queryMap = new HashMap();
        Map<String,Object> streetMap = new HashMap<>();
        List resultList = new ArrayList();
        //存储一个街镇的数据
        if (StaticScheduleTask.resultList != null){
            return StaticScheduleTask.resultList;
        }else {
            //获取当年年份
            String thisYear = new SimpleDateFormat("yyyy").format(new Date().getTime());
            //循环所有街道
            Arrays.stream(strs).forEach(s -> {
                Map<String,Object> map = new HashMap<>();
                queryMap.put("street",s);
                //请求接口
                JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByGet(baseUrl,queryMap));
                //获取返回值
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                //循环结果数组
                jsonArray.stream().forEach(array ->{
                    JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(array);
                    List<Fire> list = jsonObject1.getJSONArray("list").toJavaList(Fire.class);
                    //判断list是否为空，若为空则赋予0，否则求和
                    List list1 = list.stream().filter(fire -> thisYear.equals(fire.getYearAndMonth().substring(0,4)))
                            .collect(Collectors.toList());
                    if(list1.size() > 0){
                        int count = list.stream().filter(fire -> thisYear.equals(fire.getYearAndMonth().substring(0,4)))
                                .map(Fire::getCounts)
                                .reduce((a,b) -> a + b)
                                .get();
                        map.put(jsonObject1.getString("name"),count);
                    }else{
                        map.put(jsonObject1.getString("name"),0);
                    }
                });
                streetMap.put(s,map);
            });
            resultList.add(streetMap);
            StaticScheduleTask.resultList = Result.OK("",resultList);
            return StaticScheduleTask.resultList;
        }
    }

    /**
     * @description：消防事件明细
     * @return
     */
    @PostMapping("/fire-detail")
    public JSONObject fireDetail(@RequestBody JSONObject jsonObject){
        String baseUrl = "http://10.208.75.21:9002/xfService/PTXF/getPoliceInformationInfo";
        return JSONObject.parseObject(InterTest.getResponse(baseUrl,jsonObject.toJSONString()));
    }

    @GetMapping("/fireFighting-chart")
    public String fireFightingChart(){
        return "{\n" +
                "    \"success\": true,\n" +
                "    \"message\": \"\",\n" +
                "    \"code\": 200,\n" +
                "    \"result\": [\n" +
                "        {\n" +
                "            \"address\": \"桃浦镇莲花公寓\",\n" +
                "            \"time\": \"8.97\",\n" +
                "            \"count\": \"884\",\n" +
                "            \"coordx\": \"-6836.83130597\",\n" +
                "            \"coordy\": \"5678.02208371\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川二村居委会\",\n" +
                "            \"time\": \"8.35\",\n" +
                "            \"count\": \"562\",\n" +
                "            \"coordx\": \"-3325.1843587\",\n" +
                "            \"coordy\": \"2955.46742517\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"紫荆苑\",\n" +
                "            \"time\": \"8.12\",\n" +
                "            \"count\": \"656\",\n" +
                "            \"coordx\": \"-11987.99268278\",\n" +
                "            \"coordy\": \"5723.91606402\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"石榴苑\",\n" +
                "            \"time\": \"8\",\n" +
                "            \"count\": \"443\",\n" +
                "            \"coordx\": \"-11967.15742275\",\n" +
                "            \"coordy\": \"5405.47369945\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"华公馆\",\n" +
                "            \"time\": \"7.89\",\n" +
                "            \"count\": \"358\",\n" +
                "            \"coordx\": \"-7689.29069104\",\n" +
                "            \"coordy\": \"4775.64552255\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"上海市普陀区曹杨新村第八幼儿园\",\n" +
                "            \"time\": \"7.76\",\n" +
                "            \"count\": \"356\",\n" +
                "            \"coordx\": \"-6614.93769862\",\n" +
                "            \"coordy\": \"1226.87752246\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"上海市普陀区普雄路幼儿园\",\n" +
                "            \"time\": \"7.76\",\n" +
                "            \"count\": \"158\",\n" +
                "            \"coordx\": \"-4521.39757581\",\n" +
                "            \"coordy\": \"335.70947073\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"金祁新城\",\n" +
                "            \"time\": \"7.66\",\n" +
                "            \"count\": \"257\",\n" +
                "            \"coordx\": \"-8364.79578739\",\n" +
                "            \"coordy\": \"6544.52531651\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"南大街二小区\",\n" +
                "            \"time\": \"7.6\",\n" +
                "            \"count\": \"413\",\n" +
                "            \"coordx\": \"-6502.46679366\",\n" +
                "            \"coordy\": \"1591.3325119\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"上海市实验幼儿园\",\n" +
                "            \"time\": \"7.59\",\n" +
                "            \"count\": \"596\",\n" +
                "            \"coordx\": \"-7552.07919003\",\n" +
                "            \"coordy\": \"-11927.76887487\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"南大街一小区\",\n" +
                "            \"time\": \"7.59\",\n" +
                "            \"count\": \"307\",\n" +
                "            \"coordx\": \"-6502.46679366\",\n" +
                "            \"coordy\": \"1591.3325119\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"合欢苑\",\n" +
                "            \"time\": \"7.5\",\n" +
                "            \"count\": \"539\",\n" +
                "            \"coordx\": \"-11290.88279812\",\n" +
                "            \"coordy\": \"5400.94829145\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新杨村2\",\n" +
                "            \"time\": \"7.47\",\n" +
                "            \"count\": \"769\",\n" +
                "            \"coordx\": \"-12065.53409484\",\n" +
                "            \"coordy\": \"6530.3802605\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"明丰世纪苑\",\n" +
                "            \"time\": \"7.46\",\n" +
                "            \"count\": \"492\",\n" +
                "            \"coordx\": \"-7649.40100273\",\n" +
                "            \"coordy\": \"3149.16089735\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"曹杨花苑（北块）\",\n" +
                "            \"time\": \"7.39\",\n" +
                "            \"count\": \"207\",\n" +
                "            \"coordx\": \"-6591.94000974\",\n" +
                "            \"coordy\": \"2615.21008085\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"清水湾\",\n" +
                "            \"time\": \"7.35\",\n" +
                "            \"count\": \"1477\",\n" +
                "            \"coordx\": \"-5641.74919286\",\n" +
                "            \"coordy\": \"-816.06269034\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"迎春苑\",\n" +
                "            \"time\": \"7.34\",\n" +
                "            \"count\": \"677\",\n" +
                "            \"coordx\": \"-11562.97479837\",\n" +
                "            \"coordy\": \"5625.96112366\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"175弄后水塘\",\n" +
                "            \"time\": \"7.33\",\n" +
                "            \"count\": \"260\",\n" +
                "            \"coordx\": \"-8924.05780392\",\n" +
                "            \"coordy\": \"3227.27446542\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"中鼎豪园\",\n" +
                "            \"time\": \"7.3\",\n" +
                "            \"count\": \"375\",\n" +
                "            \"coordx\": \"-7814.64477888\",\n" +
                "            \"coordy\": \"3298.96947349\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"曹杨八村二小区\",\n" +
                "            \"time\": \"7.26\",\n" +
                "            \"count\": \"526\",\n" +
                "            \"coordx\": \"-6260.35997743\",\n" +
                "            \"coordy\": \"1558.09007987\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"真如西村\",\n" +
                "            \"time\": \"7.24\",\n" +
                "            \"count\": \"376\",\n" +
                "            \"coordx\": \"-6789.96052193\",\n" +
                "            \"coordy\": \"1470.53571179\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"普陀区精神卫生中心\",\n" +
                "            \"time\": \"7.2\",\n" +
                "            \"count\": \"687\",\n" +
                "            \"coordx\": \"105.7750727\",\n" +
                "            \"coordy\": \"-3892.22507427\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"上海华东师范大学附属进华中学\",\n" +
                "            \"time\": \"7.2\",\n" +
                "            \"count\": \"1383\",\n" +
                "            \"coordx\": \"28540.43311467\",\n" +
                "            \"coordy\": \"-11446.6209225\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"曹杨八村一小区\",\n" +
                "            \"time\": \"7.14\",\n" +
                "            \"count\": \"492\",\n" +
                "            \"coordx\": \"-6260.35997743\",\n" +
                "            \"coordy\": \"1558.09007987\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"曹杨花苑（南块）\",\n" +
                "            \"time\": \"7.1\",\n" +
                "            \"count\": \"183\",\n" +
                "            \"coordx\": \"-6591.94000974\",\n" +
                "            \"coordy\": \"2615.21008085\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"祥和星宇\",\n" +
                "            \"time\": \"7.08\",\n" +
                "            \"count\": \"840\",\n" +
                "            \"coordx\": \"-7077.6788902\",\n" +
                "            \"coordy\": \"5284.42669134\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新杨村1\",\n" +
                "            \"time\": \"7.07\",\n" +
                "            \"count\": \"663\",\n" +
                "            \"coordx\": \"-12065.53409484\",\n" +
                "            \"coordy\": \"6530.3802605\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"武宁路X6-01地块商办楼新建工程\",\n" +
                "            \"time\": \"7.06\",\n" +
                "            \"count\": \"125\",\n" +
                "            \"coordx\": \"-4993.82430269\",\n" +
                "            \"coordy\": \"890.03246887\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"2号绿地（烟囱广场）\",\n" +
                "            \"time\": \"6.94\",\n" +
                "            \"count\": \"401\",\n" +
                "            \"coordx\": \"-9673.37127661\",\n" +
                "            \"coordy\": \"45.84111846\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"春光村（春光家园）\",\n" +
                "            \"time\": \"6.92\",\n" +
                "            \"count\": \"216\",\n" +
                "            \"coordx\": \"26506.33006908\",\n" +
                "            \"coordy\": \"35997.85011194\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"华东电力设计院办公大楼改扩建工程\",\n" +
                "            \"time\": \"6.84\",\n" +
                "            \"count\": \"340\",\n" +
                "            \"coordx\": \"-5104.96978399\",\n" +
                "            \"coordy\": \"939.67545316\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"石岚三村\",\n" +
                "            \"time\": \"6.83\",\n" +
                "            \"count\": \"407\",\n" +
                "            \"coordx\": \"-4722.209224\",\n" +
                "            \"coordy\": \"2037.49232032\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"万里街道社区卫生服务中心\",\n" +
                "            \"time\": \"6.83\",\n" +
                "            \"count\": \"1893\",\n" +
                "            \"coordx\": \"-6202.07832402\",\n" +
                "            \"coordy\": \"516.34007439\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"绿春苑\",\n" +
                "            \"time\": \"6.8\",\n" +
                "            \"count\": \"859\",\n" +
                "            \"coordx\": \"-11043.73370989\",\n" +
                "            \"coordy\": \"5629.80131566\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"金光村（金光花苑）\",\n" +
                "            \"time\": \"6.77\",\n" +
                "            \"count\": \"1380\",\n" +
                "            \"coordx\": \"-8056.51989746\",\n" +
                "            \"coordy\": \"-47780.76989746\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"普陀区中心医院\",\n" +
                "            \"time\": \"6.72\",\n" +
                "            \"count\": \"2036\",\n" +
                "            \"coordx\": \"-22939.97871297\",\n" +
                "            \"coordy\": \"-24359.41480827\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"长征镇214、210街坊商办楼项目\",\n" +
                "            \"time\": \"6.72\",\n" +
                "            \"count\": \"280\",\n" +
                "            \"coordx\": \"-20567.85180664\",\n" +
                "            \"coordy\": \"17174.72888184\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"圣都汇\",\n" +
                "            \"time\": \"6.71\",\n" +
                "            \"count\": \"261\",\n" +
                "            \"coordx\": \"-8036.57537109\",\n" +
                "            \"coordy\": \"4974.30592305\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"嘉华苑\",\n" +
                "            \"time\": \"6.59\",\n" +
                "            \"count\": \"967\",\n" +
                "            \"coordx\": \"-5230.42907715\",\n" +
                "            \"coordy\": \"3892.01409912\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"桃浦村村委会\",\n" +
                "            \"time\": \"6.54\",\n" +
                "            \"count\": \"348\",\n" +
                "            \"coordx\": \"-11613.80481442\",\n" +
                "            \"coordy\": \"4521.81670663\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"香樟苑\",\n" +
                "            \"time\": \"6.52\",\n" +
                "            \"count\": \"997\",\n" +
                "            \"coordx\": \"-8900.97709989\",\n" +
                "            \"coordy\": \"3037.98950525\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"岚皋路166弄\",\n" +
                "            \"time\": \"6.45\",\n" +
                "            \"count\": \"489\",\n" +
                "            \"coordx\": \"-4229.09399154\",\n" +
                "            \"coordy\": \"1604.56751991\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"曹杨二村点\",\n" +
                "            \"time\": \"6.44\",\n" +
                "            \"count\": \"324\",\n" +
                "            \"coordx\": \"-6058.36640925\",\n" +
                "            \"coordy\": \"1114.24607946\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"永汇新苑\",\n" +
                "            \"time\": \"6.4\",\n" +
                "            \"count\": \"500\",\n" +
                "            \"coordx\": \"-11285.61134211\",\n" +
                "            \"coordy\": \"4842.86669093\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"和乐苑\",\n" +
                "            \"time\": \"6.4\",\n" +
                "            \"count\": \"567\",\n" +
                "            \"coordx\": \"-11813.05262261\",\n" +
                "            \"coordy\": \"5375.85350743\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"昆仑花苑\",\n" +
                "            \"time\": \"6.38\",\n" +
                "            \"count\": \"313\",\n" +
                "            \"coordx\": \"-8623.54980364\",\n" +
                "            \"coordy\": \"2886.97308911\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"长风一村\",\n" +
                "            \"time\": \"6.37\",\n" +
                "            \"count\": \"684\",\n" +
                "            \"coordx\": \"-6498.35309766\",\n" +
                "            \"coordy\": \"-188.97059376\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"管弄路311弄\",\n" +
                "            \"time\": \"6.36\",\n" +
                "            \"count\": \"545\",\n" +
                "            \"coordx\": \"-4714.09002399\",\n" +
                "            \"coordy\": \"2320.93011258\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"未来街区核酸检测点\",\n" +
                "            \"time\": \"6.31\",\n" +
                "            \"count\": \"542\",\n" +
                "            \"coordx\": \"-10208.00060895\",\n" +
                "            \"coordy\": \"146.6350853\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"武宁路快速化改建工程1标\",\n" +
                "            \"time\": \"6.3\",\n" +
                "            \"count\": \"340\",\n" +
                "            \"coordx\": \"-4993.82430269\",\n" +
                "            \"coordy\": \"890.03246887\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"真光新秀\",\n" +
                "            \"time\": \"6.21\",\n" +
                "            \"count\": \"196\",\n" +
                "            \"coordx\": \"-7725.74357575\",\n" +
                "            \"coordy\": \"2434.79633962\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"合德\",\n" +
                "            \"time\": \"6.2\",\n" +
                "            \"count\": \"222\",\n" +
                "            \"coordx\": \"-4326.16035963\",\n" +
                "            \"coordy\": \"632.87804701\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"赵家宅\",\n" +
                "            \"time\": \"6.2\",\n" +
                "            \"count\": \"333\",\n" +
                "            \"coordx\": \"23386.32991457\",\n" +
                "            \"coordy\": \"-8112.81998516\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"梅六小区检测点\",\n" +
                "            \"time\": \"6.2\",\n" +
                "            \"count\": \"555\",\n" +
                "            \"coordx\": \"-7884.04260295\",\n" +
                "            \"coordy\": \"886.38611124\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"俞家弄部分旧改地块改造新建项目\",\n" +
                "            \"time\": \"6.17\",\n" +
                "            \"count\": \"314\",\n" +
                "            \"coordx\": \"2447.16711426\",\n" +
                "            \"coordy\": \"-1888.82537842\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"中江路街头花园检测点\",\n" +
                "            \"time\": \"6.17\",\n" +
                "            \"count\": \"2003\",\n" +
                "            \"coordx\": \"-7485.29572258\",\n" +
                "            \"coordy\": \"-522.73449807\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"大渡河路1550弄街区\",\n" +
                "            \"time\": \"6.14\",\n" +
                "            \"count\": \"1323\",\n" +
                "            \"coordx\": \"-7296.5604264\",\n" +
                "            \"coordy\": \"738.90729511\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"普陀区中医医院\",\n" +
                "            \"time\": \"6.04\",\n" +
                "            \"count\": \"2388\",\n" +
                "            \"coordx\": \"1404.78809426\",\n" +
                "            \"coordy\": \"19558.47807177\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"梅川路步行街检测点\",\n" +
                "            \"time\": \"6.03\",\n" +
                "            \"count\": \"1811\",\n" +
                "            \"coordx\": \"-7524.86749861\",\n" +
                "            \"coordy\": \"675.78387105\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"紫藤苑\",\n" +
                "            \"time\": \"6\",\n" +
                "            \"count\": \"658\",\n" +
                "            \"coordx\": \"-12160.64129493\",\n" +
                "            \"coordy\": \"5937.41747595\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"世纪之门\",\n" +
                "            \"time\": \"5.99\",\n" +
                "            \"count\": \"1067\",\n" +
                "            \"coordx\": \"-3086.62848648\",\n" +
                "            \"coordy\": \"1507.40550382\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川六村第一居委会\",\n" +
                "            \"time\": \"5.94\",\n" +
                "            \"count\": \"468\",\n" +
                "            \"coordx\": \"-3077.19139847\",\n" +
                "            \"coordy\": \"2607.34089685\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川三村第二居委会\",\n" +
                "            \"time\": \"5.92\",\n" +
                "            \"count\": \"292\",\n" +
                "            \"coordx\": \"-2869.20800628\",\n" +
                "            \"coordy\": \"2721.50928095\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"长风三村\",\n" +
                "            \"time\": \"5.91\",\n" +
                "            \"count\": \"610\",\n" +
                "            \"coordx\": \"-6886.91386602\",\n" +
                "            \"coordy\": \"-428.83628998\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"樱花苑\",\n" +
                "            \"time\": \"5.83\",\n" +
                "            \"count\": \"476\",\n" +
                "            \"coordx\": \"-11059.65010316\",\n" +
                "            \"coordy\": \"5521.44630842\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川四村居委会\",\n" +
                "            \"time\": \"5.82\",\n" +
                "            \"count\": \"489\",\n" +
                "            \"coordx\": \"-2668.74858209\",\n" +
                "            \"coordy\": \"3272.62889747\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"吉镇路桥检测点\",\n" +
                "            \"time\": \"5.82\",\n" +
                "            \"count\": \"1680\",\n" +
                "            \"coordx\": \"-9465.91198042\",\n" +
                "            \"coordy\": \"1088.99907143\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"石泉六村\",\n" +
                "            \"time\": \"5.81\",\n" +
                "            \"count\": \"372\",\n" +
                "            \"coordx\": \"-4284.22979959\",\n" +
                "            \"coordy\": \"2395.66467265\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"延长西路180弄\",\n" +
                "            \"time\": \"5.79\",\n" +
                "            \"count\": \"479\",\n" +
                "            \"coordx\": \"-3891.0671747\",\n" +
                "            \"coordy\": \"2906.81411153\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"世纪同乐\",\n" +
                "            \"time\": \"5.78\",\n" +
                "            \"count\": \"772\",\n" +
                "            \"coordx\": \"-4895.62541616\",\n" +
                "            \"coordy\": \"-230.8612178\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川一村第一居委会\",\n" +
                "            \"time\": \"5.77\",\n" +
                "            \"count\": \"440\",\n" +
                "            \"coordx\": \"-3078.19914247\",\n" +
                "            \"coordy\": \"3114.02134532\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"泰山二村居委会\",\n" +
                "            \"time\": \"5.74\",\n" +
                "            \"count\": \"408\",\n" +
                "            \"coordx\": \"-2458.92499789\",\n" +
                "            \"coordy\": \"2853.86108908\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新黄小区\",\n" +
                "            \"time\": \"5.73\",\n" +
                "            \"count\": \"436\",\n" +
                "            \"coordx\": \"-4117.32189544\",\n" +
                "            \"coordy\": \"3276.92291347\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"山茶苑\",\n" +
                "            \"time\": \"5.69\",\n" +
                "            \"count\": \"377\",\n" +
                "            \"coordx\": \"-11790.31268658\",\n" +
                "            \"coordy\": \"5886.9412839\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"南泉苑\",\n" +
                "            \"time\": \"5.6\",\n" +
                "            \"count\": \"722\",\n" +
                "            \"coordx\": \"-4336.00096764\",\n" +
                "            \"coordy\": \"4155.24169829\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川三村第一居委会\",\n" +
                "            \"time\": \"5.6\",\n" +
                "            \"count\": \"242\",\n" +
                "            \"coordx\": \"-2869.20800628\",\n" +
                "            \"coordy\": \"2721.50928095\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新沪\",\n" +
                "            \"time\": \"5.58\",\n" +
                "            \"count\": \"332\",\n" +
                "            \"coordx\": \"-4899.80320215\",\n" +
                "            \"coordy\": \"3504.09007344\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"汪家井-沿街\",\n" +
                "            \"time\": \"5.57\",\n" +
                "            \"count\": \"519\",\n" +
                "            \"coordx\": \"-3757.2205831\",\n" +
                "            \"coordy\": \"2758.34288099\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"普陀区人民医院\",\n" +
                "            \"time\": \"5.53\",\n" +
                "            \"count\": \"2882\",\n" +
                "            \"coordx\": \"22201.36020152\",\n" +
                "            \"coordy\": \"-4827.58987504\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"延长西路40弄小广场\",\n" +
                "            \"time\": \"5.52\",\n" +
                "            \"count\": \"563\",\n" +
                "            \"coordx\": \"-2802.94282221\",\n" +
                "            \"coordy\": \"3468.98889765\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川一村第二居委会\",\n" +
                "            \"time\": \"5.51\",\n" +
                "            \"count\": \"396\",\n" +
                "            \"coordx\": \"-3078.19914247\",\n" +
                "            \"coordy\": \"3114.02134532\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"真建花苑\",\n" +
                "            \"time\": \"5.51\",\n" +
                "            \"count\": \"316\",\n" +
                "            \"coordx\": \"-10557.29460544\",\n" +
                "            \"coordy\": \"3396.38832158\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"周家巷-沿街\",\n" +
                "            \"time\": \"5.49\",\n" +
                "            \"count\": \"596\",\n" +
                "            \"coordx\": \"-9010.15991211\",\n" +
                "            \"coordy\": \"14432.87988281\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"宜川六村第二居委会\",\n" +
                "            \"time\": \"5.49\",\n" +
                "            \"count\": \"360\",\n" +
                "            \"coordx\": \"-3077.19139847\",\n" +
                "            \"coordy\": \"2607.34089685\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新村路久龄家园\",\n" +
                "            \"time\": \"5.49\",\n" +
                "            \"count\": \"1087\",\n" +
                "            \"coordx\": \"-6615.95349034\",\n" +
                "            \"coordy\": \"3940.01234633\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"安塞-沿街\",\n" +
                "            \"time\": \"5.48\",\n" +
                "            \"count\": \"640\",\n" +
                "            \"coordx\": \"-4278.85008759\",\n" +
                "            \"coordy\": \"3440.31408162\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"桃浦村（联星丽景苑）\",\n" +
                "            \"time\": \"5.39\",\n" +
                "            \"count\": \"384\",\n" +
                "            \"coordx\": \"-11613.80481442\",\n" +
                "            \"coordy\": \"4521.81670663\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"上海市普陀区长风二村幼儿园梅六分园\",\n" +
                "            \"time\": \"5.36\",\n" +
                "            \"count\": \"251\",\n" +
                "            \"coordx\": \"-7080.8346022\",\n" +
                "            \"coordy\": \"-155.05529773\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新宜小区\",\n" +
                "            \"time\": \"5.35\",\n" +
                "            \"count\": \"370\",\n" +
                "            \"coordx\": \"-3273.09447065\",\n" +
                "            \"coordy\": \"3659.82329783\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"泰山一村居委会\",\n" +
                "            \"time\": \"5.35\",\n" +
                "            \"count\": \"255\",\n" +
                "            \"coordx\": \"-2292.79382974\",\n" +
                "            \"coordy\": \"2904.30329712\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"子长小区（南）77弄\",\n" +
                "            \"time\": \"5.32\",\n" +
                "            \"count\": \"364\",\n" +
                "            \"coordx\": \"-3546.64941491\",\n" +
                "            \"coordy\": \"3210.38832141\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"社区党群服务中心（文化活动中心）\",\n" +
                "            \"time\": \"5.26\",\n" +
                "            \"count\": \"1228\",\n" +
                "            \"coordx\": \"-6202.07832402\",\n" +
                "            \"coordy\": \"516.34007439\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"志丹-沿街\",\n" +
                "            \"time\": \"5.26\",\n" +
                "            \"count\": \"859\",\n" +
                "            \"coordx\": \"-3900.00080413\",\n" +
                "            \"coordy\": \"2712.32392711\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新村路上蔬永辉\",\n" +
                "            \"time\": \"5.25\",\n" +
                "            \"count\": \"692\",\n" +
                "            \"coordx\": \"-6615.95349034\",\n" +
                "            \"coordy\": \"3940.01234633\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"悦达-沿街\",\n" +
                "            \"time\": \"5.24\",\n" +
                "            \"count\": \"554\",\n" +
                "            \"coordx\": \"-5002.95380026\",\n" +
                "            \"coordy\": \"-2275.3494757\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"新长小区\",\n" +
                "            \"time\": \"5.2\",\n" +
                "            \"count\": \"455\",\n" +
                "            \"coordx\": \"-3616.66730297\",\n" +
                "            \"coordy\": \"3607.68928178\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"灵石路1620弄\",\n" +
                "            \"time\": \"5.08\",\n" +
                "            \"count\": \"430\",\n" +
                "            \"coordx\": \"-4624.95002391\",\n" +
                "            \"coordy\": \"3607.53571378\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"延长小区\",\n" +
                "            \"time\": \"5.05\",\n" +
                "            \"count\": \"443\",\n" +
                "            \"coordx\": \"-2902.37421431\",\n" +
                "            \"coordy\": \"3699.13609786\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"长新小区（349弄）\",\n" +
                "            \"time\": \"5.01\",\n" +
                "            \"count\": \"422\",\n" +
                "            \"coordx\": \"-3756.6599111\",\n" +
                "            \"coordy\": \"3709.12012987\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"武宁路快速化改建工程2标\",\n" +
                "            \"time\": \"5.01\",\n" +
                "            \"count\": \"88\",\n" +
                "            \"coordx\": \"-4993.82430269\",\n" +
                "            \"coordy\": \"890.03246887\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"万里街道受理中心\",\n" +
                "            \"time\": \"4.9\",\n" +
                "            \"count\": \"108\",\n" +
                "            \"coordx\": \"26308.9959249\",\n" +
                "            \"coordy\": \"-20418.4061966\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
