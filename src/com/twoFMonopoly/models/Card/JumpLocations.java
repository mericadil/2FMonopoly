package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class JumpLocations implements MoveStrategy {

    // Attributes
    private final int noOfJumps;

    // Methods
    public JumpLocations( int noOfJumps ) {
        this.noOfJumps = noOfJumps;
    }

    @Override
    // NoOfJumps eksi olabilir unutmayın. Şimdilik eksi için Go dan geçme ihtimalimiz yok.
    public void act(Player player, PlayerManager playerManager ) {
        int currentLocation = player.getCurrentLocationIndex();
        int boardLocation = currentLocation + noOfJumps;
        if( boardLocation >= Constants.boardsMaxIndex)
            player.setMoneyAmount(player.getMoneyAmount() + Constants.startingPointMoney);
        player.setCurrentLocationIndex(boardLocation % Constants.boardsMaxIndex);
    }

    @Override
    public String toString() {
        return "Go back " + noOfJumps + " spaces.";
    }
}
