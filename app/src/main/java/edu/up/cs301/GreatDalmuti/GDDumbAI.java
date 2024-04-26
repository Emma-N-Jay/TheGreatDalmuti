/**
 * This contains the dumb AI for the Great Dalmuti game.
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
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import edu.up.cs301.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.GameFramework.utilities.Tickable;

public class GDDumbAI extends GameComputerPlayer implements Tickable, Serializable {

	// INSTANCE VARIABLES **************************************************************************

	private static final long serialVersionUID = 242304101501L;

	// CONSTRUCTORS ********************************************************************************

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

	//this method finds the index of the highest card
	public int highestCard(ArrayList<Integer> playerHand){
		int highCard = 1;
		for(int i = playerHand.size() - 1; i > 0; i--){
			if(playerHand.get(i) != 0){
				highCard = i;
			}
		}
		return highCard;
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
		if (!(info instanceof GDState)) return;

		GDState state = (GDState) info;

		boolean played = false;

		if (state.getTurn() != this.playerNum) {
			return;
		}

		//delay
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		/**
		 * GIVING TAXES
		 */

		if (state.getExchangingTaxes() && state.getDeck() != null) {
			//when it is the greater peon it will automatically pass its two highest cards
			if (playerNum == 3 && state.getTurn() == 3) {
				//I know this looks like a mess BUT its just passing in the two highest cards, thats it
				game.sendAction(new GPPayTaxesAction(this));
				return;
			}

			//when it is the lesser peon it will automatically pass its highest
			else if (playerNum == 2 && state.getTurn() == 2) {
				game.sendAction(new LPPayTaxesAction(this));
				return;
			}

			//paytaxes for lesser dalmuti (isLegal makes this move automatically)
			else if (playerNum == 1 && state.getTurn() == 1) {
				game.sendAction(new LDPayTaxesAction(this, highestCard(state.getDeck().get(playerNum))));
				return;
			}

			//paytaxes for greater dalmuti (isLegal makes this move automatically)
			else if (playerNum == 0 && state.getTurn() == 0) {
				game.sendAction(new GDPayTaxesAction(this, highestCard(state.getDeck().get(playerNum))));
				return;
			}
		}

			/**
			 * GETTING THE LEAD (should this somehow happen)
			 */
		if(playerNum == state.getTurn()) {
			//this is the index of the current highest card
			int tempRank = highestCard(state.getDeck().get(playerNum));

			//this has the player play their highest set of cards
			if (state.getHasLead() == playerNum) {
				game.sendAction(new PlayAction(this, playerNum, tempRank,
						state.getDeck().get(playerNum).get(tempRank), 0));
				return;
			}

			/**
			 * PASSING AND PLAYING CARDS WITH THE DUMB AI
			 */
			for (int i = 13; i >= 1; i--) {
				//checks for highest rank below the current rank in the pile
				if (i < state.getRankInPile()) {
					//checks to make sure the dumb ai has enough of that card
					if (state.getDeck().get(playerNum).get(i) >= state.getNumInPile()) {
						game.sendAction(new PlayAction(this, playerNum, i, state.getNumInPile(), 0));
						played = true;
						break;
					}
					if (i == 1) {
						game.sendAction(new PassAction(this));
					}
				}
			}
		}
	} // receiveInfo

		/**
		 * callback method: the timer ticked
		 */
		protected void timerTicked () {
			// 5% of the time, increment or decrement the counter
			if (Math.random() >= 0.05) return; // do nothing 95% of the time

			// "flip a coin" to determine whether to increment or decrement
			boolean move = Math.random() >= 0.5;

			// send the move-action to the game
			//game.sendAction(new edu.up.cs301.GreatDalmuti.GDMoveAction(this, move));
		} // timerTicked

		public String getName(){
			return this.name;
		}

} // GDComputerPlayer1 class