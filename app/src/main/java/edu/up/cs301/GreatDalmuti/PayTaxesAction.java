/**
 * This contains the pay taxes action for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class PayTaxesAction extends GameAction {

    // INSTANCE VARIABLES **************************************************************************
    public int[] taxCardIndexes;

    // CONSTRUCTORS ********************************************************************************
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PayTaxesAction(GamePlayer player, int[] initIndexes) {
        super(player);
        this.taxCardIndexes = initIndexes;
    }

    // METHODS *************************************************************************************
    //finds index of players lowest card (best)
    public int findLowest(ArrayList<ArrayList<Integer>> cards, int player) {
        int lowestIndex = 0;
        for (int i = 0; i < cards.get(player).size(); i++) {
            if(cards.get(player).get(i) > 0){
                return i;
            }
        }
        return lowestIndex;
    }

    //taxes for the peons
    public boolean payTaxes(int playerRank, ArrayList<ArrayList<Integer>> cards){

        //lesser peon gives lesser dalmuti their cards, 3 should be changed to a named variable
        if(playerRank == 3){
            //adds lowest card to greater dalmuti
            int low = findLowest(cards, playerRank);
            cards.get(2).set(low, cards.get(2).get(low) + 1);
            //takes away card from original holder
            cards.get(playerRank).set(low, cards.get(playerRank).get(low) - 1);
        }
        //great peon gives greater dalmuti 2 of their cards, 4 should be changed to a named variable
        else if(playerRank == 4){
            //adds lowest card
            int low = findLowest(cards, playerRank);
            cards.get(1).set(low, cards.get(4).get(low) + 1);
            //takes away card from original holder
            cards.get(playerRank).set(low, cards.get(playerRank).get(low) - 1);
        }
        return true;
    }

    //taxes for the greater dalmuti, ranks should be changed to named variables
    public boolean greatTaxes(int playerRank, ArrayList<ArrayList<Integer>> cards, int indexTax, int indexTax2){
        //adds first taxes
        cards.get(4).set(indexTax, cards.get(4).get(indexTax) + 1);
        cards.get(4).set(indexTax2, cards.get(4).get(indexTax) + 1);
        //takes away cards from original holder
        cards.get(1).set(indexTax, cards.get(1).get(indexTax) - 1);
        cards.get(1).set(indexTax2, cards.get(1).get(indexTax2) - 1);
        return true;
    }

    //taxes for the lesser dalmuti, ranks should be changed to named variables
    public boolean lesserTaxes(int playerRank, ArrayList<ArrayList<Integer>> cards, int indexTax){
        //adds first taxes
        cards.get(3).set(indexTax, cards.get(3).get(indexTax) + 1);
        //takes away cards from original holder
        cards.get(2).set(indexTax, cards.get(2).get(indexTax) - 1);
        return true;
    }

}
