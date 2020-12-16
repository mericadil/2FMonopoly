package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Location;

import java.util.ArrayList;
import java.util.Collections;

public class Chance implements Location, CardDeck {

    // Attributes
    private ArrayList<ChanceCard> cards;

    // Methods
    public Chance( ArrayList<ChanceCard> cards ) {
        this.cards = cards;
    }

    public void shuffleCard( ) {
        Collections.shuffle( cards );
    }

    public ChanceCard drawCard() {
        ChanceCard topCard = cards.remove( 0 );
        cards.add( topCard );
        return topCard;
    }
}
