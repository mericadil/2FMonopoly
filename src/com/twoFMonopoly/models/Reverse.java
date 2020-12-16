package com.twoFMonopoly.models.Locations;

public class Reverse implements Location {
	
  //Attributes
  private String locationText;
  private int locationIndex;
  private String reversingText;

  //Constructor
  public Reverse(String reversingText, String locationText, int locationIndex){
    this.reversingText = reversingText;
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

  public String getReversingText() {
    return reversingText;
  }
}
