package com.twoFMonopoly.UI.controller;

import com.twoFMonopoly.UI.Constants;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassicModeMapController {

    @FXML
    private Rectangle property10;
    @FXML
	private Rectangle corner3;
    @FXML
    private Rectangle corner4;
    @FXML
	private Rectangle property9;
    @FXML
	private Rectangle corner2;
    @FXML
	private Rectangle property8;
    @FXML
	private Rectangle chance1;
    @FXML
	private Rectangle property7;
    @FXML
	private Rectangle property6;
    @FXML
	private Rectangle property11;
    @FXML
	private Rectangle property12;
    @FXML
	private Rectangle property13;
    @FXML
	private Rectangle propertyOwner12;
    @FXML
	private Rectangle propertyOwner13;
    @FXML
	private Rectangle communityChest2;
    @FXML
	private Rectangle property14;
    @FXML
	private Rectangle property15;
    @FXML
	private Rectangle property16;
    @FXML
	private Rectangle corner1;
    @FXML
	private Rectangle property17;
    @FXML
	private Rectangle chance2;
    @FXML
	private Rectangle tax1;
    @FXML
	private Rectangle property18;
    @FXML
	private Rectangle property19;
    @FXML
	private Rectangle property5;
    @FXML
	private Rectangle property4;
    @FXML
	private Rectangle property3;
    @FXML
	private Rectangle communityChest1;
    @FXML
	private Rectangle property2;
    @FXML
	private Rectangle property1;
    @FXML
	private Rectangle propertyOwner10;
    @FXML
	private Rectangle propertyOwner9;
    @FXML
	private Rectangle propertyOwner8;
    @FXML
	private Rectangle propertyOwner7;
    @FXML
	private Rectangle propertyOwner6;
    @FXML
	private Rectangle propertyOwner19;
    @FXML
	private Rectangle propertyOwner18;
    @FXML
	private Rectangle propertyOwner17;
    @FXML
	private Rectangle propertyOwner16;
    @FXML
	private Rectangle propertyOwner15;
    @FXML
	private Rectangle propertyOwner14;
    @FXML
	private Rectangle propertyOwner11;
    @FXML
	private Rectangle propertyOwner1;
    @FXML
	private Rectangle propertyOwner2;
    @FXML
	private Rectangle propertyOwner3;
    @FXML
	private Rectangle propertyOwner4;
    @FXML
	private Rectangle propertyOwner5;
    @FXML
	private Text playerName1;
    @FXML
	private Text playerName2;
    @FXML
	private Text playerName3;
    @FXML
	private Text playerName4;
    @FXML
	private Text playerName5;
    @FXML
	private Text playerName6;
    @FXML
	private Text playerName7;
    @FXML
	private Text playerName8;
    @FXML
	private Text playerMoney7;
    @FXML
	private Text playerMoney8;
    @FXML
	private Text playerMoney5;
    @FXML
	private Text playerMoney6;
    @FXML
	private Text playerMoney4;
    @FXML
	private Text playerMoney3;
    @FXML
	private Text playerMoney2;
    @FXML
	private Text playerMoney1;
    @FXML
	private Text turnText;
    @FXML
	private Circle playerToken4;
    @FXML
	private Circle playerToken5;
    @FXML
	private Circle playerToken6;
    @FXML
	private Circle playerToken2;
    @FXML
	private Circle playerToken3;
    @FXML
	private Circle playerToken7;
    @FXML
	private Circle playerToken1;
    @FXML
	private Circle playerToken8;
    @FXML
	private Text playerTime1;
    @FXML
	private Text playerTime2;
    @FXML
	private Text playerTime3;
    @FXML
	private Text playerTime4;
    @FXML
	private Text playerTime5;
    @FXML
	private Text playerTime6;
    @FXML
	private Text playerTime7;
    @FXML
	private Text playerTime8;
    @FXML
	private Button rollButton;
    @FXML
	private Button endOfTurnButton;
    @FXML
    protected AnchorPane root;

    private int playerCount;
    private ArrayList<String> colors;
    private ArrayList<String> names;
    private ArrayList<Integer> queueIndices;

    private ArrayList<Text> playerNames, playerTimes, playerMoneys;
    private ArrayList<Rectangle> properties, corners, chances, communityChests, locations, propertyOwners;
    private ArrayList<Circle> playerTokens;

    public void init(int playerCount, ArrayList<String> colors, ArrayList<String> names, ArrayList<Integer> queueIndices){
        playerNames = new ArrayList<>(Arrays.asList(playerName1, playerName2, playerName3, playerName4, playerName5, playerName6, playerName7, playerName8));
        playerTimes = new ArrayList<>(Arrays.asList(playerTime1, playerTime2, playerTime3, playerTime4, playerTime5, playerTime6, playerTime7, playerTime8));
        playerMoneys = new ArrayList<>(Arrays.asList(playerMoney1, playerMoney2, playerMoney3, playerMoney4, playerMoney5, playerMoney6, playerMoney7, playerMoney8));
        playerTokens = new ArrayList<>(Arrays.asList(playerToken1, playerToken2, playerToken3, playerToken4, playerToken5, playerToken6, playerToken7, playerToken8));
        properties = new ArrayList<>(Arrays.asList(property1, property2, property3, property4, property5, property6, property7, property8, property9, property10,
                                                property11, property12, property13, property14, property15, property16, property17, property18, property19));
        corners = new ArrayList<>(Arrays.asList(corner1, corner2, corner3, corner4));
        chances = new ArrayList<>(Arrays.asList(chance1, chance2));
        communityChests = new ArrayList<>(Arrays.asList(communityChest1, communityChest2));
        propertyOwners = new ArrayList<>(Arrays.asList(propertyOwner1, propertyOwner2, propertyOwner3, propertyOwner3, propertyOwner4, propertyOwner5, propertyOwner6, propertyOwner7, propertyOwner8, propertyOwner9, propertyOwner10, propertyOwner11, propertyOwner12, propertyOwner13, propertyOwner14, propertyOwner15, propertyOwner16, propertyOwner17, propertyOwner18, propertyOwner19));

        this.playerCount = playerCount;
        this.colors = new ArrayList<String>(colors);
        this.names = new ArrayList<String>(names);
        this.queueIndices = new ArrayList<Integer>(queueIndices);

        refactorPlayers();
    }

    private void refactorPlayers(){
        for(int i = playerCount; i < 8; ++i){
            playerNames.get(i).setVisible(false);
            playerTokens.get(i).setVisible(false);
            playerMoneys.get(i).setVisible(false);
            playerTimes.get(i).setVisible(false);
        }

        for (int i = 0; i < playerCount; ++i){
            playerNames.get(i).setText(names.get(i));
            playerNames.get(i).setFill(Color.web(Constants.colors.get(colors.get(i))));
            playerTokens.get(i).setFill(Color.web(Constants.colors.get(colors.get(i))));
        }
    }






}
