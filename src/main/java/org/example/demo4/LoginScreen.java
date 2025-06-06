package org.example.demo4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginScreen {
    private VBox view;

    public LoginScreen(Stage stage, AuthScreen authScreen) {
        view = new VBox(10);
        view.setPadding(new Insets(30));
        view.setAlignment(Pos.CENTER);

        Label title = new Label("Вход");
        title.getStyleClass().add("label-title");

        TextField loginField = new TextField();
        loginField.setPromptText("Логин");
        loginField.getStyleClass().add("text-field");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Пароль");
        passwordField.getStyleClass().add("text-field");

        Button loginButton = new Button("Войти");
        loginButton.getStyleClass().add("button-main");

        Label switchToRegister = new Label("Нет аккаунта? Регистрация");
        switchToRegister.getStyleClass().add("label-switch");
        switchToRegister.setOnMouseClicked(e -> authScreen.showRegister(stage));

        Label status = new Label();
        status.getStyleClass().add("label-error");

        loginButton.setOnAction(e -> {
            String login = loginField.getText();
            String pass = passwordField.getText();
            User user = UserDatabase.authenticate(login, pass);
            if (user != null) {
                MainMenu menu = new MainMenu(stage, user);
                Scene menuScene = new Scene(menu.getView(), 800, 600);
                menuScene.getStylesheets().add(getClass().getResource("/mainMenu.css").toExternalForm());
                stage.setScene(menuScene);
            } else {
                status.setText("Неверный логин или пароль");
            }
        });

        view.getChildren().addAll(title, loginField, passwordField, loginButton, status, switchToRegister);
    }

    public VBox getView() {
        return view;
    }
}
