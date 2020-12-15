package com.twoFMonopoly.models.Locations;

import com.twoFMonopoly.models.Buildings.PropertyRegion;
import com.twoFMonopoly.models.Player;

import java.util.ArrayList;

public class Property extends Tradable implements Location{

    //Attributes
    private String locationText;
    private int locationIndex;
    private PropertyRegion region;
    private int noOfBuildings;
    private boolean isMonopoly;
    private ArrayList<Integer> monopolyRentPrices;

    //Constructor
    public Property(String name, double cost, ArrayList<Integer> rentPrices, String locationText, int locationIndex, PropertyRegion region) {
        super(name, cost, rentPrices);
        this.locationText = locationText;
        this.locationIndex = locationIndex;
        this.region = region;
        this.noOfBuildings = 0;
        this.isMonopoly = false;

        monopolyRentPrices = new ArrayList<>();
        for( Integer price : rentPrices) {
            monopolyRentPrices.add(price*2);
        }
    }

    //Operations
    public String getLocationText() {
        return locationText;
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public PropertyRegion getRegion() {
        return region;
    }

    public int getNoOfBuildings() {
        return noOfBuildings;
    }

    public void setNoOfBuildings(int noOfBuildings) {
        this.noOfBuildings = noOfBuildings;
    }

    public boolean isMonopoly() {
        return isMonopoly;
    }

    public void setMonopoly(boolean monopoly) {
        isMonopoly = monopoly;
    }

    public int getRentCost() {
        if(isMonopoly)
            return monopolyRentPrices.get(noOfBuildings);
        else
            return rentPrices.get(noOfBuildings);
    }
}
