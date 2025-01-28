package com.upgrade.config.database;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
    basePackages = "com.upgrade.erp.legacy.repositories",  // Cambia al paquete de repositorios de la base de datos legacy
    entityManagerFactoryRef = "legacyEntityManagerFactory",
    transactionManagerRef = "legacyTransactionManager"
)
public class LegacyDataSourceConfig {

    @Bean
    public DataSource legacyDataSource(Environment env) {
        return DataSourceBuilder.create()
            .url(Objects.requireNonNull(env.getProperty("legacy.datasource.url")))
            .username(env.getProperty("legacy.datasource.username"))
            .password(env.getProperty("legacy.datasource.password"))
            .driverClassName(env.getProperty("legacy.datasource.driver-class-name"))
            .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean legacyEntityManagerFactory(EntityManagerFactoryBuilder builder, DataSource legacyDataSource) {
        return builder
            .dataSource(legacyDataSource)
            .packages("com.upgrade.erp.legacy.model") // Ajusta el paquete de las entidades legacy
            .persistenceUnit("legacy")
            .build();
    }

    @Bean
    public PlatformTransactionManager legacyTransactionManager(EntityManagerFactory legacyEntityManagerFactory) {
        return new JpaTransactionManager(legacyEntityManagerFactory);
    }
}