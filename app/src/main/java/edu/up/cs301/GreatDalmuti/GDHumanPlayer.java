/**
 * This contains the human player for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.players.GameHumanPlayer;
import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class GDHumanPlayer extends GameHumanPlayer implements OnClickListener {

	// INSTANCE VARIABLES **************************************************************************
	
	// The TextView the displays the current counter value
	private TextView testResultsTextView;
	
	// the most recent game state, as given to us by the CounterLocalGame
	private edu.up.cs301.GreatDalmuti.GDState state;
	
	// the android activity that we are running
	private GameMainActivity myActivity;

	//An array of the players hand
	private Card[] hand;

	// CONSTRUCTORS ********************************************************************************
	/**
	 * constructor
	 * @param name
	 * 		the player's name
	 */
	public GDHumanPlayer(String name) {
		super(name);
	}

	// METHODS *************************************************************************************
	/**
	 * Returns the GUI's top view object
	 * 
	 * @return
	 * 		the top object in the GUI's view hierarchy
	 */
	//TODO CHECK ID
	public View getTopView() {
		return myActivity.findViewById(R.id.editTextTextMultiLine);
	}
	
	/**
	 * sets the counter value in the text view
	*/
	protected void updateDisplay() {
		// set the text in the appropriate widget
		//testResultsTextView.setText("" + state.getCounter());
	} // updateDisplay

	/**
	 * this method gets called when the user clicks the '+' or '-' button. It
	 * creates a new CounterMoveAction to return to the parent activity.
	 * 
	 * @param button
	 * 		the button that was clicked
	 */
	public void onClick(View button) {
		// if we are not yet connected to a game, ignore
		if (game == null) return;

		if(button.getId() == R.id.run_test){
			//tbd
		}

		GDState firstInstance = new GDState();
		GDState firstCopy = new GDState(firstInstance, 4);

		GDHumanPlayer[] gamePlayers = new GDHumanPlayer[4]; //array of all players in game
		gamePlayers[0] = new GDHumanPlayer("Great Dalmuti");
		gamePlayers[1] = new GDHumanPlayer("Lesser Dalmuti");
		gamePlayers[2] = new GDHumanPlayer("Lesser Peon");
		gamePlayers[3] = new GDHumanPlayer("Greater Peon");

		//greater peon declares revolution
		RevolutionAction declareRev = new RevolutionAction(gamePlayers[3]);
		declareRev.revolution(firstCopy.getTurn(), firstCopy.getP4Hand()); //swaps positions

		//greater dalmuti and peon exchange taxes
		int[] taxCards = {1, 2}; //cards that will be exchanged during taxes
		PayTaxesAction payTax = new PayTaxesAction(gamePlayers[3], taxCards); //great dalmutis cards for taxes
		payTax.greatTaxes(3, firstCopy.getP1Hand(), 1, 2);
		PayTaxesAction payTax2 = new PayTaxesAction(gamePlayers[0], taxCards); //greater peons cards for taxes
		payTax2.payTaxes(firstCopy.getTurn(), firstCopy.getP3Hand());

		//great dalmuti plays
		ArrayList<ArrayList<Integer>> playingCards = new ArrayList<>();
		ArrayList<Integer> foo = new ArrayList<>();
		playingCards.add(foo);
		foo.add(1);
		foo.add(2);
		PlayCardAction playCards = new PlayCardAction(gamePlayers[0]);
		playCards.play(firstCopy.getTurn(), firstCopy.getDeck(), playingCards);

		//lesser dalmuti passes
		PassAction passCards = new PassAction(gamePlayers[1]);
		passCards.pass(firstCopy.getTurn());

	}// onClick
	
	/**
	 * callback method when we get a message (e.g., from the game)
	 * 
	 * @param info
	 * 		the message
	 *
	 */
	@Override
	public void receiveInfo(GameInfo info) {
		// ignore the message if it's not a CounterState message
		if (!(info instanceof edu.up.cs301.GreatDalmuti.GDState)) return;
		
		// update our state; then update the display
		this.state = (edu.up.cs301.GreatDalmuti.GDState)info;
		updateDisplay();
	} // receiveInfo
	
	/**
	 * callback method--our game has been chosen/rechosen to be the GUI,
	 * called from the GUI thread
	 * 
	 * @param activity
	 * 		the activity under which we are running
	 */
	public void setAsGui(GameMainActivity activity) {
		
		// remember the activity
		this.myActivity = activity;
		
	    // Load the layout resource for our GUI
		activity.setContentView(R.layout.run_test_main);

		this.testResultsTextView =
				(TextView) activity.findViewById(R.id.greatDalmutiValueTextView);

		Button runTestButton = activity.findViewById(R.id.run_test);
		runTestButton.setOnClickListener(this);

	} // setAsGui

	//TODO fix this
//	  public ArrayList<Card> getPlayerHand() {
//        return playerHand;
//    }

	public Card[] getHand(){return hand;}
	public void setHand(Card[] playerHand){
		this.hand = playerHand;
	}
//
//    public void setPlayerHand(ArrayList<Card> playerHand) {
//        this.playerHand = playerHand;
//    }
//    private ArrayList<Card> playerHand;

} // GDHumanPlayer class

