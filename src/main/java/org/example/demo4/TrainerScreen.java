package org.example.demo4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TrainerScreen {
    private VBox view;

    public TrainerScreen(Stage stage, User user) {
        view = new VBox(10);
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Тренеры");
        title.getStyleClass().add("label-title");


        VBox trainersBox = new VBox(10);
        String[] trainers = {"Иван Иванов", "Мария Петрова", "Сергей Смирнов"};
        for (String name : trainers) {
            HBox item = new HBox(10);
            item.setAlignment(Pos.CENTER_LEFT);
            Label trainerName = new Label(name);
            Button signUpBtn = new Button("Записаться");
            signUpBtn.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Запись");
                alert.setHeaderText(null);
                alert.setContentText("Вы записались к тренеру " + name + "!");
                alert.showAndWait();
            });
            item.getChildren().addAll(trainerName, signUpBtn);
            trainersBox.getChildren().add(item);
        }

        view.getChildren().addAll(title, trainersBox, NavigationBar.get(stage, user, "trainers"));
    }

    public VBox getView() {
        return view;
    }
}