package com.twoFMonopoly;

import com.twoFMonopoly.UI.controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/mainMenu.fxml"));
        Parent root = fxmlLoader.load();

        MainMenuController mainMenuController = fxmlLoader.getController();
        fxmlLoader.setController(mainMenuController);
        mainMenuController.init();

        primaryStage.setResizable(false);
        primaryStage.setTitle("2FMonopoly");
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
