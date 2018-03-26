package com.art2cat.dev.concurrency.concurrency_in_practice.sharing_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionDispenser
 * <p/>
 * Using ThreadLocal to ensure thread confinement
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ConnectionDispenser {
    
    static String DB_URL = "jdbc:mysql://localhost/mydatabase";
    
    private ThreadLocal<Connection> connectionHolder
        = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to acquire Connection, e");
        }
    });
    
    public Connection getConnection() {
        return connectionHolder.get();
    }
}
