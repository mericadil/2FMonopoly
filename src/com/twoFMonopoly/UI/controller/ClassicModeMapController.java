package com.twoFMonopoly.UI.controller;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.Main;
import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.Managers.PropertyManager;
import com.twoFMonopoly.Managers.RailroadManager;
import com.twoFMonopoly.UI.GameInitializer;
import com.twoFMonopoly.models.Card.CardDeck;
import com.twoFMonopoly.models.Locations.*;
import com.twoFMonopoly.models.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;
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
    private AnchorPane negotiatePane;
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
    private int currentPlayerIndex;
    private int playerCount;
    private ArrayList<String> colors;
    private ArrayList<String> names;
    private ArrayList<Integer> queueIndices;

    private ArrayList<Text> playerNames, playerTimes, playerMoneys;
    private ArrayList<Rectangle> propertyViews, corners, chanceViews, communityChestViews, locationViews, propertyOwnerViews;
    private ArrayList<Circle> playerTokens;

    private PlayerManager playerManager;
    private RailroadManager railroadManager;
    private PropertyManager propertyManager;
    // Define model attributes
    private ArrayList<Location> locations;
    private ArrayList<Player> players;
    private ArrayList<Integer> playerLocations;
    private double moneyInTheMiddle;
    private Player currentPlayer;

    public void init(int playerCount, ArrayList<String> colors, ArrayList<String> names, ArrayList<Integer> queueIndices){
        Main.player.stop();
        Main.player  = new MediaPlayer(new Media(Paths.get(Constants.MAIN_MUSIC).toUri().toString()));
        Main.player.setOnEndOfMedia( () -> Main.player.seek(Duration.ZERO));
        Main.player.play();

        moneyInTheMiddle = 0;

        playerNames = new ArrayList<>(Arrays.asList(playerName1, playerName2, playerName3, playerName4, playerName5, playerName6, playerName7, playerName8));
        playerTimes = new ArrayList<>(Arrays.asList(playerTime1, playerTime2, playerTime3, playerTime4, playerTime5, playerTime6, playerTime7, playerTime8));
        playerMoneys = new ArrayList<>(Arrays.asList(playerMoney1, playerMoney2, playerMoney3, playerMoney4, playerMoney5, playerMoney6, playerMoney7, playerMoney8));
        playerTokens = new ArrayList<>(Arrays.asList(playerToken1, playerToken2, playerToken3, playerToken4, playerToken5, playerToken6, playerToken7, playerToken8));
        propertyViews = new ArrayList<>(Arrays.asList(property1, property2, property3, property4, property5, property6, property7, property8, property9, property10,
                                                property11, property12, property13, property14, property15, property16, property17, property18, property19));
        corners = new ArrayList<>(Arrays.asList(corner1, corner2, corner3, corner4));
        chanceViews = new ArrayList<>(Arrays.asList(chance1, chance2));
        communityChestViews = new ArrayList<>(Arrays.asList(communityChest1, communityChest2));
        propertyOwnerViews = new ArrayList<>(Arrays.asList(propertyOwner1, propertyOwner2, propertyOwner3, propertyOwner3, propertyOwner4, propertyOwner5, propertyOwner6, propertyOwner7, propertyOwner8, propertyOwner9, propertyOwner10, propertyOwner11, propertyOwner12, propertyOwner13, propertyOwner14, propertyOwner15, propertyOwner16, propertyOwner17, propertyOwner18, propertyOwner19));
        playerLocations = new ArrayList<>();
        locationViews = new ArrayList<>(Arrays.asList(  corner1, property1, property2, communityChest1, property3, property4, property5,
                                                    corner2, property6, property7, chance1, property8, property9, property10,
                                                    corner3, property11, property12, property13, communityChest2, property14, property15,
                                                    corner4, property16, property17, chance2, tax1, property18, property19));
        propertyOwnerViews = new ArrayList<>(Arrays.asList( propertyOwner1, propertyOwner2, propertyOwner3, propertyOwner4, propertyOwner5,
                                                        propertyOwner6, propertyOwner7, propertyOwner8, propertyOwner9, propertyOwner10,
                                                        propertyOwner11, propertyOwner12, propertyOwner13, propertyOwner14, propertyOwner15,
                                                        propertyOwner16, propertyOwner17, propertyOwner18, propertyOwner19));

        currentPlayerIndex = 0;
        this.playerCount = playerCount;
        this.colors = new ArrayList<>(colors);
        this.names = new ArrayList<>(names);
        this.queueIndices = new ArrayList<>(queueIndices);

        players = new ArrayList<>();

        for( int i = 0; i < playerCount; i++) {
            Player player = new Player(i, names.get(i), 250, colors.get(i));
            players.add(player);
        }
        currentPlayer = players.get(currentPlayerIndex);
        refactorPlayers();
        endOfTurnButton.setDisable(true);
        setTurnText(currentPlayerIndex);
        propertyPane.setVisible(false);
        negotiatePane.setVisible(false);
        //
        //GameInitializer.init();
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
            playerNames.get(i).setFill(Color.web(Constants.COLORS.get(colors.get(i))));
            playerTokens.get(i).setFill(Color.web(Constants.COLORS.get(colors.get(i))));
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

        if(currentPlayer.getJailStatus() == 0) {
            int newLocation = (playerLocations.get(currentPlayerIndex) + dice1 + dice2) % 28;
            playerLocations.set(currentPlayerIndex, newLocation);

            setNewCoordinate(newLocation);
            playerManager.setLocation(currentPlayer, newLocation);

            if(locations.get(newLocation) instanceof Property)
                takePropertyAction();
            else if(locations.get(newLocation) instanceof Railroad)
                takeRailroadAction();
            else if(locations.get(newLocation) instanceof Tax)
                takeTaxAction();
            else if(locations.get(newLocation) instanceof DirectToJail)
                takeGoToJailAction();
            else if(locations.get(newLocation) instanceof CardDeck)
                takeCardDeckAction();

            rollButton.setDisable(true);
            //endOfTurnButton.setDisable(false);
            /*
            if (locationViews.get(newLocation).getId().substring(0, 4).equals("prop")) {
                propertyPane.setVisible(true);
                propertyPaneSettings();
            }*/
        }
    }

    private void takeCardDeckAction() {

    }

    private void takeGoToJailAction() {

    }

    private void takeRailroadAction() {
        //int currentLocation = currentPlayer.getCurrentLocationIndex();
        //Railroad railroad = (Railroad) locations.get(currentLocation);


    }

    private void takeTaxAction() {
        int currentLocation = currentPlayer.getCurrentLocationIndex();
        Tax tax = (Tax) locations.get(currentLocation);
        double taxAmount = tax.getTaxAmount();
        if(playerManager.canAfford(currentPlayer,taxAmount)) {
            playerManager.giveMoney(currentPlayer,taxAmount);
        }
        else if(playerManager.tenderToAvoidBankrupt(currentPlayer, taxAmount)) {
            currentPlayer.setDebt(taxAmount);
            // Debt butonuuuuu
        }
        else
            playerManager.bankrupt(currentPlayer);
    }

    private void takePropertyAction() {
        int currentLocation = currentPlayer.getCurrentLocationIndex();
        Property property = (Property) locations.get(currentLocation);

        // If the property is owned by other player
        if(property.getOwner() != null && property.getOwner() != currentPlayer) {
            if(playerManager.canAfford(currentPlayer, property.getRentCost()))
                playerManager.payRentProperty(currentPlayer, property);
            else if(playerManager.tenderToAvoidBankrupt(currentPlayer, property.getRentCost())) {
                currentPlayer.setDebt(property.getRentCost());
                // Yukarı yazı düşelim burda kirayı ödemek için eşya satmanız lazım diye
                // bir de pay butonu yapıştıralım tepeye pay successful olana kadar end turn yapamasın

            }
            else {
                playerManager.bankrupt(currentPlayer, property.getOwner());
            }
        }
        else if( property.getOwner() == null) {
            propertyPane.setVisible(true);
            propertyPaneSettings();
        }
    }

    private void propertyPaneSettings() {
        int playerLocation = playerLocations.get(currentPlayerIndex);
        String idOfLocation = locationViews.get(playerLocation).getId();
        int propertyNum;
        if(playerLocation >12){
            propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 2));
        }
        else{
            propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 1));
        }
        if(propertyOwnerViews.get(propertyNum - 1).getFill() == playerTokens.get(queueIndices.get(currentPlayerIndex)).getFill()){
            sellButton.setDisable(false);
            buyButton.setDisable(true);
            buildButton.setDisable(false);
            mortgageButton.setDisable(false);
        }
        else if((propertyOwnerViews.get(propertyNum - 1).getFill() == Color.WHITE)){
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
        Rectangle playerLocationOnBoard = locationViews.get(playerLocation);
        double xLeftBorder = playerLocationOnBoard.getLayoutX();
        double xRightBorder = xLeftBorder + playerLocationOnBoard.getWidth();
        double yUpperBorder = playerLocationOnBoard.getLayoutY();
        double yDownBorder = yUpperBorder + playerLocationOnBoard.getHeight();

        Random random = new Random();
        double newXCoordinate = xLeftBorder + random.nextInt( (int)((xRightBorder - xLeftBorder) - 2 * playerToken1.getRadius())) + playerToken1.getRadius();
        double newYCoordinate = yUpperBorder + random.nextInt( (int)((yDownBorder - yUpperBorder) - 2 * playerToken1.getRadius())) + playerToken1.getRadius();
        playerTokens.get(queueIndices.get(currentPlayerIndex)).setLayoutX(newXCoordinate);
        playerTokens.get(queueIndices.get(currentPlayerIndex)).setLayoutY(newYCoordinate);
    }

    private void setTurnText(int index){
        String textToDisplayTurn = playerNames.get(queueIndices.get(index)).getText();
        turnText.setText(textToDisplayTurn + "'s Turn");
        Paint playerColor = playerTokens.get(queueIndices.get(currentPlayerIndex)).getFill();
        turnText.setFill(playerColor);
    }

    @FXML
    public void endTurnButtonPushed(ActionEvent event) {
        currentPlayerIndex = (currentPlayerIndex + 1) % playerCount;
        setTurnText(currentPlayerIndex);

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
        int playerLocation = playerLocations.get(currentPlayerIndex);
        setColorOfLocation(playerLocation, "buy");
        buyButton.setDisable(true);
    }

    @FXML
    public void sellButtonPushed(ActionEvent event) {
        int playerLocation = playerLocations.get(currentPlayerIndex);
        setColorOfLocation(playerLocation, "sell");
        sellButton.setDisable(true);
    }

    private void setColorOfLocation(int playerLocation, String eventType){
        String idOfLocation = locationViews.get(playerLocation).getId();
        if(idOfLocation.substring(0, 4).equals("prop")){
            int propertyNum;
            if(playerLocation >12){
                propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 2));
            }
            else{
                propertyNum = Integer.parseInt(idOfLocation.substring(idOfLocation.length() - 1));
            }
            if(eventType.equals("buy")) {
                if (propertyOwnerViews.get(propertyNum - 1).getFill() == Color.WHITE) {
                    Paint playerColor = playerTokens.get(queueIndices.get(currentPlayerIndex)).getFill();
                    propertyOwnerViews.get(propertyNum - 1).setFill(playerColor);
                }
            }
            else{
                propertyOwnerViews.get(propertyNum - 1).setFill(Color.WHITE);
                propertyPane.setVisible(false);
            }
        }
    }

}
