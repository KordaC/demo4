package org.example.demo4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static User currentUser;

    @Override
    public void start(Stage stage) {
        AuthScreen authScreen = new AuthScreen();
        LoginScreen loginScreen = new LoginScreen(stage, authScreen);

        Scene scene = new Scene(loginScreen.getView(), 400, 600);

        scene.getStylesheets().add(getClass().getResource("/mainMenu.css").toExternalForm());

        stage.setTitle("BOLGARIN gym");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
