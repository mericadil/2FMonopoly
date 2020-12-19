package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class AdvanceToCertainLocation implements MoveStrategy{
    // Attributes
    private final int boardPlace;
    private final String locationName;

    // Methods
    public AdvanceToCertainLocation( int boardPlace, String locationName ) {
        this.boardPlace = boardPlace;
        this.locationName = locationName;
    }

    @Override
    public void act(Player player, PlayerManager playerManager) {
        if(player.getCurrentLocationIndex() > boardPlace) {
            playerManager.getMoney( player, Constants.startingPointMoney );
        }
        player.setCurrentLocationIndex(boardPlace);
    }

    @Override
    public String toString() {
        return "Advance to " + locationName;
    }
}
