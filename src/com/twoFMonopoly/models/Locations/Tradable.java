package com.twoFMonopoly.models.Locations;

import com.twoFMonopoly.models.Player;

import java.util.ArrayList;

public abstract class Tradable {
    //Attributes
    protected String name;
    protected double cost;
    protected Player owner;
    protected ArrayList<Double> rentPrices;
    protected double currentMortgagePrice;
    protected final double MORTGAGE_RATE = 1.10;
    protected boolean isMortgaged;

    //Constructor
    public Tradable(String name, double cost, ArrayList<Double> rentPrices) {
        this.name = name;
        this.cost = cost;
        this.owner = null;
        this.rentPrices = rentPrices;
        this.currentMortgagePrice = cost * MORTGAGE_RATE;
        this.isMortgaged = false;
    }

    //Operations
    public double getCost() {
        return cost;
    }

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        isMortgaged = mortgaged;
    }

    public void setCost(double cost) {
        this.cost = cost;
        this.currentMortgagePrice = cost * MORTGAGE_RATE;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public ArrayList<Double> getRentPrices() {
        return rentPrices;
    }

    public void setRentPrices(ArrayList<Double> rentPrices) {
        this.rentPrices = rentPrices;
    }

    public double getCurrentMortgagePrice() {
        return currentMortgagePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
