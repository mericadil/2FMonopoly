package com.twoFMonopoly;

import com.twoFMonopoly.UI.controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/mainMenu.fxml"));
        Parent root = fxmlLoader.load();

        MainMenuController mainMenuController = fxmlLoader.getController();
        fxmlLoader.setController(mainMenuController);

        primaryStage.setResizable(false);
        primaryStage.setTitle("2FMonopoly");
        primaryStage.setScene(new Scene(root, 1366, 768));
        player.play();
        player.setOnEndOfMedia(new Runnable() {
            public void run() {
                player.seek(Duration.ZERO);
            }
        });

        primaryStage.show();

    }

    public static MediaPlayer player;
    public Main() {
        player = new MediaPlayer(new Media(Paths.get(Constants.OPENING_MUSIC).toUri().toString()));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
