package com.dataojo.putuo.entity;

import lombok.Data;

@Data
public class Issue {
    //任务号
    private String TASKID;
    //案卷编号
    private String CASESN;
    //发现时间
    private String DISCOVERTIMEl;
    //X坐标
    private String COORDX;
    //Y坐标
    private String COORDY;
    //地址
    private String ADDRESS;
    //案件属性
    private String INFOTYPEID;
    //问题描述
    private String DESCRIPTION;
    //派遣用户
    private String DISPATCHUSER;
}
