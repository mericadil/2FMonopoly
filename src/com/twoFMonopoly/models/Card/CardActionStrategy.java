package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

import java.io.Serializable;

public interface CardActionStrategy extends Serializable {
    void act(Player player, PlayerManager playerManager );
    String toString();
}
