package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class PayToOtherPlayers implements PayStrategy {

    // Attributes
    private final double amount;

    // Methods
    public PayToOtherPlayers( double amount ) {
        this.amount = amount;
    }

    @Override
    public void act(Player player, PlayerManager playerManager ) {
        for ( Player receiver : playerManager.getAllPlayers() ) {
            playerManager.getMoney( receiver, amount );
        }

        playerManager.payForcedMoney( player, amount * playerManager.getAllPlayers().size() );

    }

    public String toString() {
        return "Pay $" + amount + " to every player";
    }
}
