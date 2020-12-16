package com.twoFMonopoly.models.Locations;

public class FreeParkingLot implements Location {
	
  //Attributes
  private String locationText;
  private int locationIndex;
  private String parkingLotText;

  //Constructor
  public Reverse(String parkingLotText, String locationText, int locationIndex){
    this.parkingLotText = parkingLotText;
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

  public String getParkingLotText() {
    return parkingLotText;
  }
}
