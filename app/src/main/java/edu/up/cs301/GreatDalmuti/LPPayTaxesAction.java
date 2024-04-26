/**
 * This contains the Lesser Peon taxes action
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

public class LPPayTaxesAction extends GameAction implements Serializable {

    // INSTANCE VARIABLES **************************************************************************

    private static final long serialVersionUID = 240423102104L;

    // CONSTRUCTORS ********************************************************************************

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public LPPayTaxesAction(GamePlayer player) {
        super(player);
    } // LPPayTaxesAction
} // LPPayTaxesAction
