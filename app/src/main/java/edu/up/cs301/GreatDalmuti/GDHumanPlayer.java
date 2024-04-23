/**
 * This contains the human player for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 2024
 */

package edu.up.cs301.GreatDalmuti;

import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.players.GameHumanPlayer;

public class GDHumanPlayer extends GameHumanPlayer implements OnClickListener {

	// INSTANCE VARIABLES **************************************************************************
	
	// The TextView the displays the current counter value
	private TextView testResultsTextView;
	
	// the most recent game state, as given to us by the CounterLocalGame
	private edu.up.cs301.GreatDalmuti.GDState state;
	
	// the android activity that we are running
	private GameMainActivity myActivity;

	//selected card
	int c;
	//selected number of cards
	int n;
	int j;
	String nString;

	//all of the buttons galore
	private Button passButton;
	private Button playButton;
	private Button plusB;
	private Button minusB;
	private Button jplusB;
	private Button jminusB;

	//music and sound related variables
	private Switch musicSwitch;
	//For background music
	MediaPlayer music;
	MediaPlayer soundEffects;
	private boolean backgroundMusic = false;

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
	public View getTopView() {
		return myActivity.findViewById(R.id.editTextTextMultiLine);
	}
	
	/**
	 * redraws canvas
	 *
	 * no parameters or return statements
	*/
	protected void updateDisplay() {
		canvas.invalidate();
	} // updateDisplay

	/**
	 * 
	 * @param button
	 * 		the button that was clicked
	 */
	public void onClick(View button) {
		//current selected card is c, number is n

		// if we are not yet connected to a game
		if (game == null) return;

		if(button.getId() == R.id.editTextTextMultiLine){
		}

		if(button.getId() == R.id.playButton){
			PlayAction playAction = new PlayAction(this, playerNum, c, n, j);
			game.sendAction(playAction);
		}
		else if(button.getId() == R.id.passButton){
		PassAction passAction = new PassAction(this, playerNum);
		game.sendAction(passAction);
		}
		else if(button.getId() == R.id.revolutionButton){
		RevolutionAction revolutionAction = new RevolutionAction(this, playerNum);
		game.sendAction(revolutionAction);
		}
		else if(button.getId() == R.id.payTaxesButton){
			if (playerNum == 0) {
				GDPayTaxesAction gdPayTaxesAction = new GDPayTaxesAction(this, c);
				game.sendAction(gdPayTaxesAction);
			}
			else if (playerNum == 1) {
				LDPayTaxesAction ldPayTaxesAction = new LDPayTaxesAction(this, c);
				game.sendAction(ldPayTaxesAction);
				GPPayTaxesAction gpPayTaxesAction = new GPPayTaxesAction(this);
				game.sendAction(gpPayTaxesAction);
			}
			else if (playerNum == 2) {
				LPPayTaxesAction lpPayTaxesAction = new LPPayTaxesAction(this);
				game.sendAction(lpPayTaxesAction);
				soundEffects = MediaPlayer.create(myActivity, R.raw.wompwomp);
				music.start();
			}
			else {
				GPPayTaxesAction gpPayTaxesAction = new GPPayTaxesAction(this);
				game.sendAction(gpPayTaxesAction);
				soundEffects = MediaPlayer.create(myActivity, R.raw.wompwomp);
				music.start();
			}
		}

		//selected cards/display for selected cards
		else if(button.getId() == R.id.jester){
			 c = 13;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.one){
			c = 1;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.two){
			c = 2;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.three){
			c = 3;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.four){
			c = 4;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.five){
			c = 5;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.six){
			c = 6;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.seven){
			c = 7;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.eight){
			c = 8;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.nine){
			c = 9;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.ten){
			c = 10;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.eleven){
			c = 11;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		} else if(button.getId() == R.id.twelve){
			c = 12;
			cardsNum.setText("" + state.getDeck().get(playerNum).get(c));
			nString = state.getDeck().get(playerNum).get(c).toString();
			n = Integer.parseInt(nString);
		}

		//more or less cards
		 if(button.getId() == R.id.addbutton){
			nString = cardsNum.getText().toString();
			n = Integer.parseInt(nString) + 1;
			cardsNum.setText("" + n);
		} else if(button.getId() == R.id.minusbutton){
			 nString = cardsNum.getText().toString();
			 if(n > 0) {
				 n = Integer.parseInt(nString) - 1;
				 cardsNum.setText("" + n);
			 }
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

		//plays the background music
		if(button.getId() == R.id.musicSwitch){
			if(backgroundMusic){
				backgroundMusic = false;
				music.stop();
			} else {
				backgroundMusic = true;
				if(state.getExchangingTaxes()) {
					music = MediaPlayer.create(myActivity, R.raw.moneymoneymoenybutmedieval);
					music.start();
					music.setLooping(true);
				} else {
					music = MediaPlayer.create(myActivity, R.raw.promiscuousbutmedieval);
					music.start();
					music.setLooping(true);
				}
			}

		}

		//updates number of cards
		jesterNum.setText("" + state.getDeck().get(playerNum).get(13));
		oneNum.setText("" + state.getDeck().get(playerNum).get(1));
		twoNum.setText("" + state.getDeck().get(playerNum).get(2));
		threeNum.setText("" + state.getDeck().get(playerNum).get(3));
		fourNum.setText("" + state.getDeck().get(playerNum).get(4));
		fiveNum.setText("" + state.getDeck().get(playerNum).get(5));
		sixNum.setText("" + state.getDeck().get(playerNum).get(6));
		sevenNum.setText("" + state.getDeck().get(playerNum).get(7));
		eightNum.setText("" + state.getDeck().get(playerNum).get(8));
		nineNum.setText("" + state.getDeck().get(playerNum).get(9));
		tenNum.setText("" + state.getDeck().get(playerNum).get(10));
		elevenNum.setText("" + state.getDeck().get(playerNum).get(11));
		twelveNum.setText("" + state.getDeck().get(playerNum).get(12));
		canvas.invalidate();


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
		if(state.getExchangingTaxes()){
			paytaxesButton.setImageResource(R.drawable.paytaxesimage);
		} else {
			paytaxesButton.setImageResource(R.drawable.blankspace);
		}

		//displays total cards numbers for every card
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

		// if number of cards is more than 0, else grey once imported
		if(postType.getDeck().get(playerNum).get(1) >= 1){
			one.setImageResource(R.drawable.great_dalmuti);
		} else {
			one.setImageResource(R.drawable.grey_gd);
		}
		if(postType.getDeck().get(playerNum).get(2) >= 1){
			two.setImageResource(R.drawable.arch_bishop);
		} else {
			two.setImageResource(R.drawable.grey_archbishop);
		}
		if(postType.getDeck().get(playerNum).get(3) >= 1){
			three.setImageResource(R.drawable.earl_marshal);
		} else {
			three.setImageResource(R.drawable.grey_earl);
		}
		if(postType.getDeck().get(playerNum).get(4) >= 1){
			four.setImageResource(R.drawable.baroness);
		} else {
			four.setImageResource(R.drawable.grey_baroness);
		}
		if(postType.getDeck().get(playerNum).get(5) >= 1){
			five.setImageResource(R.drawable.abbess);
		} else {
			five.setImageResource(R.drawable.grey_abbess);
		}
		if(postType.getDeck().get(playerNum).get(6) >= 1){
			six.setImageResource(R.drawable.knight);
		} else {
			six.setImageResource(R.drawable.grey_knight);
		}
		if(postType.getDeck().get(playerNum).get(7) >= 1){
			seven.setImageResource(R.drawable.seamstress);
		} else {
			seven.setImageResource(R.drawable.grey_seamstress);
		}
		if(postType.getDeck().get(playerNum).get(8) >= 1){
			eight.setImageResource(R.drawable.mason);
		} else {
			eight.setImageResource(R.drawable.grey_mason);
		}
		if(postType.getDeck().get(playerNum).get(9) >= 1){
			nine.setImageResource(R.drawable.cook);
		} else {
			nine.setImageResource(R.drawable.grey_cook);
		}
		if(postType.getDeck().get(playerNum).get(10) >= 1){
			ten.setImageResource(R.drawable.sheperdess);
		} else {
			ten.setImageResource(R.drawable.grey_shepherdress);
		}
		if(postType.getDeck().get(playerNum).get(11) >= 1){
			eleven.setImageResource(R.drawable.stonecutter);
		} else {
			eleven.setImageResource(R.drawable.grey_stonecutter);
		}
		if(postType.getDeck().get(playerNum).get(12) >= 1){
			twelve.setImageResource(R.drawable.peasant);
		} else {
			twelve.setImageResource(R.drawable.grey_peasant);
		}
		if(postType.getDeck().get(playerNum).get(13) >= 1){
			jester.setImageResource(R.drawable.jesteryetagain);
		} else {
			jester.setImageResource(R.drawable.grey_jester);
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

		//switch to turn off background noise
		this.musicSwitch = (Switch) activity.findViewById(R.id.musicSwitch);

		//listens for button presses
		passButton.setOnClickListener(this);
		playButton.setOnClickListener(this);
		plusB.setOnClickListener(this);
		minusB.setOnClickListener(this);
		jplusB.setOnClickListener(this);
		jminusB.setOnClickListener(this);
		musicSwitch.setOnClickListener(this);

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

	} // setAsGui

} // GDHumanPlayer class