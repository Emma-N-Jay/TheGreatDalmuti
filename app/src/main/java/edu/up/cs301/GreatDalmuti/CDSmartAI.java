/**
 * This contains the computer player two for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.GameFramework.utilities.Tickable;

public class CDSmartAI extends GameComputerPlayer implements Tickable {

	// INSTANCE VARIABLES **************************************************************************

	// CONSTRUCTORS ********************************************************************************

	/**
     * Constructor for objects of class CounterComputerPlayer1
     *
     * @param name
     * 		the player's name
     */
    public CDSmartAI(String name) {
		super(name);
		boolean played = false;
		// start the timer, ticking 20 times per second
		getTimer().setInterval(50);
		getTimer().start();
	} // CDSmartAI

	// HELPER METHODS ******************************************************************************

	/**
	 * number of cards of a certain rank in the players hand
	 * @param rank
	 * @param playerHand
	 * @return
	 */
	public int numOfRank(int rank, ArrayList<Integer> playerHand){
		int numCards = 0;
		for(int i = 0; i == playerHand.size(); i++){
			if(playerHand.get(i) == rank){
				numCards++;
			}
		}
		return numCards;
	} // numOfRank

	/**
	 * locates highest single card
	 * @param playerHand
	 * @return
	 */
	public int highSingle(ArrayList<Integer> playerHand){
		int num = 1; //given the first num in the arrayList is the players rank default highest is lowest card
		for(int i = 0; i < playerHand.size(); i++){
			if(numOfRank(i,playerHand) == 1){
				return i;
			}
		}
		return num;
	} // highSingle

	/**
	 *
	 * @param playerHand
	 * @param number
	 * @return
	 */
	public int highOfNum(ArrayList<Integer> playerHand, int number){
		int num = 1; //given the first num in the arrayList is the players rank default highest is lowest card
		for(int i = 0; i < playerHand.size(); i++){
			if(numOfRank(i,playerHand) == number){
				return i;
			}
		}
		return num;
	} // highOfNum

	//this method finds the index of the highest card
	public int highestCard(ArrayList<Integer> playerHand){
		int highCard = 1;
		//this loop purposefully skips the jester
		for(int i = playerHand.size() - 2; i >= 1; i--){
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


		/**
		 * GREAT DALMUI SENDING TAXES
		 */

	if (state.getExchangingTaxes() && state.getDeck() != null) {
		if (playerNum == 3 && state.getTurn() == 3) {
			int timesPayedTaxes = 0;
			// passes the highest single card if they have a single card that is a 6 or above (and isnt the jester)
			if (highSingle(state.getDeck().get(playerNum)) >= 6 && highSingle(state.getDeck().get(playerNum)) != 13) {
				game.sendAction(new GDPayTaxesAction(this, highSingle(state.getDeck().get(playerNum))));
				timesPayedTaxes++;
			}

			// passes a second high single if it has one
			if (highSingle(state.getDeck().get(playerNum)) >= 6 && highSingle(state.getDeck().get(playerNum)) != 13) {
				game.sendAction(new GDPayTaxesAction(this, highSingle(state.getDeck().get(playerNum))));
				timesPayedTaxes++;
			}

			// if this has no high single cards
			if (timesPayedTaxes == 0) {
				boolean hasPayedTaxes = false;

			}

			if (timesPayedTaxes == 1) {
				boolean hasPayedTaxes = false;
				// if it has no single card it passes the highest card it has 3 of
				if (!hasPayedTaxes) {
					game.sendAction(new LDPayTaxesAction(this, highOfNum(state.getDeck().get(playerNum), 3)));
					hasPayedTaxes = true;
				}

				//if it doesnt have 3 of any cards it passes one of its highest cards
				if (!hasPayedTaxes) {
					game.sendAction(new LDPayTaxesAction(this, highestCard(state.getDeck().get(playerNum))));
				}
			}

		}

		/**
		 * LESSER DALMUTI SENDING TAXES
		 */
		//when it is the lesser dalmuti it will automatically pass its highest single card
		if (playerNum == 2 && state.getTurn() == 2) {
			boolean hasPayedTaxes = false;
			// passes the highest single card if they have a single card that is a 6 or above (and isnt the jester)
			if (highSingle(state.getDeck().get(playerNum)) >= 6 && highSingle(state.getDeck().get(playerNum)) != 13) {
				game.sendAction(new LDPayTaxesAction(this, highSingle(state.getDeck().get(playerNum))));
				hasPayedTaxes = true;
			}
			// if it has no single card it passes the highest card it has 3 of
			if (!hasPayedTaxes) {
				game.sendAction(new LDPayTaxesAction(this, highOfNum(state.getDeck().get(playerNum), 3)));
				hasPayedTaxes = true;
			}

			//if it doesnt have 3 of any cards it passes a 12
			if (!hasPayedTaxes) {
				game.sendAction(new LDPayTaxesAction(this, highestCard(state.getDeck().get(playerNum))));
			}

		}

		/**
		 * PEON'S SENDING TAXES (isLegal does this automatically)
		 */
		//paytaxes for lesser peon
		if (playerNum == 1 && state.getTurn() == 1) {
			game.sendAction(new LPPayTaxesAction(this));
		}

		//paytaxes for greater peon
		if (playerNum == 0 && state.getTurn() == 0) {
			game.sendAction(new LPPayTaxesAction(this));
		}
	}
		/**
		 * GETTING THE LEAD
		 */
		//this is the index of the current highest card
		int tempRank = highestCard(state.getDeck().get(playerNum));

		//this has the player play their highest set of cards (with jesters if it has any)
		if(state.getHasLead() == playerNum){
			int numJesters = 0;

			// if the player has jesters it will add the jesters to its play
			if(state.getDeck().get(playerNum).get(13) != 0){
				numJesters = state.getDeck().get(playerNum).get(13);
			}

			// will play highest cards (with or without jesters)
			game.sendAction(new PlayAction(this, playerNum, tempRank,
					state.getDeck().get(playerNum).get(tempRank), numJesters));
		}

		/**
		 * PASSING AND PLAYING CARDS WITH THE SMART AI
		 */
		for(int i = state.getDeck().get(playerNum).size() - 1; i >= 1; i--){
			//checks for highest rank below the current rank in the pile
			if(i < state.getRankInPile()){
				//checks to make sure the smart ai has the same amount of that card
				if(state.getDeck().get(playerNum).get(i) == state.getNumInPile()){
					game.sendAction(new PlayAction(this, playerNum, i, state.getNumInPile(), 0));
					played = true;
				}
			}
		}
		if(!played){
			game.sendAction(new PassAction(this));
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
	} // timerTicked

} // CDSmartAI