package com.masakaya.springmappingsample.configuration.global.converter;

import com.masakaya.springmappingsample.configuration.MapperFactoryConfigurer;
import com.masakaya.springmappingsample.configuration.global.converter.custom.OffsetDateTimeConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class OffsetDateTimeCustomMapperConverter implements MapperFactoryConfigurer {
    /**
     * counfigurer factory. both convert offsetDateTime and String
     * @param factory
     */
    @Override
    public void configure(MapperFactory factory) {
        ConverterFactory converterFactory = factory.getConverterFactory();
        converterFactory.registerConverter(new OffsetDateTimeConverter());
    }
}
