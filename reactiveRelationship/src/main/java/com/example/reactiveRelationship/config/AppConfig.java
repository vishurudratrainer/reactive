package com.example.reactiveRelationship.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.PostgresDialect;

@Configuration
public class AppConfig {

    @Bean
    public R2dbcCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new BookReadConverter());
        converters.add(new DepartmentReadConverter());
        return R2dbcCustomConversions.of(PostgresDialect.INSTANCE, converters);
        // deprecated: return new R2dbcCustomConversions(converters);
    }
}
