package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by codecadet on 28/06/16.
 */
public class JdbcUserService implements UserService {

    //private ConnectionManager manager;
    private Connection dbConnection;


    public JdbcUserService(ConnectionManager manager) {
        //this.manager = manager;
        dbConnection = manager.getConnection();
    }

    @Override
    public boolean authenticate(String username, String password) {

        Boolean isAuthenticated = false;
        Statement statement = null;

        try {

            statement = dbConnection.createStatement();
            String query = "SELECT uname, password FROM registers WHERE uname = '" + username + "'AND password = '" + password + "';";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                isAuthenticated = true;

            }

        } catch (SQLException e) {
            System.out.println("Error authenticating: " + e);
        } finally {

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isAuthenticated;
    }

    @Override
    public void addUser(User user) {

        String name = user.getUsername();
        String pass = user.getPassword();
        String email = user.getEmail();
        Statement statement = null;

        try {

            statement = dbConnection.createStatement();
            String query = "INSERT INTO registers (uname, password, email) VALUES ('" + name + "', '" + pass + "', '" + email + "');";
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int count() {

        int result = 0;
        Statement statement = null;

        try {

            statement = dbConnection.createStatement();
            String query = "SELECT COUNT(*) FROM registers";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Couldn't connect to the DB: " + e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return result;
    }


    @Override
    public User findByName(String username) {

        Statement statement = null;

        try {

            statement = dbConnection.createStatement();
            String query = "SELECT * FROM registers WHERE uname = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                String usernameValue = resultSet.getString("uname");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");

                return new User(usernameValue, passwordValue, emailValue);
            }

        } catch (SQLException e) {
            System.out.println("Couldn't connect to DB: " + e);
        } finally {

            try {
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
