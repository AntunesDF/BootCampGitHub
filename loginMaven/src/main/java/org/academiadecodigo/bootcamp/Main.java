package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by codecadet on 29/06/16.
 */
public class Main extends Application{

    private ApplicationContext applicationContext;
    private Navigation navigation;

    @Override
    public void start(Stage primaryStage) throws Exception{

        applicationContext = new ClassPathXmlApplicationContext("/spring/spring-config.xml");

        navigation = applicationContext.getBean("navigation", Navigation.class);
        navigation.setStage(primaryStage);
        navigation.loadScreen("login");
    }

    @Override
    public void stop() {
        navigation.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
