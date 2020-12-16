package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class PayForEveryBuilding implements PayStrategy {
    // Attributes
    private final int amountForHouses;
    private final int amountForHotels;

    // Methods
    PayForEveryBuilding( int amountForHouses, int amountForHotels ) {
        this.amountForHouses = amountForHouses;
        this.amountForHotels = amountForHotels;
    }

    @Override
    public void act(Player p) {
        // TODO
    }
}
