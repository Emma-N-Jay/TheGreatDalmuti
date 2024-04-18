package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PassAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     *
     * who pays, who to, and what they are paying
     */
    public PassAction(GamePlayer player) {
        super(player);
    }
    // PASS METHOD
//	public boolean pass(int turn){
//		if(turn == 3 ){
//			this.setTurn(0);
//		} else {
//			this.setTurn(turn + 1);
//		}
//		numPass++;
//
//		return true;
//	} // pass
}
