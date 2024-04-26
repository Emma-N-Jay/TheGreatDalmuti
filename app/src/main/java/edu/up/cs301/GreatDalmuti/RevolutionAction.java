/**
 * This contains the revolution action
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

public class RevolutionAction extends GameAction implements Serializable {

    // INSTANCE VARIABLES **************************************************************************

    private static final long serialVersionUID = 242304102407L;
    public int playerID;

    // CONSTRUCTORS ********************************************************************************

    /**
     * constructor for GameAction
     * @param player the player who created the action
     * @param id the id of the play who created the action
     */
    public RevolutionAction (GamePlayer player, int id) {
        super(player);
        this.playerID = id;
    } // RevolutionAction
} // RevolutionAction
