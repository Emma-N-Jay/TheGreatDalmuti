package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PassAction extends GameAction {

    public GDState game;
    public void receiveInfo(GameInfo info) {
        game = (GDState) info;
    }

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     *
     */
    public PassAction(GamePlayer player) {
        super(player);
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
