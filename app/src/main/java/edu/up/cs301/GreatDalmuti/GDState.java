package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.infoMessage.GameState;


/**
 * This contains the state for the GreatDalmuti game. The state consist of simply
 * the value of the counter.
 * 
 * @author Steven R. Vegdahl
 * @version July 2013
 *
 *
 *  Your game’s game state class used to be named CounterGameState. Edit this
class. Remove the instance variable, methods and comments. Then add new instance
variables that encompass all the information you will need about the current state of the
game in order to display it properly for a human user or allow a computer player to make
decisions. Things to consider:
◦ Information about the resources each player has (e.g., cards, pawns, money)
◦ Information about the state of any resources (e.g., card is visible, pawn is yellow)
◦ Whose turn is it?
◦ Detailed information about shared resources (e.g., the game board, contents of a draw
pile, number of coins in the bank)
◦ The visibility of certain information from the perspective of each player
◦ Current score of each player
◦ Current state of a timer
◦ Current state of the dice
◦ What stage of the game you are at (e.g., setup phase, placement phase, buy phase,
main play stage, etc.).
◦ You may need to create additional classes to describe specific elements of the game
state (e.g., a playing card, a pawn, a tile, etc.)
◦ See the Important Note below
• [5%] Get your new GameState compiling with the rest of the project.
◦ Comment out any calls to the getCounter() and setCounter() methods which no
longer exist.
◦ Implement a constructor for your class that initializes all the variables to reflect the
start of the game before any actions have been taken. Modify the local game class
(formerly named CounterLocalGame) and main activity class (formerly named
CounterMainActivity) to use this constructor in the places where they used to use
CounterGameState’s constructor.
 *
 */
public class GDState extends GameState {
	
	// to satisfy Serializable interface
	private static final long serialVersionUID = 7737393762469851826L;
	
	// the value of the counter
	private int counter;
	
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
		// set the counter to that of the original
		this.counter = orig.counter;
	}

	/**
	 * getter method for the counter
	 * 
	 * @return
	 * 		the value of the counter
	 */
	public int getCounter() {
		return counter;
	}
	
	/**
	 * setter method for the counter
	 * 
	 * @param counter
	 * 		the value to which the counter should be set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
}
