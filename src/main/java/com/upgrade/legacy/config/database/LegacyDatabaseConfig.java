package com.upgrade.legacy.config.database;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.upgrade.legacy.server.repositories",
    entityManagerFactoryRef = "legacyEntityManagerFactory",
    transactionManagerRef = "legacyTransactionManager"
)
public class LegacyDatabaseConfig {

    public static final String PERSISTENCE_UNIT_NAME = "legacy";
    public static final String ENTITY_PACKAGE = "com.upgrade.legacy.server.entities";
    public static final String DATASOURCE_NAME = "legacyDatabase";
    public static final String ENTITY_MANAGER_FACTORY_NAME = "legacyEntityManagerFactory";

    @Bean(name = DATASOURCE_NAME)
    public DataSource legacyDataSource(Environment env) {
        return DataSourceBuilder.create()
            .url(Objects.requireNonNull(env.getProperty("legacy.datasource.url")))
            .username(env.getProperty("legacy.datasource.username"))
            .password(env.getProperty("legacy.datasource.password"))
            .driverClassName(env.getProperty("legacy.datasource.driver-class-name"))
            .build();
    }

    @Bean(name = ENTITY_MANAGER_FACTORY_NAME)
    public LocalContainerEntityManagerFactoryBean legacyEntityManagerFactory(
        EntityManagerFactoryBuilder builder, DataSource legacyDataSource) {
        return builder
            .dataSource(legacyDataSource)
            .packages(ENTITY_PACKAGE)
            .persistenceUnit(PERSISTENCE_UNIT_NAME)
            .build();
    }

    @Bean
    public PlatformTransactionManager legacyTransactionManager(EntityManagerFactory legacyEntityManagerFactory) {
        return new JpaTransactionManager(legacyEntityManagerFactory);
    }
}