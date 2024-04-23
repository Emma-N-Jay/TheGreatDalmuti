/**
 * This contains the Greater Peon taxes action
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

public class GPPayTaxesAction extends GameAction implements Serializable {

    //instance variables
    private static final long serialVersionUID = 242304101902L;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public GPPayTaxesAction(GamePlayer player) {
        super(player);
    }
}
