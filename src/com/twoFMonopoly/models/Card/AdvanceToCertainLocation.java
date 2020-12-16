package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.models.Player;

public class AdvanceToCertainLocation implements MoveStrategy{
    // Attributes
    private final int boardPlace;

    // Methods
    public AdvanceToCertainLocation( int boardPlace ) {
        this.boardPlace = boardPlace;
    }

    @Override
    public void act(Player player) {
        if(player.getCurrentLocationIndex() > boardPlace) {
            player.setMoneyAmount(player.getMoneyAmount() + Constants.startingPointMoney);
        }
        player.setCurrentLocationIndex(boardPlace);
    }
}
