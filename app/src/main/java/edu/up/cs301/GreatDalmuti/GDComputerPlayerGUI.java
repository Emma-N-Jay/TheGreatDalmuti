/**
 * This contains the computer player GUI for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class GDComputerPlayerGUI extends edu.up.cs301.GreatDalmuti.GDComputerPlayer1 {
	
	// INSTANCE VARIABLES **************************************************************************
	
	// the most recent game state, as given to us by the CounterLocalGame
	private GDState currentGameState = null;
	
	// If this player is running the GUI, the activity (null if the player is
	// not running a GUI).
	private Activity activityForGui = null;
	
	// If this player is running the GUI, the widget containing the counter's
	// value (otherwise, null);
	private TextView counterValueTextView = null;
	
	// If this player is running the GUI, the handler for the GUI thread (otherwise
	// null)
	private Handler guiHandler = null;

	// CONSTRUCTORS ********************************************************************************

	/**
	 * constructor
	 * 
	 * @param name
	 * 		the player's name
	 */
	public GDComputerPlayerGUI(String name) {
		super(name);
	}

	// METHODS *************************************************************************************

    /**
     * callback method--game's state has changed
     * 
     * @param info
     * 		the information (presumably containing the game's state)
     */
	@Override
	protected void receiveInfo(GameInfo info) {
		// perform superclass behavior
		super.receiveInfo(info);
		
		Log.i("computer player", "receiving");
		
		// if there is no game, ignore
		if (game == null) {
			return;
		}
		else if (info instanceof GDState) {
			// if we indeed have a counter-state, update the GUI
			currentGameState = (GDState)info;
			updateDisplay();
		}
	}
	
	/** 
	 * sets the counter value in the text view
	 *  */
	private void updateDisplay() {
		// if the guiHandler is available, set the new counter value
		// in the counter-display widget, doing it in the Activity's
		// thread.
		if (guiHandler != null) {
			guiHandler.post(
					new Runnable() {
						public void run() {
							if (counterValueTextView != null && currentGameState != null) {

								//TODO Change this to something else if we need to
								//counterValueTextView.setText("" + currentGameState.getCounter());
							}
						}
					});
		}
	}
	
	/**
	 * Tells whether we support a GUI
	 * 
	 * @return
	 * 		true because we support a GUI
	 */
	public boolean supportsGui() {
		return true;
	}
	
	/**
	 * callback method--our player has been chosen/rechosen to be the GUI,
	 * called from the GUI thread.
	 * 
	 * @param a
	 * 		the activity under which we are running
	 */
	@Override
	public void setAsGui(GameMainActivity a) {
		
		// remember who our activity is
		this.activityForGui = a;
		
		// remember the handler for the GUI thread
		this.guiHandler = new Handler();
		
		// Load the layout resource for the our GUI's configuration
		activityForGui.setContentView(R.layout.gd_human_player);

		// remember who our text view is, for updating the counter value
		this.counterValueTextView =
				(TextView) activityForGui.findViewById(R.id.greatDalmutiValueTextView);
		
		// disable the buttons, since they will have no effect anyway
		Button plusButton = (Button)activityForGui.findViewById(R.id.plusButton);
		plusButton.setEnabled(false);
		Button minusButton = (Button)activityForGui.findViewById(R.id.minusButton);
		minusButton.setEnabled(false);
		
		// if the state is non=null, update the display
		if (currentGameState != null) {
			updateDisplay();
		}
	}

}
