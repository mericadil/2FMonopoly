package com.twoFMonopoly.UI.controller;

import com.twoFMonopoly.Main;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

public class OptionsController {
    @FXML
    public Slider musicVolume;

    @FXML
    public Slider sfxVolume;
    
    public void init() {
        musicVolume.setMin(0);
        musicVolume.setMax(100);
        musicVolume.setValue(50);
        musicVolume.setMinorTickCount(5);
        musicVolume.setBlockIncrement(10);
        sfxVolume.setMin(0);
        sfxVolume.setMax(100);
        sfxVolume.setValue(40);
        sfxVolume.setMinorTickCount(5);
        sfxVolume.setBlockIncrement(10);
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

    public void setMusicVolume(MouseEvent mouseEvent) {
        Slider slider = (Slider) mouseEvent.getSource();
        System.out.println(slider.getValue() + " " + Main.player.getVolume());
        Main.player.setVolume(slider.getValue() / 100);
    }

    public void setSFXVolume(MouseEvent mouseEvent) {
    }
}
