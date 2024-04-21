/**
 * This contains the Greater Dalmuti taxes action
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 2024
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.Game;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class GDPayTaxesAction extends GameAction {

    // INSTANCE VARIABLES **************************************************************************
    int cardOne;
    int cardTwo;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public GDPayTaxesAction(GamePlayer player) {
        super(player);
    }

    public GDPayTaxesAction(GamePlayer player, int cardChoiceOne, int cardChoiceTwo) {
        super(player);
        this.cardOne = cardChoiceOne;
        this.cardTwo = cardChoiceTwo;
    }
}
