package com.twoFMonopoly.models;

import com.twoFMonopoly.models.Locations.Property;
import com.twoFMonopoly.models.Locations.Railroad;

import java.util.HashMap;

public class Player {
    //Attributes
    private int id;
    private String name;
    private double moneyAmount;
    private HashMap<String, Property> properties;
    private HashMap<String, Railroad> railroads;
    private int jailStatus;
    private int noOfFreedomRights;
    private int noOfHouses;
    private int noOfHotels;
    private int noOfRailroads;
    private boolean isBankrupt;
    private double timeSpent;
    private int currentLocationIndex;

    //Constructor
    public Player(int id, String name, double moneyAmount) {
        this.id = id;
        this.name = name;
        this.moneyAmount = moneyAmount;
        this.properties = new HashMap<>();
        this.railroads = new HashMap<>();
        this.jailStatus = 0;
        this.noOfFreedomRights = 0;
        this.noOfHouses = 0;
        this.noOfHotels = 0;
        this.noOfRailroads = 0;
        this.isBankrupt = false;
        this.timeSpent = 0.0;
        this.currentLocationIndex = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Property> getProperties() {
        return properties;
    }

    public HashMap<String, Railroad> getRailroads() {
        return railroads;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void bankrupt() {
        isBankrupt = true;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getJailStatus() {
        return jailStatus;
    }

    public void setJailStatus(int jailStatus) {
        this.jailStatus = jailStatus;
    }

    public int getNoOfFreedomRights() {
        return noOfFreedomRights;
    }

    public void setNoOfFreedomRights(int noOfFreedomRights) {
        this.noOfFreedomRights = noOfFreedomRights;
    }

    public int getNoOfHouses() {
        return noOfHouses;
    }

    public void setNoOfHouses(int noOfHouses) {
        this.noOfHouses = noOfHouses;
    }

    public int getNoOfHotels() {
        return noOfHotels;
    }

    public void setNoOfHotels(int noOfHotels) {
        this.noOfHotels = noOfHotels;
    }

    public int getNoOfRailroads() {
        return noOfRailroads;
    }

    public void setNoOfRailroads(int noOfRailroads) {
        this.noOfRailroads = noOfRailroads;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getCurrentLocationIndex() {
        return currentLocationIndex;
    }

    public void setCurrentLocationIndex(int currentLocationIndex) {
        this.currentLocationIndex = currentLocationIndex;
    }
}
