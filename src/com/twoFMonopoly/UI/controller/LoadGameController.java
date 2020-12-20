package com.twoFMonopoly.UI.controller;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.Managers.PropertyManager;
import com.twoFMonopoly.Managers.RailroadManager;
import com.twoFMonopoly.models.Locations.Location;
import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Locations.Railroad;
import com.twoFMonopoly.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadGameController {


    @FXML
    public void sjsjs(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/mainMenu.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttonClicked() {

    }

    @FXML
    public void goToMainMenu(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/classicModeMap.fxml"));
            Parent root = fxmlLoader.load();
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root);
            window.show();

            ClassicModeMapController classicModeMapController = fxmlLoader.getController();
            fxmlLoader.setController(classicModeMapController);
            initLoadGame( classicModeMapController );

            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initLoadGame( ClassicModeMapController classicModeMapController ) {
        String filepath = Constants.SAVE_GAME_FOLDER + "test.sv";
        ArrayList<Object> newList = (ArrayList<Object>) readObjectFromFile( filepath );

        // get primitive types
        int count = 0;
        int currentPlayerIndex = (int) newList.get( count++ );
        int playerCount = (int) newList.get( count++ );
        ArrayList<String> colors = (ArrayList<String>) newList.get( count++ );
        ArrayList<String> names = (ArrayList<String>) newList.get( count++ );
        ArrayList<Integer> queueIndices = (ArrayList<Integer>) newList.get( count++ );
        ArrayList<Integer> playerLocations = (ArrayList<Integer>) newList.get( count++ );
        double moneyInTheMiddle = (double) newList.get( count++ );
        int lastClickedTradable  = (int) newList.get( count++ );
        ArrayList<Player> players = (ArrayList<Player>) newList.get( count++ );
        ArrayList<Location> locations = (ArrayList<Location>) newList.get( count++ );

        classicModeMapController.initLoadGame( currentPlayerIndex, playerCount, colors, names, queueIndices, locations, players, playerLocations,
                moneyInTheMiddle, lastClickedTradable );
    }

    private Object readObjectFromFile( String filepath ) {
        try {
            FileInputStream fis = new FileInputStream( filepath );
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object woi = ois.readObject();
            System.out.println( "Geldik.");
            return woi;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
