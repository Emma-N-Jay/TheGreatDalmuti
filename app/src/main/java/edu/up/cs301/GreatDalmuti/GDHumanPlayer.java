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

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.players.GameHumanPlayer;

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
	private Button plusB = null;
	private Button minusB = null;

	//for image button
	private ImageButton revolutionButton = null;
	private ImageButton jester = null;
	private ImageButton one = null;
	private ImageButton two = null;
	private ImageButton three = null;
	private ImageButton four = null;
	private ImageButton five = null;
	private ImageButton six = null;
	private ImageButton seven = null;
	private ImageButton eight = null;
	private ImageButton nine = null;
	private ImageButton ten = null;
	private ImageButton eleven = null;
	private ImageButton twelve = null;


	//text for number of cards
	private TextView cardsNum = null;
	private TextView jesterNum = null;
	private TextView oneNum = null;
	private TextView twoNum = null;
	private TextView threeNum = null;
	private TextView fourNum = null;
	private TextView fiveNum = null;
	private TextView sixNum = null;
	private TextView sevenNum = null;
	private TextView eightNum = null;
	private TextView nineNum = null;
	private TextView tenNum = null;
	private TextView elevenNum = null;
	private TextView twelveNum = null;



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
		//current selected card
		int c = 0;

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

		//selected cards/display for selected cards
		else if(button == jester){
			 c = 13;
		} else if(button == one){
			c = 1;
		} else if(button == two){
			c = 2;
		} else if(button == three){
			c = 3;
		} else if(button == four){
			c = 4;
		} else if(button == five){
			c = 5;
		} else if(button == six){
			c = 6;
		} else if(button == seven){
			c = 7;
		} else if(button == eight){
			c = 8;;
		} else if(button == nine){
			c = 9;
		} else if(button == ten){
			c = 10;
		} else if(button == eleven){
			c = 11;
		} else if(button == twelve){
			c = 12;
		}
		cardsNum.setText(state.getP1Hand().get(c));

		//more or less cards
		 if(button == plusB){
			String nString = cardsNum.getText().toString();
			int n = Integer.parseInt(nString);
			cardsNum.setText((n + 1));
		} else if(button == minusB){
			 String nString = cardsNum.getText().toString();
			 int n = Integer.parseInt(nString);
			 cardsNum.setText((n - 1));
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
		ArrayList<Integer> playingCards = new ArrayList<>();
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

		// image of revolution image button set if possible, lots of ifs unfortunately without
		if(this.playerNum == 1) {
			if (postType.getP1Hand().get(13) == 2) {
				revolutionButton.setImageResource(R.drawable.newrevbutton);
			} else {
				revolutionButton.setImageResource(R.drawable.blankspace);
			}
		} else if(this.playerNum == 2) {
			if (postType.getP2Hand().get(13) == 2) {
				revolutionButton.setImageResource(R.drawable.newrevbutton);
			} else {
				revolutionButton.setImageResource(R.drawable.blankspace);
			}
		} else if(this.playerNum == 3) {
			if (postType.getP3Hand().get(13) == 2) {
				revolutionButton.setImageResource(R.drawable.newrevbutton);
			} else {
				revolutionButton.setImageResource(R.drawable.blankspace);
			}
		} else if(this.playerNum == 4) {
			if (postType.getP4Hand().get(13) == 2) {
				revolutionButton.setImageResource(R.drawable.newrevbutton);
			} else {
				revolutionButton.setImageResource(R.drawable.blankspace);
			}
		}

		//displays total cards numbers
		if(playerNum == 1) {
			jesterNum.setText(postType.getP1Hand().get(13));
			oneNum.setText(postType.getP1Hand().get(1));
			twoNum.setText(postType.getP1Hand().get(2));
			threeNum.setText(postType.getP1Hand().get(3));
			fourNum.setText(postType.getP1Hand().get(4));
			fiveNum.setText(postType.getP1Hand().get(5));
			sixNum.setText(postType.getP1Hand().get(6));
			sevenNum.setText(postType.getP1Hand().get(7));
			eightNum.setText(postType.getP1Hand().get(8));
			nineNum.setText(postType.getP1Hand().get(9));
			tenNum.setText(postType.getP1Hand().get(10));
			elevenNum.setText(postType.getP1Hand().get(11));
			twelveNum.setText(postType.getP1Hand().get(12));
		} else if (playerNum == 2) {
			jesterNum.setText(postType.getP2Hand().get(13));
			oneNum.setText(postType.getP2Hand().get(1));
			twoNum.setText(postType.getP2Hand().get(2));
			threeNum.setText(postType.getP2Hand().get(3));
			fourNum.setText(postType.getP2Hand().get(4));
			fiveNum.setText(postType.getP2Hand().get(5));
			sixNum.setText(postType.getP2Hand().get(6));
			sevenNum.setText(postType.getP2Hand().get(7));
			eightNum.setText(postType.getP2Hand().get(8));
			nineNum.setText(postType.getP2Hand().get(9));
			tenNum.setText(postType.getP2Hand().get(10));
			elevenNum.setText(postType.getP2Hand().get(11));
			twelveNum.setText(postType.getP2Hand().get(12));
		} else if (playerNum == 3) {
			jesterNum.setText(postType.getP3Hand().get(13));
			oneNum.setText(postType.getP3Hand().get(1));
			twoNum.setText(postType.getP3Hand().get(2));
			threeNum.setText(postType.getP3Hand().get(3));
			fourNum.setText(postType.getP3Hand().get(4));
			fiveNum.setText(postType.getP3Hand().get(5));
			sixNum.setText(postType.getP3Hand().get(6));
			sevenNum.setText(postType.getP3Hand().get(7));
			eightNum.setText(postType.getP3Hand().get(8));
			nineNum.setText(postType.getP3Hand().get(9));
			tenNum.setText(postType.getP3Hand().get(10));
			elevenNum.setText(postType.getP3Hand().get(11));
			twelveNum.setText(postType.getP3Hand().get(12));
		} else if (playerNum == 4) {
			jesterNum.setText(postType.getP4Hand().get(13));
			oneNum.setText(postType.getP4Hand().get(1));
			twoNum.setText(postType.getP4Hand().get(2));
			threeNum.setText(postType.getP4Hand().get(3));
			fourNum.setText(postType.getP4Hand().get(4));
			fiveNum.setText(postType.getP4Hand().get(5));
			sixNum.setText(postType.getP4Hand().get(6));
			sevenNum.setText(postType.getP4Hand().get(7));
			eightNum.setText(postType.getP4Hand().get(8));
			nineNum.setText(postType.getP4Hand().get(9));
			tenNum.setText(postType.getP4Hand().get(10));
			elevenNum.setText(postType.getP4Hand().get(11));
			twelveNum.setText(postType.getP4Hand().get(12));
		}

		//if number of cards is more than 0
		if(postType.getP1Hand().get(1) >= 1){
			one.setImageResource(R.drawable.great_dalmuti);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(2) >= 1){
			one.setImageResource(R.drawable.arch_bishop);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(3) >= 1){
			one.setImageResource(R.drawable.earl_marshal);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(4) >= 1){
			one.setImageResource(R.drawable.baroness);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(5) >= 1){
			one.setImageResource(R.drawable.abbess);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(6) >= 1){
			one.setImageResource(R.drawable.knight);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(7) >= 1){
			one.setImageResource(R.drawable.seamstress);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(8) >= 1){
			one.setImageResource(R.drawable.mason);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(9) >= 1){
			one.setImageResource(R.drawable.cook);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(10) >= 1){
			one.setImageResource(R.drawable.sheperdess);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(11) >= 1){
			one.setImageResource(R.drawable.stonecutter);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(12) >= 1){
			one.setImageResource(R.drawable.peasant);
		} else {
			//gray
		}
		if(postType.getP1Hand().get(13) >= 1){
			one.setImageResource(R.drawable.jesteryetagain);
		} else {
			//gray
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


		//image button for rev and the cards
		this.revolutionButton = (ImageButton)activity.findViewById(R.id.revolutionButton);
		this.one = (ImageButton)activity.findViewById(R.id.one);
		this.two = (ImageButton)activity.findViewById(R.id.two);
		this.three = (ImageButton)activity.findViewById(R.id.three);
		this.four = (ImageButton)activity.findViewById(R.id.four);
		this.five = (ImageButton)activity.findViewById(R.id.five);
		this.six = (ImageButton)activity.findViewById(R.id.six);
		this.seven = (ImageButton)activity.findViewById(R.id.seven);
		this.eight = (ImageButton)activity.findViewById(R.id.eight);
		this.nine = (ImageButton)activity.findViewById(R.id.nine);
		this.ten = (ImageButton)activity.findViewById(R.id.ten);
		this.eleven = (ImageButton)activity.findViewById(R.id.eleven);
		this.twelve = (ImageButton)activity.findViewById(R.id.twelve);
		this.jester = (ImageButton)activity.findViewById(R.id.jester);

		//player action buttons
		this.passButton = (Button) activity.findViewById(R.id.passButton);
		this.playButton = (Button) activity.findViewById(R.id.playButton);
		this.plusB = (Button) activity.findViewById(R.id.plusButton);
		this.minusB = (Button) activity.findViewById(R.id.minusButton);

		//listens for button presses
		passButton.setOnClickListener(this);
		playButton.setOnClickListener(this);
		plusB.setOnClickListener(this);
		minusB.setOnClickListener(this);

		//sets image button listener
		revolutionButton.setOnClickListener(this);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		ten.setOnClickListener(this);
		eleven.setOnClickListener(this);
		twelve.setOnClickListener(this);
		jester.setOnClickListener(this);

		//text views
		this.cardsNum = (TextView) activity.findViewById(R.id.cardnum);
		this.jesterNum = (TextView) activity.findViewById(R.id.jesterNum);
		this.oneNum = (TextView) activity.findViewById(R.id.oneNum);
		this.twoNum = (TextView) activity.findViewById(R.id.twoNum);
		this.threeNum = (TextView) activity.findViewById(R.id.threeNum);
		this.fourNum = (TextView) activity.findViewById(R.id.fourNum);
		this.fiveNum = (TextView) activity.findViewById(R.id.fiveNum);
		this.sixNum = (TextView) activity.findViewById(R.id.sixNum);
		this.sevenNum = (TextView) activity.findViewById(R.id.sevenNum);
		this.eightNum = (TextView) activity.findViewById(R.id.eightNum);
		this.nineNum = (TextView) activity.findViewById(R.id.nineNum);
		this.tenNum = (TextView) activity.findViewById(R.id.tenNum);
		this.elevenNum = (TextView) activity.findViewById(R.id.elevenNum);
		this.twelveNum = (TextView) activity.findViewById(R.id.twelveNum);

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

