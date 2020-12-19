package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class ReceiveFromBank implements ReceiveStrategy {

    // Attributes
    private final double amount;

    // Methods
    public ReceiveFromBank( double amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player player, PlayerManager playerManager) {
        playerManager.getMoney( player, amount );
    }

    public String toString() {
        return "Collect $" + amount;
    }
}
