package com.twoFMonopoly.Managers;


import com.twoFMonopoly.models.Buildings.PropertyRegion;
import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Player;

import java.util.ArrayList;

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
        if(property.getNoOfBuildings() == 0) {
            property.setMortgaged(true);
            if(property.isMonopoly()) updatePropertyRegion(property.getRegion());
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
        if(!property.isMonopoly() || property.getNoOfBuildings() < 1)
            return false;
        property.setNoOfBuildings(property.getNoOfBuildings()-1);
        return true;
    }

    public void sellAllBuildings(Property property) {
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


}
