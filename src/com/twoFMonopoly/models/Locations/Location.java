package com.twoFMonopoly.models.Locations;

import java.io.Serializable;

/**
 * Location interface corresponds to a rectangle in the gameboard.
 * This interface is implemented by: Property, Railroad, Starting Point, Jail, Direct To Jail, Chance, Community Chest and Free Parking Lot
 */
public interface Location extends Serializable {
    String getLocationText();
    int getLocationIndex();
}
