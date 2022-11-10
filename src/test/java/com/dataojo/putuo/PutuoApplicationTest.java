package com.dataojo.putuo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.entity.Fire;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutuoApplicationTest {
    @Test
    void a() {
        String s = "{\n" +
                "    \"code\": 200,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"list\": [\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 16,\n" +
                "                    \"disposalObject\": \"社会救助\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 36,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 14,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 34,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 11,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"社会救助\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 20,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 92,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"社会救助\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 14,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 180,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 11,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"社会救助\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 142,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 13,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"社会救助\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 10,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 63,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 42,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"关闭居民水、气阀门\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"社会救助\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 339,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 20,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 9,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 6,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"社会救助\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 9,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 10,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"居民家中取钥匙\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 17,\n" +
                "                    \"disposalObject\": \"关消防栓\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"社会救助\",\n" +
                "                    \"counts\": 17,\n" +
                "                    \"disposalObject\": \"摘除蜂窝\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"name\": \"社会救助\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"list\": [\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 11,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"燃气自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-11\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 14,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 40,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 6,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 18,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 11,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 26,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 11,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 6,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"抽水\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 48,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 32,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 54,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 24,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 10,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 19,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 13,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"抽水\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"燃气自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-09\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 24,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 43,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 19,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 23,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 13,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"抽水\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 10,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-08\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 16,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 41,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 6,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 15,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 19,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 14,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"纵火自焚\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2022-07\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 43,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"纵火自焚\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 20,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 14,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 23,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 6,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 6,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"抽水\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-06\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 50,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 18,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 9,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 35,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"燃气自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"纵火自焚\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-05\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 85,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 9,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 15,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 15,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 29,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 7,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"燃气自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"抽水\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-04\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 10,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 34,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 23,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 25,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-03\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 42,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 12,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 16,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 16,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"爆炸事故\",\n" +
                "                    \"yearAndMonth\": \"2022-02\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 6,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 17,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 39,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 13,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 8,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 20,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 9,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 4,\n" +
                "                    \"disposalObject\": \"消火栓被撞\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 3,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2022-01\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 18,\n" +
                "                    \"disposalObject\": \"高空排险\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 20,\n" +
                "                    \"disposalObject\": \"救助人员\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 10,\n" +
                "                    \"disposalObject\": \"不明异味\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 28,\n" +
                "                    \"disposalObject\": \"人员被困\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"其他\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 5,\n" +
                "                    \"disposalObject\": \"公路\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 11,\n" +
                "                    \"disposalObject\": \"跳楼自杀\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 11,\n" +
                "                    \"disposalObject\": \"扬言自杀\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"跳河自杀\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 12,\n" +
                "                    \"disposalObject\": \"电梯故障\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 2,\n" +
                "                    \"disposalObject\": \"燃气泄露\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"抢险救援\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"燃气自杀\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"水域救援\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"caseType\": \"抢险救援\",\n" +
                "                    \"counts\": 1,\n" +
                "                    \"disposalObject\": \"城市给水管网爆裂\",\n" +
                "                    \"yearAndMonth\": \"2021-12\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"name\": \"抢险救援\"\n" +
                "        }\n"+
                "    ],\n" +
                "    \"msg\": \"\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        Map<String,Object> map = new HashMap<>();
        //存储一个街镇的数据
        jsonArray.stream().forEach(array ->{
            JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(array);
            List<Fire> list = jsonObject1.getJSONArray("list").toJavaList(Fire.class);
            List<Fire> fireList = new ArrayList<>();
            int count = list.stream().filter(fire -> "2022".equals(fire.getYearAndMonth().substring(0,4)))
                    .map(Fire::getCounts)
                    .reduce((a,b) -> a + b)
                    .get();
            map.put(jsonObject1.getString("name"),count);
            System.out.println(map);
        });

//        list.stream().filter(a -> "2021".equals(a.getYearAndMonth().substring(0,3)))
//                .forEach(a-> System.out.println(a));
    }
}
