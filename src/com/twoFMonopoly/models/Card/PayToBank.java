package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class PayToBank implements PayStrategy {

    // Attributes
    private final int amount;

    // Methods
    public PayToBank( int amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player player, PlayerManager playerManager) {
        playerManager.payForcedMoney( player, amount );
    }

    public String toString() {
        return "Pay $" + amount;
    }
}
