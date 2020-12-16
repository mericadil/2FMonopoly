package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Location;

import java.util.ArrayList;
import java.util.Collections;

public class CommunityChest extends Location implements CardDeck {

    // Attributes
    private ArrayList<CommunityChestCard> cards;

    // Methods
    public CommunityChest( ArrayList<CommunityChestCard> cards ) {
        this.cards = cards;
    }

    public void shuffleCard( ) {
        Collections.shuffle( cards );
    }

    public CommunityChestCard drawCard() {
        CommunityChestCard topCard = cards.remove( 0 );
        cards.add( topCard );
        return topCard;
    }
}
