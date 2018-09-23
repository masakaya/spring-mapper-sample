package com.masakaya.springmappingsample.bean.child;

import com.masakaya.springmappingsample.bean.child.FooClass;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ExtendFooClass extends FooClass {
    private String custom;
}
