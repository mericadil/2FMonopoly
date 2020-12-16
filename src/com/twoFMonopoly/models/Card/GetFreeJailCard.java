package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public class GetFreeJailCard implements MoveStrategy {

    @Override
    public void act(Player player) {
        player.setNoOfFreedomRights(player.getNoOfFreedomRights() + 1);
        // TODO
    }
}
