package org.academiadecodigo.bootcamp.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by codecadet on 29/06/16.
 */
public class ConnectionManager {

    private Connection connection = null;


    public Connection getConnection() {

        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql:///login", "root", "");
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database: " + ex.getMessage());
        }
        return connection;
    }


    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }
}
