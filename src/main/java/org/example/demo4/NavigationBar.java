package org.example.demo4;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NavigationBar {
    public static HBox get(Stage stage, User user, String current) {
        HBox nav = new HBox(10);
        nav.setAlignment(Pos.CENTER);
        nav.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px;");

        Button homeBtn = new Button("🏠 Главная");
        Button scheduleBtn = new Button("📅");
        Button myBtn = new Button("📝");
        Button profileBtn = new Button("👤");

        homeBtn.setOnAction(e -> {
            if (!"home".equals(current))
                SceneUtil.setStyledScene(stage, new MainMenu(stage, user).getView());
        });

        scheduleBtn.setOnAction(e -> {
            if (!"schedule".equals(current))
                SceneUtil.setStyledScene(stage, new ScheduleScreen(stage, user).getView());
        });

        myBtn.setOnAction(e -> {
            if (!"my".equals(current))
                SceneUtil.setStyledScene(stage, new MySessionsScreen(stage, user).getView());
        });

        profileBtn.setOnAction(e -> {
            if (!"profile".equals(current))
                SceneUtil.setStyledScene(stage, new ProfileScreen(stage, user).getView());
        });

        nav.getChildren().addAll(homeBtn, scheduleBtn, myBtn, profileBtn);
        return nav;
    }
}