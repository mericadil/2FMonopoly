package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class ReceiveFromOtherPlayers implements ReceiveStrategy {

    // Attributes
    private final int amount;

    // Methods
    public ReceiveFromOtherPlayers( int amount ) {
        this.amount = amount;
    }

    @Override
    // Burada diğer oyuncuların parası eksiye düşebilir onu kendi turlarında kontrol edicez.
    public void act(Player player, PlayerManager playerManager) {
        for ( Player sender : playerManager.getAllPlayers() ) {
            playerManager.getMoney( player, amount );
            playerManager.payForcedMoneyToOtherPlayer( sender, player, amount );
        }
    }

    public String toString() {
        return "Collect $" + amount + " from every player";
    }
}
