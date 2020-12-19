package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class PayToBank implements PayStrategy {

    // Attributes
    private final int amount;

    // Methods
    public PayToBank( int amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player p) {
        // TODO
    }
}
