package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.models.Player;

public class JumpLocations implements MoveStrategy {

    // Attributes
    private final int noOfJumps;

    // Methods
    public JumpLocations( int noOfJumps ) {
        this.noOfJumps = noOfJumps;
    }

    @Override
    public void act(Player player) {
        int currentLocation = player.getCurrentLocationIndex();
        int boardLocation = currentLocation + noOfJumps;
        if( boardLocation > Constants.boardsMaxIndex)
            player.setMoneyAmount(player.getMoneyAmount() + Constants.startingPointMoney);
        player.setCurrentLocationIndex(boardLocation % Constants.boardsMaxIndex);
        // TODO
    }
}
