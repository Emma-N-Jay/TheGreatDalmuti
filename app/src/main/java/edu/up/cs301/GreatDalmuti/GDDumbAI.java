/**
 * This contains the computer player one for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 */

package edu.up.cs301.GreatDalmuti;


import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.utilities.Tickable;

public class GDDumbAI extends GameComputerPlayer implements Tickable {

	// INSTANCE VARIABLES *********************************************************************
	private edu.up.cs301.GreatDalmuti.GDState state;

	/**
	 * TODO: IF THERE IS A PROBLEM WITH THIS CLASS IT IS LIKELY BECAUSE IT IS REFERENCING A
	 * CERTAIN SET OF NUMBERS (GD = 0, LD = 1, LP = 2 GP = 3)
	 */

	// CONSTRUCTORS ***************************************************************************
    /**
     * Constructor for objects of class CounterComputerPlayer1
     * 
     * @param name
     * 		the player's name
     */
    public GDDumbAI(String name) {
        // invoke superclass constructor
        super(name);
        // start the timer, ticking 20 times per second
        getTimer().setInterval(50);
        getTimer().start();
    } // GDComputerPlayer1

	public int numOfRank(int rank, ArrayList<Integer> playerHand){
		int numCards = 0;
		for(int i = 0; i >= playerHand.size(); i++){
			if(playerHand.get(i) == rank){
				numCards++;
			}
		}
		return numCards;
	}

	public int rankOfCard(int index, ArrayList<Integer> playerHand){
		return playerHand.get(index);
	}

	// METHODS *************************************************************************************
    /**
     * callback method--game's state has changed
     * 
     * @param info
     * 		the information (presumably containing the game's state)
	 *GDComputerPlayer1
     */
	@Override
	protected void receiveInfo(GameInfo info) {
		// Do nothing, as we ignore all state in deciding our next move. It
		// depends totally on the timer and random numbers.
		boolean played = false;
		state = new GDState();
		/**
		 * GIVING TAXES
		 */
		//when it is the great dalmuti it will automatically pass its two highest cards
		if(playerNum == 3){
			//I know this looks like a mess BUT its just passing in the two highest cards, thats it
			state.GDPayTaxes(rankOfCard(state.getDeck().get(playerNum).size() - 1,
							state.getDeck().get(playerNum)),
					rankOfCard(state.getDeck().get(playerNum).size() - 2,
							state.getDeck().get(playerNum)));
		}
		//when it is the lesser dalmuti it will automatically pass its highest
		if(playerNum == 2){
			state.LDPayTaxes(rankOfCard(state.getDeck().get(playerNum).size() - 1,
					state.getDeck().get(playerNum)));
		}

		/**
		 * GETTING THE LEAD (should this somehow happen)
		 */
		int tempRank = rankOfCard(state.getDeck().get(playerNum).size() - 1,
				state.getDeck().get(playerNum));

		if(state.getHasLead() == playerNum){
			state.play(playerNum, state.getDeck(), tempRank,
					numOfRank(tempRank,state.getDeck().get(playerNum)), 0);
		}

		/**
		 * PASSING AND PLAYING CARDS WITH THE DUMB AI
		 */
		//will give us a sorted version of this players hand
		state.getDeck().get(playerNum);
		for(int i = state.getDeck().get(playerNum).size() - 1; i >= 0; i--){
			if(i < state.getRankInPile()){
				if(numOfRank(state.getRankInPile(), state.getDeck().get(playerNum)) >= state.getNumInPile()){
					state.play(playerNum, state.getDeck(), i, state.getNumInPile(), 0);
					played = true;
				}
			}
		}
		if(played == false){
			state.pass(state.getTurn());
		}
	} // receiveInfo
	
	/**
	 * callback method: the timer ticked
	 */
	protected void timerTicked() {
		// 5% of the time, increment or decrement the counter
		if (Math.random() >= 0.05) return; // do nothing 95% of the time

		// "flip a coin" to determine whether to increment or decrement
		boolean move = Math.random() >= 0.5;
		
		// send the move-action to the game
		//game.sendAction(new edu.up.cs301.GreatDalmuti.GDMoveAction(this, move));
	} // timerTicked

} // GDComputerPlayer1 class