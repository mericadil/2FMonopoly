package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class JumpLocations implements MoveStrategy {

    // Attributes
    private final int noOfJumps;

    // Methods
    public JumpLocations( int noOfJumps ) {
        this.noOfJumps = noOfJumps;
    }

    @Override
    public void act(Player p) {
        // TODO
    }
}
