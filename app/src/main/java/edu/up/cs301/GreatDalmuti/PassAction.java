package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PassAction extends GameAction {

    // INSTANCE VARIABLES **************************************************************************
    int playerId;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     *
     * who pays, who to, and what they are paying
     */
    public PassAction(GamePlayer player) {
        super(player);
    }

    public PassAction (GamePlayer player, int turn) {
        super(player);
        this.playerId = turn;
    }
}
