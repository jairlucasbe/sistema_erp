// package com.upgrade.erp.server;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.Query;

// @Service
// public class TestServiceImpl {

//     // Inyección de los EntityManagers para ambas bases de datos
//     @Autowired
//     @Qualifier("newEntityManagerFactory")
//     private EntityManager newEntityManager;

//     @Autowired
//     @Qualifier("legacyEntityManagerFactory")
//     private EntityManager legacyEntityManager;

//     // Método de prueba para interactuar con ambas bases de datos
//     @Transactional
//     public void testDatabases() {
//         // Probar la base de datos nueva (new)
//         try {
//             String sqlNewDb = "SELECT * FROM authentication.test"; // Cambia esto por una consulta válida de tu base de datos
//             Query queryNewDb = newEntityManager.createNativeQuery(sqlNewDb);
//             Long countNewDb = (Long) queryNewDb.getSingleResult();
//             System.out.println("Total rows in new database: " + countNewDb);
//         } catch (Exception e) {
//             e.printStackTrace();
//             System.out.println("Error interacting with the new database");
//         }

//         // Probar la base de datos legacy (antigua)
//         try {
//             String sqlLegacyDb = "SELECT * from extcs.almacenes"; // Cambia esto por una consulta válida de tu base de datos legacy
//             Query queryLegacyDb = legacyEntityManager.createNativeQuery(sqlLegacyDb);
//             Long countLegacyDb = (Long) queryLegacyDb.getSingleResult();
//             System.out.println("Total rows in legacy database: " + countLegacyDb);
//         } catch (Exception e) {
//             e.printStackTrace();
//             System.out.println("Error interacting with the legacy database");
//         }
//     }
// }
