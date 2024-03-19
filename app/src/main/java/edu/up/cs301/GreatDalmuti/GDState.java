/**
 * This contains the state for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 *
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;
import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class GDState extends GameState {


	// INSTANCE VARIABLES **************************************************************************
	private boolean exchangingTaxes;
	private RevolutionAction revolution;
	private PlayCardAction playCard;
	private PassAction pass;

	// to satisfy Serializable interface
	private static final long serialVersionUID = 7737393762469851826L;


	//this is literally the entire deck of cards
	private ArrayList<ArrayList<Integer>> deck;
	private boolean handIsVisible;
	private boolean revolutionIsVisible;
	private int numInPile;
	private int rankInPile;
	private boolean hasLowestInRound;
	private int hasLead;
	private int turn;
	private GDState game;

	/**
	 * constructor, initializing from the parameter
	 *
	 * @param playNum
	 * 		the value to be initialized
	 */
	 public GDState(int playNum){
		 //intentionally left blank
	 }
	
	/**
	 * copy constructor; makes a copy of the original object
	 * 
	 * @param orig
	 * 		the object from which the copy should be made
	 */
	public GDState(edu.up.cs301.GreatDalmuti.GDState orig, int playNum) {
		// makes a deep copy of all variables so far
		this.revolution = new RevolutionAction(this.revolution.getPlayer());
		this.playCard = new PlayCardAction(this.playCard.getPlayer());
		this.pass = new PassAction(this.pass.getPlayer());


		this.exchangingTaxes = orig.exchangingTaxes;
		this.deck = orig.deck;
		this.handIsVisible = orig.handIsVisible;
		this.numInPile = orig.numInPile;
		this.rankInPile = orig.rankInPile;
		this.hasLowestInRound = orig.hasLowestInRound;
		this.hasLead = orig.hasLead;
		this.revolutionIsVisible = orig.revolutionIsVisible;
	}


	//Getter and setter for turn
	public int getTurn(){return this.turn;}
	public void setTurn(int turn){this.turn = turn;}
	public GDState getState(){
		return this;
	}
	public void setExchangingTaxes(boolean update){
		exchangingTaxes = update;
	}


	@Override
	public String toString() {
		System.out.println("Revolution action - " + this.revolution);
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
	}
}
