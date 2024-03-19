/**
 * This contains the state for the GreatDalmuti game. The state consist of simply
 * the value of the counter.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 18 2024
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.infoMessage.GameState;
import java.util.ArrayList;


public class GDState extends GameState {

	//added variables
	private boolean exchangingTaxes;
	private boolean revolution;
	private boolean playCard;
	private boolean pass;

	// to satisfy Serializable interface
	private static final long serialVersionUID = 7737393762469851826L;

	// the value of the counter
	private int counter;

	private ArrayList<ArrayList<Character>> cards;
	private boolean handIsVisible;
	private boolean revolutionIsVisible;
	private  int[] playerScores;
	private int timerCurrent;
	private int numInPile;
	private char rankInPile;
	private boolean exchangeTax;
	private boolean hasLowest;
	private boolean hasLead;

	// METHODS *************************************************************************************

	public void setExchangingTaxes(boolean inExchangingTaxes) {
		this.exchangingTaxes = inExchangingTaxes;
	}

	//added methods for game actions
	public boolean taxes(){
		if(!exchangingTaxes){
			return false;
		}

		//cards selected need to be exchanged

		setExchangingTaxes(false);
		return true;
	}

	public boolean revolution(){
		if(!exchangingTaxes){
			return false;
		}

		//needs to check if 2 jesters are in hand
		//needs to check rank of the owner of jesters

		setExchangingTaxes(false);
		return true;
	}

	//shuffeling but i think thats happening automatically
	//playCards needs to know which player/hand

	public boolean playCards(){
		//needs to check if legal else return false and then get rid of cards
		//needs to change the player who has the lead and whose turn it is

		return true;
	}

	public boolean pass(){
		//needs to check whose turn it is else return false
		//needs to change whose turn it is

		return true;
	}

	
	/**
	 * constructor, initializing the counter value from the parameter
	 * 
	 * @param counterVal
	 * 		the value to which the counter's value should be initialized
	 */
	public GDState(int counterVal) {
		counter = counterVal;
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
		this.counter = orig.counter;
		this.exchangingTaxes = orig.exchangingTaxes;
		this.revolution = orig.revolution;
		this.playCard = orig.playCard;
		this.pass = orig.pass;
		this.cards = orig.cards;
		this.handIsVisible = orig.handIsVisible;
		this.revolutionIsVisible = orig.revolutionIsVisible;
		this.playerScores = orig.playerScores;
		this.timerCurrent = orig.timerCurrent;
		this.numInPile = orig.numInPile;
		this.rankInPile = orig.rankInPile;
		this.exchangingTaxes = orig.exchangingTaxes;
		this.hasLowest = orig.hasLowest;
		this.hasLead = orig.hasLead;
	}

	/**
	 * getter method for the counter
	 * 
	 * @return
	 * 		the value of the counter
	 */
	//TODO MARKED FOR DELETION
	public int getCounter() {
		return counter;
	}
	
	/**
	 * setter method for the counter
	 * 
	 * @param counter
	 * 		the value to which the counter should be set
	 */
	//TODO MARKED FOR DELETION
	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		System.out.println("Taxes have been exchanged - " + this.exchangingTaxes);

		return null;
	}
}
