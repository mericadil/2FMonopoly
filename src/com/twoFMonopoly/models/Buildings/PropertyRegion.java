package com.twoFMonopoly.models.Buildings;

import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class PropertyRegion implements Serializable {

    //Attributes
    private ArrayList<Property> properties;
    private boolean isMonopoly;
    //Constructor
    public PropertyRegion(ArrayList<Property> properties) {
        this.properties = properties;
        this.isMonopoly = false;
    }

    public PropertyRegion() {
        this.properties = new ArrayList<>();
        this.isMonopoly = false;
    }

    //Operations
    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    //Add property to the property region
    public boolean addProperty(Property property) {
        if(properties.contains(property))
            return false;
        properties.add(property);
        return true;
    }

    public boolean isMonopoly() {
        return isMonopoly;
    }

    public void setMonopoly(boolean monopoly) {
        isMonopoly = monopoly;
    }

    // Check whether all properties in the property region belong to the same player.
    public boolean checkPropertyRegion() {
        Player owner = properties.get(0).getOwner();

        if(owner == null) return false;

        for( Property property : properties) {
            if(property.getOwner() == null || property.getOwner() != owner || property.isMortgaged())
                return false;
        }
        return true;
    }
    /* Coded in the property manager class
    public void updatePropertyRegion() {
        if(checkPropertyRegion()) {
            for( Property property : properties) {
                property.setMonopoly(true);
            }
            isMonopoly = true;
        }
        else if(isMonopoly){
            for( Property property : properties) {
                property.setMonopoly(false);
            }
            isMonopoly = false;
        }
    }*/
}
