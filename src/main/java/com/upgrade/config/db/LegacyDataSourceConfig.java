package com.upgrade.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.upgrade.config.properties.LegacyDataSourceProperties;

import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class LegacyDataSourceConfig {

    @Autowired
    private LegacyDataSourceProperties legacyDataSourceProperties;

    @Bean(name = "legacyDataSource")
    public DataSource legacyDataSource() {
        return DataSourceBuilder.create()
                .url(legacyDataSourceProperties.getUrl())
                .username(legacyDataSourceProperties.getUsername())
                .password(legacyDataSourceProperties.getPassword())
                .driverClassName(legacyDataSourceProperties.getDriverClassName())
                .build();
    }
}