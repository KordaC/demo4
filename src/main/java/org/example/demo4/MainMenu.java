package org.example.demo4;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {
    private VBox view;

    public MainMenu(Stage stage, User user) {
        view = new VBox(10);
        view.setPadding(new Insets(15));
        view.getStyleClass().add("vbox-layout");


        Label greeting = new Label("Привет, " + user.getName());
        greeting.getStyleClass().add("label-title");

        Label welcome = new Label("Добро пожаловать в BOLGARIN gym!");
        welcome.getStyleClass().add("label-welcome");

        VBox content = new VBox(10, greeting, welcome);
        content.setPadding(new Insets(30, 40, 30, 40));
        content.getStyleClass().add("vbox-content");


        view.getChildren().addAll(content, NavigationBar.get(stage, user, "home"));
    }

    public VBox getView() {
        return view;
    }
}
