package com.twoFMonopoly.Managers;

import com.twoFMonopoly.models.Locations.Railroad;
import com.twoFMonopoly.models.Player;

import java.util.HashMap;

public class RailroadManager {

    private static RailroadManager instance = new RailroadManager();

    private RailroadManager() {

    }

    public static RailroadManager getInstance() {
        return instance;
    }

    //Playermanager's buy-sell-mortgage operation should be used before
    public void buyRailroad(Railroad railroad, Player player) {
        railroad.setOwner(player);
        updateRailroads(player);
    }

    public void mortgageRailroad(Railroad railroad, Player player) {
        railroad.setMortgaged(true);
        updateRailroads(player);
    }

    public void removeMortgageRailroad(Railroad railroad, Player player) {
        railroad.setMortgaged(false);
        updateRailroads(player);
    }

    public void bankrupt(Player player) {
        HashMap<String,Railroad> playerRailroads = player.getRailroads();

        for( String key : playerRailroads.keySet()) {
            Railroad railroad = playerRailroads.get(key);
            railroad.setOwner(null);
            railroad.setMortgaged(false);
            railroad.setNoOfRailroadsOwnedByTheOwner(0);

            //updateRailroads(player);
        }
    }

    public void bankrupt(Player player1, Player player2) {
        HashMap<String,Railroad> player1Railroads = player1.getRailroads();
        HashMap<String,Railroad> player2Railroads = player2.getRailroads();

        for( String key : player1Railroads.keySet()) {
            Railroad railroad = player1Railroads.get(key);
            railroad.setOwner(player2);
            updateRailroads(player2);
        }
    }

    public void updateRailroads(Player player) {
        HashMap<String, Railroad> railroads = player.getRailroads();
        for( String key: railroads.keySet()) {
            Railroad railroad = railroads.get(key);
            railroad.setNoOfRailroadsOwnedByTheOwner(player.getNoOfRailroads());
        }
    }
}
