package com.twoFMonopoly.models.Card;

import com.twoFMonopoly.Managers.PlayerManager;
import com.twoFMonopoly.models.Player;

public class PayForEveryBuilding implements PayStrategy {
    // Attributes
    private final int amountForHouses;
    private final int amountForHotels;

    // Methods
    public PayForEveryBuilding( int amountForHouses, int amountForHotels ) {
        this.amountForHouses = amountForHouses;
        this.amountForHotels = amountForHotels;
    }

    @Override
    public void act(Player player, PlayerManager playerManager) {
        int totalAmount = player.getNoOfHotels() * amountForHotels + player.getNoOfHouses() * amountForHouses;
        playerManager.payForcedMoney( player, totalAmount );
    }

    @Override
    public String toString() {
        return "Pay $" + amountForHouses + " per house and $" +  amountForHotels + " per hotel you own";
    }
}
