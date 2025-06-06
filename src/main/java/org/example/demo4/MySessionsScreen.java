package org.example.demo4;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MySessionsScreen {
    private VBox view;

    public MySessionsScreen(Stage stage, User user) {
        view = new VBox(20);
        view.setPadding(new Insets(20));
        view.getStyleClass().add("screen");

        Label title = new Label("📝 Мои записи");
        title.getStyleClass().add("label-title");

        VBox sessionList = new VBox(15);
        sessionList.setPadding(new Insets(10));

        var sessions = ScheduleDatabase.getSessionsForUser(user);
        if (sessions.isEmpty()) {
            Label emptyLabel = new Label("Нет записей");
            emptyLabel.getStyleClass().add("label-info");
            sessionList.getChildren().add(emptyLabel);
        } else {
            for (TrainingSession session : sessions) {
                VBox card = new VBox(8);
                card.setPadding(new Insets(12));
                card.setStyle("-fx-background-color: #e6f7ff; -fx-background-radius: 10;");
                card.setPrefWidth(360);

                Label sessionLabel = new Label(session.toString());
                sessionLabel.getStyleClass().add("label-session");

                Button cancelBtn = new Button("❌ Отменить запись");
                cancelBtn.setStyle("-fx-background-color: #ffcccc;");
                cancelBtn.setOnAction(e -> {
                    ScheduleDatabase.cancel(user, session);
                    reload(stage, user);
                });

                card.getChildren().addAll(sessionLabel, cancelBtn);
                sessionList.getChildren().add(card);
            }
        }

        ScrollPane scrollPane = new ScrollPane(sessionList);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        scrollPane.setPrefHeight(500);

        Button back = new Button("← Назад");
        back.getStyleClass().add("button-back");
        back.setOnAction(e -> {
            SceneUtil.setStyledScene(stage, new MainMenu(stage, user).getView());
        });

        view.getChildren().addAll(back, title, scrollPane, NavigationBar.get(stage, user, "my"));
    }

    private void reload(Stage stage, User user) {
        SceneUtil.setStyledScene(stage, new MySessionsScreen(stage, user).getView());
    }

    public VBox getView() {
        return view;
    }
}