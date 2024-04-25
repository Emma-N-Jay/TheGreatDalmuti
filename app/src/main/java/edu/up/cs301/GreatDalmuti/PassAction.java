/**
 * This contains the pass action
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.io.Serializable;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PassAction extends GameAction implements Serializable {

    // INSTANCE VARIABLES **************************************************************************
    private static final long serialVersionUID = 242304102205L;
    int playerId;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     *
     * who pays, who to, and what they are paying
     */
    public PassAction (GamePlayer player) {
        super(player);
        this.playerId = player.getPlayerNum();
    }
}
