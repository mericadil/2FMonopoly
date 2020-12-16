package com.twoFMonopoly.models.Locations;

import java.util.ArrayList;

public class Railroad extends Tradable implements Location{

    //Attributes
    private String locationText;
    private int locationIndex;
    private int noOfRailroadsOwnedByTheOwner;

    //Constructor
    public Railroad(String name, double cost, ArrayList<Double> rentPrices, String locationText, int locationIndex) {
        super(name, cost, rentPrices);
        this.locationText = locationText;
        this.locationIndex = locationIndex;
        this.noOfRailroadsOwnedByTheOwner = 0;
    }

    //Operations
    public String getLocationText() {
        return locationText;
    }
    public int getLocationIndex() {
        return locationIndex;
    }
    public int getNoOfRailroadsOwnedByTheOwner(){
        return noOfRailroadsOwnedByTheOwner;
    }
    public void setNoOfRailroadsOwnedByTheOwner(int railroadsOwnedByTheOwner){
        noOfRailroadsOwnedByTheOwner = railroadsOwnedByTheOwner;
    }

}
