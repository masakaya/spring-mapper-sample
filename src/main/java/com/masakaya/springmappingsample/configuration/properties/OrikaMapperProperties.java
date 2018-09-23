package com.masakaya.springmappingsample.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "orika")
public class OrikaMapperProperties {

    private Boolean captureFieldContext;

    private Boolean dumpStateOnException;

    private Boolean favorExtension;

    private Boolean mapNulls;

    private Boolean useAutoMapping;

    private Boolean useBuiltinConverters;
}
