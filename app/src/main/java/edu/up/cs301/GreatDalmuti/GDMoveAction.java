/**
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 18 2024
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.players.GamePlayer;
import edu.up.cs301.GameFramework.actionMessage.GameAction;

public class GDMoveAction extends GameAction {
	
	// to satisfy the serializable interface
	private static final long serialVersionUID = 28062013L;

	//whether this move is a plus (true) or minus (false)
	private boolean isPlus;
	
	/**
	 * Constructor for the CounterMoveAction class.
	 * 
	 * @param player
	 *            the player making the move
	 * @param isPlus
	 *            value to initialize this.isPlus
	 */
	public GDMoveAction(GamePlayer player, boolean isPlus) {
		super(player);
		this.isPlus = isPlus;
	}
	
	/**
	 * getter method, to tell whether the move is a "plus"
	 * 
	 * @return
	 * 		a boolean that tells whether this move is a "plus"
	 */
	public boolean isPlus() {
		return isPlus;
		
	}
}//class CounterMoveAction
