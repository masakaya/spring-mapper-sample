package com.masakaya.springmappingsample.bean;

import com.masakaya.springmappingsample.bean.child.ExtendFooClass;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DestBean {
    private int primitiveIntField;
    private Integer integerField;
    private long primitiveLongField;
    private Long longField;
    private String testType;
    private List<String> stringList;
    private Map<String, String> stringMap;
    private ExtendFooClass foo;
    private String offsetDateTime;
}
