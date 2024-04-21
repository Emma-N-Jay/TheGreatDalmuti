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

import android.app.Notification;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class RevolutionAction extends GameAction {

    // INSTANCE VARIABLES **************************************************************************
    public int playerID;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public RevolutionAction(GamePlayer player) {
        super(player);
    }

    public RevolutionAction (GamePlayer player, int id) {
        super(player);
        this.playerID = id;
    }
}
