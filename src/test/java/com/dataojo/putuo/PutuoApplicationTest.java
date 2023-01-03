package com.dataojo.putuo;

import com.alibaba.fastjson.JSONObject;
import com.dataojo.putuo.mapper.PutuoPipeiMapper;
import com.dataojo.putuo.entity.PutuoPipei;
import com.dataojo.putuo.mapper.PutuoPipeiMapper;
import com.dataojo.putuo.util.InterTest;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@MapperScan("com.dataojo.putuo.mapper")
public class PutuoApplicationTest {
    @Resource
    PutuoPipeiMapper putuoPipeiMapper;
    @Test
    void a() {
        PutuoPipei putuoPipei = null;
        for (int i = 199; i < 1219; i++){
            putuoPipei = putuoPipeiMapper.select(i);
            String s = putuoPipei.getAddress().split(" ")[0];
            String baseUrl = "http://158.10.0.222/wk/proxy/Search/api/Address/Search?keyWord=" + s + "&pageSize=1000&area=普陀区&pageIndex=1";
            Map<String, String> queryMap = new HashMap();
            JSONObject jsonObject = JSONObject.parseObject(InterTest.getResponseByMap(baseUrl,queryMap,"IPhj81.qyUqPr.wWJDx6"));
            int result = Integer.parseInt(jsonObject.getString("matchCount"));
            putuoPipeiMapper.update(i,result);
        }
    }
}
