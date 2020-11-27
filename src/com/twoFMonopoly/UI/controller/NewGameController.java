package com.twoFMonopoly.UI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NewGameController {

    @FXML
    private Button startButton;
    @FXML
    private TextField playerOnePlayerName;
    @FXML
    private ChoiceBox playerOneChoiceBox;
    @FXML
    private AnchorPane playerTwoAnchorPane;
    @FXML
    private TextField playerTwoPlayerName;
    @FXML
    private ChoiceBox playerTwoChoiceBox;
    @FXML
    private AnchorPane playerThreeAnchorPane;
    @FXML
    private TextField playerThreePlayerName;
    @FXML
    private ChoiceBox playerThreeChoiceBox;
    @FXML
    private AnchorPane playerFourAnchorPane;
    @FXML
    private TextField playerFourPlayerName;
    @FXML
    private ChoiceBox playerFourChoiceBox;
    @FXML
    private AnchorPane playerFiveAnchorPane;
    @FXML
    private TextField playerFivePlayerName;
    @FXML
    private ChoiceBox playerFiveChoiceBox;
    @FXML
    private AnchorPane playerSixAnchorPane;
    @FXML
    private TextField playerSixPlayerName;
    @FXML
    private ChoiceBox playerSixChoiceBox;
    @FXML
    private AnchorPane playerSevenAnchorPane;
    @FXML
    private TextField playerSevenPlayerName;
    @FXML
    private ChoiceBox playerSevenChoiceBox;
    @FXML
    private AnchorPane playerEightAnchorPane;
    @FXML
    private TextField playerEightPlayerName;
    @FXML
    private ChoiceBox playerEightChoiceBox;

    @FXML
    private AnchorPane playerOneAnchorPane;

    @FXML
    private HBox hboxOne, hboxTwo;



    private ArrayList<String> colors;
    private ArrayList<String> names;

    private ArrayList<Integer> lockedPlayers = new ArrayList<Integer>();
    private ArrayList<AnchorPane> anchorPanes;
    private ArrayList<ChoiceBox> choiceBoxes;
    private ArrayList<TextField> playerNames;


    private int playerCount;
    private String modeName;

    @FXML
    public void goToPlayGame(ActionEvent actionEvent){
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
    public void init( int playerCount, String modeName) {
        anchorPanes = new ArrayList<>(Arrays.asList(playerOneAnchorPane, playerTwoAnchorPane, playerThreeAnchorPane, playerFourAnchorPane,
                playerFiveAnchorPane, playerSixAnchorPane, playerSevenAnchorPane, playerEightAnchorPane));
        choiceBoxes = new ArrayList<>(Arrays.asList(playerOneChoiceBox, playerTwoChoiceBox, playerThreeChoiceBox, playerFourChoiceBox,
                playerFiveChoiceBox, playerSixChoiceBox, playerSevenChoiceBox, playerEightChoiceBox));
        playerNames = new ArrayList<>(Arrays.asList(playerOnePlayerName, playerTwoPlayerName, playerThreePlayerName, playerFourPlayerName, playerFivePlayerName, playerSixPlayerName, playerSevenPlayerName, playerEightPlayerName));

        startButton.setDisable(true);

        this.playerCount = playerCount;
        this.modeName = modeName;

        colors = new ArrayList<>(Arrays.asList(new String[playerCount]));
        names = new ArrayList<>(Arrays.asList(new String[playerCount]));
        System.out.println(playerCount + " " + modeName);

        for( int i = playerCount; i < 8; ++i){
            this.disableAnchorPane(anchorPanes.get(i));
        }


    }

    private void disableAnchorPane( AnchorPane anchorPane){
        for( int i = 0; i < anchorPane.getChildren().size(); ++i){
            anchorPane.getChildren().get(i).setDisable(true);
            if(anchorPane.getChildren().get(i) instanceof Text){
                anchorPane.getChildren().get(i).setOpacity(0.37);
            }
        }
    }

    @FXML
    public void playerReady(ActionEvent actionEvent) {
        Button clickedButton = ((Button) (actionEvent.getSource()));
        AnchorPane anchorPane = (AnchorPane) clickedButton.getParent();
        int anchorPaneIndex = 0;

        for( int i = 0; i < anchorPanes.size(); ++i) {
            if (anchorPane == anchorPanes.get(i)){
                anchorPaneIndex = i;
            }
        }

        if( clickedButton.getText().equals("Confirm")){
            if( !colors.contains(((String) choiceBoxes.get(anchorPaneIndex).getSelectionModel().getSelectedItem())) && !playerNames.get(anchorPaneIndex).getText().trim().isEmpty()) {
                for (int i = 0; i < anchorPane.getChildren().size(); ++i) {
                    if (clickedButton != anchorPane.getChildren().get(i)) {
                        anchorPane.getChildren().get(i).setDisable(true);
                    }
                }
                colors.set( anchorPaneIndex,((String) choiceBoxes.get(anchorPaneIndex).getSelectionModel().getSelectedItem()));
                names.set(anchorPaneIndex, ( playerNames.get(anchorPaneIndex).getText().trim()));
                lockedPlayers.add(anchorPaneIndex);
                clickedButton.setText("Cancel");

                if( lockedPlayers.size() == playerCount) {
                    startButton.setDisable(false);
                }
            } else {
                choiceBoxes.get(anchorPaneIndex).setBorder(new Border(new BorderStroke(Color.RED,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            }
        } else {
            for( int i = 0; i < anchorPane.getChildren().size(); ++i) {
                if (clickedButton != anchorPane.getChildren().get(i)) {
                    anchorPane.getChildren().get(i).setDisable(false);
                }
                try {
                    lockedPlayers.remove(lockedPlayers.indexOf(anchorPaneIndex));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            clickedButton.setText("Confirm");
        }
    }

    @FXML
    public void goToOrderDetermination(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/twoFMonopoly/UI/FX/orderDetermination.fxml"));
            Parent root = fxmlLoader.load();
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root);
            window.show();

            OrderDeterminationController orderDeterminationController = fxmlLoader.getController();
            fxmlLoader.setController(orderDeterminationController);
            orderDeterminationController.init(playerCount, colors, names);

            System.out.println(window);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
