/**
 * This contains the local game for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 2024
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

	// INSTANCE VARIABLES **************************************************************************
	public static final int TARGET_MAGNITUDE = 10;

	// the game's state
	private GDState gameState;

	// CONSTRUCTORS ********************************************************************************
	/**
	 * This constructor should be called when a new Dalmuti game is started
	 */
	public GDLocalGame(GameState state) {
		// initialize the game state, with the counter value starting at 0
		if (! (state instanceof GDState)) {
			state = new GDState();
		}
		this.gameState = (GDState)state;
		super.state = state;
	} //GDLocalGame

//	public void start(GamePlayer[] players){
//		super.start(players);
//		super.state = new GDState(players.length);
//		state = (GDState)super.state;
//	}

	// METHODS *************************************************************************************
	/**
	 * can this player move
	 */
	@Override
	protected boolean canMove(int playerIdx) {
		if (playerIdx == gameState.getTurn()) {
			return true;
		}
		return false;
	} // canMove

	/**
	 * The only type of GameAction that should be sent is CounterMoveAction
	 */
	@Override
	protected boolean makeMove(GameAction action) {
		Log.i("action", action.getClass().toString());

		if (action instanceof GDPayTaxesAction) {
			GDPayTaxesAction gdPayTaxesAction = (GDPayTaxesAction) action;
			//we will want to synchronize taxes probably
			synchronized(gdPayTaxesAction) {
				gameState.GDPayTaxes(gdPayTaxesAction);
			}
			return true;
		}
		else if (action instanceof GPPayTaxesAction) {
			GPPayTaxesAction gpPayTaxesAction = (GPPayTaxesAction) action;
			gameState.GPPayTaxes(gpPayTaxesAction);
			return true;
		}
		else if (action instanceof LDPayTaxesAction) {
			LDPayTaxesAction ldPayTaxesAction = (LDPayTaxesAction) action;
			gameState.LDPayTaxes(ldPayTaxesAction);
			return true;
		}
		else if (action instanceof LPPayTaxesAction) {
			LPPayTaxesAction lpPayTaxesAction = (LPPayTaxesAction) action;
			gameState.LPPayTaxes(lpPayTaxesAction);
			return true;
		}
		else if (action instanceof PassAction) {
			PassAction passAction = (PassAction) action;
			gameState.pass(passAction);
			return true;
		}
		else if (action instanceof PlayAction) {
			PlayAction playAction = (PlayAction) action;
			gameState.play(playAction);
			return true;
		}
		else if (action instanceof RevolutionAction) {
			RevolutionAction revolutionAction = (RevolutionAction) action;
			gameState.revolution(revolutionAction);
			return true;
		}
		else {
			// denote that this was an illegal move
			return false;
		}
	} // makeMove
	
	/**
	 * send the updated state to a given player
	 */
	@Override
	protected void sendUpdatedStateTo(GamePlayer p) {
		// this is a perfect-information game, so we'll make a
		// complete copy of the state to send to the player
		GDState gdState = new GDState(this.gameState);
		p.sendInfo(gdState);
	} // sendUpdatedSate
	
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
		int playerOne = 0;
		int playerTwo = 0;
		int playerThree = 0;
		int playerFour = 0;

		for (int i = 1; i < gameState.getP1Hand().size(); i++) {
			if (gameState.getP1Hand().get(i) != 0) {
				playerOne++;
			}
			if (gameState.getP2Hand().get(i) != 0) {
				playerTwo++;
			}
			if (gameState.getP3Hand().get(i) != 0) {
				playerThree++;
			}
			if (gameState.getP4Hand().get(i) != 0) {
				playerFour++;
			}
		}

		if (playerOne == 0) {
			return "The Greater Dalmuti has won!";
		}
		else if (playerTwo == 0) {
			return "The Lesser Dalmuti has won!";
		}
		else if (playerThree == 0) {
			return "The Greater Peon has won!";
		}
		else if (playerFour == 0) {
			return "The Lesser Peon has won!";
		}
		else {
			return null;
		}
	} // checkIfGameOver

} // GDLocalGame class
