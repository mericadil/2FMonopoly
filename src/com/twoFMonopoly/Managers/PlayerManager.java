package com.twoFMonopoly.Managers;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.models.Buildings.Building;
import com.twoFMonopoly.models.Card.*;
import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Locations.Railroad;
import com.twoFMonopoly.models.Locations.Tradable;
import com.twoFMonopoly.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerManager {
    private ArrayList<Player> players;
    private static PlayerManager instance = new PlayerManager();

    private PlayerManager() {}

    public static PlayerManager getInstance() {
        return instance;
    }

    public void setPlayer( ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * This method handles the player when he buys a property.
     * @param property the bought property instance
     * @param player the player
     */
    public void buyProperty(Player player, Property property) {
        HashMap<String,Property> properties = player.getProperties();
        properties.put(property.getName(),property);
        giveMoney(player, property.getCost());
    }

    /**
     * This method handles the player when he mortgages a property.
     * @param property the mortgaged property instance
     * @param player the player
     */
    public void mortgageProperty(Player player, Property property) {
        getMoney(player, property.getCost());
    }

    /**
     * This method handles the player when he unmortgages a property.
     * @param property the unmortgaged property instance
     * @param player the player
     */
    public void removeMortgageProperty(Player player, Property property) {
        giveMoney(player, property.getCurrentMortgagePrice());
    }

    /**
     * This method handles the player when he buys a railroad.
     * @param railroad the bought railroad instance
     * @param player the player
     */
    public void buyRailroad(Player player, Railroad railroad) {
        HashMap<String,Railroad> railroads = player.getRailroads();
        railroads.put(railroad.getName(),railroad);
        player.setNoOfRailroads(player.getNoOfRailroads()+1);
        giveMoney(player, railroad.getCost());
    }

    /**
     * This method handles the player when he mortgages a railroad.
     * @param railroad the mortgaged railroad instance
     * @param player the player
     */
    public void mortgageRailroad(Player player, Railroad railroad) {
        getMoney(player, railroad.getCost());
        player.setNoOfRailroads(player.getNoOfRailroads()-1);
    }

    /**
     * This method handles the player when he unmortgages a railroad.
     * @param railroad the unmortgaged railroad instance
     * @param player the player
     */
    public void removeMortgageRailroad(Player player, Railroad railroad) {
        giveMoney(player, railroad.getCurrentMortgagePrice());
        player.setNoOfRailroads(player.getNoOfRailroads()+1);
    }

    /**
     * This method is used to handle a player whenever this player must go to jail.
     * @param player the player
     * @param jailLocation the index of Jail in the board
     */
    public void goToJail( Player player, int jailLocation) {
        player.setJailStatus(1);
        player.setCurrentLocationIndex(jailLocation);
    }

    /**
     * This method is called for each player turn in the Jail. It updates the jail status of the player.
     * @param player
     */
    public void updateJailStatus(Player player) {
        player.setJailStatus(player.getJailStatus()+1);
    }

    /**
     * This method is called when a player pays fine to get out of jail. It handles the player status.
     * @param player
     * @param fine the amount of fine that player must pay.
     */
    public void payFineToExitJail(Player player, double fine) {
        giveMoney(player, fine);
        exitJail(player);
    }

    /**
     * This method is called when a player uses freedom right to get out of jail. It handles the player status.
     * @param player
     */
    public boolean useFreedomRightToExitJail(Player player) {
        if(player.getNoOfFreedomRights() > 0) {
            player.setNoOfFreedomRights(player.getNoOfFreedomRights()-1);
            exitJail(player);
            return true;
        }
        return false;
    }

    /**
     * The previous exit jail functions uses this basically.
     * @param player
     */
    public void exitJail(Player player) {
        player.setJailStatus(0);
    }

    /**
     * This method is used to add a money to a player in the whole code.
     * @param player the player who gets money
     * @param money the amount of money that player gets
     */
    public void getMoney(Player player, double money) {
        player.setMoneyAmount(player.getMoneyAmount() + money);
    }

    /**
     * This method is used to remove a money to a player in the whole code.
     * @param player the player who gives money
     * @param money the amount of money that player gives
     */
    public void giveMoney(Player player, double money) {
        player.setMoneyAmount(player.getMoneyAmount() - money);
    }

    /**
     * This method handles the situation when a player bankrupts to another player
     * @param loser the one who bankrupts
     * @param winner the one who takes everything from the loser
     */
    public void bankrupt(Player loser, Player winner) {
        HashMap<String,Property> player1Properties = loser.getProperties();
        HashMap<String,Property> player2Properties = winner.getProperties();

        HashMap<String,Railroad> player1Railroads = loser.getRailroads();
        HashMap<String,Railroad> player2Railroads = winner.getRailroads();

        getMoney(winner, loser.getMoneyAmount());
        winner.setNoOfFreedomRights(winner.getNoOfFreedomRights() + loser.getNoOfFreedomRights());
        winner.setNoOfRailroads(winner.getNoOfRailroads() + loser.getNoOfRailroads());
        winner.setNoOfHotels(winner.getNoOfHotels() + loser.getNoOfHotels());
        winner.setNoOfHouses(winner.getNoOfHouses() + loser.getNoOfHouses());


        for( String key: player1Properties.keySet()) {
            player2Properties.put(key, player1Properties.get(key));
        }

        for( String key : player1Railroads.keySet())
            player2Railroads.put(key, player1Railroads.get(key));

        loser.setMoneyAmount(0);
        loser.setNoOfFreedomRights(0);
        loser.setNoOfRailroads(0);
        loser.setNoOfHotels(0);
        loser.setNoOfHouses(0);
        loser.setJailStatus(0);
        loser.bankrupt();

    }

    /**
     * This method handles the stiuation when a player bankrupts to the Bank.
     * @param player
     */
    public void bankrupt(Player player) {
        player.setMoneyAmount(0);
        player.setNoOfFreedomRights(0);
        player.setNoOfRailroads(0);
        player.setNoOfHotels(0);
        player.setNoOfHouses(0);
        player.bankrupt();
        player.setJailStatus(0);

        HashMap<String, Railroad> railroads = player.getRailroads();
        HashMap<String, Property> properties = player.getProperties();
        for( String key : railroads.keySet()) {
            Railroad railroad = railroads.get(key);
            railroad.setDefaultSettings();
        }

        for(String key : properties.keySet()) {
            Property property = properties.get(key);
            property.setDefaultSettings();
        }
    }

    /**
     * Whenever a player lands on anyone else's tradable, he must pay the rent to its owner.
     * @param player the money giver
     * @param tradable the tradebe
     */
    public void payRent(Player player, Tradable tradable) {
        double rentCost = tradable.getRentCost();
        giveMoney(player, rentCost);
        getMoney(tradable.getOwner(), rentCost);
    }

    /**
     * This method is called whenever a has not enough money to pay something.
     * @param player our action guy
     * @param amount the amount of money that the player is depted
     * @return whether the player has enough tradables to pay his debt
     */
    public boolean tenderToAvoidBankrupt( Player player, double amount) {
        double moneyNeeded = amount - player.getMoneyAmount();
        double totalMoney = calculateTotalMoneyCanBeEarned(player);
        return totalMoney >= moneyNeeded;
    }

    /**
     * Used in the tender to avoid bankrupt method.
     * Calculates the total wealth of a player coming from tradables.
     * Answers the question how much the player can gain by mortgaging everything he has.
     * @param player our action guy
     * @return the amount of money that can be gained from tradables
     */
    private double calculateTotalMoneyCanBeEarned(Player player) {
        double totalMoney = 0;
        HashMap<String,Property> properties = player.getProperties();
        HashMap<String, Railroad> railroads = player.getRailroads();

        for( String key : properties.keySet())
            totalMoney += properties.get(key).getTotalValue();

        for( String key : railroads.keySet())
            totalMoney += railroads.get(key).getCost();

        return totalMoney;
    }

    /**
     * Checks whether the player can afford the given amount of money
     * @param player our action guy
     * @param amount the amount
     * @return whether the player can afford the amount
     */
    public boolean canAfford(Player player, double amount) {
        return player.getMoneyAmount() >= amount;
    }

    /**
     * This method handles the player when he builds a building to a property
     * @param player our action guy
     * @param property the property which the building will be built on
     * @return whether the process succeeded
     */
    public boolean buildOneBuilding(Player player, Property property) {
        if(!property.isMonopoly() || property.getNoOfBuildings() > 4 || !canAfford(player, property.getNextBuildingsBuildingCost()))
            return false;
        giveMoney(player, property.getNextBuildingsBuildingCost());
        if(property.getNoOfBuildings() == 4)
            player.setNoOfHotels(player.getNoOfHotels() + 1);
        else
            player.setNoOfHouses(player.getNoOfHouses() + 1);
        return true;
    }

    /**
     * This method handles the player when he sells a building to a property
     * @param player our action guy
     * @param property the property which the building will be sells
     * @return whether the process succeeded
     */
    public boolean sellOneBuilding(Player player, Property property) {
        if(property.getNoOfBuildings() < 1)
            return false;
        getMoney(player, property.getCurrentBuildingsSellingCost());
        if(property.getNoOfBuildings() == 5)
            player.setNoOfHotels(player.getNoOfHotels() - 1);
        else
            player.setNoOfHouses(player.getNoOfHouses() - 1);
        return true;
    }

    /**
     * This method handles the player when he sells all buildings of a property
     * @param player our action guy
     * @param property the property which the buildings will be selled
     * @return whether the process succeeded
     */
    public boolean sellAllBuildings(Player player, Property property) {
        if(property.getNoOfBuildings() < 1)
            return false;
        int noOfBuildings = property.getNoOfBuildings();
        ArrayList<Building> buildings = property.getBuildings();

        for( int i = 0; i < noOfBuildings; i++) {
            getMoney(player, buildings.get(i).getSellingPrice());
        }

        if(noOfBuildings == 5) {
            player.setNoOfHotels(player.getNoOfHotels() - 1);
            player.setNoOfHouses(player.getNoOfHouses() - 4);
        }
        else
            player.setNoOfHouses(player.getNoOfHouses() - noOfBuildings);
        return true;
    }

    /**
     * Whenever a player lands on a card location, a card is drawn and this method is called
     * @param player our action guy
     * @param card the drawn card
     */
    public void makeCardAction(Player player, Card card) {
        card.makeCardAction( player, this );
    }

    public void setLocation(Player player, int location) {
        if(player.getCurrentLocationIndex() > location) {
            player.setMoneyAmount(player.getMoneyAmount() + Constants.startingPointMoney);
        }
        player.setCurrentLocationIndex(location);
    }

    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    /**
     * This method is used take money forcefully from a player. Note that this one is called when he pays it to the bank.
     * @param player
     * @param amount the amount I guess :)
     */
    public void payForcedMoney( Player player, double amount ) {
        if ( canAfford(player, amount) )
            giveMoney(player , amount);
        else if (tenderToAvoidBankrupt( player , amount ))  {
            player.setDebt(amount);
            // Yukarı yazı düşelim burda kirayı ödemek için eşya satmanız lazım diye
            // bir de pay butonu yapıştıralım tepeye pay successful olana kadar end turn yapamasın
        } else {
            bankrupt( player );
        }
    }

    /**
     * This method is used take money forcefully from a player. Note that this one is called when he pays it to another player.
     * @param player the money payer
     * @param amount the amount I guess :)
     * @param receiver the guy who receives money from the player
     */
    public void payForcedMoneyToOtherPlayer( Player player, Player receiver, double amount ) {
        if ( canAfford(player, amount) )
            giveMoney(player , amount);
        else if (tenderToAvoidBankrupt( player , amount ))  {
            player.setDebt(amount);
            // Yukarı yazı düşelim burda kirayı ödemek için eşya satmanız lazım diye
            // bir de pay butonu yapıştıralım tepeye pay successful olana kadar end turn yapamasın
        } else {
            bankrupt( player, receiver );
        }
    }

}
