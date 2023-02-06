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
    @Test
    void a() {
    }
}
