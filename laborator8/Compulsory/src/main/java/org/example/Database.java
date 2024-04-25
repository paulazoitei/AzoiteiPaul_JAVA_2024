package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection manager.

 */
public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "kjgkjgkjgkjgk";
    private static Connection connection = null;

    /**
     * Private constructor to prevent instantiation.
     */
    private Database() {}

    /**
     * Get a connection to the database.
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            createConnection();
        }
        return connection;
    }

    /**
     * Create a new connection to the database.
     * @throws SQLException
     */
    private static void createConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);
    }

    /**
     * Close the connection to the database.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Failed to close the database connection: " + e.getMessage());
            }
        }
    }

    /**
     * Rollback the current transaction.
     */
    public static void rollback() {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.err.println("Failed to rollback the transaction: " + e.getMessage());
            }
        }
    }
}
