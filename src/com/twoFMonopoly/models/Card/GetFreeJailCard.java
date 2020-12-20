package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class GetFreeJailCard implements MoveStrategy {

    @Override
    public void act(Player player, PlayerManager playerManager) {
        player.setNoOfFreedomRights(player.getNoOfFreedomRights() + 1);
    }

    @Override
    public String toString() {
        return "Get Out of Jail Free";
    }
}
