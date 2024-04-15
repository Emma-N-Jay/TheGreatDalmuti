/**
 * This contains the state for the GreatDalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 12 2024
 */

package edu.up.cs301.GreatDalmuti;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import edu.up.cs301.GameFramework.infoMessage.GameState;
public class GDState extends GameState {
	// INSTANCE VARIABLES **************************************************************************
	// to satisfy Serializable interface
	private static final long serialVersionUID = 7737393762469851826L;
	// instances of specific actions taken in the game

	//TODO: SORTED BY PERSON AND THEN THAT PERSONS HAND (IF YOU DO NOT UNDERSTAND THIS ASK ALEX)
	private ArrayList<ArrayList<Integer>> deck; //this is literally the entire deck of cards
	private boolean handIsVisible; //if a players hand is visible for a specific device
	private boolean revolutionIsVisible; //is the revolution button visible
	private boolean exchangingTaxes; //are we currently exchanging taxes
	private int numInPile; // number of the current rank of cards in the middle
	private int rankInPile; // the number of the rank in the pile
	private int hasLowestInRound; // who is in line to get the lead next
	private int hasLead = 0; // who currently has the lead
	private int turn = 0; // who's turn is it
	private int numPass;

	/** ALL OF THE F0LLOWING INSTANCE VARIABLES ARE FROM THE ACTION CLASSES */
	public int[] taxCardIndexes;
	public int indexHand;

	//rank of each player
	String[] ranks = new String[4];

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
		 this.deck = new ArrayList<ArrayList<Integer>>();
		 //this.shuffle();
		 this.exchangingTaxes = true;
		 this.handIsVisible = false;
		 this.numInPile = 0;
		 this.rankInPile = 0;
		 this.hasLowestInRound = 0;
		 this.hasLead = 0; //this should assign the lead to default to GDalmuti but also could be 1 instead of 0
		 this.revolutionIsVisible = false;
		 setPlayers(ranks);
	 } // GDState
	
	/**
	 * copy constructor; makes a copy of the original object
	 * 
	 * @param orig
	 * 		the object from which the copy should be made
	 */
	public GDState(edu.up.cs301.GreatDalmuti.GDState orig, int numPlayer) {
		// makes a deep copy of all variables so far
		this.deck = orig.deck;
		//this.shuffle();
		this.exchangingTaxes = orig.exchangingTaxes;
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
	public boolean getExhangtingTaxes(){return this.exchangingTaxes;}
	public int getNumPass(){return this.numPass;}
	public void setExchangingTaxes(boolean update){exchangingTaxes = update;}
	public int getNumInPile(){return this.numInPile;}
	public int getRankInPile(){return this.rankInPile;}
	public int getHasLead(){return this.hasLead;}
	public ArrayList<ArrayList<Integer>> getDeck(){return deck;}
	public ArrayList<Integer>getP1Hand(){return deck.get(0);}
	public ArrayList<Integer>getP2Hand(){return deck.get(1);}
	public ArrayList<Integer>getP3Hand(){return deck.get(2);}
	public ArrayList<Integer>getP4Hand(){return deck.get(3);}

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

	private void setPlayers(String [] ranks) {
		int zero = (int) (Math.random() * 4) + 1;

		ranks[zero] ="Great Dalmuti";

		int one = (int) (Math.random() * 4) + 1;
		while (zero == one){
			one = (int) (Math.random() * 4) + 1;
		}
		ranks[one] = "Lesser Dalmuti";

		int two = (int) (Math.random() * 4) + 1;
		while ( (zero == two) || (one == two)){
			two = (int) (Math.random() * 4) + 1;
		}
		ranks[two] = "Greater Peon";

		int three = (int) (Math.random() * 4) + 1;
		while ( (zero == three) || (one == three) || (two == three) ){
			three = (int) (Math.random() * 4) + 1;
		}
		ranks[three] = "Lesser Dalmuti";

	}

	//SHUFFLES DECK
	public void shuffle(){
		ArrayList<Integer> p1Hand = new ArrayList<Integer>();
		ArrayList<Integer> p2Hand = new ArrayList<Integer>();
		ArrayList<Integer> p3Hand = new ArrayList<Integer>();
		ArrayList<Integer> p4Hand = new ArrayList<Integer>();

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
		deck.add(new ArrayList<Integer>());
		deck.add(new ArrayList<Integer>());
		deck.add(new ArrayList<Integer>());
		deck.add(new ArrayList<Integer>());

		for(int i = 0; i < 80; i++){
			if(i < 20){
				p1Hand.add(deckArray[i]);
				Collections.sort(p1Hand);
				deck.get(0).add(deckArray[i]);
			}
			else if(i < 40){
				p2Hand.add(deckArray[i]);
				Collections.sort(p2Hand);
				deck.get(1).add(deckArray[i]);
			}
			else if(i < 60){
				p3Hand.add(deckArray[i]);
				Collections.sort(p3Hand);
				deck.get(2).add(deckArray[i]);
			}
			else if(i < 80){
				p4Hand.add(deckArray[i]);
				Collections.sort(p4Hand);
				deck.get(3).add(deckArray[i]);
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
		numPass++;

		return true;
	} // pass


	/** THESE METHODS ARE ALL RELATED TO THE PAYING AND RECEIVING OF TAXES */
	//finds index of players lowest card (best)
	public int findLowest(int player) {
		int lowestIndex = deck.get(player).get(1);
		for (int i = 0; i < deck.get(player).size(); i++) {
			if( (deck.get(player).get(i) < lowestIndex) && (deck.get(player).get(i) != 0) ){
				lowestIndex = deck.get(player).get(i);
			}
		}
		return lowestIndex;
	} // findLowest

	public void LPPayTaxes () {
		//lesser peon gives lesser dalmuti their cards
		int low = findLowest(2);
		//adds lowest card to lesser dalmuti
		deck.get(1).set(low, deck.get(1).get(low) + 1);
		//takes away card from original holder
		deck.get(2).set(low, deck.get(2).get(low) - 1);
	} //LPPayTaxes

	public void LDPayTaxes (int LDTaxCard) {
		//lesser peon gives lesser dalmuti their cards
		//adds highest card to lesser dalmuti
		int high = LDTaxCard;
		deck.get(1).set(high, deck.get(1).get(high) + 1);
		//takes away card from original holder
		deck.get(2).set(high, deck.get(2).get(high) - 1);
	} //LDPayTaxes

	public void GPPayTaxes () {
		//great peon gives greater dalmuti 2 of their cards
		int low = findLowest(3);
		//adds lowest card
		deck.get(0).set(low, deck.get(0).get(low) + 1);
		//takes away card from original holder
		deck.get(3).set(low, deck.get(3).get(low) - 1);
		low = findLowest(3);
		deck.get(0).set(low, deck.get(0).get(low) + 1);
		//takes away card from original holder
		deck.get(3).set(low, deck.get(3).get(low) - 1);
	} //GPPayTaxes

	public boolean GDPayTaxes(int GDTaxCard1, int GDTaxCard2){
		//great dalmuti gives greater peon 2 of their cards
		//adds lowest card
		int high = GDTaxCard1;
		deck.get(3).set(high, deck.get(3).get(high) + 1);
		//takes away card from original holder
		deck.get(0).set(high, deck.get(0).get(high) - 1);
		high = GDTaxCard2;
		deck.get(3).set(high, deck.get(3).get(high) + 1);
		//takes away card from original holder
		deck.get(0).set(high, deck.get(0).get(high) - 1);

		return true;
	} // GDPayTaxes

	//this method allows a player to play a card
	public ArrayList<ArrayList<Integer>> play(int player, ArrayList<ArrayList<Integer>> decks, int rankSelected,
											  int numSelected, int jestersSelected){
		GDLocalGame local = new GDLocalGame(this);

		boolean temp = false; //is true when the play was legal and actually happened

		//for when a new round starts for the player who has the lead
		if(numPass == 3 && player == hasLead && local.leadIsLegalMove(player, decks, rankSelected, numSelected, jestersSelected)){
			this.rankInPile = rankSelected;
			this.numInPile = numSelected + jestersSelected;
			decks.get(player).set(rankSelected, decks.get(player).get(rankSelected) - (numSelected) );
			decks.get(player).set(13, decks.get(player).get(13) - (jestersSelected) );
			temp = true;
		}

		if( (numSelected > 0) && (local.isLegalMove(player, decks, rankSelected, numSelected, jestersSelected)) ){
				decks.get(player).set(rankSelected, decks.get(player).get(rankSelected) - numSelected);
				decks.get(player).set(13, decks.get(player).get(13) - (jestersSelected) );
				temp = true;
		}


		if(temp == true) {
			if (this.getTurn() == 3) {
				this.setTurn(0);
			} else {
				this.setTurn(this.getTurn() + 1);
			}
			this.hasLead = player;
			this.numPass = 0;
		}

		return decks;
	} // play

	//given that the player that has the jesters calls the revolution, carries out revolution
	public boolean revolution(int player, ArrayList<ArrayList<Integer>> cards){
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
} // GDState class