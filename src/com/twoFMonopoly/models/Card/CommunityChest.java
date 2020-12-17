package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Locations.Location;

import java.util.ArrayList;
import java.util.Collections;

public class CommunityChest implements Location, CardDeck {

    // Attributes
    private ArrayList<CommunityChestCard> cards;

    // Methods
    public CommunityChest( ArrayList<CommunityChestCard> cards ) {
        this.cards = cards;
    }

    public CommunityChest() {
    }

    public void shuffleCard( ) {
        Collections.shuffle( cards );
    }

    public CommunityChestCard drawCard() {
        CommunityChestCard topCard = cards.remove( 0 );
        cards.add( topCard );
        return topCard;
    }

    @Override
    public String getLocationText() {
        return null;
    }

    @Override
    public int getLocationIndex() {
        return 0;
    }
}
