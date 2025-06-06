package org.example.demo4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ProfileScreen {
    private VBox view;

    public ProfileScreen(Stage stage, User user) {
        view = new VBox();
        view.setPadding(new Insets(20));
        view.setSpacing(20);
        view.setStyle("-fx-background-color: #f8f8f8;");


        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: #cccccc; -fx-background-radius: 8px;");

        Circle avatar = new Circle(20);
        avatar.setStyle("-fx-fill: black;");

        Label greeting = new Label("Привет, " + user.getName());
        greeting.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        header.getChildren().addAll(avatar, greeting);


        Label sectionTitle = new Label("Для вас");
        sectionTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        VBox buttonList = new VBox(10);
        buttonList.getChildren().addAll(
                createOption("📅", "Расписание", () -> {
                    SceneUtil.setStyledScene(stage, new ScheduleScreen(stage, user).getView());
                }),
                createOption("📝", "Запись на персональную тренировку", () -> {
                    SceneUtil.setStyledScene(stage, new TrainerScreen(stage, user).getView());
                }),
                createOption("🧾", "Мои записи", () -> {
                    SceneUtil.setStyledScene(stage, new TrainerScreen(stage, user).getView());
                }),
                createOption("🏠", "О клубе", () -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("О клубе");
                    alert.setHeaderText(null);
                    alert.setContentText("Добро пожаловать в наш BOLGARIN gym!");
                    alert.showAndWait();
                })
        );

        view.getChildren().addAll(header, sectionTitle, buttonList, NavigationBar.get(stage, user, "profile"));
    }

    private HBox createOption(String icon, String title, Runnable action) {
        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-background-color: #e0e0e0; -fx-background-radius: 8px;");

        Label iconLabel = new Label(icon);
        iconLabel.setStyle("-fx-font-size: 16px;");

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 14px;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label arrow = new Label(">");
        arrow.setStyle("-fx-font-size: 14px;");

        box.getChildren().addAll(iconLabel, titleLabel, spacer, arrow);
        box.setOnMouseClicked(e -> action.run());
        return box;
    }

    public VBox getView() {
        return view;
    }
    private void setSceneWithStyle(Stage stage, Region view) {
        Scene scene = new Scene(view, 400, 600);
        scene.getStylesheets().add(getClass().getResource("/mainMenu.css").toExternalForm());
        stage.setScene(scene);
    }
}