package com.masakaya.springmappingsample.bean;

import com.masakaya.springmappingsample.bean.child.FooClass;
import com.masakaya.springmappingsample.constants.TestType;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class BaseBean {
    private int primitiveIntField;
    private Integer integerField;
    private long primitiveLongField;
    private Long longField;
    private TestType testType;
    private List<String> stringList;
    private Map<String, String> stringMap;
    private FooClass foo;
    private OffsetDateTime offsetDateTime;
}
