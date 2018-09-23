package com.masakaya.springmappingsample.configuration;

import ma.glasnost.orika.MapperFactory;

public interface MapperFactoryConfigurer {
    void configure(MapperFactory factory );
}
