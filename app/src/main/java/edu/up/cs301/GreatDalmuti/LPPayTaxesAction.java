package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class LPPayTaxesAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public LPPayTaxesAction(GamePlayer player) {
        super(player);
    }

//    public void LDPayTaxes (int LDTaxCard) {
//        //lesser peon gives lesser dalmuti their cards
//        //adds highest card to lesser dalmuti
//        int high = LDTaxCard;
//        deck.get(1).set(high, deck.get(1).get(high) + 1);
//        //takes away card from original holder
//        deck.get(2).set(high, deck.get(2).get(high) - 1);
//    } //LDPayTaxes
//
//    public void GPPayTaxes () {
//        //great peon gives greater dalmuti 2 of their cards
//        int low = findLowest(3);
//        //adds lowest card
//        deck.get(0).set(low, deck.get(0).get(low) + 1);
//        //takes away card from original holder
//        deck.get(3).set(low, deck.get(3).get(low) - 1);
//        low = findLowest(3);
//        deck.get(0).set(low, deck.get(0).get(low) + 1);
//        //takes away card from original holder
//        deck.get(3).set(low, deck.get(3).get(low) - 1);
//    } //GPPayTaxes
//
//    public boolean GDPayTaxes(int GDTaxCard1, int GDTaxCard2){
//        //great dalmuti gives greater peon 2 of their cards
//        //adds lowest card
//        int high = GDTaxCard1;
//        deck.get(3).set(high, deck.get(3).get(high) + 1);
//        //takes away card from original holder
//        deck.get(0).set(high, deck.get(0).get(high) - 1);
//        high = GDTaxCard2;
//        deck.get(3).set(high, deck.get(3).get(high) + 1);
//        //takes away card from original holder
//        deck.get(0).set(high, deck.get(0).get(high) - 1);
//
//        return true;
//    } // GDPayTaxes

}
