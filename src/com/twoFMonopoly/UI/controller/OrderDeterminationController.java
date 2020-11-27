package com.twoFMonopoly.UI.controller;

import com.twoFMonopoly.UI.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderDeterminationController {

    @FXML
    private Button startButton;
    @FXML
    private AnchorPane playerOneAnchorPane;
    @FXML
    private AnchorPane playerTwoAnchorPane;
    @FXML
    private AnchorPane playerThreeAnchorPane;
    @FXML
    private AnchorPane playerFourAnchorPane;
    @FXML
    private AnchorPane playerFiveAnchorPane;
    @FXML
    private AnchorPane playerSixAnchorPane;
    @FXML
    private AnchorPane playerSevenAnchorPane;
    @FXML
    private AnchorPane playerEightAnchorPane;

    @FXML
    private Button rollOne;
    @FXML
    private Button rollTwo;
    @FXML
    private Button rollThree;
    @FXML
    private Button rollFour;
    @FXML
    private Button rollFive;
    @FXML
    private Button rollSix;
    @FXML
    private Button rollSeven;
    @FXML
    private Button rollEight;


    @FXML
    private Text playerNameOne;
    @FXML
    private Text playerNameTwo;
    @FXML
    private Text playerNameThree;
    @FXML
    private Text playerNameFour;
    @FXML
    private Text playerNameFive;
    @FXML
    private Text playerNameSix;
    @FXML
    private Text playerNameSeven;
    @FXML
    private Text playerNameEight;

    @FXML
    private Text resultOne;
    @FXML
    private Text resultTwo;
    @FXML
    private Text resultThree;
    @FXML
    private Text resultFour;
    @FXML
    private Text resultFive;
    @FXML
    private Text resultSix;
    @FXML
    private Text resultSeven;
    @FXML
    private Text resultEight;
    @FXML
    private Text queueText;
    

    @FXML
    private HBox hboxOne, hboxTwo;


    private Random dice;
    private int playerCount;
    private ArrayList<String> colors;
    private ArrayList<String> names;
    private ArrayList<AnchorPane> anchorPanes;
    private ArrayList<Button> buttons;
    private ArrayList<Text> playerNames;
    private ArrayList<Text> results;
    private ArrayList<Integer> rollOutcomes;
    private Map<Integer, Integer> indicesRolls;

    public OrderDeterminationController() {
        rollOutcomes = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        dice = new Random(System.currentTimeMillis());
        indicesRolls = new HashMap<Integer, Integer>();
    }

    public void init(int playerCount, ArrayList<String> colors, ArrayList<String> names){
        anchorPanes = new ArrayList<>(Arrays.asList(playerOneAnchorPane, playerTwoAnchorPane, playerThreeAnchorPane, playerFourAnchorPane, playerFiveAnchorPane, playerSixAnchorPane, playerSevenAnchorPane, playerEightAnchorPane));
        buttons = new ArrayList<>(Arrays.asList(rollOne, rollTwo, rollThree, rollFour, rollFive, rollSix, rollSeven, rollEight));
        results = new ArrayList<>(Arrays.asList(resultOne, resultTwo, resultThree, resultFour, resultFive, resultSix, resultSeven, resultEight));
        playerNames = new ArrayList<>(Arrays.asList(playerNameOne, playerNameTwo, playerNameThree, playerNameFour, playerNameFive, playerNameSix, playerNameSeven, playerNameEight));

        for(int i = playerCount; i < 8; ++i){
            disableAnchorPane(anchorPanes.get(i));
        }

        for(int i = 0; i < playerCount; ++i){
            playerNames.get(i).setText(names.get(i));
            playerNames.get(i).setFill(Color.web(Constants.colors.get(colors.get(i))));
        }

        this.playerCount = playerCount;
        this.colors = new ArrayList<String>(colors);
        this.names = new ArrayList<String>(names);

    }

    private void disableAnchorPane( AnchorPane anchorPane){
        for( int i = 0; i < anchorPane.getChildren().size(); ++i){
            anchorPane.getChildren().get(i).setDisable(true);
            if(anchorPane.getChildren().get(i) instanceof Text){
                anchorPane.getChildren().get(i).setOpacity(0.37);
            }
        }
    }

    public int rollDice(){
        dice.setSeed(System.currentTimeMillis());
        return dice.nextInt(11) + 2;
    }

    @FXML
    public void rollButtonPushed(ActionEvent event){
        int source = 0;
        for( int i = 0; i < playerCount; ++i){
            if (((Button) (event.getSource())) == buttons.get(i))
                source = i;
        }

        int outcome = rollDice();
        rollOutcomes.set(source, outcome);
        buttons.get(source).setDisable(true);
        results.get(source).setText("Result: " + outcome);

        boolean rollsComplete = true;
        for(int i = 0; i < playerCount; ++i){
            if ( !buttons.get(i).isDisabled()){
                rollsComplete = false;
            }
        }

        if( rollsComplete){
            for(int i = 0; i < playerCount; ++i)
                indicesRolls.put(i, rollOutcomes.get(i));

            Stream<Map.Entry<Integer,Integer>> sorted = indicesRolls.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
            StringBuilder queueTextValue = new StringBuilder();
            sorted.forEach( entry -> { queueTextValue.append(names.get(entry.getKey())).append(" > ");});
            queueTextValue.delete( queueTextValue.length() - 3,queueTextValue.length());
            queueText.setText(queueTextValue.toString().trim());
        }


    }

    @FXML
    public void goToClassicModeMap(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/classicModeMap.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
