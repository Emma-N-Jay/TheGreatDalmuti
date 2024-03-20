/**
 * This contains the state for the GreatDalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;
import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class GDState extends GameState {
	// INSTANCE VARIABLES **************************************************************************
	// to satisfy Serializable interface
	private static final long serialVersionUID = 7737393762469851826L;

	// instances of specific actions taken in the game
	private RevolutionAction revolution;
	private PlayCardAction playCard;
	private PassAction pass;

	private ArrayList<ArrayList<Integer>> deck; //this is literally the entire deck of cards
	private boolean handIsVisible; //if a players hand is visible for a specific device
	private boolean revolutionIsVisible; //is the revolution button visible
	private boolean exchangingTaxes; //are we currently exchanging taxes
	private int numInPile; // number of the current rank of cards in the middle
	private int rankInPile; // the number of the rank in the pile
	private boolean hasLowestInRound; // who is in line to get the lead next
	private int hasLead; // who currently has the lead
	private int turn; // who's turn is it

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
		 this.deck = new ArrayList<ArrayList<Integer>>();
		 this.handIsVisible = false;
		 this.numInPile = 0;
		 this.rankInPile = 0;
		 this.hasLowestInRound = false;
		 this.hasLead = 0;
		 this.revolutionIsVisible = false;
	 }
	
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
		this.handIsVisible = orig.handIsVisible;
		this.numInPile = orig.numInPile;
		this.rankInPile = orig.rankInPile;
		this.hasLowestInRound = orig.hasLowestInRound;
		this.hasLead = orig.hasLead;
		this.revolutionIsVisible = orig.revolutionIsVisible;
	}

	// METHODS *************************************************************************************
	//Getter and setter for turn
	public int getTurn(){return this.turn;}
	public void setTurn(int turn){this.turn = turn;}
	public GDState getState(){return this;}

	public void setExchangingTaxes(boolean update){
		exchangingTaxes = update;
	}

	@Override
	public String toString() {
		System.out.println("Revolution is visible - " + this.revolution);
		System.out.println("Card is played - " + this.playCard);
		System.out.println("Pass action - " + this.pass);

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

}
