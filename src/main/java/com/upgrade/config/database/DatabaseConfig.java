package com.upgrade.config.database;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
    basePackages = "com.upgrade.erp.server.repositories", 
    entityManagerFactoryRef = "localEntityManagerFactory", 
    transactionManagerRef = "localTransactionManager"
)
public class DatabaseConfig {

    public static final String PERSISTENCE_UNIT_NAME = "principal";
    public static final String ENTITY_PACKAGE = "com.upgrade.erp.server.entities";
    public static final String DATASOURCE_NAME = "datasource";
    public static final String ENTITY_MANAGER_FACTORY_NAME = "localEntityManagerFactory";

    @Bean(name = DATASOURCE_NAME)
    @Primary
    public DataSource dataSource(Environment env) {
        return DataSourceBuilder.create()
            .url(Objects.requireNonNull(env.getProperty("spring.datasource.url")))
            .username(env.getProperty("spring.datasource.username"))
            .password(env.getProperty("spring.datasource.password"))
            .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
            .build();
    }

    @Bean(name = ENTITY_MANAGER_FACTORY_NAME)
    @Primary
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(
        EntityManagerFactoryBuilder builder, DataSource dataSource) {
        return builder
            .dataSource(dataSource)
            .packages(ENTITY_PACKAGE)
            .persistenceUnit(PERSISTENCE_UNIT_NAME)
            .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager localTransactionManager(EntityManagerFactory localEntityManagerFactory) {
        return new JpaTransactionManager(localEntityManagerFactory);
    }
}
