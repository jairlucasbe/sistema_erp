// package com.upgrade.erp.shared.config.db;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;

// import jakarta.persistence.EntityManagerFactory;

// import java.util.HashMap;

// import javax.sql.DataSource;

// @Configuration
// public class LegacyDatabaseConfig {

//     @Bean(name = "legacyDataSource")
//     @ConfigurationProperties(prefix = "legacy.datasource")
//     public DataSource legacyDataSource() {
//         return DataSourceBuilder.create().build();
//     }

//     @Bean(name = "legacyEntityManagerFactory")
//     public LocalContainerEntityManagerFactoryBean legacyEntityManagerFactory(
//             @Qualifier("legacyDataSource") DataSource legacyDataSource) {

//         LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//         em.setDataSource(legacyDataSource);
//         em.setPackagesToScan("com.example.legacy"); // Cambia esto al paquete de tus entidades legacy

//         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//         em.setJpaVendorAdapter(vendorAdapter);

//         HashMap<String, Object> properties = new HashMap<>();
//         properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//         em.setJpaPropertyMap(properties);

//         return em;
//     }

//     @Bean(name = "legacyTransactionManager")
//     public PlatformTransactionManager legacyTransactionManager(
//             @Qualifier("legacyEntityManagerFactory") EntityManagerFactory legacyEntityManagerFactory) {
//         return new JpaTransactionManager(legacyEntityManagerFactory);
//     }
// }