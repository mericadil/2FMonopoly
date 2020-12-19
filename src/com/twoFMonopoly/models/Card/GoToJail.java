package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Constants;
import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class GoToJail implements JailStrategy {
    @Override
    public void act(Player player, PlayerManager playerManager ) {
        player.setJailStatus(1);
        player.setCurrentLocationIndex(Constants.jailLocation);
    }

    @Override
    public String toString() {
        return "Go To Jail";
    }
}
