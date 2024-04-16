/**
 * This contains the human player for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 12 2024
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
	//selected card
	int c;
	//selected number of cards
	int n;
	int j;

	//pass and hold buttons
	private Button passButton;
	private Button playButton;
	private Button plusB;
	private Button minusB;
	private Button jplusB;
	private Button jminusB;


	//for image button
	private ImageButton revolutionButton;
	private ImageButton paytaxesButton;
	private ImageButton jester;
	private ImageButton one;
	private ImageButton two;
	private ImageButton three;
	private ImageButton four;
	private ImageButton five;
	private ImageButton six;
	private ImageButton seven;
	private ImageButton eight;
	private ImageButton nine;
	private ImageButton ten;
	private ImageButton eleven;
	private ImageButton twelve;


	//text for number of cards
	private TextView cardsNum;
	private TextView jesterSelected ;
	private TextView jesterNum;
	private TextView oneNum;
	private TextView twoNum;
	private TextView threeNum;
	private TextView fourNum;
	private TextView fiveNum;
	private TextView sixNum;
	private TextView sevenNum;
	private TextView eightNum;
	private TextView nineNum;
	private TextView tenNum;
	private TextView elevenNum;
	private TextView twelveNum;

	//the canvas
	private surfaceDraw canvas;

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
		canvas.invalidate();
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
		//current selected card is c, number is n

		// if we are not yet connected to a game, ignore
		if (game == null) return;

		if(button.getId() == R.id.editTextTextMultiLine){
			//tbd
		}

		//what happens when player hits buttons
		if(button.getId() == R.id.playButton){
			state.play(this.playerNum, state.getDeck(), c, n, j);
		}
		else if(button.getId() == R.id.passButton){
		state.pass(state.getTurn());
		}
		else if(button.getId() == R.id.revolutionButton){
		state.revolution(this.playerNum, state.getDeck());
		}
		else if(button.getId() == R.id.payTaxesButton){
			if(playerNum == 3){
				state.GPPayTaxes();
			} else if(playerNum == 2){
				state.LPPayTaxes();
			} else if(playerNum == 1){
				state.LDPayTaxes(c);
			} else if(playerNum == 0){
				state.LDPayTaxes(c);
			}

		}

		//selected cards/display for selected cards
		else if(button.getId() == R.id.jester){
			 c = 13;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.one){
			c = 1;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.two){
			c = 2;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.three){
			c = 3;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.four){
			c = 4;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.five){
			c = 5;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.six){
			c = 6;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.seven){
			c = 7;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.eight){
			c = 8;;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.nine){
			c = 9;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.ten){
			c = 10;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.eleven){
			c = 11;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		} else if(button.getId() == R.id.twelve){
			c = 12;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
		}


		//more or less cards
		 if(button.getId() == R.id.addbutton){
			String nString = cardsNum.getText().toString();
			n = Integer.parseInt(nString) + 1;
			cardsNum.setText("" + n);
		} else if(button.getId() == R.id.minusbutton){
			 String nString = cardsNum.getText().toString();
			 n = Integer.parseInt(nString) - 1;
			 cardsNum.setText("" + n);
		}

		 //more or less jesters selected
		if(button.getId() == R.id.addjbutton){
			String jString = jesterSelected.getText().toString();
			j = Integer.parseInt(jString) + 1;
			jesterSelected.setText( "" + j);
		} else if(button.getId() == R.id.minusjbutton){
			String nString = jesterSelected.getText().toString();
			j = Integer.parseInt(nString) - 1;
			jesterSelected.setText("" + j);
		}


//		// I cannot overstate how long I took me to figure out this needed to be called on
//		// myActivity and not that for some reason nothing works for no reason
//		EditText textBox = myActivity.findViewById(R.id.editTextTextMultiLine);
//		textBox.setText("");
//
//		GDState firstInstance = new GDState();
//		GDState firstCopy = new GDState(firstInstance, 4);
//
//		GDHumanPlayer[] gamePlayers = new GDHumanPlayer[4]; //array of all players in game
//		gamePlayers[0] = new GDHumanPlayer("Great Dalmuti");
//		gamePlayers[1] = new GDHumanPlayer("Lesser Dalmuti");
//		gamePlayers[2] = new GDHumanPlayer("Lesser Peon");
//		gamePlayers[3] = new GDHumanPlayer("Greater Peon");
//
//		//greater peon declares revolution
//		state.revolution(firstCopy.getTurn(), firstCopy.getDeck()); //swaps positions
//		textBox.setText("" + textBox.getText() + "The Lesser Dalmuti has declared a revolution!\n");
//
//		//greater dalmuti and peon exchange taxes
//		state.GDPayTaxes(1, 2);
//		textBox.setText("" + textBox.getText() + "Taxes have been exchanged!\n");
//
//		//great dalmuti plays
//		ArrayList<ArrayList<Integer>> playingCards = new ArrayList<>();
//		ArrayList<Integer> foo = new ArrayList<>();
//		playingCards.add(foo);
//		foo.add(1);
//		foo.add(2);
//		state.play(firstCopy.getTurn(), firstCopy.getDeck(), c, n, j);
//		textBox.setText("" + textBox.getText() + "The Great Dalmuti has played!\n");
//
//		//lesser dalmuti passes
//		state.pass(firstCopy.getTurn());
//		textBox.setText("" + textBox.getText() + "Lesser Dalmuti has passed\n");
//
//		//lesser peon passes
//		state.pass(firstCopy.getTurn());
//		textBox.setText("" + textBox.getText() + "Lesser Dalmuti has passed\n");
//
//		//greater peon passes
//		state.pass(firstCopy.getTurn());
//		textBox.setText("" + textBox.getText() + "Lesser Dalmuti has passed\n");
//
//		//great dalmuti plays again
//		ArrayList<ArrayList<Integer>> playingCards2 = new ArrayList<>();
//		ArrayList<Integer> foo2 = new ArrayList<>();
//		playingCards2.add(foo2);
//		foo.add(1);
//		foo.add(2);
//		state.play(firstCopy.getTurn(), firstCopy.getDeck(), c, n, j);
//		textBox.setText("" + textBox.getText() + "The Great Dalmuti has played the rest of their hand" +
//				" and gone out!\n");
//		textBox.setText("" + textBox.getText() + "Great Dalmuti has won!!!!!\n");
//
//
//		// secondInstance
//		GDState secondInstance = new GDState();
//		// deep copy of secondInstance assigned to secondCopy
//		GDState secondCopy = new GDState(secondInstance, 4);
//
//		// call to toString() on firstCopy and secondCopy
//		firstCopy.toString();
//		secondCopy.toString();
//
//		// prints strings to the multi-line EditText for visual inspection
//		textBox.setText("" + textBox.getText() + "" + firstInstance.toString());
//		textBox.setText("" + textBox.getText() + "" + secondInstance.toString());
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

		GDState postType = (GDState) info;

		// update our state; then update the display
		this.state = (edu.up.cs301.GreatDalmuti.GDState) info;
		canvas.setCurrentGameState(state);
		updateDisplay();

		// image of revolution image button set if possible
		if(state.getDeck().get(playerNum).get(13) == 2){
			revolutionButton.setImageResource(R.drawable.revbutton);
		} else {
			revolutionButton.setImageResource(R.drawable.blankspace);
		}

		//image of pay taxes button if during that phase of the game
		if(state.getExhangtingTaxes()){
			paytaxesButton.setImageResource(R.drawable.paytaxesimage);
		} else {
			paytaxesButton.setImageResource(R.drawable.blankspace);
		}


//		//displays total cards numbers for every card
			jesterNum.setText("" + postType.getDeck().get(playerNum).get(13));
			oneNum.setText("" + postType.getDeck().get(playerNum).get(1));
			twoNum.setText("" +postType.getDeck().get(playerNum).get(2));
			threeNum.setText("" +postType.getDeck().get(playerNum).get(3));
			fourNum.setText("" +postType.getDeck().get(playerNum).get(4));
			fiveNum.setText("" +postType.getDeck().get(playerNum).get(5));
			sixNum.setText("" +postType.getDeck().get(playerNum).get(6));
			sevenNum.setText("" +postType.getDeck().get(playerNum).get(7));
			eightNum.setText("" +postType.getDeck().get(playerNum).get(8));
			nineNum.setText("" +postType.getDeck().get(playerNum).get(9));
			tenNum.setText("" +postType.getDeck().get(playerNum).get(10));
			elevenNum.setText("" +postType.getDeck().get(playerNum).get(11));
			twelveNum.setText("" +postType.getDeck().get(playerNum).get(12));


		//if number of cards is more than 0, else grey once imported
//		if(postType.getP1Hand().get(1) >= 1){
//			one.setImageResource(R.drawable.great_dalmuti);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(2) >= 1){
//			one.setImageResource(R.drawable.arch_bishop);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(3) >= 1){
//			one.setImageResource(R.drawable.earl_marshal);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(4) >= 1){
//			one.setImageResource(R.drawable.baroness);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(5) >= 1){
//			one.setImageResource(R.drawable.abbess);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(6) >= 1){
//			one.setImageResource(R.drawable.knight);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(7) >= 1){
//			one.setImageResource(R.drawable.seamstress);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(8) >= 1){
//			one.setImageResource(R.drawable.mason);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(9) >= 1){
//			one.setImageResource(R.drawable.cook);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(10) >= 1){
//			one.setImageResource(R.drawable.sheperdess);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(11) >= 1){
//			one.setImageResource(R.drawable.stonecutter);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(12) >= 1){
//			one.setImageResource(R.drawable.peasant);
//		} else {
//			//gray
//		}
//		if(postType.getP1Hand().get(13) >= 1){
//			one.setImageResource(R.drawable.jesteryetagain);
//		} else {
//			//gray
//		}


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
		activity.setContentView(R.layout.dalmuti_main_xml);

		this.testResultsTextView = (TextView) activity.findViewById(R.id.greatDalmutiValueTextView);

		//image button for rev and the cards
		this.revolutionButton = (ImageButton)activity.findViewById(R.id.revolutionButton);
		this.paytaxesButton = (ImageButton)activity.findViewById(R.id.payTaxesButton);
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
		this.plusB = (Button) activity.findViewById(R.id.addbutton);
		this.minusB = (Button) activity.findViewById(R.id.minusbutton);
		this.jplusB = (Button) activity.findViewById(R.id.addjbutton);
		this.jminusB = (Button) activity.findViewById(R.id.minusjbutton);

		//listens for button presses
		passButton.setOnClickListener(this);
		playButton.setOnClickListener(this);
		plusB.setOnClickListener(this);
		minusB.setOnClickListener(this);
		jplusB.setOnClickListener(this);
		jminusB.setOnClickListener(this);

		//sets image button listener
		revolutionButton.setOnClickListener(this);
		paytaxesButton.setOnClickListener(this);
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
		this.jesterSelected = (TextView) activity.findViewById(R.id.jesterNumSelected);
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

		//find the surface view
		this.canvas = (surfaceDraw)activity.findViewById(R.id.the_canvas);

		// Load the layout resource for our GUI
		//activity.setContentView(R.layout.dalmuti_main_xml);

	} // setAsGui

} // GDHumanPlayer class


