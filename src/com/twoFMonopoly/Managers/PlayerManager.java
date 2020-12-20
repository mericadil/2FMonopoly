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

    public void buyProperty(Player player, Property property) {
        HashMap<String,Property> properties = player.getProperties();
        properties.put(property.getName(),property);
        giveMoney(player, property.getCost());
        //player.setMoneyAmount(player.getMoneyAmount() - property.getCost());
    }

    public void mortgageProperty(Player player, Property property) {
        getMoney(player, property.getCost());
        //player.setMoneyAmount(player.getMoneyAmount() + property.getCost());
    }

    public void removeMortgageProperty(Player player, Property property) {
        giveMoney(player, property.getCurrentMortgagePrice());
        //player.setMoneyAmount(player.getMoneyAmount() - property.getCurrentMortgagePrice());
    }

    public void buyRailroad(Player player, Railroad railroad) {
        HashMap<String,Railroad> railroads = player.getRailroads();
        railroads.put(railroad.getName(),railroad);
        player.setNoOfRailroads(player.getNoOfRailroads()+1);
        giveMoney(player, railroad.getCost());
        //player.setMoneyAmount(player.getMoneyAmount() - railroad.getCost());
    }

    public void mortgageRailroad(Player player, Railroad railroad) {
        getMoney(player, railroad.getCost());
        //player.setMoneyAmount(player.getMoneyAmount() + railroad.getCost());
        player.setNoOfRailroads(player.getNoOfRailroads()-1);
    }

    public void removeMortgageRailroad(Player player, Railroad railroad) {
        giveMoney(player, railroad.getCurrentMortgagePrice());
        //player.setMoneyAmount(player.getMoneyAmount() - railroad.getCurrentMortgagePrice());
        player.setNoOfRailroads(player.getNoOfRailroads()+1);
    }

    public void goToJail( Player player, int jailLocation) {
        player.setJailStatus(1);
        player.setCurrentLocationIndex(jailLocation);
    }

    public void updateJailStatus(Player player) {
        player.setJailStatus(player.getJailStatus()+1);
    }

    public void payFineToExitJail(Player player, double fine) {
        giveMoney(player, fine);
        //player.setMoneyAmount(player.getMoneyAmount()-fine);
        exitJail(player);
    }

    public boolean useFreedomRightToExitJail(Player player) {
        if(player.getNoOfFreedomRights() > 0) {
            player.setNoOfFreedomRights(player.getNoOfFreedomRights()-1);
            exitJail(player);
            return true;
        }
        return false;
    }

    public void exitJail(Player player) {
        player.setJailStatus(0);
    }

    public void getMoney(Player player, double money) {
        player.setMoneyAmount(player.getMoneyAmount() + money);
    }

    public void giveMoney(Player player, double money) {
        player.setMoneyAmount(player.getMoneyAmount() - money);
    }

    public void bankrupt(Player player1, Player player2) {
        HashMap<String,Property> player1Properties = player1.getProperties();
        HashMap<String,Property> player2Properties = player2.getProperties();

        HashMap<String,Railroad> player1Railroads = player1.getRailroads();
        HashMap<String,Railroad> player2Railroads = player2.getRailroads();

        getMoney(player2, player1.getMoneyAmount());
        player2.setNoOfFreedomRights(player2.getNoOfFreedomRights() + player1.getNoOfFreedomRights());
        player2.setNoOfRailroads(player2.getNoOfRailroads() + player1.getNoOfRailroads());
        player2.setNoOfHotels(player2.getNoOfHotels() + player1.getNoOfHotels());
        player2.setNoOfHouses(player2.getNoOfHouses() + player1.getNoOfHouses());


        for( String key: player1Properties.keySet()) {
            player2Properties.put(key, player1Properties.get(key));
        }

        for( String key : player1Railroads.keySet())
            player2Railroads.put(key, player1Railroads.get(key));

        player1.setMoneyAmount(0);
        player1.setNoOfFreedomRights(0);
        player1.setNoOfRailroads(0);
        player1.setNoOfHotels(0);
        player1.setNoOfHouses(0);
        player1.setJailStatus(0);
        player1.bankrupt();

    }

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

    public void payRent(Player player, Tradable tradable) {
        double rentCost = tradable.getRentCost();
        giveMoney(player, rentCost);
        getMoney(tradable.getOwner(), rentCost);
    }
    public void payRentProperty(Player player, Property property) {
        double rentCost = property.getRentCost();
        giveMoney(player, rentCost);
        getMoney(property.getOwner(), rentCost);
    }

    public void payRentRailroad( Player player, Railroad railroad) {
        double rentCost = railroad.getRentCost();
        giveMoney(player, rentCost);
        getMoney(railroad.getOwner(), rentCost);
    }


    public boolean tenderToAvoidBankrupt( Player player, double amount) {
        double moneyNeeded = amount - player.getMoneyAmount();
        double totalMoney = calculateTotalMoneyCanBeEarned(player);
        return totalMoney >= moneyNeeded;
    }

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

    public boolean canAfford(Player player, double amount) {
        return player.getMoneyAmount() >= amount;
    }

    //Call first
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
