package com.dataojo.putuo.controller;

import com.alibaba.fastjson.JSONArray;
import com.dataojo.putuo.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue")
public class IssueController {
    /**
    * @program:
    * @description:返回事件相关测试数据
    * @author: hlh
    * @date: 2022/10/17 19:23
     * @return
    */
    @PostMapping("/issueInfo")
    public Result issueTest(){
        String s = "[{\n" +
                "            \"discovertimel\": \"2022/10/17 6:31:00\",\n" +
                "            \"description\": \"救助动物\",\n" +
                "            \"address\": \"普陀区 兰溪路92号 门口 梧桐树上\",\n" +
                "            \"coordx\": \"-8359.71\",\n" +
                "            \"dispatchuser\": \"消防\",\n" +
                "            \"casesn\": \"2022普陀管字1031476\",\n" +
                "            \"taskid\": \"2210T4018885\",\n" +
                "            \"infotypeid\": \"抢险救援\",\n" +
                "            \"coordy\": \"5540.3\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"discovertimel\": \"2022/10/17 6:32:58\",\n" +
                "            \"description\": \"8岁儿童铁门卡住身体\",\n" +
                "            \"address\": \"普陀区 双山路167弄11号门口\",\n" +
                "            \"coordx\": \"-8468.82\",\n" +
                "            \"dispatchuser\": \"消防\",\n" +
                "            \"casesn\": \"2022普陀管字1031478\",\n" +
                "            \"taskid\": \"2210T4018887\",\n" +
                "            \"infotypeid\": \"抢险救援\",\n" +
                "            \"coordy\": \"4800.71\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"discovertimel\": \"2022/10/17 6:28:52\",\n" +
                "            \"description\": \"走廊停放电动车充电导致自燃\",\n" +
                "            \"address\": \"普陀区 梅川路141弄7号304室（杏园）\",\n" +
                "            \"coordx\": \"-8386.19\",\n" +
                "            \"dispatchuser\": \"消防\",\n" +
                "            \"casesn\": \"2022普陀管字1031474\",\n" +
                "            \"taskid\": \"2210T4018882\",\n" +
                "            \"infotypeid\": \"火灾\",\n" +
                "            \"coordy\": \"4791.84\"\n" +
                "        }]";
        JSONArray jsonObject = JSONArray.parseArray(s);
        return Result.OK("",jsonObject);
    }
}
