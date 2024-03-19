package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PlayCardAction extends GameAction {

    public int indexHand;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PlayCardAction(GamePlayer player) {
        super(player);
    }
}
