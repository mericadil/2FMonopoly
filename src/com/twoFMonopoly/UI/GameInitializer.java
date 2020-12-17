package com.twoFMonopoly.UI;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.models.Buildings.Building;
import com.twoFMonopoly.models.Buildings.PropertyRegion;
import com.twoFMonopoly.models.Card.Chance;
import com.twoFMonopoly.models.Card.CommunityChest;
import com.twoFMonopoly.models.Locations.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameInitializer {
    public static ArrayList<Property> createProperties(ArrayList<String> names, ArrayList<Double> costs,
                                                       ArrayList<ArrayList<Double>> rentPrices,
                                                       ArrayList<Integer> locationIndexes, ArrayList<PropertyRegion> region,
                                                       ArrayList<Building> buildings,
                                                       int noOfProperties) {
        ArrayList<Property> properties = new ArrayList<>();
        for( int i = 0; i < 16; i++) {
            Property property = new Property(names.get(i),costs.get(i), rentPrices.get(i),
                    names.get(i), locationIndexes.get(i), region.get(i), buildings);
            properties.add(property);
            region.get(i).addProperty(property);
        }
        return properties;
    }

    public static ArrayList<PropertyRegion> createPropertyRegions() {
        ArrayList<PropertyRegion> propertyRegions = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            PropertyRegion propertyRegion = new PropertyRegion();
            propertyRegions.add(propertyRegion);
        }

        return propertyRegions;
    }
    public static ArrayList<Railroad> createRailroads( ArrayList<String> names, ArrayList<Double> costs,
                                        ArrayList<ArrayList<Double>> rentPrices, ArrayList<Integer> locationIndex) {
            ArrayList<Railroad> railroads = new ArrayList<>();

            for(int i = 0; i < 3; i++) {
                Railroad railroad = new Railroad(names.get(i), costs.get(i), rentPrices.get(i),
                        names.get(i), locationIndex.get(i));
                railroads.add(railroad);
            }
            return railroads;
    }

    public static ArrayList<Building> createBuildingSet( ArrayList<Double> buildingPrices,
                                                         ArrayList<Double> sellingPrices) {
        ArrayList<Building> buildings = new ArrayList<>();

        for( int i = 0; i < 5; i++) {
            Building building = new Building(buildingPrices.get(i), sellingPrices.get(i));
            buildings.add(building);
        }

        return buildings;
    }
    public static void initLocations( ArrayList<Property> properties, ArrayList<Railroad> railroads) {
        ArrayList<Location> locations = new ArrayList<>();
        for( int i = 0; i < Constants.boardsMaxIndex; i++) {
            locations.add(new Location() {
                @Override
                public String getLocationText() {
                    return null;
                }

                @Override
                public int getLocationIndex() {
                    return 0;
                }
            });
        }

        for( Property property : properties) {
            locations.set(property.getLocationIndex(), property);
        }

        for( Railroad railroad : railroads) {
            locations.set(railroad.getLocationIndex(), railroad);
        }

        CommunityChest communityChest = new CommunityChest();
        Chance chance = new Chance();
        locations.set(0, new StartingPoint("Starting Point", 0));
        locations.set(3, communityChest);
        locations.set(18, communityChest);

        locations.set(10, chance);
        locations.set(24, chance);
        locations.set(7, new Jail("Jail", 7));
        locations.set(14, new DirectToJail("Go To Jail", 14));
        locations.set(21, new FreeParkingLot("Free Parking Lot", 21));
        locations.set(25, new Tax(300, "Free Parking Lot", 25));
    }
}
