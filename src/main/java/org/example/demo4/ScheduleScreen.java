package org.example.demo4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ScheduleScreen {
    private VBox view;

    public ScheduleScreen(Stage stage, User user) {
        view = new VBox(20);
        view.setPadding(new Insets(20));
        view.getStyleClass().add("screen");

        Label title = new Label("📅 Расписание тренировок");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.getStyleClass().add("title");

        VBox sessionList = new VBox(15);
        sessionList.setPadding(new Insets(10));

        for (TrainingSession session : ScheduleDatabase.getAllSessions()) {
            VBox card = new VBox(10);
            card.setPadding(new Insets(15));
            card.setStyle("-fx-background-color: #f2f2f2; -fx-background-radius: 10;");
            card.setPrefWidth(360);

            Label name = new Label(session.getCoach());
            name.setFont(Font.font("Arial", FontWeight.BOLD, 16));

            Label time = new Label("🕒 " + session.getTime());
            Label subtitle = new Label("🏋️ Тренировка: " + session.getSubtitle());

            Button action = new Button();
            if (ScheduleDatabase.isUserSignedUp(user, session)) {
                action.setText("❌ Отменить запись");
                action.setOnAction(e -> {
                    ScheduleDatabase.cancel(user, session);
                    reload(stage, user);
                });
                action.setStyle("-fx-background-color: #ffcccc;");
            } else {
                action.setText("✅ Записаться");
                action.setOnAction(e -> {
                    ScheduleDatabase.signUp(user, session);
                    reload(stage, user);
                });
                action.setStyle("-fx-background-color: #ccffcc;");
            }

            card.getChildren().addAll(name, time, subtitle, action);
            sessionList.getChildren().add(card);
        }

        ScrollPane scrollPane = new ScrollPane(sessionList);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color:transparent;");
        scrollPane.setPrefHeight(500);

        Button back = new Button("← Назад");
        back.getStyleClass().add("back-button");
        back.setOnAction(e -> {
            VBox root = new MainMenu(stage, user).getView();
            setStyledScene(stage, root);
        });

        view.getChildren().addAll(back, title, scrollPane);
    }

    public VBox getView() {
        return view;
    }

    public void reload(Stage stage, User user) {
        VBox root = new ScheduleScreen(stage, user).getView();
        setStyledScene(stage, root);
    }

    private void setStyledScene(Stage stage, VBox root) {
        Scene scene = new Scene(root, 400, 600);
        scene.getStylesheets().add(getClass().getResource("/mainMenu.css").toExternalForm());
        stage.setScene(scene);
    }
}