/**
 * This contains the play action
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PlayAction extends GameAction {

    // INSTANCE VARIABLES **************************************************************************
    int playerId;
    int rankSelected;
    int numSelected;
    int jesterSelected;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PlayAction(GamePlayer player) {
        super(player);
    }

    public PlayAction (GamePlayer player, int playerId, int rankSelected, int numSelected,
                       int jesterSelected) {
        super(player);
        this.playerId = playerId;
        this.rankSelected = rankSelected;
        this.numSelected = numSelected;
        this.jesterSelected = jesterSelected;
    }
}
