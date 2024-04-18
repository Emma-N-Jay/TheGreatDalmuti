package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PlayAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PlayAction(GamePlayer player) {
        super(player);
    }

//    public ArrayList<ArrayList<Integer>> play(int player, ArrayList<ArrayList<Integer>> decks, int rankSelected,
//                                              int numSelected, int jestersSelected){
//        GDLocalGame local = new GDLocalGame(this);
//
//        boolean temp = false; //is true when the play was legal and actually happened
//
//        //for when a new round starts for the player who has the lead
//        if( (numPass >= 3) && (player == hasLead) && (numSelected > 0) &&
//                (local.leadIsLegalMove(player, decks, rankSelected, numSelected, jestersSelected) ) ){
//            this.rankInPile = rankSelected;
//            this.numInPile = numSelected + jestersSelected;
//            decks.get(player).set(rankSelected, decks.get(player).get(rankSelected) - (numSelected) );
//            decks.get(player).set(13, decks.get(player).get(13) - (jestersSelected) );
//            temp = true;
//        }
//
////		if( (numSelected > 0) && (local.isLegalMove(player, decks, rankSelected, numSelected, jestersSelected)) ){
////				decks.get(player).set(rankSelected, decks.get(player).get(rankSelected) - numSelected);
////				decks.get(player).set(13, decks.get(player).get(13) - (jestersSelected) );
////				temp = true;
////		}
//
//        if(temp == true) {
//            if (this.getTurn() == 3) {
//                this.setTurn(0);
//            } else {
//                this.setTurn(this.getTurn() + 1);
//            }
//            this.hasLead = player;
//            this.numPass = 0;
//        }
//
//        return decks;
//    } // play


}
