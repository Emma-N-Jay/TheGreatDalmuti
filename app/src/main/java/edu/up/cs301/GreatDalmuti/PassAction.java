package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PassAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PassAction(GamePlayer player) {
        super(player);
    }


    public boolean pass(int turn){
     //   if(turn == 4 ){
     //       setTurn(1);
     //   } else {
     //        setTurn(turn + 1);
     //      }
        return true;
    }


}
