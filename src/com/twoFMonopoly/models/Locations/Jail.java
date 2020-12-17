package com.twoFMonopoly.models.Locations;

public class Jail implements Location {

    //Attributes
    private String locationText;
    private int locationIndex;

    //Constructor
    public Jail(String locationText, int locationIndex){
        this.locationText = locationText;
        this.locationIndex = locationIndex;
    }

    //Operations
    public String getLocationText() {
        return locationText;
    }

    public int getLocationIndex() {
        return locationIndex;
    }

}
