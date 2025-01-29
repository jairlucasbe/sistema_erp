package com.upgrade.legacy.config.database;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class LegacyDatabaseConnectionChecker {

    private static final Logger logger = LoggerFactory.getLogger(LegacyDatabaseConnectionChecker.class);

    private final DataSource legacyDataSource;

    public LegacyDatabaseConnectionChecker(
            @Qualifier(LegacyDatabaseConfig.DATASOURCE_NAME) DataSource legacyDataSource) {
        this.legacyDataSource = legacyDataSource;
    }

    @PostConstruct
    public void init() {
        logger.info("Iniciando verificación de conexión...");
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
