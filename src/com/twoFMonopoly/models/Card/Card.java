package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

import java.io.Serializable;

public abstract class Card implements Serializable {

    // Attributes
    protected final CardActionStrategy actionStrategy;

    // Methods

    public Card( CardActionStrategy actionStrategy ) {
        this.actionStrategy = actionStrategy;
    }

    public void makeCardAction(Player player, PlayerManager playerManager) {
        actionStrategy.act( player, playerManager );
    }

    @Override
    public String toString() {
        return actionStrategy.toString();
    }
}
