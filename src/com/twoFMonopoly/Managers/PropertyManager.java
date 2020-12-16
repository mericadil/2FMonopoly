package com.twoFMonopoly.Managers;


import com.twoFMonopoly.models.Buildings.PropertyRegion;
import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PropertyManager {

    private static PropertyManager instance = new PropertyManager();

    //Singleton constructor
    private PropertyManager(){
    }

    //Get the instance of the class
    public static PropertyManager getInstance() {
        return instance;
    }

    public void buyProperty(Property property, Player player) {
        property.setOwner(player);
        updatePropertyRegion(property.getRegion());
    }

    public boolean mortgageProperty(Property property) {
        if(property.getNoOfBuildings() == 0 && !property.isMortgaged()) {
            property.setMortgaged(true);
            if(property.isMonopoly()) updatePropertyRegion(property.getRegion());
            return true;
        }
        return false;
    }

    public boolean removeMortgageProperty(Property property) {
        if(property.isMortgaged()) {
            property.setMortgaged(false);
            updatePropertyRegion(property.getRegion());
            return true;
        }
        return false;
    }

    public boolean buildOneBuilding(Property property) {
        if(!property.isMonopoly() || property.getNoOfBuildings() > 4)
            return false;
        property.setNoOfBuildings(property.getNoOfBuildings()+1);
        return true;
    }

    public boolean sellOneBuilding(Property property) {
        if(property.getNoOfBuildings() < 1)
            return false;
        property.setNoOfBuildings(property.getNoOfBuildings()-1);
        return true;
    }

    public void sellAllBuildings(Property property) {
        if(property.getNoOfBuildings() > 0)
            property.setNoOfBuildings(0);
    }

    public void updatePropertyRegion(PropertyRegion region) {
        ArrayList<Property> properties = region.getProperties();
        if(region.checkPropertyRegion()) {
            for(Property property : properties) {
                property.setMonopoly(true);
            }
            region.setMonopoly(true);
        }
        else if(region.isMonopoly()) {
            for(Property property : properties) {
                property.setMonopoly(false);
            }
            region.setMonopoly(false);
        }
    }

    public void bankrupt(Player player) {
        HashMap<String,Property> playerProperties = player.getProperties();

        for( String key : playerProperties.keySet()) {
            Property property = playerProperties.get(key);
            property.setOwner(null);
            property.setNoOfBuildings(0);
            property.setMortgaged(false);
            property.setMonopoly(false);
            // not necessary but not sure
            //updatePropertyRegion(property.getRegion());
        }
    }

    public void bankrupt(Player player1, Player player2) {
        HashMap<String,Property> player1Properties = player1.getProperties();
        HashMap<String,Property> player2Properties = player2.getProperties();

        for( String key : player1Properties.keySet()) {
            Property property = player1Properties.get(key);
            property.setOwner(player2);

            updatePropertyRegion(property.getRegion());
        }

    }


}
