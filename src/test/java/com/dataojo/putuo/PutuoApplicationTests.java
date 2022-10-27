package com.dataojo.putuo;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PutuoApplicationTests {

    @Test
    void contextLoads() {
//        for(Object o: ReadExcel.readExcel("C:\\Users\\24724\\Desktop\\12345热线样例数据-20221017.xls","")){
//            System.out.println(o);
//        }
        String s = "{\n" +
                "    \"code\": 200,\n" +
                "    \"data\": [\n" +
                "        [\n" +
                "            {\n" +
                "                \"name\": \"抢险救援\",\n" +
                "                \"value\": \"1560\"\n" +
                "            }\n" +
                "        ]],\n" +
                "    \"msg\": \"\"}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);

    }

}
