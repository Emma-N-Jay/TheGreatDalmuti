/**
 * This contains the state for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import edu.up.cs301.GameFramework.infoMessage.GameState;

public class GDState extends GameState implements Serializable {
	// INSTANCE VARIABLES ************************************************************************
	// to satisfy Serializable interface
	private static final long serialVersionUID = 7737393762469851826L;

	// entire deck of cards, sorted by person then hand
	private ArrayList<ArrayList<Integer>> deck;

	//if a players hand is visible for a specific device
	private boolean handIsVisible;

	//true if the revolution button visible
	private boolean revolutionIsVisible;

	// true if we are currently exchanging taxes
	private boolean exchangingTaxes;

	// is all true when everyone payed their taxes
	private boolean[] taxesPayed = {false, false, false, false};

	//keeps track of the number of cards the great dalmuti has payed in taxes
	private int dalmutiTaxes;

	// number of the cards in the pile (played)
	private int numInPile;

	// the number of the rank in the pile (played)
	private int rankInPile;

	// who is in line to get the lead next
	private int hasLowestInRound;

	// who currently has the lead
	private int hasLead;

	// who's turn is it
	private int turn;

	// number of concurrent passes
	private int numPass;

	// CONSTRUCTORS ********************************************************************************

	/**
	 * constructor
	 * no parameters
	 */
	 public GDState(){
		 this.deck = new ArrayList<ArrayList<Integer>>();
		 this.exchangingTaxes = true;
		 this.handIsVisible = false;
		 this.numInPile = 0;
		 this.rankInPile = 0;
		 this.hasLowestInRound = 0;
		 this.hasLead = 0;
		 this.revolutionIsVisible = false;
		 this.turn = 0;
		 shuffle();
	 } // GDState
	
	/**
	 * copy constructor; makes a copy of the original object
	 * 
	 * @param orig
	 * 		the object from which the copy should be made
	 */
	public GDState(GDState orig) {
		// when we run this again and it crashes this will be the reason
		for(int i = 0; i < orig.deck.size(); i++){
			for(int j = 0; j < orig.deck.get(i).size(); j++){
				assert this.deck != null;
				this.deck.get(i).add(j, orig.deck.get(i).get(j));
			}
		}
		this.exchangingTaxes = orig.exchangingTaxes;
		this.handIsVisible = orig.handIsVisible;
		this.numInPile = orig.numInPile;
		this.rankInPile = orig.rankInPile;
		this.hasLowestInRound = orig.hasLowestInRound;
		this.hasLead = orig.hasLead;
		this.revolutionIsVisible = orig.revolutionIsVisible;
		this.turn = orig.turn;
		this.taxesPayed = orig.taxesPayed;
		this.dalmutiTaxes = orig.dalmutiTaxes;
		this.numPass = orig.numPass;
	} // GDState

	// HELPER METHODS ******************************************************************************

	public int getTurn(){return this.turn;}
	public void setTurn(int turn){this.turn = turn;}
	public GDState getState(){return this;}
	public boolean getExchangingTaxes(){return this.exchangingTaxes;}
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

	public int totalP1Hand(){
		int total = 0;
		for(int i = 1; i < getP1Hand().size(); i++) {
			total += getP1Hand().get(i);
		}
		return total;
	} // totalP1Hand

	public int totalP2Hand(){
		int total = 0;
		for(int i = 1; i < getP2Hand().size(); i++) {
			total += getP2Hand().get(i);
		}
		return total;
	} // totalP2Hand

	public int totalP3Hand(){
		int total = 0;
		for(int i = 1; i < getP3Hand().size(); i++) {
			total += getP3Hand().get(i);
		}
		return total;
	} // totalP3Hand

	public int totalP4Hand(){
		int total = 0;
		for(int i = 1; i < getP4Hand().size(); i++) {
			total += getP4Hand().get(i);
		}
		return total;
	} // totalP4Hand

	// TODO: ASK NUX IF THIS CAN BE REMOVED
//	@Override
//	public String toString() {
//		System.out.println("Taxes have been exchanged - " + this.exchangingTaxes);
//		System.out.println("Deck of cards - " + this.deck);
//		System.out.println("Hand is variable - " + this.handIsVisible);
//		System.out.println("Number of cards last put in pile - " + this.numInPile);
//		System.out.println("Rank of cards last put in pile - " + this.rankInPile);
//		System.out.println("If player has played the lowest card of the round - " + this.hasLowestInRound);
//		System.out.println("Number of player who has the lead - " + this.hasLead);
//		System.out.println("Revolution is visible - " + this.revolutionIsVisible);
//		return null;
//	} // toString

	// TODO: CHECK TO MAKE SURE THIS DOESN'T CAUSE IT TO CRASH
//	/**
//	 * copy deck method for the copy constructor
//	 * @param oldDeck
//	 * @return
//	 */
//	public ArrayList<ArrayList<Integer>> copyDeck(ArrayList<ArrayList<Integer>> oldDeck){
//		ArrayList<ArrayList<Integer>> newDeck = new ArrayList<ArrayList<Integer>>();
//		newDeck.add(new ArrayList<Integer>());
//		newDeck.add(new ArrayList<Integer>());
//		newDeck.add(new ArrayList<Integer>());
//		newDeck.add(new ArrayList<Integer>());
//
//		for(int i = 0; i < oldDeck.size(); i++){
//			for(int j = 0; j < oldDeck.get(i).size(); j++){
//				newDeck.get(i).add(j, oldDeck.get(i).get(j));
//			}
//		}
//		return newDeck;
//	} // copyDeck

	/**
	 * helper method for the shuffle method
	 * @param foo
	 * @param num
	 * @return total number
	 */
	public static int getNumOf(ArrayList<Integer> foo, int num){
		int total = 0;
		for(int i = 0; i < foo.size(); i++){
			if(foo.get(i) == num){
				total++;
			}
		}
		return total;
	} // getNumOf

	/**
	 * checks if everyone finished paying their taxes
	 * changes exchanging taxes boolean accordingly
	 */
	public void checkTaxes(){
		boolean temp = true;

		if(dalmutiTaxes == 2){
			taxesPayed[0] = true;
			if(turn != 3) {
				turn++;
			} else{
				turn = 0;
			}
		}

		for(int i = 0; i < 4; i++){
			if (!taxesPayed[i]) {
				temp = false;
				break;
			}
		}

		exchangingTaxes = !temp;
		if(!exchangingTaxes) {
			this.numPass = 3;
		}
	} // checkTaxes

	/**
	 * finds lowest rank (best) card player has
	 * @param player - the number of the player in the deck
	 * @return the lowest rank
	 */
	public int findLowest(int player){
		int low = 1;
		for(int i = 1; i < 14; i++){
			if(deck.get(player).get(i) > 0){
				return i;
			}
		}
		return low;
	} // findLowest

	/**
	 * checks the selected cards against the rules of the game to ensure the move is legal
	 * @param player - the number of the player in the deck
	 * @param cardNumSelected - the rank selected
	 * @param numSelected - number of cards selected
	 * @param jestersSelected - number of jesters selected
	 * @return boolean depending on if the move is legal
	 */
	protected boolean isLegalMove(int player, int cardNumSelected,
								  int numSelected, int jestersSelected) {

		if( (cardNumSelected > 0) && (cardNumSelected < 13) ){

			if (jestersSelected == 0) {
				if (player == getTurn()) {

					if ( ( ( (deck.get(player).get(cardNumSelected) ) <= numSelected) )
							&& ( deck.get(player).get(cardNumSelected)) > 0) {

						if( numSelected == getNumInPile() ) {

							return cardNumSelected < getRankInPile();

						}

					}

				}
			}

			else if ( (jestersSelected == 1) || (jestersSelected == 2) ){
				if (player == getTurn()) {

					if ( ( ( (deck.get(player).get(cardNumSelected) ) <= numSelected) )
							&& ( deck.get(player).get(cardNumSelected)) > 0) {

						if( (numSelected  + jestersSelected) == getNumInPile() ) {

							return cardNumSelected < getRankInPile();

						}

					}

				}
			}

		}

		return false;
	} // isLegalMove

	/**
	 * is legal move specifically for when the player has the lead
	 * @param player - the number of the player in the deck
	 * @param rankSelected - the rank selected
	 * @param numSelected - number of cards selected
	 * @param jestersSelected - number of jesters selected
	 * @return boolean depending on if the move is legal
	 */
	protected boolean leadIsLegalMove(int player, int rankSelected,
									  int numSelected, int jestersSelected){
		boolean temp = numSelected + jestersSelected > 0;
		//sets to false if they don't have the cards to play
		if ( deck.get(player).get(rankSelected) < numSelected){
			temp = false;
		}
		if ( deck.get(player).get(13) < jestersSelected){
			temp = false;
		}
		if(!(player == this.getTurn())){
			temp = false;
		}

		return temp;
	} // leadIsLegalMove

	/**
	 * is legal move to check if they have the cards for taxes
	 * @param player - the number of the player in the deck
	 * @param cardRank - the rank selected
	 * @return boolean depending on if the move is legal
	 */
	public boolean dTaxesLegal(int player, int cardRank){
		//temp turns false when move isn't possible
		boolean temp = deck.get(player).get(cardRank) > 0;
		return temp;
	} //dTaxesLegal

// METHODS *****************************************************************************************

	/**
	 * shuffles the deck of cards and deals to players hand
	 * no parameters or return
	 */
	public void shuffle(){
		ArrayList<ArrayList<Integer>> deckCopy = new ArrayList<ArrayList<Integer>>();

		int[] deckArray = new int[80];
		int pos = 0;
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= i; j++) {
				deckArray[pos] = i;
				pos++;
			}
		}

		deckArray[pos] = 13;
		deckArray[pos + 1] = 13;

		Random rnd = new Random();
		for (int i = deckArray.length - 1; i > 0; i--) {
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

		deckCopy.add(new ArrayList<Integer>());
		deckCopy.add(new ArrayList<Integer>());
		deckCopy.add(new ArrayList<Integer>());
		deckCopy.add(new ArrayList<Integer>());

		for (int i = 0; i < 80; i++) {
			if (i < 20) {
				deckCopy.get(0).add(deckArray[i]);
			} else if (i < 40) {
				deckCopy.get(1).add(deckArray[i]);
			} else if (i < 60) {
				deckCopy.get(2).add(deckArray[i]);
			} else {
				deckCopy.get(3).add(deckArray[i]);
			}
		}
		deck.get(0).add(0);
		deck.get(1).add(1);
		deck.get(2).add(2);
		deck.get(3).add(3);

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				deck.get(i).add(getNumOf(deckCopy.get(i), j));
			}
		}
	} // shuffle

	/**
	 * pass method that takes an action from the PassAction class
	 * @param action
	 * @return if pass was completed
	 */
	public boolean pass(PassAction action){
		if(this.getTurn() == action.playerId) {
			if (action.playerId == 3) {
				this.setTurn(0);
			} else {
				this.setTurn(action.playerId + 1);
			}
			numPass++;
			if ( ( (numPass - 1) == 3) && (getHasLead() == action.playerId)){
				hasLead = action.playerId;
			}
			return true;
		} else
			return false;
	} // pass

	/**
	 * Lesser Peon pay taxes method
	 * automatically chooses card for the player
	 * @param action - action sent from the LPPayTaxesAction by the player
	 */
	public void LPPayTaxes (LPPayTaxesAction action) {
		if(!(taxesPayed[2]) && exchangingTaxes){
			//lesser peon gives lesser dalmuti their cards
			int low = findLowest(2);
			deck.get(1).set(low, deck.get(1).get(low) + 1);
			deck.get(2).set(low, deck.get(2).get(low) - 1);

			taxesPayed[2] = true;
			checkTaxes();
		}
	} //LPPayTaxes

	/**
	 * Lesser Dalmuti taxes method
	 * pays tax from card selected
	 * @param action - action sent from the LDPayTaxesAction by the player
	 */
	public void LDPayTaxes (LDPayTaxesAction action) {
		if(!(taxesPayed[1]) && (exchangingTaxes) && (dTaxesLegal(1, action.cardChoice))) {
			//lesser dalmuti gives lesser peon their cards
			int high = action.cardChoice;
			deck.get(2).set(high, deck.get(2).get(high) + 1);
			//takes away card from original holder
			deck.get(1).set(high, deck.get(1).get(high) - 1);

			taxesPayed[1] = true;
			checkTaxes();
		}
	} //LDPayTaxes

	/**
	 * Greater Peon taxes method
	 * automatically chooses card for the player
	 * @param action - action sent from the GPPayTaxesAction by the player
	 */
	public void GPPayTaxes (GPPayTaxesAction action) {
		if((!taxesPayed[3]) && exchangingTaxes) {
			//great peon gives greater dalmuti 2 of their cards
			int low = findLowest(3);
			deck.get(0).set(low, deck.get(0).get(low) + 1);
			deck.get(3).set(low, deck.get(3).get(low) - 1);
			low = findLowest(3);
			deck.get(0).set(low, deck.get(0).get(low) + 1);
			deck.get(3).set(low, deck.get(3).get(low) - 1);

			taxesPayed[3] = true;
			checkTaxes();
		}
	} //GPPayTaxes

	/**
	 * Greater Dalmuti taxes method
	 * pays tax from card selected
	 * @param action - action sent from the GDPayTaxesAction by the player
	 */
	public void GDPayTaxes(GDPayTaxesAction action){
		if(!(taxesPayed[0]) && (exchangingTaxes) && (dTaxesLegal(0, action.cardOne))) {
			//great dalmuti gives greater peon their cards
			int high = action.cardOne;
			deck.get(3).set(high, deck.get(3).get(high) + 1);
			deck.get(0).set(high, deck.get(0).get(high) - 1);

			dalmutiTaxes++;
			checkTaxes();
		}
	} // GDPayTaxes

	/**
	 * play method that takes an action from the PlayAction class
	 * @param action
	 * @return new deck with changes
	 */
	public ArrayList<ArrayList<Integer>> play(PlayAction action){
		//is true when the play was legal and actually happened
		boolean temp = false;

		//for when a new round starts for the player who has the lead
		if( (numPass >= 3) && (action.playerId == hasLead) && (action.numSelected > 0) &&
				(leadIsLegalMove(action.playerId, action.rankSelected,
						action.numSelected, action.jesterSelected) ) ){

			this.rankInPile = action.rankSelected;
			this.numInPile = action.numSelected + action.jesterSelected;
			deck.get(action.playerId).set(action.rankSelected,
					deck.get(action.playerId).get(action.rankSelected) - (action.numSelected) );

			deck.get(action.playerId).set(13,
					deck.get(action.playerId).get(13) - (action.jesterSelected) );
			temp = true;
		}
		else if (isLegalMove(action.playerId, action.rankSelected, action.numSelected,
				action.jesterSelected)) {

				deck.get(action.playerId).set(action.rankSelected,
						deck.get(action.playerId).get(action.rankSelected) - (action.numSelected) );

				deck.get(action.playerId).set(13,
						deck.get(action.playerId).get(13) - (action.jesterSelected) );

				this.rankInPile = action.rankSelected;
				temp = true;
		}

		// changes the turn
		if(temp) {
			if (this.getTurn() == 3) {
				this.setTurn(0);
			} else {
				this.setTurn(this.getTurn() + 1);
			}
			this.hasLead = action.playerId;
			this.numPass = 0;
		}

		return deck;
	} // play

	/**
	 * revolution method that takes an action from the RevolutionAction class
	 * given that the player that has the jesters calls the revolution,
	 * carries out revolution
	 * @param action
	 * @return if revolution was completed
	 */
	public boolean revolution (RevolutionAction action) {
		if(deck.get(action.playerID).get(13) == 2){
			if(action.playerID == 2) {
				this.setExchangingTaxes(false);
				this.numPass = 3;
			}
		}
		return true;
	} // revolution

} // GDState class