package org.example.demo4;

import javafx.stage.Stage;

public class AuthScreen {

    public void showLogin(Stage stage) {
        LoginScreen login = new LoginScreen(stage, this);
        SceneUtil.setStyledScene(stage, login.getView());
    }

    public void showRegister(Stage stage) {
        RegisterScreen register = new RegisterScreen(stage, this);
        SceneUtil.setStyledScene(stage, register.getView());
    }
}
