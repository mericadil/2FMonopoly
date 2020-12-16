package com.twoFMonopoly.models.Locations;

public class StartingPoint implements Location {
	
  //Attributes
  private String locationText;
  private int locationIndex;
	private String startingPointText;

	//Constructor
	public Reverse(String startingPointText, String locationText, int locationIndex){
	  this.startingPointText = startingPointText;
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

	public String getStartingPointText() {
		return startingPointText;
	}
}
