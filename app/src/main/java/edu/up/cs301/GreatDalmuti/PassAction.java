/**
 * This contains the pass action for the GreatDalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PassAction extends GameAction {

    // INSTANCE VARIABLES **************************************************************************
    public GDState game;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     *
     */
    public PassAction(GamePlayer player) {
        super(player);
    }

    // METHODS *************************************************************************************
    public void receiveInfo(GameInfo info) {
        game = (GDState) info;
    }

    public boolean pass(int turn){
        if(turn == 4 ){
            game.setTurn(1);
        } else {
             game.setTurn(turn + 1);
           }
        return true;
    }

}
