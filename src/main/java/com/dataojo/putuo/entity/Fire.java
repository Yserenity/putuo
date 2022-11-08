package com.dataojo.putuo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fire {
    private String yearAndMonth;
    private int counts;
    private String disposalObject;
    private String caseType;

}
