package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.common.Result;
import com.dataojo.putuo.util.InterTest;
import org.apache.el.parser.JJTELParserState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/video")
public class VideoController {
    @PostMapping("/stream/open")
    public JSONObject videoStream(HttpServletRequest request){
        String resolution = "SD";
        String baseUrl = "http://10.208.5.10:38502/xf-public-api-device-search/v1/stream/live/open";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.readRequestStream(request));
        String deviceId = jsonObject.getString("deviceId");
        if (jsonObject.getString("resolution") != null){
            resolution = jsonObject.getString("resolution");
        }
        String data = "{\"deviceId\":\"" + deviceId + "\",\"protocol\":\"hls\",\"resolution\":\"" + resolution + "\"}";
        JSONObject jsonObject1 = JSONObject.parseObject(InterTest.post(baseUrl,data));
        return jsonObject1;
    }

    @PostMapping("/stream/close")
    public JSONObject closeStream(HttpServletRequest request){
        String baseUrl = "http://10.208.5.10:38502/xf-public-api-device-search/v1/stream/live/close";
        String context = null;
        String data = null;
        try{
            BufferedReader bufferedReader = request.getReader();
            while ((context = bufferedReader.readLine()) != null){
                data = context;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(InterTest.post(baseUrl,data));
        return jsonObject;
    }

    @PostMapping("/search-device")
    public Result searchDevice(){
        String s = "{\n" +
                "    \"code\": 20000,\n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"count\": 26,\n" +
                "        \"totalPage\": 7,\n" +
                "        \"result\": [\n" +
                "            {\n" +
                "                \"objectid\": 22489,\n" +
                "                \"序号\": null,\n" +
                "                \"设备厂商\": \"宇视\",\n" +
                "                \"行政区划\": \"31020211\",\n" +
                "                \"监控点位类型\": \"二类视频监控点\",\n" +
                "                \"设备型号\": \"IPC-B502\",\n" +
                "                \"点位俗称\": \"清涧六街坊高清2\",\n" +
                "                \"摄像机类型\": \"固定枪机\",\n" +
                "                \"摄像机功能类型\": \"普通监控\",\n" +
                "                \"补光属性\": \"白光补光\",\n" +
                "                \"摄像机编码格式\": \"H.264\",\n" +
                "                \"对应存储设备通道\": \"31010722011186016006\",\n" +
                "                \"安装地址\": \"桃浦路1023弄1-94号清涧六小区内/1个\",\n" +
                "                \"摄像机位置类型\": \"封闭式住宅小区\",\n" +
                "                \"监视方向\": \"东\",\n" +
                "                \"摄像机场景预设照片url\": null,\n" +
                "                \"联网属性\": \"已联网\",\n" +
                "                \"所属辖区公安机关\": \"310107590000\",\n" +
                "                \"安装时间\": \"2019-11-09\",\n" +
                "                \"管理单位\": \"中国联合网络通信有限公司上海市分公司\",\n" +
                "                \"管理单位联系方式\": \"021-51831088-80901\",\n" +
                "                \"录像或图片保存天数\": \"30\",\n" +
                "                \"设备状态\": \"在用\",\n" +
                "                \"所属部门_行业\": null,\n" +
                "                \"视频分辨率\": \"高清\",\n" +
                "                \"视频信号类型\": \"数字\",\n" +
                "                \"是否对外共享\": \"否\",\n" +
                "                \"是否接入三级平台\": \"否\",\n" +
                "                \"键盘编号\": null,\n" +
                "                \"建设应用类别\": \"社会单位复接\",\n" +
                "                \"定位模块\": \"GPS\",\n" +
                "                \"场所编号\": \"31010720010063\",\n" +
                "                \"场所名称\": null,\n" +
                "                \"行业类型\": \"社会治安社区接入\",\n" +
                "                \"出入方向\": \"其他\",\n" +
                "                \"数据来源\": \"城运智慧安防\",\n" +
                "                \"小区名称\": null,\n" +
                "                \"街道名称\": \"真如镇街道\",\n" +
                "                \"街道代码\": \"0721\",\n" +
                "                \"居委会名称\": \"星河世纪城\",\n" +
                "                \"居委会代码\": \"072137\",\n" +
                "                \"设备编码\": \"31010722011326016006\",\n" +
                "                \"设备名称\": \"清涧六街坊高清2HG\",\n" +
                "                \"设备目录\": null,\n" +
                "                \"安装高度\": \"4.0\",\n" +
                "                \"可视距离\": \"10\",\n" +
                "                \"geometry\": {\n" +
                "                    \"x\": -7401.167297363281,\n" +
                "                    \"y\": 2580.6453247070312\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"objectid\": 22599,\n" +
                "                \"序号\": null,\n" +
                "                \"设备厂商\": \"宇视\",\n" +
                "                \"行政区划\": \"31020211\",\n" +
                "                \"监控点位类型\": \"二类视频监控点\",\n" +
                "                \"设备型号\": \"HIC2961-WH-WSGB\",\n" +
                "                \"点位俗称\": \"杨家桥二小区车行入口2\",\n" +
                "                \"摄像机类型\": \"固定枪机\",\n" +
                "                \"摄像机功能类型\": \"车辆识别\",\n" +
                "                \"补光属性\": \"白光补光\",\n" +
                "                \"摄像机编码格式\": \"H.264\",\n" +
                "                \"对应存储设备通道\": \"31010721011186069005\",\n" +
                "                \"安装地址\": \"真北路与交通路交叉路口往西南约100米(杨桥二街坊)二小区车行入口2大门内/1个\",\n" +
                "                \"摄像机位置类型\": \"封闭式住宅小区\",\n" +
                "                \"监视方向\": \"东\",\n" +
                "                \"摄像机场景预设照片url\": null,\n" +
                "                \"联网属性\": \"已联网\",\n" +
                "                \"所属辖区公安机关\": \"310107590000\",\n" +
                "                \"安装时间\": \"2019-11-09\",\n" +
                "                \"管理单位\": \"中国联合网络通信有限公司上海市分公司\",\n" +
                "                \"管理单位联系方式\": \"021-51831088-80901\",\n" +
                "                \"录像或图片保存天数\": \"30\",\n" +
                "                \"设备状态\": \"在用\",\n" +
                "                \"所属部门_行业\": null,\n" +
                "                \"视频分辨率\": \"高清\",\n" +
                "                \"视频信号类型\": \"数字\",\n" +
                "                \"是否对外共享\": \"否\",\n" +
                "                \"是否接入三级平台\": \"否\",\n" +
                "                \"键盘编号\": null,\n" +
                "                \"建设应用类别\": \"社会单位复接\",\n" +
                "                \"定位模块\": \"GPS\",\n" +
                "                \"场所编号\": \"31010719010040\",\n" +
                "                \"场所名称\": null,\n" +
                "                \"行业类型\": \"社会治安社区接入\",\n" +
                "                \"出入方向\": \"进\",\n" +
                "                \"数据来源\": \"城运智慧安防\",\n" +
                "                \"小区名称\": null,\n" +
                "                \"街道名称\": \"真如镇街道\",\n" +
                "                \"街道代码\": \"0721\",\n" +
                "                \"居委会名称\": \"曹杨新苑\",\n" +
                "                \"居委会代码\": \"072128\",\n" +
                "                \"设备编码\": \"31010721011326047105\",\n" +
                "                \"设备名称\": \"杨家桥二小区车行入口2HG_sp\",\n" +
                "                \"设备目录\": null,\n" +
                "                \"安装高度\": \"4.0\",\n" +
                "                \"可视距离\": \"21\",\n" +
                "                \"geometry\": {\n" +
                "                    \"x\": -6946.2080078125,\n" +
                "                    \"y\": 3291.1544799804688\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"objectid\": 23059,\n" +
                "                \"序号\": null,\n" +
                "                \"设备厂商\": \"宇视\",\n" +
                "                \"行政区划\": \"31020211\",\n" +
                "                \"监控点位类型\": \"二类视频监控点\",\n" +
                "                \"设备型号\": \"IPC-B502\",\n" +
                "                \"点位俗称\": \"清涧六街坊高清8\",\n" +
                "                \"摄像机类型\": \"固定枪机\",\n" +
                "                \"摄像机功能类型\": \"普通监控\",\n" +
                "                \"补光属性\": \"白光补光\",\n" +
                "                \"摄像机编码格式\": \"H.264\",\n" +
                "                \"对应存储设备通道\": \"31010722011186016012\",\n" +
                "                \"安装地址\": \"桃浦路1023弄1-94号清涧六小区内/1个\",\n" +
                "                \"摄像机位置类型\": \"封闭式住宅小区\",\n" +
                "                \"监视方向\": \"东\",\n" +
                "                \"摄像机场景预设照片url\": null,\n" +
                "                \"联网属性\": \"已联网\",\n" +
                "                \"所属辖区公安机关\": \"310107590000\",\n" +
                "                \"安装时间\": \"2019-11-09\",\n" +
                "                \"管理单位\": \"中国联合网络通信有限公司上海市分公司\",\n" +
                "                \"管理单位联系方式\": \"021-51831088-80901\",\n" +
                "                \"录像或图片保存天数\": \"30\",\n" +
                "                \"设备状态\": \"在用\",\n" +
                "                \"所属部门_行业\": null,\n" +
                "                \"视频分辨率\": \"高清\",\n" +
                "                \"视频信号类型\": \"数字\",\n" +
                "                \"是否对外共享\": \"否\",\n" +
                "                \"是否接入三级平台\": \"否\",\n" +
                "                \"键盘编号\": null,\n" +
                "                \"建设应用类别\": \"社会单位复接\",\n" +
                "                \"定位模块\": \"GPS\",\n" +
                "                \"场所编号\": \"31010720010063\",\n" +
                "                \"场所名称\": null,\n" +
                "                \"行业类型\": \"社会治安社区接入\",\n" +
                "                \"出入方向\": \"其他\",\n" +
                "                \"数据来源\": \"城运智慧安防\",\n" +
                "                \"小区名称\": \"真北一小区\",\n" +
                "                \"街道名称\": \"真如镇街道\",\n" +
                "                \"街道代码\": \"0721\",\n" +
                "                \"居委会名称\": \"真北一委\",\n" +
                "                \"居委会代码\": \"072105\",\n" +
                "                \"设备编码\": \"31010722011326016012\",\n" +
                "                \"设备名称\": \"清涧六街坊高清8HG\",\n" +
                "                \"设备目录\": null,\n" +
                "                \"安装高度\": \"4.0\",\n" +
                "                \"可视距离\": \"10\",\n" +
                "                \"geometry\": {\n" +
                "                    \"x\": -7052.01220703125,\n" +
                "                    \"y\": 2561.7877197265625\n" +
                "                }\n" +
                "            },\n" +
                "                        {\n" +
                "                \"objectid\": 23069,\n" +
                "                \"序号\": null,\n" +
                "                \"设备厂商\": \"宇视\",\n" +
                "                \"行政区划\": \"31020211\",\n" +
                "                \"监控点位类型\": \"二类视频监控点\",\n" +
                "                \"设备型号\": \"IPC-B502\",\n" +
                "                \"点位俗称\": \"清涧六街坊高清5\",\n" +
                "                \"摄像机类型\": \"固定枪机\",\n" +
                "                \"摄像机功能类型\": \"普通监控\",\n" +
                "                \"补光属性\": \"白光补光\",\n" +
                "                \"摄像机编码格式\": \"H.264\",\n" +
                "                \"对应存储设备通道\": \"31010722011186016009\",\n" +
                "                \"安装地址\": \"桃浦路1023弄1-94号清涧六小区内/1个\",\n" +
                "                \"摄像机位置类型\": \"封闭式住宅小区\",\n" +
                "                \"监视方向\": \"东\",\n" +
                "                \"摄像机场景预设照片url\": null,\n" +
                "                \"联网属性\": \"已联网\",\n" +
                "                \"所属辖区公安机关\": \"310107590000\",\n" +
                "                \"安装时间\": \"2019-11-09\",\n" +
                "                \"管理单位\": \"中国联合网络通信有限公司上海市分公司\",\n" +
                "                \"管理单位联系方式\": \"021-51831088-80901\",\n" +
                "                \"录像或图片保存天数\": \"30\",\n" +
                "                \"设备状态\": \"在用\",\n" +
                "                \"所属部门_行业\": null,\n" +
                "                \"视频分辨率\": \"高清\",\n" +
                "                \"视频信号类型\": \"数字\",\n" +
                "                \"是否对外共享\": \"否\",\n" +
                "                \"是否接入三级平台\": \"否\",\n" +
                "                \"键盘编号\": null,\n" +
                "                \"建设应用类别\": \"社会单位复接\",\n" +
                "                \"定位模块\": \"GPS\",\n" +
                "                \"场所编号\": \"31010720010063\",\n" +
                "                \"场所名称\": null,\n" +
                "                \"行业类型\": \"社会治安社区接入\",\n" +
                "                \"出入方向\": \"其他\",\n" +
                "                \"数据来源\": \"城运智慧安防\",\n" +
                "                \"小区名称\": null,\n" +
                "                \"街道名称\": \"真如镇街道\",\n" +
                "                \"街道代码\": \"0721\",\n" +
                "                \"居委会名称\": \"真北三委\",\n" +
                "                \"居委会代码\": \"072134\",\n" +
                "                \"设备编码\": \"31010722011326016009\",\n" +
                "                \"设备名称\": \"清涧六街坊高清5HG\",\n" +
                "                \"设备目录\": null,\n" +
                "                \"安装高度\": \"4.0\",\n" +
                "                \"可视距离\": \"10\",\n" +
                "                \"geometry\": {\n" +
                "                    \"x\": -7226.589904785156,\n" +
                "                    \"y\": 2571.215087890625\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        JSONArray jsonArray  = JSONArray.parseArray(s);
        return Result.OK("",jsonArray);
    }

    @GetMapping("/video-like-search")
    public JSONObject videoLikeSearch(HttpServletRequest request){
        String baseUrl = "http://158.10.0.222/wk/proxy/Search/api/Address/Search";
        Map<String, String> queryMap = new HashMap();
        if (request.getParameter("keyWord") != null){
            queryMap.put("keyWord",request.getParameter("keyWord"));
        }
        if (request.getParameter("pageSize") != null){
            queryMap.put("pageSize",request.getParameter("pageSize"));
        }
        if (request.getParameter("pageIndex") != null){
            queryMap.put("pageIndex",request.getParameter("pageIndex"));
        }
        if (request.getParameter("area") != null){
            queryMap.put("area",request.getParameter("area"));
        }
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByMap(baseUrl,queryMap,"IPhj81.qyUqPr.wWJDx6"));
        return jsonObject;
    }

    @PostMapping("/video-around")
    public JSONObject videoAround(HttpServletRequest request){
        String baseUrl = "http://158.10.0.222/wk/proxy/CoordReverse/mapTransform/hitLayerByXY";
        String data = InterTest.readRequestStream(request);
        JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByMap(baseUrl,data,"o7KvLA.YlN9UX.WvQLzf"));
        return jsonObject;
    }

    @PostMapping("/get-grid-info")
    public JSONObject getGridInfo(HttpServletRequest request){
        String baseUrl = "http://158.10.0.222/wk/proxy/CoordReverse/mapTransform/hitLocationInfoByXY";
        return JSONObject.parseObject(InterTest.getResponseByMap(baseUrl,InterTest.readRequestStream(request),"sB1OHv.t53CzK.cjQkEi"));
    }
}
