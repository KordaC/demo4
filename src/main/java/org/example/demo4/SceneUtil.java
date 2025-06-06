package org.example.demo4;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class SceneUtil {
    public static void setStyledScene(Stage stage, Region view) {
        Scene scene = new Scene(view, 400, 600);
        scene.getStylesheets().add(SceneUtil.class.getResource("/mainMenu.css").toExternalForm());
        stage.setScene(scene);
    }
}