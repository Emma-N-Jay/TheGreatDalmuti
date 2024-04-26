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

import java.io.Serializable;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PlayAction extends GameAction implements Serializable {

    // INSTANCE VARIABLES **************************************************************************

    private static final long serialVersionUID = 242304102306L;
    int playerId;
    int rankSelected;
    int numSelected;
    int jesterSelected;

    // CONSTRUCTORS ********************************************************************************

    /**
     * constructor
     * @param player - the game player sent
     * @param playerId - the id of the player
     * @param rankSelected - the rank of card selected
     * @param numSelected - the number of cards selected
     * @param jesterSelected - the number of jesters selected
     */
    public PlayAction (GamePlayer player, int playerId, int rankSelected, int numSelected,
                       int jesterSelected) {
        super(player);
        this.playerId = playerId;
        this.rankSelected = rankSelected;
        this.numSelected = numSelected;
        this.jesterSelected = jesterSelected;
    } // PlayAction
} // PlayAction
