package com.twoFMonopoly.Managers;


import com.twoFMonopoly.models.Buildings.PropertyRegion;
import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class manages all property related functions.
 */
public class PropertyManager {

    private static PropertyManager instance = new PropertyManager();

    //Singleton constructor
    private PropertyManager(){
    }

    //Get the instance of the class
    public static PropertyManager getInstance() {
        return instance;
    }

    /**
     * This method handles the property when a player buys it.
     * @param property the bought property instance
     * @param player the owner
     */
    public void buyProperty(Property property, Player player) {
        property.setOwner(player);
        updatePropertyRegion(property.getRegion());
    }

    /**
     * This method handles the property when the owner mortgages it.
     * @param property the mortgaged property
     * @return whether the mortgage process succeeded
     */
    public boolean mortgageProperty(Property property) {
        if(property.getNoOfBuildings() == 0 && !property.isMortgaged()) {
            property.setMortgaged(true);
            if(property.isMonopoly()) updatePropertyRegion(property.getRegion());
            return true;
        }
        return false;
    }

    /**
     * This method handles the property when the owner unmortgages it.
     * @param property the unmortgaged property
     * @return whether the unmortgage process succeeded
     */
    public boolean removeMortgageProperty(Property property) {
        if(property.isMortgaged()) {
            property.setMortgaged(false);
            updatePropertyRegion(property.getRegion());
            return true;
        }
        return false;
    }

    /**
     * This method handles the property when the owner builds one building on it.
     * @param property the property
     * @return whether the process succeeded
     */
    public boolean buildOneBuilding(Property property) {
        if(!property.isMonopoly() || property.getNoOfBuildings() > 4)
            return false;
        property.setNoOfBuildings(property.getNoOfBuildings()+1);
        return true;
    }

    /**
     * This method handles the property when the owner sells one building on it.
     * @param property the property
     * @return whether the process succeeded
     */
    public boolean sellOneBuilding(Property property) {
        if(property.getNoOfBuildings() < 1)
            return false;
        property.setNoOfBuildings(property.getNoOfBuildings()-1);
        return true;
    }

    /**
     * This method handles the property region when a player monopolizes it
     * @param region the monopolized property region
     * @return whether the process succeeded
     */
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
}
