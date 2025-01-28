package com.upgrade.config.database;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;

// import jakarta.persistence.EntityManagerFactory;
// import javax.sql.DataSource;
// import java.util.Map;

// @Configuration
// public class DatabaseConfig {

//     private static final String ENTITY_PACKAGE = "com.upgrade.erp.server.entities";
//     private static final String HIBERNATE_DIALECT = "hibernate.dialect";
//     private static final String DIALECT_CLASS = "org.hibernate.dialect.PostgreSQLDialect";

//     @Bean(name = "DataSource")
//     @ConfigurationProperties(prefix = "spring.datasource")
//     @Primary
//     public DataSource newDataSource() {
//         return DataSourceBuilder.create().build();
//     }

//     @Bean(name = "entityManagerFactory")
//     public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//             @Qualifier("DataSource") DataSource DataSource) {
//         LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//         entityManagerFactory.setDataSource(DataSource);
//         entityManagerFactory.setPackagesToScan(ENTITY_PACKAGE);
//         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//         entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//         entityManagerFactory.setJpaPropertyMap(Map.of(
//                 HIBERNATE_DIALECT, DIALECT_CLASS
//         ));
//         return entityManagerFactory;
//     }

//     @Bean(name = "TransactionManager")
//     public PlatformTransactionManager TransactionManager(
//             @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//         return new JpaTransactionManager(entityManagerFactory);
//     }

// }
