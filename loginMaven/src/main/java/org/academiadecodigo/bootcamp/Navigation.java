package org.academiadecodigo.bootcamp;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by codecadet on 29/06/16.
 */
public final class Navigation {

    private final int MIN_WIDTH = 320;
    private final int MIN_HEIGHT = 331;

    private LinkedList<Scene> scenes = new LinkedList<Scene>();
    private Map<String, Initializable> controllers;

    private Stage stage;

    private Navigation() {
    }


    public void loadScreen(String view) {

        Parent root = null;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + view + ".fxml"));

            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> param) {
                    return controllers.get(param.getSimpleName());
                }
            });

            root = fxmlLoader.load();

            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            setScene(scene);
            scenes.push(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }
    }


    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        scenes.pop();

        setScene(scenes.peek());
    }


    private void setScene(Scene scene) {

        stage.setScene(scene);

        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void close() {
    }

    public Map<String, Initializable> getControllers() {
        return controllers;
    }

    public void setControllers(Map<String, Initializable> controllers) {
        this.controllers = controllers;
    }

    public Initializable getController(String string) {
        return controllers.get(string);
    }


}
