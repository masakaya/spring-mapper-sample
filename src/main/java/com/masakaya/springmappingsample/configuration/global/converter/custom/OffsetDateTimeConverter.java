package com.masakaya.springmappingsample.configuration.global.converter.custom;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeConverter extends BidirectionalConverter<OffsetDateTime,String> {

    private static final String DATETIME_FORMAT= "yyyy-MM-dd'T'HH:mm:ss'Z'";

    @Override
    public String convertTo(OffsetDateTime source,
                            Type<String> destinationType,
                            MappingContext mappingContext) {
        // convert utc offset datetime.
        OffsetDateTime dateTime = OffsetDateTime.of(
                source.atZoneSameInstant(ZoneOffset.UTC).
                        toLocalDateTime(), ZoneOffset.UTC);
        return dateTime.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }

    @Override
    public OffsetDateTime convertFrom(String source,
                                      Type<OffsetDateTime> destinationType,
                                      MappingContext mappingContext) {
        return OffsetDateTime.parse(source,
                DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
