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
        if(isMonopoly)
            return monopolyRentPrices.get(noOfBuildings);
        else
            return rentPrices.get(noOfBuildings);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    // Çağırılmadan önce condition check yapılacak...
    //noOfBuilding 4ten büyük olamaz
    public double getNextBuildingsBuildingCost() {
        return buildings.get(noOfBuildings).getSellingPrice();
    }

    // Çağırılmadan önce condition check yapılacak...
    //noOfBuilding 0 olamaz
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
}
