package com.dataojo.putuo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *火警实体类
 */
@Data
@AllArgsConstructor
public class Fire {
    private String yearAndMonth;
    private int counts;
    private String disposalObject;
    private String caseType;

}
