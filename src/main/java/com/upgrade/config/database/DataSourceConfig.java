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
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource(Environment env) {
        return DataSourceBuilder.create()
            .url(Objects.requireNonNull(env.getProperty("spring.datasource.url")))
            .username(env.getProperty("spring.datasource.username"))
            .password(env.getProperty("spring.datasource.password"))
            .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
            .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(
        EntityManagerFactoryBuilder builder, DataSource dataSource) {
        return builder
            .dataSource(dataSource)
            .packages("com.upgrade.erp.server.entities")
            .persistenceUnit("local")
            .build();
    }

    @Bean
    public PlatformTransactionManager localTransactionManager(EntityManagerFactory localEntityManagerFactory) {
        return new JpaTransactionManager(localEntityManagerFactory);
    }
}
