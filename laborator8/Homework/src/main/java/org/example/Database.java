package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Database class that manages the connection to the database.

 */
public class Database {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";


    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "I@siF4619";

    private static HikariDataSource dataSource;
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    static {
        setupDataSource();
    }

    /**
     * Sets up the data source.
     */
    private static void setupDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.setAutoCommit(false);

        dataSource = new HikariDataSource(config);
    }

    /**
     * Returns a connection to the database.
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = connectionHolder.get();
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
            connectionHolder.set(connection);
        }
        return connection;
    }

    /**
     * Closes the connection to the database.
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        Connection connection = connectionHolder.get();
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        connectionHolder.remove();
    }

    /**
     *
     * Commits the transaction.
     */
    public static void rollback() {
        Connection connection = connectionHolder.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.err.println("Failed to rollback the transaction: " + e.getMessage());
            }
        }
    }

    /**
     * Closes the connection pool.

     */
    public static void closeConnectionPool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
