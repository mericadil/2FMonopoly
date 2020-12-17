package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class ReceiveFromBank implements ReceiveStrategy {

    // Attributes
    private final double amount;

    // Methods
    public ReceiveFromBank( double amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player player) {
        player.setMoneyAmount(player.getMoneyAmount() + amount);
        // TODO
    }
}
