package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class PayToOtherPlayers implements PayStrategy {

    // Attributes
    private final int amount;

    // Methods
    public PayToOtherPlayers( int amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player p) {
        // TODO
    }
}
