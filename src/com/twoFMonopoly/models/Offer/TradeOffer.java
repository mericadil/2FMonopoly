package com.twoFMonopoly.models.Offer;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.Managers.PropertyManager;
import com.twoFMonopoly.Managers.RailroadManager;
import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Locations.Railroad;
import com.twoFMonopoly.models.Player;
import jdk.nashorn.internal.runtime.PrototypeObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TradeOffer {
    private Player player1;
    private Player player2;

    private ArrayList<Property> givenProperties;
    private ArrayList<Property> takenProperties;

    private ArrayList<Railroad> givenRailroads;
    private ArrayList<Railroad> takenRailroads;

    private double gainedAmount;

    PlayerManager playerManager;
    PropertyManager propertyManager;
    RailroadManager railroadManager;

    public TradeOffer(Player player1, Player player2, ArrayList<Property> givenProperties,
                      ArrayList<Property> takenProperties, ArrayList<Railroad> givenRailroads,
                      ArrayList<Railroad> takenRailroads, double givenAmount, double takenAmount) {
        this.player1 = player1;
        this.player2 = player2;
        this.givenProperties = givenProperties;
        this.takenProperties = takenProperties;
        this.givenRailroads = givenRailroads;
        this.takenRailroads = takenRailroads;

        gainedAmount = takenAmount - givenAmount;

        playerManager = PlayerManager.getInstance();
        propertyManager = PropertyManager.getInstance();
        railroadManager = RailroadManager.getInstance();
    }

    public void completeOffer() {
        HashMap<String, Property> properties1 = player1.getProperties();
        HashMap<String, Property> properties2 = player2.getProperties();

        HashMap<String, Railroad> railroads1 = player1.getRailroads();
        HashMap<String, Railroad> railroads2 = player2.getRailroads();

        if(givenProperties.size() != 0) {
            for (Property property : givenProperties) {
                properties1.remove(property.getName());
                properties2.put(property.getName(), property);
                property.setOwner(player2);
                propertyManager.updatePropertyRegion(property.getRegion());
            }
        }
        if(takenProperties.size() != 0) {
            for (Property property : takenProperties) {
                properties2.remove(property.getName());
                properties1.put(property.getName(), property);
                property.setOwner(player1);
                propertyManager.updatePropertyRegion(property.getRegion());
            }
        }

        if(givenRailroads.size() != 0) {
            for (Railroad railroad : givenRailroads) {
                railroads1.remove(railroad.getName());
                railroads2.put(railroad.getName(), railroad);
                railroad.setOwner(player2);
            }
        }

        if(takenRailroads.size() != 0) {
            for (Railroad railroad : takenRailroads) {
                railroads2.remove(railroad.getName());
                railroads1.put(railroad.getName(), railroad);
                railroad.setOwner(player2);
            }
        }

        playerManager.getMoney(player1, gainedAmount);
        playerManager.giveMoney(player2, gainedAmount);

        player1.updateInformation();
        player2.updateInformation();

        railroadManager.updateRailroads(player1);
        railroadManager.updateRailroads(player2);

    }
}
