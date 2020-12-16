package com.twoFMonopoly.models.Locations;

public class Tax implements Location {
	
  //Attributes
  private String locationText;
  private int locationIndex;
  private double taxAmount;

  //Constructor
  public Tax(double taxAmount, String locationText, int locationIndex){
    this.taxAmount = taxAmount;
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
	
  public double getTaxAmount() {
    return taxAmount;
  }

}
