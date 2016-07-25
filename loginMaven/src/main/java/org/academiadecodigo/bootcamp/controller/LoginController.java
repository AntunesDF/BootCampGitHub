package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.user.UserService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 29/06/16.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField email;

    @FXML
    private Label warning;

    @FXML
    private Button button;

    @FXML
    private Hyperlink hyperlink;

    private UserService user;

    private Navigation navigation;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        warning.setText("");
        button.setText("Login");
        hyperlink.setText("Want to register? Click here.");
        emailLabel.setVisible(false);
        email.setVisible(false);
    }


    public void onLogin(ActionEvent event) {

        String u = username.getText();
        String p = password.getText();
        String e = email.getText();

        if (u.length() == 0 || p.length() == 0) {

            warning.setText("One or more fields are empty.");

        } else {

            if (button.getText().equals("Login")) {

                if (user.findByName(u) != null) {

                    if (user.authenticate(u, p)) {

                        navigation.loadScreen("loggedin");

                    } else {

                        warning.setText("Wrong password.");
                    }

                } else {

                    warning.setText("Wrong username.");
                }


            } else {

                if (e.length() != 0) {

                    if (user.findByName(u) != null) {

                        warning.setText("User already exists.");

                    } else {

                        user.addUser(new User(u, e, p));
                        warning.setText("Registration Successful.");
                        emailLabel.setVisible(false);
                        email.setVisible(false);
                        button.setText("Login");
                        hyperlink.setText("Want to register? Click here.");

                    }
                } else {

                    warning.setText("One or more fields are empty.");
                }

            }

        }
    }


    public void onRegister(ActionEvent event) {

        if (hyperlink.getText().equals("Want to register? Click here.")) {

            button.setText("Register");
            emailLabel.setVisible(true);
            email.setVisible(true);
            hyperlink.setText("Cancel registration");
            username.setText("");
            password.setText("");
            email.setText("");
            warning.setText("");

        } else {

            button.setText("Login");
            emailLabel.setVisible(false);
            email.setVisible(false);
            username.setText("");
            password.setText("");
            hyperlink.setText("Want to register? Click here.");
            warning.setText("");
        }
    }

    public LoginController() {
    }

    public void setUser(UserService user) {
        this.user = user;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}
