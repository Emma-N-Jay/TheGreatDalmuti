/**
 * This contains the Lesser Dalmuti taxes action
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

public class LDPayTaxesAction extends GameAction implements Serializable {

    // INSTANCE VARIABLES **************************************************************************
    private static final long serialVersionUID = 240423102003L;
    int cardChoice;

    // CONSTRUCTORS*********************************************************************************

    /**
     * constructor for GameAction
     * @param player the player who created the action
     * @param cardChoice the card selected by the player to be used for taxes
     */
    public LDPayTaxesAction (GamePlayer player, int cardChoice) {
        super(player);
        this.cardChoice = cardChoice;
    } // LDPayTaxesAction
} // LDPayTaxesAction
