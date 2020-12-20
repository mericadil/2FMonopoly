package com.twoFMonopoly.UI.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
/**
 * WinnerScreenController is the controller of the monopoly game. It just manages winner screen page
 * @authors: Adil Meric - Omer Faruk Akgul - Osman Batur Ince - Burak Ocalan - Doga Tansel
 * @date: 22.11.2020
 * @version: 20.12.2020
 */
public class WinnerScreenController {

    @FXML
    private Text winnerName;
    @FXML
    private Button mainMenuButton;

    public void init(String winnerName) {
        this.winnerName.setText(winnerName);
    }
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
}