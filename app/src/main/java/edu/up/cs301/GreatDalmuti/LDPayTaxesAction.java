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

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class LDPayTaxesAction extends GameAction {

    // INSTANCE VARIABLES **************************************************************************
    int cardChoice;

    // CONSTRUCTORS*********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public LDPayTaxesAction(GamePlayer player) {
        super(player);
    }

    public LDPayTaxesAction (GamePlayer player, int cardChoice) {
        super(player);
        this.cardChoice = cardChoice;
    }
}
