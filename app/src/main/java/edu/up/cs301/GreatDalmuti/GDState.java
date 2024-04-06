/**
 * This contains the state for the GreatDalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 4 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;
import java.util.Random;

import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;


public class GDState extends GameState {
	// INSTANCE VARIABLES **************************************************************************
	// to satisfy Serializable interface
	private static final long serialVersionUID = 7737393762469851826L;

	// instances of specific actions taken in the game
	private ArrayList<Integer> deck; //this is literally the entire deck of cards
	private ArrayList<Integer> p1Hand;
	private ArrayList<Integer> p2Hand;
	private ArrayList<Integer> p3Hand;
	private ArrayList<Integer> p4Hand;
	private boolean handIsVisible; //if a players hand is visible for a specific device
	private boolean revolutionIsVisible; //is the revolution button visible
	private boolean exchangingTaxes; //are we currently exchanging taxes
	private int numInPile; // number of the current rank of cards in the middle
	private int rankInPile; // the number of the rank in the pile
	private boolean hasLowestInRound; // who is in line to get the lead next
	private int hasLead; // who currently has the lead
	private int turn; // who's turn is it

	/** ALL OF THE F0LLOWING INSTANCE VARIABLES ARE FROM THE ACTION CLASSES */
	public int[] taxCardIndexes;
	public int indexHand;

	// CONSTRUCTORS ********************************************************************************
	/**
	 * constructor
	 * @param playNum
	 */
	 public GDState(int playNum){
		 //intentionally left blank
	 }

	/**
	 * constructor
	 * no parameters
	 */
	 public GDState(){
		 // makes a deep copy of all variables so far
		 this.exchangingTaxes = true;
		 this.deck = new ArrayList<Integer>();
		 this.p1Hand = new ArrayList<Integer>();
		 this.p2Hand = new ArrayList<Integer>();
		 this.p3Hand = new ArrayList<Integer>();
		 this.p4Hand = new ArrayList<Integer>();
		 this.handIsVisible = false;
		 this.numInPile = 0;
		 this.rankInPile = 0;
		 this.hasLowestInRound = false;
		 this.hasLead = 0; //this should assign the lead to default to GDalmuti but also could be 1 instead of 0
		 this.revolutionIsVisible = false;
	 } // GDState
	
	/**
	 * copy constructor; makes a copy of the original object
	 * 
	 * @param orig
	 * 		the object from which the copy should be made
	 */
	public GDState(edu.up.cs301.GreatDalmuti.GDState orig, int numPlayer) {
		// makes a deep copy of all variables so far
		this.exchangingTaxes = orig.exchangingTaxes;
		this.deck = orig.deck;
		this.p1Hand = new ArrayList<Integer>();
		this.p2Hand = new ArrayList<Integer>();
		this.p3Hand = new ArrayList<Integer>();
		this.p4Hand = new ArrayList<Integer>();
		this.handIsVisible = orig.handIsVisible;
		this.numInPile = orig.numInPile;
		this.rankInPile = orig.rankInPile;
		this.hasLowestInRound = orig.hasLowestInRound;
		this.hasLead = orig.hasLead;
		this.revolutionIsVisible = orig.revolutionIsVisible;
	} // GDState

	// METHODS *************************************************************************************
	//Getter and setter for turn
	public int getTurn(){return this.turn;}
	public void setTurn(int turn){this.turn = turn;}
	public GDState getState(){return this;}

	public void setExchangingTaxes(boolean update){
		exchangingTaxes = update;
	}
	public ArrayList<Integer> getDeck(){return deck;}
	public ArrayList<Integer> getP1Hand(){return p1Hand;}
	public ArrayList<Integer> getP2Hand(){return p2Hand;}
	public ArrayList<Integer> getP3Hand(){return p3Hand;}
	public ArrayList<Integer> getP4Hand(){return p4Hand;}

	@Override
	public String toString() {
		System.out.println("Taxes have been exchanged - " + this.exchangingTaxes);
		System.out.println("Deck of cards - " + this.deck);
		System.out.println("Hand is variable - " + this.handIsVisible);
		System.out.println("Number of cards last put in pile - " + this.numInPile);
		System.out.println("Rank of cards last put in pile - " + this.rankInPile);
		System.out.println("If player has played the lowest card of the round - " + this.hasLowestInRound);
		System.out.println("Number of player who has the lead - " + this.hasLead);
		System.out.println("Revolution is visible - " + this.revolutionIsVisible);
		return null;
	} // toString

	//SHUFFLES DECK
	public void shuffle(){
		int[] deckArray = new int[80];
		int pos = 0;
		for(int i = 1; i <= 12; i++){
			for(int j = 1; j <= i; j++){
				deckArray[pos] = i;
				pos++;
			}
		}
		deckArray[pos] = 13;
		deckArray[pos + 1] = 13;

		Random rnd = new Random();
		for (int i = deckArray.length - 1; i > 0; i--)
		{
			/**
			 External Citation
			 Date: 6 April 2024
			 Problem: Was struggling to make a shuffle method for 2d arraylist
			 Resource: https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
			 Solution: Switched to array and used some of the code from above
			 */
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = deckArray[index];
			deckArray[index] = deckArray[i];
			deckArray[i] = a;
		}

		for(int i = 0; i < 80; i++){
			if(i < 20){
				p1Hand.add(deckArray[i]);
			}
			else if(i < 40){
				p2Hand.add(deckArray[i]);
			}
			else if(i < 60){
				p3Hand.add(deckArray[i]);
			}
			else if(i < 80){
				p4Hand.add(deckArray[i]);
			}
		}
	}

	// PASS METHOD
	public boolean pass(int turn){
		if(turn == 3 ){
			this.setTurn(0);
		} else {
			this.setTurn(turn + 1);
		}
		return true;
	} // pass


	/** THESE METHODS ARE ALL RELATED TO THE PAYING AND RECEIVING OF TAXES */
	//finds index of players lowest card (best)
	public int findLowest(ArrayList<ArrayList<Integer>> cards, int player) {
		int lowestIndex = 0;
		for (int i = 0; i < cards.get(player).size(); i++) {
			if(cards.get(player).get(i) > 0){
				return i;
			}
		}
		return lowestIndex;
	} // findLowest
	public boolean payTaxes(int playerRank, ArrayList<ArrayList<Integer>> cards){

		//lesser peon gives lesser dalmuti their cards, 3 should be changed to a named variable
		if(playerRank == 2){
			//adds lowest card to greater dalmuti
			int low = findLowest(cards, playerRank);
			cards.get(1).set(low, cards.get(1).get(low) + 1);
			//takes away card from original holder
			cards.get(playerRank).set(low, cards.get(playerRank).get(low) - 1);
		}
		//great peon gives greater dalmuti 2 of their cards, 4 should be changed to a named variable
		else if(playerRank == 3){
			//adds lowest card
			int low = findLowest(cards, playerRank);
			cards.get(0).set(low, cards.get(3).get(low) + 1);
			//takes away card from original holder
			cards.get(playerRank).set(low, cards.get(playerRank).get(low) - 1);
		}
		return true;
	} // payTaxes

	//taxes for the greater dalmuti, ranks should be changed to named variables
	public boolean greatTaxes(int playerRank, ArrayList<ArrayList<Integer>> cards, int indexTax, int indexTax2){
		//adds first taxes
		cards.get(3).set(indexTax, cards.get(3).get(indexTax) + 1);
		cards.get(3).set(indexTax2, cards.get(3).get(indexTax) + 1);
		//takes away cards from original holder
		cards.get(0).set(indexTax, cards.get(0).get(indexTax) - 1);
		cards.get(0).set(indexTax2, cards.get(0).get(indexTax2) - 1);
		return true;
	} // greatTaxes

	//taxes for the lesser dalmuti, ranks should be changed to named variables
	public boolean lesserTaxes(int playerRank, ArrayList<ArrayList<Integer>> cards, int indexTax){
		//adds first taxes
		cards.get(2).set(indexTax, cards.get(2).get(indexTax) + 1);
		//takes away cards from original holder
		cards.get(1).set(indexTax, cards.get(1).get(indexTax) - 1);
		return true;
	} // lesserTaxes

	//this method allows a player to play a card
	public ArrayList<ArrayList<Integer>> play(int player, ArrayList<ArrayList<Integer>> decks, ArrayList<ArrayList<Integer>> selected){
		for(int i = 0; i < decks.get(player).size(); i++){
			if(selected.get(player).get(i) > 0){
				decks.get(player).set(i, decks.get(player).get(i) - selected.get(player).get(i));
			}
		}
		if(this.getTurn() == 3 ){
			this.setTurn(0);
		} else {
			this.setTurn(this.getTurn() + 1);
		}

		return decks;
	} // play

	//given that the player that has the jesters calls the revolution, carries out revolution
	public boolean revolution(int player, ArrayList<Integer> cards){
		if(cards.get(player).get(13) == 2){
			if(player == 2){
				this.setExchangingTaxes(false);
			} else if(player == 3){

				//switches player 1 for 4 & 2 for 3
				ArrayList<ArrayList<Integer>> newCards = null;
				for(int j = 0; j < cards.get(1).size(); j++) {
					newCards.get(3).set(j, cards.get(0).get(j));
					newCards.get(2).set(j, cards.get(1).get(j));
					newCards.get(1).set(j, cards.get(2).get(j));
					newCards.get(0).set(j, cards.get(3).get(j));
				}
			}
		}
		return true;
	} // revolution


	public boolean isLegalMove(){
		return false;
	} // isLegalMove
} // GDState class