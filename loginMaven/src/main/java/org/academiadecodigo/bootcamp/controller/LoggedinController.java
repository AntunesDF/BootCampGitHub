package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import org.academiadecodigo.bootcamp.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 29/06/16.
 */
public class LoggedinController implements Initializable {

    @FXML
    private Label loggedIn;

    @FXML
    private Label yo;

    @FXML
    private MenuItem logout;

    private Navigation navigation;

    public LoggedinController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void back(ActionEvent event) {
        navigation.back();
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}
