package org.example.demo4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegisterScreen {
    private VBox view;

    public RegisterScreen(Stage stage, AuthScreen authScreen) {
        view = new VBox(10);
        view.setPadding(new Insets(30));
        view.setAlignment(Pos.CENTER);

        Label title = new Label("Регистрация");
        title.getStyleClass().add("label-title");

        TextField nameField = new TextField();
        nameField.setPromptText("Имя");
        nameField.getStyleClass().add("text-field");

        TextField loginField = new TextField();
        loginField.setPromptText("Логин");
        loginField.getStyleClass().add("text-field");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Пароль");
        passwordField.getStyleClass().add("text-field");

        Button registerButton = new Button("Зарегистрироваться");
        registerButton.getStyleClass().add("button-main");

        Label switchToLogin = new Label("Уже есть аккаунт? Вход");
        switchToLogin.getStyleClass().add("label-switch");
        switchToLogin.setOnMouseClicked(e -> authScreen.showLogin(stage));

        Label status = new Label();
        status.getStyleClass().add("label-error");

        registerButton.setOnAction(e -> {
            String name = nameField.getText();
            String login = loginField.getText();
            String pass = passwordField.getText();
            if (UserDatabase.registerUser(name, login, pass)) {
                authScreen.showLogin(stage);
            } else {
                status.setText("Пользователь уже существует");
            }
        });

        view.getChildren().addAll(title, nameField, loginField, passwordField, registerButton, status, switchToLogin);
    }

    public VBox getView() {
        return view;
    }
}
