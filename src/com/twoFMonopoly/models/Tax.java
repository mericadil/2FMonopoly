package com.twoFMonopoly.models.Locations;

public class Tax implements Location {
	
  //Attributes
  private String locationText;
  private int locationIndex;
  private int taxAmount;
  private String taxTypeText;

  //Constructor
  public Reverse(int taxAmount, String taxTypeText, String locationText, int locationIndex){
    this.taxAmount = taxAmount;
    this.taxTypeText = taxTypeText;
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
	
  public int getTaxAmount() {
    return taxAmount;
  }

  public String getTaxTypeText() {
    return taxTypeText;
  }
}
