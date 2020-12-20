package com.twoFMonopoly.Managers;

import com.twoFMonopoly.models.Locations.Railroad;
import com.twoFMonopoly.models.Player;

import java.util.HashMap;

/**
 * This class manages all railroad related functions.
 */
public class RailroadManager {

    private static RailroadManager instance = new RailroadManager();

    private RailroadManager() {

    }

    public static RailroadManager getInstance() {
        return instance;
    }

    /**
     * This method handles the railroad when a player buys it.
     * @param railroad the bought property instance
     * @param player the owner
     */
    public void buyRailroad(Railroad railroad, Player player) {
        railroad.setOwner(player);
        updateRailroads(player);
    }

    /**
     * This method handles the railroad when a player mortgaged it.
     * @param railroad the mortgaged railroad instance
     * @param player the owner
     */
    public void mortgageRailroad(Railroad railroad, Player player) {
        railroad.setMortgaged(true);
        updateRailroads(player);
    }

    /**
     * This method handles the railroad when a player unmortgaged it.
     * @param railroad the unmortgaged railroad instance
     * @param player the owner
     */
    public boolean removeMortgageRailroad(Railroad railroad, Player player) {
        if(railroad.isMortgaged()) {
            railroad.setMortgaged(false);
            updateRailroads(player);
            return true;
        }
        return false;
    }

    /**
     * This method handles the rent that player takes according to the number of railroads that he owns.
     * @param player the owner of railroads
     * @return whether the process succeeded
     */
    public void updateRailroads(Player player) {
        HashMap<String, Railroad> railroads = player.getRailroads();
        for( String key: railroads.keySet()) {
            Railroad railroad = railroads.get(key);
            railroad.setNoOfRailroadsOwnedByTheOwner(player.getNoOfRailroads());
        }
    }
}
