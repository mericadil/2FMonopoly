package com.twoFMonopoly.UI.controller;

/**
 * MainMenuController is the controller of the monopoly game. It just manages the main menu page
 * @authors: Adil Meric - Omer Faruk Akgul - Osman Batur Ince - Burak Ocalan - Doga Tansel
 * @date: 22.11.2020
 * @version: 20.12.2020
 */

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.Main;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Paths;

public class MainMenuController {
    public MainMenuController() {
        Main.player.stop();
        Main.player = new MediaPlayer(new Media(Paths.get(Constants.OPENING_MUSIC).toUri().toString()));
        Main.player.setOnEndOfMedia( () -> Main.player.seek(Duration.ZERO));
        Main.player.setVolume(0.5);
        Main.player.play();
    }

    @FXML
    public void goToPlayGame(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/playGame.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToModeEditor(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/modeEditor.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToOptions(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/options.fxml"));
            Parent root = fxmlLoader.load();
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root);
            window.show();

            OptionsController optionsController = fxmlLoader.getController();
            fxmlLoader.setController(optionsController);
            optionsController.init();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void goToHowToPlay(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/howToPlay.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToCredits(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/credits.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void terminateApp(ActionEvent actionEvent) {
        System.exit(0);
    }
}
