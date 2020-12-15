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
    private boolean isBuildable;

    //Constructor
    public Property(String name, double cost, ArrayList<Integer> rentPrices, String locationText, int locationIndex, PropertyRegion region) {
        super(name, cost, rentPrices);
        this.locationText = locationText;
        this.locationIndex = locationIndex;
        this.region = region;
        this.noOfBuildings = 0;
        this.isBuildable = false;
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

    public boolean isBuildable() {
        return isBuildable;
    }

    public void setBuildable(boolean buildable) {
        isBuildable = buildable;
    }
}
