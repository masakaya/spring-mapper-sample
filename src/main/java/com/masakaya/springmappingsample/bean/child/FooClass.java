package com.masakaya.springmappingsample.bean.child;

import com.masakaya.springmappingsample.bean.child.BarClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FooClass {
    private String foo1;
    private String foo2;
    private BarClass bar;
}
