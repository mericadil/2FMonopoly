package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.models.Player;

public interface CardActionStrategy {
    void act( Player p );
}
