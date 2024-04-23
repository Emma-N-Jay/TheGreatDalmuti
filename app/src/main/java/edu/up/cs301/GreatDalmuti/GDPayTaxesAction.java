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

import java.io.Serializable;

import edu.up.cs301.GameFramework.Game;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class GDPayTaxesAction extends GameAction implements Serializable {

    // INSTANCE VARIABLES **************************************************************************
    private static final long serialVersionUID = 242304102408L;
    int cardOne;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public GDPayTaxesAction(GamePlayer player) {
        super(player);
    }

    public GDPayTaxesAction(GamePlayer player, int cardChoiceOne) {
        super(player);
        this.cardOne = cardChoiceOne;
    }
}
