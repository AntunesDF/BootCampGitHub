package org.academiadecodigo.bootcamp;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by codecadet on 23/06/16.
 */
public final class Navigation {

    private final int MIN_WIDTH = 320;
    private final int MIN_HEIGHT = 331;

    private LinkedList<Scene> scenes = new LinkedList<Scene>();
    private Map<String, Initializable> controllers = new HashMap<String, Initializable>();

    private Stage stage;

    private static Navigation instance = null;


    private Navigation() {
    }


    public static synchronized Navigation getInstance() {

        if(instance == null) {
            instance = new Navigation();
        }

        return instance;
    }


    public Initializable getController(String string) {
        return controllers.get(string);
    }


    public void loadScreen(String view) {

        try {

            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("/org/academiadecodigo/bootcamp/view/" + view + ".fxml"));
            Parent root = fxmlLoader.load();

            controllers.put(view, (Initializable) fxmlLoader.getController());

            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            scenes.push(scene);

            setScene(scene);

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

}
