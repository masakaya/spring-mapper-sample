package com.masakaya.springmappingsample.main;

import com.masakaya.springmappingsample.bean.BaseBean;
import com.masakaya.springmappingsample.bean.DestBean;
import com.masakaya.springmappingsample.configuration.MapperConfiguration;
import com.masakaya.springmappingsample.constants.TestType;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.time.OffsetDateTime;

@Slf4j
@Import(MapperConfiguration.class)
@SpringBootApplication
public class SpringMappingSampleApplication implements ApplicationRunner {
    /**
     * orika-mapper facade
     */
    @Autowired
    private MapperFacade facade;

    @Override
    public void run(ApplicationArguments args) {
        log.info("Start.");
        BaseBean bean = BaseBean.builder()
                .primitiveIntField(10)
                .integerField(11)
                .primitiveLongField(20L)
                .longField(21L)
                .testType(TestType.ERROR)
                .offsetDateTime(OffsetDateTime.now())
                .build();
        DestBean same = facade.map(bean, DestBean.class);
        log.info(same.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMappingSampleApplication.class, args);
    }
}
