package com.twoFMonopoly.UI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayGameController {
    @FXML
    private ChoiceBox playerChoiceBox;

    @FXML
    private ChoiceBox modeChoiceBox;

    @FXML
    public void goToMainMenu(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/mainMenu.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToNewGame(ActionEvent actionEvent){

        try {
            int playerCount = Integer.parseInt((String) playerChoiceBox.getSelectionModel().getSelectedItem());
            String modeName = (String) modeChoiceBox.getSelectionModel().getSelectedItem();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/newGame.fxml"));
            Parent root = fxmlLoader.load();
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root);
            window.show();

            NewGameController newGameController = fxmlLoader.getController();
            fxmlLoader.setController(newGameController);
            newGameController.init(playerCount, modeName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToLoadGame(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/loadGame.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
