package com.upgrade.config.database;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseConnectionChecker {

    private final DataSourceConfig dataSourceConfig;
    private final LegacyDataSourceConfig legacyDataSourceConfig;

    public DatabaseConnectionChecker(DataSourceConfig dataSourceConfig, LegacyDataSourceConfig legacyDataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
        this.legacyDataSourceConfig = legacyDataSourceConfig;
    }

    @PostConstruct
    public void init() {
        // Verifica la conexión de la base de datos principal
        checkConnection(dataSourceConfig.dataSource(null), "Base de Datos Principal");

        // Verifica la conexión de la base de datos legacy (solo lectura)
        checkConnection(legacyDataSourceConfig.legacyDataSource(null), "Base de Datos Legacy");
    }

    public void checkConnection(DataSource dataSource, String dbName) {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.out.println("Conexión satisfactoria a la " + dbName);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la " + dbName + ": " + e.getMessage());
        }
    }
}
