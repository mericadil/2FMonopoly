package com.twoFMonopoly.models.Locations;

import com.twoFMonopoly.models.Buildings.Building;
import com.twoFMonopoly.models.Buildings.Hotel;
import com.twoFMonopoly.models.Buildings.House;
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
    private ArrayList<Double> monopolyRentPrices;
    private ArrayList<Building> buildings;

    //Constructor
    public Property(String name, double cost, ArrayList<Double> rentPrices, String locationText, int locationIndex, PropertyRegion region, ArrayList<Building> buildings) {
        super(name, cost, rentPrices);
        this.locationText = locationText;
        this.locationIndex = locationIndex;
        this.region = region;
        this.noOfBuildings = 0;
        this.isMonopoly = false;
        this.buildings = buildings;

        monopolyRentPrices = new ArrayList<>();
        for( Double price : rentPrices) {
            monopolyRentPrices.add(price*1.5);
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

    public double getRentCost() {
        return rentPrices.get(noOfBuildings);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    // Condition check should be applied before calling
    // noOfBuildings should be less than 5
    public double getNextBuildingsBuildingCost() {
        return buildings.get(noOfBuildings).getBuildingPrice();
    }

    // Condition check should be applied before calling
    // noOfBuildings should be greater than 0
    public double getCurrentBuildingsSellingCost() {
        return buildings.get(noOfBuildings-1).getSellingPrice();
    }

    public double getTotalValue() {
        double totalValue = 0;
        for( int i = 0; i < noOfBuildings; i++)
            totalValue += buildings.get(i).getSellingPrice();
        totalValue += this.cost;
        return totalValue;
    }

    public void setDefaultSettings() {
        owner = null;
        isMortgaged = false;
        isMonopoly = false;
        noOfBuildings = 0;
    }
}
