package com.wave.helpers;

import java.sql.*;

/**
 *
 * @author dibyajyotimishra
 */
public class ConnectionProvider {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                // Load the driver class.
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create a connection.
                String dbUrl = "jdbc:mysql://localhost:3306/wave";
                String dbUserName = "root";
                String dbPassword = "password";

                connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

                if (connection != null) {
                    System.out.println("Database connected.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
