/**
 * This contains the state for the GreatDalmuti game. The state consist of simply
 * the value of the counter.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 18 2024
 *
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;
import edu.up.cs301.GameFramework.infoMessage.GameState;

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

	GDState(int playNum){

	}
	
	/**
	 * copy constructor; makes a copy of the original object
	 * 
	 * @param orig
	 * 		the object from which the copy should be made
	 */
	public GDState(edu.up.cs301.GreatDalmuti.GDState orig) {
		//TODO figure out if we have to do anything with the serial number in here

		// makes a deep copy of all variables so far
		this.exchangingTaxes = orig.exchangingTaxes;
		this.revolution = orig.revolution;
		this.playCard = orig.playCard;
		this.pass = orig.pass;
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

	@Override
	public String toString() {
		System.out.println("Taxes have been exchanged - " + this.exchangingTaxes);
		System.out.println("Revolution is visible - " + this.revolution);
		System.out.println("Card is played - " + this.playCard);
		return null;
	}
}
