package com.twoFMonopoly.UI.controller;
/**
 * LoadGameController is the controller of the monopoly game. It just manages the load game page
 * @authors: Adil Meric - Omer Faruk Akgul - Osman Batur Ince - Burak Ocalan - Doga Tansel
 * @date: 22.11.2020
 * @version: 20.12.2020
 */
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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class LoadGameController {


    public VBox listTilesVBox;

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

    public void createSingleLoadGameTile(String fileName, String fileTime, Path file) {
        HBox hBox = new HBox();
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(1143.0);
        AnchorPane anchorPane1 = new AnchorPane();
        hBox.getChildren().add(anchorPane1);
        anchorPane1.setPrefHeight(100.0);
        anchorPane1.setPrefWidth(259.0);
        Text text1 = new Text();
        anchorPane1.getChildren().add(text1);

        text1.setFont(new Font(22.0));
        text1.setLayoutX(59.0);
        text1.setLayoutY(59.0);
        text1.setStrokeType(StrokeType.OUTSIDE);
        text1.setTextAlignment(TextAlignment.CENTER);
        text1.setText(fileName);

        AnchorPane anchorPane2 = new AnchorPane();
        hBox.getChildren().add(anchorPane2);
        anchorPane2.setPrefHeight(100.0);
        anchorPane2.setPrefWidth(238.0);

        AnchorPane anchorPane3 = new AnchorPane();
        hBox.getChildren().add(anchorPane3);
        anchorPane3.setPrefHeight(100.0);
        anchorPane3.setPrefWidth(261.0);

        Text text2 = new Text();
        anchorPane3.getChildren().add(text2);
        text2.setFont(new Font(22.0));
        text2.setLayoutX(45.0);
        text2.setLayoutY(59.0);
        text2.setStrokeType(StrokeType.OUTSIDE);
        text2.setTextAlignment(TextAlignment.CENTER);
        text2.setText(fileTime);

        AnchorPane anchorPane4 = new AnchorPane();
        hBox.getChildren().add(anchorPane4);
        anchorPane4.setPrefHeight(200.0);
        anchorPane4.setPrefWidth(200.0);

        AnchorPane anchorPane5 = new AnchorPane();
        hBox.getChildren().add(anchorPane5);
        anchorPane5.setPrefHeight(200.0);
        anchorPane5.setPrefWidth(200.0);
        Button button = new Button("Play");
        button.setLayoutX(120.0);
        button.setLayoutY(30.0);
        button.setOnMouseClicked((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/classicModeMap.fxml"));
                Parent root = fxmlLoader.load();
                Stage window = (Stage)(button).getScene().getWindow();
                window.getScene().setRoot(root);
                window.show();

                ClassicModeMapController classicModeMapController = fxmlLoader.getController();
                fxmlLoader.setController(classicModeMapController);
                initLoadGame( classicModeMapController, fileName);

                System.out.println(window);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        anchorPane5.getChildren().add(button);

        Text text3 = new Text();
        anchorPane5.getChildren().add(text3);

        text3.setFont(new Font("System Bold",28.0));
        text3.setFill(Color.rgb(255, 0, 0));
        text3.setLayoutX(46.0);
        text3.setLayoutY(61.0);
        text3.setStrokeType(StrokeType.OUTSIDE);
        text3.setText("X");
        text3.setOnMouseClicked( (event) -> {
            try {
                Files.deleteIfExists(file);
            } catch( Exception e){
                e.printStackTrace();
            }
        });

        listTilesVBox.getChildren().add(hBox);

    }

    public void createLoadGameTiles() {
        try (Stream<Path> paths = Files.walk(Paths.get(Constants.SAVE_GAME_FOLDER))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach( file -> {
                        try {
                            FileTime fileTime = Files.getLastModifiedTime(file);
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
                            String fileTimeStr = dateFormat.format(fileTime.toMillis());
                            String fileName = file.getFileName().toString();
                            createSingleLoadGameTile(fileName, fileTimeStr, file);

                        } catch( Exception e){
                            e.printStackTrace();
                        }
                    });
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sjsjs(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/classicModeMap.fxml"));
            Parent root = fxmlLoader.load();
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root);
            window.show();

            ClassicModeMapController classicModeMapController = fxmlLoader.getController();
            fxmlLoader.setController(classicModeMapController);
            initLoadGame( classicModeMapController, "fileName");

            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initLoadGame( ClassicModeMapController classicModeMapController, String fileName) {
        String filepath = Constants.SAVE_GAME_FOLDER + fileName;
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
