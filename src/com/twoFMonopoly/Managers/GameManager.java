package com.twoFMonopoly.Managers;

import com.twoFMonopoly.UI.GameInitializer;
import com.twoFMonopoly.models.Locations.Location;
import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Player;

import java.util.ArrayList;

public class GameManager {
    private ArrayList<Location> locations;
    private ArrayList<Player> players;
    private double moneyInTheMiddle;
    private PlayerManager playerManager;
    private PropertyManager propertyManager;
    private RailroadManager railroadManager;

    public GameManager(ArrayList<Location> locations, ArrayList<Player> players) {
        this.locations = locations;
        this.players = players;
        propertyManager = PropertyManager.getInstance();
        railroadManager = RailroadManager.getInstance();
        playerManager = PlayerManager.getInstance();
    }
}
