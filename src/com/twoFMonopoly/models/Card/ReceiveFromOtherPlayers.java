package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class ReceiveFromOtherPlayers implements ReceiveStrategy {

    // Attributes
    private final int amount;

    // Methods
    public ReceiveFromOtherPlayers( int amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player p) {
        // TODO
    }
}
