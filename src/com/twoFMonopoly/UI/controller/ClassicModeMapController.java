package com.twoFMonopoly.UI.controller;

import com.twoFMonopoly.UI.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
    private ImageView diceImage1;
    @FXML
    private ImageView diceImage2;
    @FXML
    private AnchorPane propertyPane;
    @FXML
    private Rectangle propertyNameRect;
    @FXML
    private Text propertyName;
    @FXML
    private Button closePropertyButton;
    @FXML
    private Text costText;
    @FXML
    private Text cost;
    @FXML
    private Text rentText;
    @FXML
    private Text siteOnlyText;
    @FXML
    private Text oneHouseText;
    @FXML
    private Text twoHousesText;
    @FXML
    private Text threeHousesText;
    @FXML
    private Text fourHousesText;
    @FXML
    private Text hotelText;
    @FXML
    private Text siteOnlyRent;
    @FXML
    private Text oneHouseRent;
    @FXML
    private Text twoHousesRent;
    @FXML
    private Text threeHousesRent;
    @FXML
    private Text fourHousesRent;
    @FXML
    private Text hotelRent;
    @FXML
    private Text houseCostText;
    @FXML
    private Text hotelCostText;
    @FXML
    private Text mortgageValueText;
    @FXML
    private Text houseCost;
    @FXML
    private Text hotelCost;
    @FXML
    private Text mortgageValue;
    @FXML
    private Button buildButton;
    @FXML
    private Button buyButton;
    @FXML
    private Button sellButton;
    @FXML
    private Button mortgageButton;

    @FXML
    protected AnchorPane root;

    private Random dice;
    private int currentPlayer;
    private int playerCount;
    private ArrayList<String> colors;
    private ArrayList<String> names;
    private ArrayList<Integer> queueIndices;
    private ArrayList<Integer> playerLocations;

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
        playerLocations = new ArrayList<>();
        locations = new ArrayList<>(Arrays.asList(  corner1, property1, property2, communityChest1, property3, property4, property5,
                                                    corner2, property6, property7, chance1, property8, property9, property10,
                                                    corner3, property11, property12, property13, communityChest2, property14, property15,
                                                    corner4, property16, property17, chance2, tax1, property18, property19));
        propertyOwners = new ArrayList<>(Arrays.asList( propertyOwner1, propertyOwner2, propertyOwner3, propertyOwner4, propertyOwner5,
                                                        propertyOwner6, propertyOwner7, propertyOwner8, propertyOwner9, propertyOwner10,
                                                        propertyOwner11, propertyOwner12, propertyOwner13, propertyOwner14, propertyOwner15,
                                                        propertyOwner16, propertyOwner17, propertyOwner18, propertyOwner19));

        currentPlayer = 0;
        this.playerCount = playerCount;
        this.colors = new ArrayList<String>(colors);
        this.names = new ArrayList<String>(names);
        this.queueIndices = new ArrayList<Integer>(queueIndices);

        refactorPlayers();
        endOfTurnButton.setDisable(true);
        setTurnText(currentPlayer);
        propertyPane.setVisible(false);
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
            playerLocations.add(0);
        }

    }

    private int rollDice(){
        dice = new Random();
        return dice.nextInt(6) + 1;
    }

    @FXML
    public void rollButtonPushed(ActionEvent event){
        int dice1 = rollDice();
        int dice2 = rollDice();

        String dice1Url = "/com/twoFMonopoly/UI/assets/dice" + dice1 + ".png";
        String dice2Url = "/com/twoFMonopoly/UI/assets/dice" + dice2 + ".png";

        diceImage1.setImage(new Image(getClass().getResourceAsStream(dice1Url)));
        diceImage2.setImage(new Image(getClass().getResourceAsStream(dice2Url)));

        int newLocation = (playerLocations.get(currentPlayer) + dice1 + dice2) % 28;
        playerLocations.set(currentPlayer, newLocation);

        setNewCoordinate(newLocation);

        rollButton.setDisable(true);
        endOfTurnButton.setDisable(false);
        if(locations.get(newLocation).getId().substring(0, 4).equals("prop")) {
            propertyPane.setVisible(true);
            propertyPaneSettings();
        }

    }

    private void propertyPaneSettings() {
        int playerLocation = playerLocations.get(currentPlayer);
        String idOfLocation = locations.get(playerLocation).getId();
        int propertyNum;
        if(playerLocation >12){
            propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 2));
        }
        else{
            propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 1));
        }
        if(propertyOwners.get(propertyNum - 1).getFill() == playerTokens.get(queueIndices.get(currentPlayer)).getFill()){
            sellButton.setDisable(false);
            buyButton.setDisable(true);
            buildButton.setDisable(false);
            mortgageButton.setDisable(false);
        }
        else if((propertyOwners.get(propertyNum - 1).getFill() == Color.WHITE)){
            sellButton.setDisable(true);
            buyButton.setDisable(false);
            buildButton.setDisable(true);
            mortgageButton.setDisable(true);
        }
        else{
            sellButton.setDisable(true);
            buyButton.setDisable(true);
            buildButton.setDisable(true);
            mortgageButton.setDisable(true);
        }
    }

    private void setNewCoordinate(int playerLocation){
        Rectangle playerLocationOnBoard = locations.get(playerLocation);
        double xLeftBorder = playerLocationOnBoard.getLayoutX();
        double xRightBorder = xLeftBorder + playerLocationOnBoard.getWidth();
        double yUpperBorder = playerLocationOnBoard.getLayoutY();
        double yDownBorder = yUpperBorder + playerLocationOnBoard.getHeight();

        Random random = new Random();
        double newXCoordinate = xLeftBorder + random.nextInt( (int)((xRightBorder - xLeftBorder) - 2 * playerToken1.getRadius())) + playerToken1.getRadius();
        double newYCoordinate = yUpperBorder + random.nextInt( (int)((yDownBorder - yUpperBorder) - 2 * playerToken1.getRadius())) + playerToken1.getRadius();
        playerTokens.get(queueIndices.get(currentPlayer)).setLayoutX(newXCoordinate);
        playerTokens.get(queueIndices.get(currentPlayer)).setLayoutY(newYCoordinate);
    }

    private void setTurnText(int index){
        String textToDisplayTurn = playerNames.get(queueIndices.get(index)).getText();
        turnText.setText(textToDisplayTurn + "'s Turn");
        Paint playerColor = playerTokens.get(queueIndices.get(currentPlayer)).getFill();
        turnText.setFill(playerColor);
    }
    @FXML
    public void endTurnButtonPushed(ActionEvent event) {
        currentPlayer = (currentPlayer + 1) % playerCount;
        setTurnText(currentPlayer);

        rollButton.setDisable(false);
        endOfTurnButton.setDisable(true);
    }

    @FXML
    public void closeButtonPushed(ActionEvent event) {
        propertyPane.setVisible(false);
    }

    @FXML
    public void pauseAndReturnMainMenu(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../FX/mainMenu.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.getScene().setRoot(root); window.show();
        System.out.println(window);
    }
    @FXML
    public void buyButtonPushed(ActionEvent event) {
        int playerLocation = playerLocations.get(currentPlayer);
        setColorOfLocation(playerLocation, "buy");
        buyButton.setDisable(true);
    }

    @FXML
    public void sellButtonPushed(ActionEvent event) {
        int playerLocation = playerLocations.get(currentPlayer);
        setColorOfLocation(playerLocation, "sell");
        sellButton.setDisable(true);
    }

    private void setColorOfLocation(int playerLocation, String eventType){
        String idOfLocation = locations.get(playerLocation).getId();
        if(idOfLocation.substring(0, 4).equals("prop")){
            int propertyNum;
            if(playerLocation >12){
                propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 2));
            }
            else{
                propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 1));
            }
            if(eventType == "buy") {
                if (propertyOwners.get(propertyNum - 1).getFill() == Color.WHITE) {
                    Paint playerColor = playerTokens.get(queueIndices.get(currentPlayer)).getFill();
                    propertyOwners.get(propertyNum - 1).setFill(playerColor);
                }
            }
            else{
                propertyOwners.get(propertyNum - 1).setFill(Color.WHITE);
                propertyPane.setVisible(false);
            }
        }
    }
}
