/**
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 18 2024
 *
 * A class that represents the state of a game. In The Great Dalmuti, we need to know the cards,
 * players hands, rank, revolution status, taxes, player turn, and who is in the lead.
 * 2d arraylist of cards(represents players hand, group cards by like numbers)
 * isVisibleCard:boolean
 * For deciding turn reuse getPlayerTurn from pig lab
 * handIsVisible
 * revolutionIsVisible
 * playerScores:int[]
 * timerCurrent:int
 * numInPile:int
 * rankInPile:char
 * exchangingTaxes:boolean //if we are in the taxing stage still
 * hasLowest:boolean//currently has the lowest play
 * hasLead:boolean//is allowed to start new round
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;
import edu.up.cs301.GameFramework.LocalGame;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import android.util.Log;

import java.util.ArrayList;

public class GDLocalGame extends LocalGame {

	//TODO Change this comment to pertain to Dalmuti
	// When a counter game is played, any number of players. The first player
	// is trying to get the counter value to TARGET_MAGNITUDE; the second player,
	// if present, is trying to get the counter to -TARGET_MAGNITUDE. The
	// remaining players are neither winners nor losers, but can interfere by
	// modifying the counter.
	public static final int TARGET_MAGNITUDE = 10;

	// the game's state
	private edu.up.cs301.GreatDalmuti.GDState gameState;
	
	/**
	 * can this player move
	 *TODO Change this to if they can play cards. Maybe make another class called isLegalPlay
	 */
	@Override
	protected boolean canMove(int playerIdx) {
		return true;
	}

	/**
	 * This ctor should be called when a new Dalmuti game is started
	 */
	public GDLocalGame(GameState state) {
		// initialize the game state, with the counter value starting at 0
		if (! (state instanceof edu.up.cs301.GreatDalmuti.GDState)) {
			state = new edu.up.cs301.GreatDalmuti.GDState(0);
		}
		this.gameState = (edu.up.cs301.GreatDalmuti.GDState)state;
		super.state = state;
	}

	/**
	 * The only type of GameAction that should be sent is CounterMoveAction
	 */
	@Override
	protected boolean makeMove(GameAction action) {
		Log.i("action", action.getClass().toString());
		
		if (action instanceof edu.up.cs301.GreatDalmuti.GDMoveAction) {
		
			// cast so that we Java knows it's a CounterMoveAction
			edu.up.cs301.GreatDalmuti.GDMoveAction cma = (edu.up.cs301.GreatDalmuti.GDMoveAction)action;

			//TODO Change this as needed
			// Update the counter values based upon the action
			//int result = gameState.getCounter() + (cma.isPlus() ? 1 : -1);
			//gameState.setCounter(result);
			
			// denote that this was a legal/successful move
			return true;
		}
		else {
			// denote that this was an illegal move
			return false;
		}
	}//makeMove
	
	/**
	 * send the updated state to a given player
	 */
	@Override
	protected void sendUpdatedStateTo(GamePlayer p) {
		// this is a perfect-information game, so we'll make a
		// complete copy of the state to send to the player
		p.sendInfo(new edu.up.cs301.GreatDalmuti.GDState(this.gameState, this.getPlayerIdx(p)));
		
	}//sendUpdatedSate
	
	/**
	 * Check if the game is over. It is over, return a string that tells
	 * who the winner(s), if any, are. If the game is not over, return null;
	 * 
	 * @return
	 * 		a message that tells who has won the game, or null if the
	 * 		game is not over
	 *
	 */
	@Override
	protected String checkIfGameOver() {

		//TODO change as needed or delete
		// get the value of the counter
//		int counterVal = this.gameState.getCounter();
//
//		if (counterVal >= TARGET_MAGNITUDE) {
//			// counter has reached target magnitude, so return message that
//			// player 0 has won.
//			return playerNames[0]+" has won.";
//		}
//		else if (counterVal <= -TARGET_MAGNITUDE) {
//			// counter has reached negative of target magnitude; if there
//			// is a second player, return message that this player has won,
//			// otherwise that the first player has lost
//			if (playerNames.length >= 2) {
//				return playerNames[1]+" has won.";
//			}
//			else {
//				return playerNames[0]+" has lost.";
//			}
//		}else {
//			// game is still between the two limit: return null, as the game
//			// is not yet over
//			return null;
//		}
		return null;
	}

}// class CounterLocalGame
