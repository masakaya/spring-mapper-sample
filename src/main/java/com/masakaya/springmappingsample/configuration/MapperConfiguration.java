package com.masakaya.springmappingsample.configuration;

import com.masakaya.springmappingsample.configuration.properties.OrikaMapperProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties({OrikaMapperProperties.class})
@ComponentScan({"com.masakaya.springmappingsample.configuration.global.converter"})
public class MapperConfiguration {

    private final OrikaMapperProperties prop;

    private final Optional<List<MapperFactoryConfigurer>> factoryConfigurers;

    @ConditionalOnMissingBean
    @Bean
    public MapperFactoryBuilder orikaMapperFactoryBuilder() {
        MapperFactoryBuilder builder = new DefaultMapperFactory.Builder();
        if(Objects.nonNull(prop.getCaptureFieldContext())) {
            builder.captureFieldContext(prop.getCaptureFieldContext());
        }
        if(Objects.nonNull(prop.getDumpStateOnException())) {
            builder.dumpStateOnException(prop.getDumpStateOnException());
        }
        if(Objects.nonNull(prop.getFavorExtension())) {
            builder.favorExtension(prop.getFavorExtension());
        }
        if(Objects.nonNull(prop.getMapNulls())) {
           builder.mapNulls(prop.getMapNulls());
        }
        if(Objects.nonNull(prop.getUseAutoMapping())){
            builder.useAutoMapping(prop.getUseAutoMapping());
        }
        if(Objects.nonNull(prop.getUseBuiltinConverters())){
            builder.useBuiltinConverters(prop.getUseBuiltinConverters());
        }
        return builder;
    }

    @ConditionalOnMissingBean
    @Bean
    public MapperFactory orikaMapperFactory(MapperFactoryBuilder builder) {
        MapperFactory factory = builder.build();
        factoryConfigurers.orElseGet(Collections::emptyList).
                forEach(conf-> conf.configure(factory));
        return factory;
    }

    @ConditionalOnMissingBean
    @Bean
    public MapperFacade orikaMapperFacade(MapperFactory mapperFactory) {
        return mapperFactory.getMapperFacade();
    }

}
