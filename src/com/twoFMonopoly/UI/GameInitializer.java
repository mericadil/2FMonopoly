package com.twoFMonopoly.UI;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.models.Buildings.Building;
import com.twoFMonopoly.models.Buildings.PropertyRegion;
import com.twoFMonopoly.models.Card.Chance;
import com.twoFMonopoly.models.Card.CommunityChest;
import com.twoFMonopoly.models.Locations.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GameInitializer { // (Ankara, Antalya)
    public ArrayList<Property> createProperties(ArrayList<String> names, ArrayList<Double> costs,
                                                       ArrayList<ArrayList<Double>> rentPrices, // 6 elemanlı liste
                                                       ArrayList<Integer> locationIndexes, ArrayList<PropertyRegion> region,
                                                       ArrayList<Building> buildings,
                                                       int noOfProperties) {
        System.out.println("ben create propertyim");
        ArrayList<Property> properties = new ArrayList<>();
        for( int i = 0; i < 16; i++) {
            Property property = new Property(names.get(i),costs.get(i), rentPrices.get(i),
                    names.get(i), locationIndexes.get(i), region.get(i/2), buildings);
            properties.add(property);
            region.get(i/2).addProperty(property);
        }
        return properties;
    }

    // Call this first
    public ArrayList<PropertyRegion> createPropertyRegions() {
        System.out.println("ben create propertyregion");
        ArrayList<PropertyRegion> propertyRegions = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            PropertyRegion propertyRegion = new PropertyRegion();
            propertyRegions.add(propertyRegion);
        }

        return propertyRegions;
    }
    public ArrayList<Railroad> createRailroads( ArrayList<String> names, ArrayList<Double> costs,
                                        ArrayList<ArrayList<Double>> rentPrices, ArrayList<Integer> locationIndex) {
        System.out.println("ben create railroadsum");
            ArrayList<Railroad> railroads = new ArrayList<>();

            for(int i = 0; i < 3; i++) {
                Railroad railroad = new Railroad(names.get(i), costs.get(i), rentPrices.get(i),
                        names.get(i), locationIndex.get(i));
                railroads.add(railroad);
            }
            return railroads;
    }

    public ArrayList<Building> createBuildingSet( ArrayList<Double> buildingPrices,
                                                         ArrayList<Double> sellingPrices) {
        System.out.println("ben create building setim");
        ArrayList<Building> buildings = new ArrayList<>();

        for( int i = 0; i < 5; i++) {
            Building building = new Building(buildingPrices.get(i), sellingPrices.get(i));
            buildings.add(building);
        }

        return buildings;
    }
    public ArrayList<Location> initLocations( ArrayList<Property> properties, ArrayList<Railroad> railroads) {
        System.out.println("ben create initLoc");
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
        locations.set(25, new Tax(300, "Tax", 25));

        return locations;
    }

    public ArrayList<Location> initTurkeyMap() {
        ArrayList<PropertyRegion> propertyRegions = createPropertyRegions();

        ArrayList<Building> buildings = createBuildingSet(  new ArrayList<Double>( Arrays.asList(150.0, 200.0, 250.0, 300.0, 350.0)),
                new ArrayList<Double>( Arrays.asList(75.0, 100.0, 125.0, 150.0, 200.0)));

        ArrayList<Railroad> railroads = createRailroads( new ArrayList<String>( Arrays.asList("Haydarpasa", "Ankara", "Alsancak")),
                new ArrayList<Double>( Arrays.asList(200.0, 200.0, 200.0)),
                new ArrayList<ArrayList<Double>>( Arrays.asList(
                        new ArrayList<Double>( Arrays.asList(25.0, 50.0, 100.0, 200.0)),
                        new ArrayList<Double>( Arrays.asList(25.0, 50.0, 100.0, 200.0)),
                        new ArrayList<Double>( Arrays.asList(25.0, 50.0, 100.0, 200.0)))),
                new ArrayList<Integer>( Arrays.asList(5, 12, 16)));
        for( Railroad railroad : railroads) {
            System.out.println(railroad.getName());
        }

        ArrayList<Property> properties = createProperties(  new ArrayList<String>( Arrays.asList("Van",
                "Urfa", "Erzurum", "Yozgat", "Antep", "Mersin",
                "Kars", "Kayseri", "Konya", "Çanakkale", "Kocaeli", "Bursa",
                "Muğla", "İzmir", "Ankara", "İstanbul")),

                new ArrayList<Double>(   Arrays.asList( 60.0, 60.0, 100.0, 120.0, 140.0, 160.0,
                        180.0, 200.0, 220.0, 240.0, 260.0, 280.0,
                        300.0, 320.0, 350.0, 400.0)),

                new ArrayList<ArrayList<Double>>( Arrays.asList(
                        new ArrayList<Double>( Arrays.asList(2.0, 10.0, 30.0, 90.0, 160.0, 250.0)),
                        new ArrayList<Double>( Arrays.asList(4.0, 20.0, 60.0, 180.0, 320.0, 450.0)),
                        new ArrayList<Double>( Arrays.asList(6.0, 30.0, 90.0, 270.0, 400.0, 550.0)),
                        new ArrayList<Double>( Arrays.asList(8.0, 40.0, 100.0, 300.0, 450.0, 600.0)),
                        new ArrayList<Double>( Arrays.asList(10.0, 50.0, 150.0, 450.0, 625.0, 750.0)),
                        new ArrayList<Double>( Arrays.asList(12.0, 60.0, 180.0, 500.0, 700.0, 900.0)),
                        new ArrayList<Double>( Arrays.asList(14.0, 70.0, 200.0, 550.0, 750.0, 950.0)),
                        new ArrayList<Double>( Arrays.asList(16.0, 80.0, 220.0, 600.0, 800.0, 1000.0)),
                        new ArrayList<Double>( Arrays.asList(18.0, 90.0, 250.0, 700.0, 875.0, 1050.0)),
                        new ArrayList<Double>( Arrays.asList(20.0, 100.0, 300.0, 750.0, 925.0, 1100.0)),
                        new ArrayList<Double>( Arrays.asList(22.0, 110.0, 330.0, 800.0, 975.0, 1150.0)),
                        new ArrayList<Double>( Arrays.asList(22.0, 120.0, 360.0, 850.0, 1025.0, 1200.0)),
                        new ArrayList<Double>( Arrays.asList(26.0, 130.0, 390.0, 900.0, 1100.0, 1275.0)),
                        new ArrayList<Double>( Arrays.asList(28.0, 150.0, 450.0, 1000.0, 1200.0, 1400.0)),
                        new ArrayList<Double>( Arrays.asList(35.0, 175.0, 500.0, 1100.0, 1300.0, 1500.0)),
                        new ArrayList<Double>( Arrays.asList(50.0, 200.0, 600.0, 1400.0, 1700.0, 2000.0)))),

                new ArrayList<Integer>( Arrays.asList(  1, 2, 4, 6, 8, 9,
                        11, 13, 15, 17, 19, 20,
                        22, 23, 26, 27)),
                propertyRegions, buildings, 16);
            ArrayList<Location> locations = initLocations(properties, railroads);
            /*
            for( Location location: locations) {
                System.out.println(location.getLocationText());
            }*/

            return locations;

    }

    public GameInitializer() {
    }
}
