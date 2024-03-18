package edu.up.cs301.GreatDalmuti;

public class Card {
     private String cardName;
    private int cardValue;


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
