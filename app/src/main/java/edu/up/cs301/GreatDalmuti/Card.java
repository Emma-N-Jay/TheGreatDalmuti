/**
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 18 2024
 */

package edu.up.cs301.GreatDalmuti;

public class Card {
     private String cardName;
    private int cardValue;

    /**
     * 80 Cards Total:
     * twelve 12s, eleven 11s, ten 10s, nine 9s, eight 8s, seven 7s, six 6s,
     * five 5s, four 4s, three 3s, two 2s, one 1, and two Jesters.
     */

    public Card(int cardValue) {
        this.cardValue = cardValue;
        this.cardName = DalmutiVals.CARD_NAMES[cardValue-1];
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardValue() {
        return cardValue;
    }

}
