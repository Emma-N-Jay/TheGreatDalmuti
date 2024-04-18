package edu.up.cs301.GreatDalmuti;

import android.app.Notification;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class RevolutionAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public RevolutionAction(GamePlayer player) {
        super(player);
    }

//    public boolean revolution(int player, ArrayList<ArrayList<Integer>> cards){
//        if(cards.get(player).get(13) == 2){
//            if(player == 2){
//                this.setExchangingTaxes(false);
//            } else if(player == 3){
//                //switches player 1 for 4 & 2 for 3
//                ArrayList<ArrayList<Integer>> newCards = null;
//                for(int j = 0; j < cards.get(1).size(); j++) {
//                    newCards.get(3).set(j, cards.get(0).get(j));
//                    newCards.get(2).set(j, cards.get(1).get(j));
//                    newCards.get(1).set(j, cards.get(2).get(j));
//                    newCards.get(0).set(j, cards.get(3).get(j));
//                }
//            }
//        }
//        return true;
//    } // revolution

}
