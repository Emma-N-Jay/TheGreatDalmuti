/**
 * This contains the human player for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 26 2024
 */

package edu.up.cs301.GreatDalmuti;

import edu.up.cs301.GameFramework.players.GameHumanPlayer;
import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class GDHumanPlayer extends GameHumanPlayer implements OnClickListener {
	//TODO: make shuffle method for deck

	// INSTANCE VARIABLES **************************************************************************
	
	// The TextView the displays the current counter value
	private TextView testResultsTextView;
	
	// the most recent game state, as given to us by the CounterLocalGame
	private edu.up.cs301.GreatDalmuti.GDState state;
	//private GDState state;
	
	// the android activity that we are running
	private GameMainActivity myActivity;

	//An array of the players hand
	private Card[] hand;

	//pass and hold buttons
	private Button passButton = null;
	private Button playButton = null;

	//for image button
	private ImageButton  revolutionButton = null;


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

		if(button.getId() == R.id.editTextTextMultiLine){
			//tbd
		}


		//what happens when player hits buttons
		if(button == playButton){
			//currently no way of selecting cards
			//	state.play(this.playerNum, state.getDeck(), SELECTED CARDS)

		}

		else if(button == passButton){
		state.pass(state.getTurn());
		}
		else if(button == revolutionButton){
		state.revolution(this.playerNum, state.getDeck());
		}


		// I cannot overstate how long I took me to figure out this needed to be called on
		// myActivity and not that for some reason nothing works for no reason
		EditText textBox = myActivity.findViewById(R.id.editTextTextMultiLine);
		textBox.setText("");

		GDState firstInstance = new GDState();
		GDState firstCopy = new GDState(firstInstance, 4);

		GDHumanPlayer[] gamePlayers = new GDHumanPlayer[4]; //array of all players in game
		gamePlayers[0] = new GDHumanPlayer("Great Dalmuti");
		gamePlayers[1] = new GDHumanPlayer("Lesser Dalmuti");
		gamePlayers[2] = new GDHumanPlayer("Lesser Peon");
		gamePlayers[3] = new GDHumanPlayer("Greater Peon");

		//greater peon declares revolution
		state.revolution(firstCopy.getTurn(), firstCopy.getP4Hand()); //swaps positions
		textBox.setText(textBox.getText() + "The Lesser Dalmuti has declared a revolution!\n");

		//greater dalmuti and peon exchange taxes
		int[] taxCards = {1, 2}; //cards that will be exchanged during taxes
		state.greatTaxes(3, firstCopy.getP1Hand(), 1, 2);
		state.payTaxes(firstCopy.getTurn(), firstCopy.getP3Hand());
		textBox.setText(textBox.getText() + "Taxes have been exchanged!\n");

		//great dalmuti plays
		ArrayList<ArrayList<Integer>> playingCards = new ArrayList<>();
		ArrayList<Integer> foo = new ArrayList<>();
		playingCards.add(foo);
		foo.add(1);
		foo.add(2);
		state.play(firstCopy.getTurn(), firstCopy.getDeck(), playingCards);
		textBox.setText(textBox.getText() + "The Great Dalmuti has played!\n");

		//lesser dalmuti passes
		state.pass(firstCopy.getTurn());
		textBox.setText(textBox.getText() + "Lesser Dalmuti has passed\n");

		//lesser peon passes
		state.pass(firstCopy.getTurn());
		textBox.setText(textBox.getText() + "Lesser Dalmuti has passed\n");

		//greater peon passes
		state.pass(firstCopy.getTurn());
		textBox.setText(textBox.getText() + "Lesser Dalmuti has passed\n");

		//great dalmuti plays again
		ArrayList<ArrayList<Integer>> playingCards2 = new ArrayList<>();
		ArrayList<Integer> foo2 = new ArrayList<>();
		playingCards2.add(foo2);
		foo.add(1);
		foo.add(2);
		state.play(firstCopy.getTurn(), firstCopy.getDeck(), playingCards);
		textBox.setText(textBox.getText() + "The Great Dalmuti has played the rest of their hand" +
				" and gone out!\n");
		textBox.setText(textBox.getText() + "Great Dalmuti has won!!!!!\n");


		// secondInstance
		GDState secondInstance = new GDState();
		// deep copy of secondInstance assigned to secondCopy
		GDState secondCopy = new GDState(secondInstance, 4);

		// call to toString() on firstCopy and secondCopy
		firstCopy.toString();
		secondCopy.toString();

		// prints strings to the multi-line EditText for visual inspection
		textBox.setText(textBox.getText() + "" + firstInstance.toString());
		textBox.setText(textBox.getText() + "" + secondInstance.toString());
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


		GDState postType = (GDState) info;

		// image of revolution image button set if possible

		if(postType.getDeck().get(this.playerNum).get(13) == 2){
				revolutionButton.setImageResource(R.drawable.revolutionbutton);

		} else {
			revolutionButton.setImageResource(R.drawable.blankspace);

		}



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


		//image button
		this.revolutionButton = (ImageButton)activity.findViewById(R.id.revolutionButton);

		//player action buttons
		this.passButton = (Button) activity.findViewById(R.id.passButton);
		this.playButton = (Button) activity.findViewById(R.id.playButton);

		//listens for button presses
		passButton.setOnClickListener(this);
		playButton.setOnClickListener(this);

		//sets image button listener
		revolutionButton.setOnClickListener(this);


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

