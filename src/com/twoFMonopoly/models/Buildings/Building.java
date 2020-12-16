package com.twoFMonopoly.models.Buildings;

public class Building {
    protected double buildingPrice;
    protected double sellingPrice;

    //Constructor
    public Building(double buildingPrice, double sellingPrice) {
        this.buildingPrice = buildingPrice;
        this.sellingPrice = sellingPrice;
    }

    public Building(double buildingPrice) {
        this.buildingPrice = buildingPrice;
        this.sellingPrice = buildingPrice;
    }

    public double getBuildingPrice() {
        return buildingPrice;
    }

    public void setBuildingPrice(double buildingPrice) {
        this.buildingPrice = buildingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
