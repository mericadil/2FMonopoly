package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public abstract class Card {

    // Attributes
    protected final CardActionStrategy actionStrategy;
    protected final String cardText;

    // Methods

    public Card( CardActionStrategy actionStrategy, String cardText ) {
        this.actionStrategy = actionStrategy;
        this.cardText = cardText;
    }

    public void makeCardAction(Player p) {
        actionStrategy.act( p );
    }

    public String getCardText() {
        return cardText;
    }
}
