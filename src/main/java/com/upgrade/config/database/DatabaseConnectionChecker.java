package com.upgrade.config.database;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.upgrade.legacy.config.LegacyDatabaseConfig;

import jakarta.annotation.PostConstruct;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseConnectionChecker {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionChecker.class);
    
    private final DataSource principalDataSource;
    private final DataSource legacyDataSource;

    public DatabaseConnectionChecker(
            @Qualifier(DatabaseConfig.DATASOURCE_NAME) DataSource principalDataSource, 
            @Qualifier(LegacyDatabaseConfig.DATASOURCE_NAME) DataSource legacyDataSource) {
        this.principalDataSource = principalDataSource;
        this.legacyDataSource = legacyDataSource;
    }

    @PostConstruct
    public void init() {
        logger.info("Iniciando verificación de conexión...");
        checkConnection(principalDataSource, "Base de Datos Principal");
        checkConnection(legacyDataSource, "Base de Datos Legacy");
    }

    public void checkConnection(DataSource dataSource, String dbName) {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                logger.info("Conexión satisfactoria a la {}", dbName);
            }
        } catch (SQLException e) {
            logger.error("Error al conectar a la {}: {}", dbName, e.getMessage());
        }
    }
}
