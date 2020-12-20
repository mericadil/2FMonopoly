package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Locations.Location;

import java.util.ArrayList;
import java.util.Collections;

public class Chance implements Location, CardDeck {

    // Attributes
    private ArrayList<ChanceCard> cards;

    // Methods
    public Chance( ArrayList<ChanceCard> cards ) {
        this.cards = cards;
        shuffleCard();
    }

    public void shuffleCard( ) {
        Collections.shuffle( cards );
    }

    // Draws the top card, returns it for further usage and puts it at the bottom of card deck.
    public ChanceCard drawCard() {
        ChanceCard topCard = cards.remove( 0 );
        cards.add( topCard );
        return topCard;
    }

    @Override
    public String getLocationText() {
        return "Chance";
    }

    @Override
    public int getLocationIndex() {
        return 0;
    }
}
