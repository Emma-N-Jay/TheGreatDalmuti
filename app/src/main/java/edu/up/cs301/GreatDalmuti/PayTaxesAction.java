package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PayTaxesAction extends GameAction {

    public int[] taxCardIndexes;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PayTaxesAction(GamePlayer player, int[] initIndexes) {
        super(player);
        this.taxCardIndexes = initIndexes;
    }
}
