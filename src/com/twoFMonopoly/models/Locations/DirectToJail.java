package com.twoFMonopoly.models.Locations;

public class DirectToJail implements Location {

    //Attributes
    private String locationText;
    private int locationIndex;

    //Constructor
    public DirectToJail(String locationText, int locationIndex){
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
