package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class ReceiveFromBank implements ReceiveStrategy {

    // Attributes
    private final int amount;

    // Methods
    public ReceiveFromBank( int amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player p) {
        // TODO
    }
}
