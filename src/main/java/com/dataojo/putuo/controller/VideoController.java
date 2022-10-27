package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.common.Result;
import com.dataojo.putuo.util.InterTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

@RestController
@RequestMapping("/video")
public class VideoController {
    @PostMapping("/stream/open")
    public Result<Object> videoStream(){
        String baseUrl = "http://10.208.5.10:38502/xf-public-api-device-search/v1/stream/live/open";
//        String s = "{\"tgt_session_id\": \"xfor_0C637226312769F7FB2029684E6EF971\",\n" +
//                "        \"send_uri\": \"http://10.171.211.7:8080/api-ex/xfor_0C637226312769F7FB2029684E6EF971/31010723001181052001.m3u8\"}";
//        JSONObject jsonObject = JSONObject.parseObject(s);
        String data = "{\"deviceId\":\"31010724001321053010\",\"protocol\":\"hls\",\"resolution\":\"HD\"}";
        JSONObject jsonObject = JSONObject.parseObject(InterTest.post(baseUrl,data));
        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
        return Result.OK("",jsonObject1);
    }

    @PostMapping("/stream/close")
    public void closeStream(HttpServletRequest request){
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
    }

    @PostMapping("/search-device")
    public Result searchDevice(){
        String s = "[\n" +
                "        {\n" +
                "            \"deviceState\": 1,\n" +
                "            \"deviceId\": \"31010724001321053010\",\n" +
                "            \"deviceName\": \"C0212泰康路190弄西通道2\",\n" +
                "            \"productor\": \"9\",\n" +
                "            \"cameraType\": \"3\",\n" +
                "            \"cameraFunc\": \"5\",\n" +
                "            \"ipv4\": \"111.222.13.17\",\n" +
                "            \"longitude\": -8259.71,\n" +
                "            \"latitude\": 5440.3,\n" +
                "            \"regionId\": \"31010123\",\n" +
                "            \"tagBuildRegionName\": \"打浦桥派出所\",\n" +
                "            \"monitorDir\": 1,\n" +
                "            \"status\": 1,\n" +
                "            \"tagBuildResolution\": \"高清\",\n" +
                "            \"tagBuildCameraFunc\": [\n" +
                "                \"普通监控\"\n" +
                "            ],\n" +
                "            \"tagBuildIscontrol\": \"固定\",\n" +
                "            \"tagBuildDeviceState\": \"在用\",\n" +
                "            \"tagBuildCameraType\": \"固定枪机\",\n" +
                "            \"tagBuildPoliceSelfBuild\": \"非自建\",\n" +
                "            \"hasBizTag\": false,\n" +
                "            \"hasScenceTag\": true,\n" +
                "            \"setPlace\": \"C0212泰康路190弄西通道2\",\n" +
                "            \"keyboard\": \"530131211\",\n" +
                "            \"deviceIconFlag\": 1,\n" +
                "            \"policeSelfBuildOrder\": 2,\n" +
                "            \"monitorType\": \"3\",\n" +
                "            \"resolutionOrder\": 2,\n" +
                "            \"tagBuildAI\": null,\n" +
                "            \"cameraFuncValue\": \"MONITOR\",\n" +
                "            \"orderScore\": 0,\n" +
                "            \"battaryRemain\": null,\n" +
                "            \"tagSceneArea\": [\n" +
                "                \"泰康路190弄\"\n" +
                "            ],\n" +
                "            \"tagScenePlace\": [\n" +
                "                \"泰康路190弄\"\n" +
                "            ],\n" +
                "            \"tagSceneType\": [\n" +
                "                \"社区\"\n" +
                "            ],\n" +
                "            \"tagScenePosition\": [\n" +
                "                \"小区内部\"\n" +
                "            ],\n" +
                "            \"tagScenePositionPure\": [\n" +
                "                \"小区内部\"\n" +
                "            ],\n" +
                "            \"tagBuildProductor\": \"宇视\",\n" +
                "            \"tagBuildMonitorType\": \"三类视频监控点\",\n" +
                "            \"tagBuildCameraEncode\": \"H.264\",\n" +
                "            \"tagBuildLightType\": \"无补光\",\n" +
                "            \"tagBuildPlaceType\": [\n" +
                "                \"治安复杂区域\"\n" +
                "            ],\n" +
                "            \"tagBuildMonitorDir\": \"东\",\n" +
                "            \"tagBuildConnectType\": \"已联网\",\n" +
                "            \"tagBuildSetTimeYear\": \"2017\",\n" +
                "            \"tagBuildManageDepartment\": \"打浦桥派出所\",\n" +
                "            \"tagBuildDepartment\": \"[\\\"公安机关\\\"]\",\n" +
                "            \"tagBuildBuildType\": \"社会单位联网\",\n" +
                "            \"tagBuildDigital\": \"数字\",\n" +
                "            \"tagBuildRegionShort\": \"黄浦\",\n" +
                "            \"tagBuildHeight\": \"0\",\n" +
                "            \"tagBuildStatus\": \"启用\"\n" +
                "        }]";
        JSONArray jsonArray  = JSONArray.parseArray(s);
        return Result.OK("",jsonArray);
    }
}
