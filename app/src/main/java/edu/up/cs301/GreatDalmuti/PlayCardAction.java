///**
// * This contains the play card action for the Great Dalmuti game.
// *
// * @author Tramanh Best
// * @author Emma Jeppesen
// * @author Alex Burns
// * @author Theresa Wunderlich
// * @version March 19 2024
// */
//
//package edu.up.cs301.GreatDalmuti;
//
//import java.util.ArrayList;
//
//import edu.up.cs301.GameFramework.actionMessage.GameAction;
//import edu.up.cs301.GameFramework.infoMessage.GameInfo;
//import edu.up.cs301.GameFramework.players.GamePlayer;
//
//public class PlayCardAction extends GameAction {
//
//    // INSTANCE VARIABLES **************************************************************************
//    public int indexHand;
//    public GDState game;
//
//    // CONSTRUCTORS ********************************************************************************
//    /**
//     * constructor for GameAction
//     *
//     * @param player the player who created the action
//     */
//    public PlayCardAction(GamePlayer player) {
//        super(player);
//        game.getTurn();
//    } // PlayCardAction
//
//    // METHODS *************************************************************************************
//    public void receiveInfo(GameInfo info) {
//        game = (GDState) info;
//    }
//
//    public ArrayList<ArrayList<Integer>> play(int player, ArrayList<ArrayList<Integer>> decks, ArrayList<ArrayList<Integer>> selected){
//        for(int i = 0; i < decks.get(player).size(); i++){
//            if(selected.get(player).get(i) > 0){
//                decks.get(player).set(i, decks.get(player).get(i) - selected.get(player).get(i));
//            }
//        }
//        if(game.getTurn() == 4 ){
//            game.setTurn(1);
//        } else {
//            game.setTurn(game.getTurn() + 1);
//        }
//
//        return decks;
//    } // play
//
//} // PlayCardAction class
