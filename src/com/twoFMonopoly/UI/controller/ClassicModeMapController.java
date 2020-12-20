package com.twoFMonopoly.UI.controller;

import com.sun.deploy.panel.IProperty;
import com.twoFMonopoly.Constants;
import com.twoFMonopoly.Main;
import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.Managers.PropertyManager;
import com.twoFMonopoly.Managers.RailroadManager;
import com.twoFMonopoly.UI.GameInitializer;
import com.twoFMonopoly.models.Buildings.Building;
import com.twoFMonopoly.models.Card.Card;
import com.twoFMonopoly.models.Card.CardDeck;
import com.twoFMonopoly.models.Locations.*;
import com.twoFMonopoly.models.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ClassicModeMapController {
    @FXML
    public AnchorPane pausePane;
    @FXML
    public AnchorPane saveGamePane;
    @FXML
    public TextField saveGameNameTextField;
    @FXML
    public Text queueIndexText1;
    @FXML
    public Text queueIndexText2;
    @FXML
    public Text queueIndexText3;
    @FXML
    public Text queueIndexText4;
    @FXML
    public Text queueIndexText5;
    @FXML
    public Text queueIndexText6;
    @FXML
    public Text queueIndexText7;
    @FXML
    public Text queueIndexText8;

    @FXML
    private ImageView house1_1, house1_2, house1_3, house1_4, house2_1, house2_2, house2_3, house2_4;
    @FXML
    private ImageView house4_1, house4_2, house4_3, house4_4, house6_1, house6_2, house6_3, house6_4;
    @FXML
    private ImageView house8_1, house8_2, house8_3, house8_4, house9_1, house9_2, house9_3, house9_4;
    @FXML
    private ImageView house11_1, house11_2, house11_3, house11_4, house13_1, house13_2, house13_3, house13_4;
    @FXML
    private ImageView house15_1, house15_2, house15_3, house15_4, house17_1, house17_2, house17_3, house17_4;
    @FXML
    private ImageView house19_1, house19_2, house19_3, house19_4, house20_1, house20_2, house20_3, house20_4;
    @FXML
    private ImageView house22_1, house22_2, house22_3, house22_4, house23_1, house23_2, house23_3, house23_4;
    @FXML
    private ImageView house26_1, house26_2, house26_3, house26_4, house27_1, house27_2, house27_3, house27_4;
    @FXML
    private ImageView house1_5, house2_5, house4_5, house6_5, house8_5, house9_5, house11_5, house13_5;
    @FXML
    private ImageView house15_5, house17_5, house19_5, house20_5, house22_5, house23_5, house26_5, house27_5;

    @FXML
    private Text propertyRectName1, propertyRectName2, propertyRectName4, propertyRectName6;
    @FXML
    private Text propertyRectName8, propertyRectName9, propertyRectName11, propertyRectName13;
    @FXML
    private Text propertyRectName15, propertyRectName17, propertyRectName19, propertyRectName20;
    @FXML
    private Text propertyRectName22, propertyRectName23, propertyRectName26, propertyRectName27;
    @FXML
    private Text railroadRectName5, railroadRectName12, railroadRectName16;

    @FXML
    private Text mortgaged1, mortgaged2, mortgaged4, mortgaged6, mortgaged8, mortgaged9, mortgaged11,
            mortgaged13, mortgaged15, mortgaged17, mortgaged19, mortgaged20, mortgaged22, mortgaged23,
            mortgaged26, mortgaged27, mortgaged5, mortgaged12, mortgaged16;

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
    private Rectangle propertyOwner1;
    @FXML
    private Rectangle propertyOwner2;
    @FXML
    private Rectangle propertyOwner4;
    @FXML
    private Rectangle propertyOwner5;
    @FXML
    private Rectangle propertyOwner6;
    @FXML
    private Rectangle propertyOwner8;
    @FXML
    private Rectangle propertyOwner9;
    @FXML
    private Rectangle propertyOwner11;
    @FXML
    private Rectangle propertyOwner12;
    @FXML
    private Rectangle propertyOwner13;
    @FXML
    private Rectangle propertyOwner15;
    @FXML
    private Rectangle propertyOwner16;
    @FXML
    private Rectangle propertyOwner17;
    @FXML
    private Rectangle propertyOwner19;
    @FXML
    private Rectangle propertyOwner20;
    @FXML
    private Rectangle propertyOwner22;
    @FXML
    private Rectangle propertyOwner23;
    @FXML
    private Rectangle propertyOwner26;
    @FXML
    private Rectangle propertyOwner27;
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
    private Button unMortgageButton;
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
    private Text houseCost1;
    @FXML
    private Text houseCost2;
    @FXML
    private Text houseCost3;
    @FXML
    private Text houseCost4;
    @FXML
    private Text costPriceText;
    @FXML
    private Text popUpScreen;
    @FXML
    private Button payDebtButton;
    @FXML
    private AnchorPane cardPane;
    @FXML
    private AnchorPane jailPane;
    @FXML
    private Text cardContentText;
    @FXML
    private Button cardCloseButton;
    @FXML
    private Button closeJailPaneButton;
    @FXML
    private Button payFineButton;
    @FXML
    private Button useFreedomCardButton;
    @FXML
    private Text numberOfFreedomRights;
    @FXML
    private Text popUpPlayer, popUpActionText;
    @FXML
    private AnchorPane popUpPane;

    @FXML
    protected AnchorPane root;
    @FXML
    private Text titleOfPropertyDetails;

    private final double JAIL_FINE = 200;
    private Random dice;
    private int currentPlayerIndex;
    private int playerCount;
    private ArrayList<String> colors;
    private ArrayList<String> names;
    private ArrayList<Integer> queueIndices;

    private ArrayList<Text> playerNames, playerTimes, playerMoneys, queueIndexTexts;
    private ArrayList<Rectangle> propertyViews, corners, chanceViews, communityChestViews, locationViews, propertyOwnerViews;
    private ArrayList<Text> propertyRectNameViews;
    private ArrayList<Text> railroadRectNameViews;
    private ArrayList<ImageView> houseViews;
    private ArrayList<Text> mortgagedViews;

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
    private int lastClickedTradable;
    private GameInitializer gameInitializer;
    private Card currentCard;

    public void init(int playerCount, ArrayList<String> colors, ArrayList<String> names, ArrayList<Integer> queueIndices){
        Main.player.stop();
        Main.player  = new MediaPlayer(new Media(Paths.get(Constants.MAIN_MUSIC).toUri().toString()));
        Main.player.setOnEndOfMedia( () -> Main.player.seek(Duration.ZERO));
        Main.player.play();

        moneyInTheMiddle = 0;

        this.lastClickedTradable = 1;
        playerNames = new ArrayList<>(Arrays.asList(playerName1, playerName2, playerName3, playerName4, playerName5, playerName6, playerName7, playerName8));
        queueIndexTexts = new ArrayList<>(Arrays.asList(queueIndexText1, queueIndexText2, queueIndexText3, queueIndexText4, queueIndexText5, queueIndexText6, queueIndexText7, queueIndexText8));
        playerTimes = new ArrayList<>(Arrays.asList(playerTime1, playerTime2, playerTime3, playerTime4, playerTime5, playerTime6, playerTime7, playerTime8));
        playerMoneys = new ArrayList<>(Arrays.asList(playerMoney1, playerMoney2, playerMoney3, playerMoney4, playerMoney5, playerMoney6, playerMoney7, playerMoney8));
        playerTokens = new ArrayList<>(Arrays.asList(playerToken1, playerToken2, playerToken3, playerToken4, playerToken5, playerToken6, playerToken7, playerToken8));
        propertyViews = new ArrayList<>(Arrays.asList(property1, property2, property3, property4, property5, property6, property7, property8, property9, property10,
                property11, property12, property13, property14, property15, property16, property17, property18, property19));
        corners = new ArrayList<>(Arrays.asList(corner1, corner2, corner3, corner4));
        chanceViews = new ArrayList<>(Arrays.asList(chance1, chance2));
        communityChestViews = new ArrayList<>(Arrays.asList(communityChest1, communityChest2));
        propertyOwnerViews = new ArrayList<>(Arrays.asList(propertyOwner1, propertyOwner2, propertyOwner4, propertyOwner5, propertyOwner6, propertyOwner8, propertyOwner9,
                propertyOwner11, propertyOwner12, propertyOwner13, propertyOwner15, propertyOwner16, propertyOwner17, propertyOwner19,
                propertyOwner20, propertyOwner22, propertyOwner23, propertyOwner26, propertyOwner27));
        playerLocations = new ArrayList<>();
        locationViews = new ArrayList<>(Arrays.asList(  corner1, property1, property2, communityChest1, property3, property4, property5,
                corner2, property6, property7, chance1, property8, property9, property10,
                corner3, property11, property12, property13, communityChest2, property14, property15,
                corner4, property16, property17, chance2, tax1, property18, property19));
        propertyRectNameViews = new ArrayList<>(Arrays.asList(propertyRectName1, propertyRectName2, propertyRectName4, propertyRectName6, propertyRectName8,
                propertyRectName9, propertyRectName11, propertyRectName13, propertyRectName15, propertyRectName17,
                propertyRectName19, propertyRectName20, propertyRectName22, propertyRectName23, propertyRectName26, propertyRectName27));

        railroadRectNameViews = new ArrayList<>(Arrays.asList(railroadRectName5, railroadRectName12, railroadRectName16));

        houseViews = new ArrayList<>(Arrays.asList( house1_1, house1_2, house1_3, house1_4, house1_5, house2_1, house2_2, house2_3, house2_4, house2_5,
                house4_1, house4_2, house4_3, house4_4, house4_5, house6_1, house6_2, house6_3, house6_4, house6_5,
                house8_1, house8_2, house8_3, house8_4, house8_5, house9_1, house9_2, house9_3, house9_4, house9_5,
                house11_1, house11_2, house11_3, house11_4, house11_5, house13_1, house13_2, house13_3, house13_4, house13_5,
                house15_1, house15_2, house15_3, house15_4, house15_5, house17_1, house17_2, house17_3, house17_4, house17_5,
                house19_1, house19_2, house19_3, house19_4, house19_5, house20_1, house20_2, house20_3, house20_4, house20_5,
                house22_1, house22_2, house22_3, house22_4, house22_5, house23_1, house23_2, house23_3, house23_4, house23_5,
                house26_1, house26_2, house26_3, house26_4, house26_5, house27_1, house27_2, house27_3, house27_4, house27_5));

        mortgagedViews = new ArrayList<>( Arrays.asList(mortgaged1, mortgaged2, mortgaged4, mortgaged6, mortgaged8, mortgaged9, mortgaged11,
                mortgaged13, mortgaged15, mortgaged17, mortgaged19, mortgaged20, mortgaged22, mortgaged23,
                mortgaged26, mortgaged27, mortgaged5, mortgaged12, mortgaged16));

        gameInitializer = new GameInitializer();
        locations = gameInitializer.initTurkeyMap();
        for( Location location : locations) {
            System.out.println(location.getLocationText());
        }
        currentPlayerIndex = 0;
        this.playerCount = playerCount;
        this.colors = new ArrayList<>(colors);
        this.names = new ArrayList<>(names);
        this.queueIndices = new ArrayList<>(queueIndices);

        players = new ArrayList<>();

        playerManager = PlayerManager.getInstance();
        propertyManager = PropertyManager.getInstance();
        railroadManager = RailroadManager.getInstance();

        for( int i = 0; i < playerCount; i++) {
            Player player = new Player(i, names.get(i), 1500.0, colors.get(i));
            players.add(player);
        }

        saveGamePane.setVisible(false);
        pausePane.setVisible(false);
        for(Text mortgage: mortgagedViews){
            mortgage.setVisible(false);
        }
        for(ImageView imageView: houseViews){
            imageView.setVisible(false);
        }
        for(Text playerTime: playerTimes){
            playerTime.setVisible(false);
        }
        playerManager.setPlayer(players);
        currentPlayer = players.get(queueIndices.get(currentPlayerIndex));
        refactorPlayers();
        endOfTurnButton.setDisable(true);
        setTurnText(currentPlayerIndex);
        propertyPane.setVisible(false);
        negotiatePane.setVisible(false);
        payDebtButton.setVisible(true);
        cardPane.setVisible(false);
        jailPane.setVisible(false);
        payDebtButton.setDisable(true);
        unMortgageButton.setDisable(true);
        popUpPane.setVisible(false);


        updatePlayers();
        updateProperties();
        updateRailroads();
    }

    private void refactorPlayers() {
        for(int i = playerCount; i < 8; ++i) {
            playerNames.get(i).setVisible(false);
            playerTokens.get(i).setVisible(false);
            playerMoneys.get(i).setVisible(false);
            playerTimes.get(i).setVisible(false);
            queueIndexTexts.get(i).setVisible(false);
        }

        for (int i = 0; i < playerCount; ++i){
            playerNames.get(i).setText(names.get(i));
            queueIndices.set(i, queueIndices.get(i) + 1);
            queueIndexTexts.get(i).setText(queueIndices.get(i).toString());
            playerNames.get(i).setFill(Color.web(Constants.COLORS.get(colors.get(i))));
            queueIndexTexts.get(i).setFill(Color.web(Constants.COLORS.get(colors.get(i))));
            playerTokens.get(i).setFill(Color.web(Constants.COLORS.get(colors.get(i))));
            playerLocations.add(0);
        }
        for( int i = 0; i < playerCount; ++i) {
            queueIndices.set(i, queueIndices.get(i) - 1);
        }
        queueIndexTexts.get(0).setVisible(true);
        queueIndexTexts.get(0).toFront();
        System.out.println(queueIndexTexts.get(0) + ", ");
    }

    private int rollDice(){
        dice = new Random();
        return dice.nextInt(6) + 1;
    }

    private void takeNormalTurn(int dice1, int dice2) {
        int newLocation = (playerLocations.get(currentPlayerIndex) + dice1 + dice2) % 28;
        playerLocations.set(currentPlayerIndex, newLocation);
        setNewCoordinate(newLocation);
        playerManager.setLocation(currentPlayer, newLocation);
        updatePlayers();
        rollButton.setDisable(true);

        if(locations.get(newLocation) instanceof Property) {
            lastClickedTradable = newLocation;
            takeTradableAction();
        }
        else if(locations.get(newLocation) instanceof Railroad) {
            lastClickedTradable = newLocation;
            takeTradableAction();
        }
        else if(locations.get(newLocation) instanceof Tax)
            takeTaxAction();
        else if(locations.get(newLocation) instanceof DirectToJail)
            takeGoToJailAction();
        else if(locations.get(newLocation) instanceof CardDeck)
            takeCardDeckAction();
        else
            endOfTurnButton.setDisable(false);
    }

    public void takeJailTurn() {
        rollButton.setDisable(true);
        if(currentPlayer.getJailStatus() == 4) {
            if(playerManager.canAfford(currentPlayer, JAIL_FINE) ||
                    playerManager.tenderToAvoidBankrupt(currentPlayer, JAIL_FINE)) {
                endOfTurnButton.setDisable(true);
            }
            else {
                playerManager.bankrupt(currentPlayer);
                updateProperties();
                updatePlayer(currentPlayer);
                endOfTurnButton.setDisable(false);
            }
        }
        else {
            //pay fine button active
            //use freedom right button active if player has freedomRights
            endOfTurnButton.setDisable(false);
        }
    }

    /**
     * Take Actionlar ayrı bir classa taşınabilir!
     */
    private void takeCardDeckAction() {
        currentCard = ((CardDeck)locations.get(currentPlayer.getCurrentLocationIndex())).drawCard();
        System.out.println(currentCard);
        payDebtButton.setDisable(true);
        cardContentText.setText(currentCard.toString());
        cardPane.setVisible(true);
        endOfTurnButton.setDisable(true);
    }

    private void takeGoToJailAction() {
        playerManager.goToJail(currentPlayer, Constants.jailLocation);
        updatePlayers();
        endOfTurnButton.setDisable(false);
    }

    private void takeTaxAction() {
        int currentLocation = currentPlayer.getCurrentLocationIndex();
        Tax tax = (Tax) locations.get(currentLocation);
        double taxAmount = tax.getTaxAmount();
        popUpActionText.setText("$" + taxAmount + "K withdrawn for tax");
        popUpPlayer.setText(currentPlayer.getName());
        popUpPane.setVisible(true);
        if(playerManager.canAfford(currentPlayer,taxAmount)) {
            playerManager.giveMoney(currentPlayer,taxAmount);
            endOfTurnButton.setDisable(false);
        }
        else if(playerManager.tenderToAvoidBankrupt(currentPlayer, taxAmount)) {
            currentPlayer.addDebt(taxAmount);
            endOfTurnButton.setDisable(true);
            payDebtButton.setDisable(false);
        }
        else {
            playerManager.bankrupt(currentPlayer);
            endOfTurnButton.setDisable(false);
        }
        moneyInTheMiddle += taxAmount;
        updatePlayers();

    }

    private void takeTradableAction() {
        Tradable tradable = (Tradable) locations.get(lastClickedTradable);
        propertyPaneSettings();
        propertyPane.setVisible(true);
        if(tradable.getOwner() != null && tradable.getOwner() != currentPlayer) {

            if(playerManager.canAfford(currentPlayer, tradable.getRentCost())) {
                playerManager.payRent(currentPlayer, tradable);
                endOfTurnButton.setDisable(false);
                popUpActionText.setText("$" + tradable.getRentCost() + "K withdrawn to pay rent");
                popUpPane.setVisible(true);
                popUpPlayer.setText(currentPlayer.getName());
            }
            else if(playerManager.tenderToAvoidBankrupt(currentPlayer, tradable.getRentCost())) {
                currentPlayer.addDebt(tradable.getRentCost());
                endOfTurnButton.setDisable(true);
                payDebtButton.setDisable(false);
            }
            else {
                playerManager.bankrupt(currentPlayer, tradable.getOwner());
                endOfTurnButton.setDisable(false);
            }
        }
        else if( tradable.getOwner() == null) {
            jailPane.setVisible(false);
            endOfTurnButton.setDisable(false);
        }
        else
            endOfTurnButton.setDisable(false);
        updatePlayers();
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

    private void buyRailroad( Railroad railroad) {
        playerManager.buyRailroad(currentPlayer, railroad);
        railroadManager.buyRailroad(railroad, currentPlayer);
        updatePlayer(currentPlayer);
    }

    private void buyProperty( Property property) {
        playerManager.buyProperty(currentPlayer, property);
        propertyManager.buyProperty(property, currentPlayer);
    }

    private boolean isGameOver() {
        int playingPlayerCount = 0;
        for( Player player : players) {
            if(!player.isBankrupt()) playingPlayerCount++;
        }
        return !(playingPlayerCount > 1);
    }

    private boolean payDebt() {
        double debt = currentPlayer.getDebt();
        if(playerManager.canAfford(currentPlayer, debt)) {
            playerManager.giveMoney(currentPlayer, debt);
            currentPlayer.setDebt(0);
            return true;
        }
        else
            return false;
    }

    public void goBackToGameFromPausePane(ActionEvent actionEvent) {
        pausePane.setVisible(false);
        pausePane.toBack();
    }

    public void goBackToGameFromSaveGamePane(ActionEvent actionEvent) {
        saveGamePane.setVisible(false);
        saveGamePane.toBack();
    }

    public void openPausePane(ActionEvent actionEvent) {
        pausePane.toFront();
        pausePane.setVisible(true);
    }

    public void openSaveGamePane(ActionEvent actionEvent) {
        saveGamePane.toFront();
        saveGamePane.setVisible(true);
    }

    /**
     ÖÇA SAVEGAME FONKSİYONU BURADA
     */
    public void saveGame(ActionEvent actionEvent) {
        String filepath = Constants.SAVE_GAME_FOLDER + saveGameNameTextField.getText().trim();

        ArrayList<Object> itemsToSave = new ArrayList<>();
        itemsToSave.add( locations );
        itemsToSave.add( players );
        itemsToSave.add( playerLocations );
        itemsToSave.add( moneyInTheMiddle );

        writeObjectToFile( itemsToSave, filepath );
    }

    public void writeObjectToFile( Object serObj, String filepath ) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //Visual update functions
    private void updateTradable(Tradable tradable) {
        if( tradable instanceof Railroad)
            updateRailroad((Railroad) tradable);
        else if( tradable instanceof Property)
            updateProperty((Property) tradable);
    }

    private void updateRailroads() {
        for( Location location : locations) {
            if(location instanceof Railroad) updateRailroad((Railroad) location);
        }
    }

    private void updateProperties() {
        for( Location location : locations) {
            if(location instanceof Property) updateProperty((Property) location);
        }
    }

    private void updatePlayers() {
        for( Player player : players)
            updatePlayer(player);
    }

    private void updatePlayer( Player player) {
        double money = player.getMoneyAmount();
        int playerNumber = players.indexOf(player) + 1;
        String playerMoneyX = "playerMoney" + playerNumber;

        for(Text playerMoney : playerMoneys){
            if(playerMoney.getId().equals(playerMoneyX)){
                playerMoney.setText("$" + money + "K");
            }
        }
        if(player == currentPlayer) {
            if (playerLocations.get(currentPlayerIndex) != player.getCurrentLocationIndex()) {
                setNewCoordinate(player.getCurrentLocationIndex());
                playerLocations.set(currentPlayerIndex, player.getCurrentLocationIndex());
            }
        }

    }

    private void updateProperty( Property property){
        int propertyLocationIndex = property.getLocationIndex();
        String propertyRectName = "propertyRectName" + propertyLocationIndex;
        String propertyOwner = "propertyOwner" + propertyLocationIndex;
        int noOfBuildings = property.getNoOfBuildings();
        ArrayList<String> buildingNames = new ArrayList<String>();

        for(int i = 1; i <= noOfBuildings; i++){
            buildingNames.add(propertyLocationIndex + "house" + i);
        }

        for(Text prop: propertyRectNameViews){
            if(prop == null) continue;
            if(prop.getId().equals(propertyRectName)){
                prop.setText(property.getName());
            }
        }

        for(Rectangle rect: propertyOwnerViews){
            if(rect.getId().equals(propertyOwner)){
                if(property.getOwner() != null) {
                    String color = property.getOwner().getColor();
                    System.out.println(color);
                    rect.setFill(Color.web(color));
                }
                else
                    rect.setFill(Color.WHITE);
            }
        }
        String house = propertyLocationIndex + "house" ;
        ArrayList<String> houseNames = new ArrayList<String>();
        for(int i = 1; i <= property.getNoOfBuildings(); i++){
            houseNames.add(house + i);
        }
        for(ImageView imageView: houseViews){
            if(houseNames.contains(imageView.getId())){
                imageView.setVisible(true);
            }
            else
                imageView.setVisible(false);
        }
    }

    private void updateRailroad( Railroad railroad) {
        int propertyLocationIndex = railroad.getLocationIndex();
        String propertyRectName = "railroadRectName" + propertyLocationIndex;
        String propertyOwner = "propertyOwner" + propertyLocationIndex;

        for (Text rail : railroadRectNameViews) {
            if (rail.getId().equals(propertyRectName)) {
                rail.setText(railroad.getName());
            }
        }
        for (Rectangle rect : propertyOwnerViews) {
            if (rect.getId().equals(propertyOwner)) {
                if( railroad.getOwner() != null) {
                    String color = railroad.getOwner().getColor();
                    rect.setFill(Color.web(color));
                }
                else
                    rect.setFill(Color.WHITE);
            }
        }
    }

    private void updatePropertyPane( Property property){
        double cost = property.getCost();
        double mortgagePrice = property.getCurrentMortgagePrice();
        String name = property.getName();
        ArrayList<Double> rentPrices = property.getRentPrices();
        ArrayList<Building> buildings = property.getBuildings();

        siteOnlyText.setText("Site Only");
        oneHouseText.setVisible(true);
        oneHouseRent.setVisible(true);
        twoHousesText.setText("2 Houses");
        threeHousesText.setText("3 Houses");
        fourHousesRent.setVisible(true);
        fourHousesText.setVisible(true);
        hotelText.setText("Hotel");
        houseCostText.setVisible(true);
        houseCost1.setVisible(true);
        houseCost2.setVisible(true);
        houseCost3.setVisible(true);
        houseCost4.setVisible(true);
        hotelCostText.setVisible(true);
        hotelCost.setVisible(true);
        buildButton.setVisible(true);

        titleOfPropertyDetails.setText(name);
        costPriceText.setText("$" + cost + "K");
        mortgageValue.setText("$" + mortgagePrice + "K");
        siteOnlyRent.setText("$" + rentPrices.get(0) + "K" );
        oneHouseRent.setText("$" + rentPrices.get(1) + "K" );
        twoHousesRent.setText("$" + rentPrices.get(2) + "K" );
        threeHousesRent.setText("$" + rentPrices.get(3) + "K" );
        fourHousesRent.setText("$" + rentPrices.get(4) + "K" );
        hotelRent.setText("$" + rentPrices.get(5) + "K" );

        houseCost1.setText("$" + buildings.get(0).getBuildingPrice() + "K");
        houseCost2.setText("$" + buildings.get(1).getBuildingPrice() + "K");
        houseCost3.setText("$" + buildings.get(2).getBuildingPrice() + "K");
        houseCost4.setText("$" + buildings.get(3).getBuildingPrice() + "K");
        hotelCost.setText("$" + buildings.get(4).getBuildingPrice() + "K");
        mortgageValue.setText("$" + mortgagePrice + "K");
    }

    private void updateRailroadPane(Railroad railroad){
        titleOfPropertyDetails.setText(railroad.getName());
        ArrayList<Double> rentPrices = railroad.getRentPrices();

        siteOnlyText.setText("1 Railroad");
        oneHouseText.setVisible(false);
        oneHouseRent.setVisible(false);
        twoHousesText.setText("2 Railroad");
        threeHousesText.setText("3 Railroad");
        fourHousesRent.setVisible(false);
        fourHousesText.setVisible(false);
        hotelText.setText("4 Railroad");
        houseCostText.setVisible(false);
        houseCost1.setVisible(false);
        houseCost2.setVisible(false);
        houseCost3.setVisible(false);
        houseCost4.setVisible(false);
        hotelCostText.setVisible(false);
        hotelCost.setVisible(false);
        buildButton.setVisible(false);

        siteOnlyRent.setText("$" + rentPrices.get(0) + "K" );
        twoHousesRent.setText("$" + rentPrices.get(1) + "K" );
        threeHousesRent.setText("$" + rentPrices.get(2) + "K" );
        hotelRent.setText("$" + rentPrices.get(3) + "K" );
    }

    private void propertyPaneSettings() {
        if(!currentPlayer.isBankrupt()) {
            if (locations.get(lastClickedTradable) instanceof Property) {
                Property property = (Property) locations.get(lastClickedTradable);
                updatePropertyPane(property);
                if (property.getOwner() == null) {
                    sellButton.setDisable(true);
                    buyButton.setDisable(!(playerManager.canAfford(currentPlayer, property.getCost())
                            && property.getLocationIndex() == currentPlayer.getCurrentLocationIndex()));
                    buildButton.setDisable(true);
                    mortgageButton.setDisable(true);
                    unMortgageButton.setDisable(true);

                } else if (property.getOwner() == currentPlayer) {
                    sellButton.setDisable(!(property.getNoOfBuildings() > 0));
                    buyButton.setDisable(true);
                    buildButton.setDisable(!(property.isMonopoly() && property.getNoOfBuildings() < 5
                            && playerManager.canAfford(currentPlayer, property.getNextBuildingsBuildingCost())));
                    mortgageButton.setDisable(!(property.getNoOfBuildings() == 0 && !property.isMortgaged()));
                    unMortgageButton.setDisable(!(property.isMortgaged() &&
                            playerManager.canAfford(currentPlayer, property.getCurrentMortgagePrice())));
                } else {
                    sellButton.setDisable(true);
                    buyButton.setDisable(true);
                    buildButton.setDisable(true);
                    mortgageButton.setDisable(true);
                    unMortgageButton.setDisable(true);
                }
            } else {
                Railroad railroad = (Railroad) locations.get(lastClickedTradable);
                updateRailroadPane(railroad);
                if (railroad.getOwner() == null) {
                    sellButton.setDisable(true);
                    buyButton.setDisable(!(playerManager.canAfford(currentPlayer, railroad.getCost())
                            && currentPlayer.getCurrentLocationIndex() == railroad.getLocationIndex()));
                    buildButton.setDisable(true);
                    mortgageButton.setDisable(true);
                    unMortgageButton.setDisable(true);
                } else if (railroad.getOwner() == currentPlayer) {
                    sellButton.setDisable(true);
                    buyButton.setDisable(true);
                    buildButton.setDisable(true);
                    mortgageButton.setDisable(railroad.isMortgaged());
                    unMortgageButton.setDisable(!(railroad.isMortgaged() &&
                            playerManager.canAfford(currentPlayer,railroad.getCurrentMortgagePrice())));
                } else {
                    sellButton.setDisable(true);
                    buyButton.setDisable(true);
                    buildButton.setDisable(true);
                    mortgageButton.setDisable(true);
                    unMortgageButton.setDisable(true);
                }
            }
        }
        else {
            sellButton.setDisable(true);
            buyButton.setDisable(true);
            buildButton.setDisable(true);
            mortgageButton.setDisable(true);
        }
    }

    private void jailPaneSettings() {
        if(currentPlayer.getJailStatus() == 0 || currentPlayer.isBankrupt()) {
            useFreedomCardButton.setDisable(true);
            payFineButton.setDisable(true);
        }
        else {
            useFreedomCardButton.setDisable(!(currentPlayer.getNoOfFreedomRights() > 0));
            payFineButton.setDisable(!(playerManager.canAfford(currentPlayer,JAIL_FINE)));
        }
    }


    // FXML Listeners
    @FXML
    public void buyButtonPushed(ActionEvent event) {
        //int playerLocation = currentPlayer.getCurrentLocationIndex();

        if( locations.get(lastClickedTradable) instanceof Property) {
            Property property = (Property) locations.get(lastClickedTradable);
            buyProperty(property);
            popUpActionText.setText("$" + property.getCost() + "K withdrawn for buying property");
            popUpPlayer.setText(currentPlayer.getName());

            System.out.println(property.getOwner().getName());
            System.out.println(property.getOwner().getColor());
            System.out.println("**************************");
            System.out.println(currentPlayer.getName());
            updateProperty(property);
        }
        else if( locations.get(lastClickedTradable) instanceof Railroad) {
            Railroad railroad = (Railroad) locations.get(lastClickedTradable);
            buyRailroad(railroad);
            updateRailroad(railroad);
            popUpActionText.setText("$" + railroad.getCost() + "K withdrawn for buying railroad");
            popUpPlayer.setText(currentPlayer.getName());
        }
        popUpPane.setVisible(true);
        buyButton.setDisable(true);
        propertyPaneSettings();
        updatePlayer(currentPlayer);
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

    @FXML
    public void buildButtonPushed() {
        Property property = (Property) locations.get(lastClickedTradable);
        popUpActionText.setText("$" + property.getNextBuildingsBuildingCost() + "K withdrawn for building");
        popUpPlayer.setText(currentPlayer.getName());
        popUpPane.setVisible(true);
        playerManager.buildOneBuilding(currentPlayer, property);
        propertyManager.buildOneBuilding(property);
        propertyPaneSettings();
        updateProperty(property);
        updatePlayers();
        System.out.println();
    }

    @FXML
    public void sellButtonPushed(ActionEvent event) {
        Property property = (Property) locations.get(lastClickedTradable);
        popUpActionText.setText("$" + property.getCurrentBuildingsSellingCost() + "K deposited, building sold");
        popUpPlayer.setText(currentPlayer.getName());
        popUpPane.setVisible(true);
        playerManager.sellOneBuilding(currentPlayer, property);
        propertyManager.sellOneBuilding(property);
        propertyPaneSettings();
        updateProperty(property);
        updatePlayers();
    }

    @FXML
    public void mortgageButtonPushed(ActionEvent event) {
        if(locations.get(lastClickedTradable) instanceof Railroad) {
            Railroad railroad = (Railroad) locations.get(lastClickedTradable);
            playerManager.mortgageRailroad(currentPlayer, railroad);
            railroadManager.mortgageRailroad(railroad, currentPlayer);
        }
        else if( locations.get(lastClickedTradable) instanceof Property) {
            Property property = (Property) locations.get(lastClickedTradable);
            playerManager.mortgageProperty(currentPlayer, property);
            propertyManager.mortgageProperty(property);
        }
        String mortgaged = "mortgaged" + currentPlayer;
        for(Text mortgagedView: mortgagedViews){
            if(mortgaged.equals(mortgagedView.getId()))
                mortgagedView.setVisible(true);
        }

        propertyPaneSettings();
        updatePlayers();
        updateTradable((Tradable) locations.get(lastClickedTradable));
    }

    @FXML
    public void unMortgagedButtonPushed(ActionEvent event) {
        Tradable tradable =(Tradable) locations.get(lastClickedTradable);
        if( tradable instanceof Property) {
            playerManager.removeMortgageProperty(currentPlayer, (Property) tradable);
            propertyManager.removeMortgageProperty((Property) tradable);
        }
        else if( tradable instanceof Railroad) {
            playerManager.removeMortgageRailroad(currentPlayer, (Railroad) tradable);
            railroadManager.removeMortgageRailroad((Railroad) tradable, currentPlayer);
        }
        String mortgaged = "mortgaged" + currentPlayer;
        for(Text mortgagedView: mortgagedViews){
            if(mortgaged.equals(mortgagedView.getId()))
                mortgagedView.setVisible(false);
        }
        updateTradable(tradable);
        updatePlayers();
        propertyPaneSettings();
    }

    @FXML
    public void payDebtButtonPushed( ActionEvent actionEvent) {
        double debt = currentPlayer.getDebt();
        popUpActionText.setText("$" + debt + "K withdrawn for debt");
        popUpPlayer.setText(currentPlayer.getName());
        popUpPane.setVisible(true);
        if(payDebt()) {
            payDebtButton.setDisable(true);
            endOfTurnButton.setDisable(false);
        }
        else if(playerManager.tenderToAvoidBankrupt(currentPlayer, debt)) {
            payDebtButton.setDisable(false);
        }
        else {
            playerManager.bankrupt(currentPlayer);
            updatePlayer(currentPlayer);
            endOfTurnButton.setDisable(false);
            payDebtButton.setDisable(true);
        }
    }

    @FXML
    public void closeCardPane(MouseEvent mouseEvent) {
        playerManager.makeCardAction( currentPlayer, currentCard );
        updatePlayers();
        cardPane.setVisible(false);
        if(currentPlayer.getDebt() != 0) {
            payDebtButton.setDisable(false);
        }
        else {
            endOfTurnButton.setDisable(false);
            payDebtButton.setDisable(true);
        }
    }
    @FXML
    public void jailClicked(MouseEvent mouseEvent) {
        jailPaneSettings();
        jailPane.setVisible(true);
    }

    @FXML
    public void closeJailPaneClicked(ActionEvent actionEvent) {
        jailPane.setVisible(false);
    }

    @FXML
    public void payFineButtonClicked(ActionEvent actionEvent) {
        if(currentPlayer.getJailStatus() == 4) {
            if(playerManager.canAfford(currentPlayer, JAIL_FINE)) {
                popUpActionText.setText("$200K withdrawn for leaving jail");
                popUpPlayer.setText(currentPlayer.getName());
                popUpPane.setVisible(true);
                playerManager.giveMoney(currentPlayer, JAIL_FINE);
                playerManager.exitJail(currentPlayer);
                updatePlayer(currentPlayer);
                endOfTurnButton.setDisable(false);
            }
            else if(playerManager.tenderToAvoidBankrupt(currentPlayer, JAIL_FINE)) {
                // Text düş tepeye you have to sell sth to pay your fine
            }
            else {
                playerManager.bankrupt(currentPlayer);
                updatePlayer(currentPlayer);
                endOfTurnButton.setDisable(false);
            }
            jailPaneSettings();
        }
        else {
            if(playerManager.canAfford(currentPlayer, JAIL_FINE)) {
                playerManager.giveMoney(currentPlayer, JAIL_FINE);
                playerManager.exitJail(currentPlayer);
                updatePlayer(currentPlayer);
            }
            else {
                //jail texti you do not have enough money.
            }
            jailPaneSettings();
            endOfTurnButton.setDisable(false);
        }
    }

    @FXML
    public void useFreedomButtonClicked(ActionEvent actionEvent) {
        if(playerManager.useFreedomRightToExitJail(currentPlayer)) {
            jailPaneSettings();
            endOfTurnButton.setDisable(false);
            updatePlayer(currentPlayer);
            popUpActionText.setText("Freedom right is used. Remaining freedom cards: " + currentPlayer.getNoOfFreedomRights());
            popUpPlayer.setText(currentPlayer.getName());
            popUpPane.setVisible(true);
        }
    }

    @FXML
    public void closeButtonPushed(ActionEvent event) {
        propertyPane.setVisible(false);
    }

    @FXML
    public void propertyClicked(MouseEvent mouseEvent) {
        lastClickedTradable = Integer.parseInt(((Rectangle) mouseEvent.getSource()).getId());
        Tradable tradable = (Tradable) locations.get(lastClickedTradable);
        propertyPaneSettings();
        propertyPane.setVisible(true);
        jailPane.setVisible(false);
    }

    @FXML
    public void endTurnButtonPushed(ActionEvent event) {
        if(isGameOver()) {
            //finish the game
        }
        else {
            updatePlayer(currentPlayer);
            if(currentPlayer.getJailStatus() != 0) playerManager.updateJailStatus(currentPlayer);
            currentPlayerIndex = (currentPlayerIndex + 1) % playerCount;

            while(currentPlayer.isBankrupt()) {
                currentPlayerIndex = (currentPlayerIndex + 1) % playerCount;
                currentPlayer = players.get(queueIndices.get(currentPlayerIndex));
            }
            currentPlayer = players.get(queueIndices.get(currentPlayerIndex));

            setTurnText(currentPlayerIndex);
            rollButton.setDisable(false);
            endOfTurnButton.setDisable(true);
            popUpPane.setVisible(false);
        }
    }

    @FXML
    public void rollButtonPushed(ActionEvent event){
        int dice1 = rollDice();
        int dice2 = rollDice();

        String dice1Url = "/com/twoFMonopoly/UI/assets/dice" + dice1 + ".png";
        String dice2Url = "/com/twoFMonopoly/UI/assets/dice" + dice2 + ".png";

        diceImage1.setImage(new Image(getClass().getResourceAsStream(dice1Url)));
        diceImage2.setImage(new Image(getClass().getResourceAsStream(dice2Url)));

        rollButton.setDisable(true);

        if(currentPlayer.getJailStatus() == 0) {
            takeNormalTurn(dice1, dice2);
        }
        else if( dice1 == dice2) {
            playerManager.exitJail(currentPlayer);
            takeNormalTurn(dice1, dice2);
        }
        else {
            takeJailTurn();
        }
    }
}