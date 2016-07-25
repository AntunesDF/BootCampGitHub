package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.JdbcUserService;
import org.academiadecodigo.bootcamp.service.user.UserService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("login");

        UserService userService = new JdbcUserService(new ConnectionManager());
        ServiceRegistry.getInstance().setService("Jdbc", userService);

        LoginController loginController = (LoginController) Navigation.getInstance().getController("login");

        loginController.setUser((UserService)ServiceRegistry.getInstance().getService("Jdbc"));

    }

    public static void main(String[] args) {
        launch(args);
    }
}
