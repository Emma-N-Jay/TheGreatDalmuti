/**
 * This contains the main activity for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version April 12 2024
 *
 * Our game allows a user to pay taxes, declare a revolution when they have two jesters, play, and pass.
 * We chose that the greater and lesser peons' taxes are automatically paid for them, whereas the greater
 * and lesser dalmatis' get to select the cards they want to be sent as taxes. We decided that the only revolution
 * allowed in our game is the case when no taxes are present. We made this decision because we could not figure out
 * how to get the players' names to switch the players' ranks. We consulted Vegdahl about accessing players and
 * concluded it would be unrealistic, so we decided to scrap the second case and support only the first revolution case.
 * The play allows the jester to be added to the cards selected to meet the required number of cards in the pile.
 * Our GUI has improved from our initial design; using image buttons and a surface view, we created a clean and
 * intuitive layout for the user. The differences between the smart and dumb AIs are the following:
 * taxes are smarter and leading. The play style is similar, where they will only play the same
 *amount of cards as in the pile. Leading will play the highest set of cards, including jesters,
 * for the smart AI, whereas the dumb AI will first play the jester and then their lowest card.
 * Our game supports network play with up to four devices. We made the decision that our game must be
 * played with four players.
 *
 * One bug we have is that when a revolution is able to be declared, if a player pays taxes before
 * declaring a revolution, they will lose those tax cards and not get them back. In this case, we
 * did not have time to implement a helper method for precedence to prevent this from happening.
 * Another functionality that could have been added is the second revolution case, switching the
 * ranks of players, which would mean figuring out how to access players. Additionally, by finding
 * out how to access players, we would be able to label player ranks on the GUI. We also would have
 * liked to figure out and implement a way to display whose turn it is.
 *
 * Additional features: custom cards, background music, sound effects when buttons are clicked,
 * app icon, pop-ups (rules and how to play)
 */

package edu.up.cs301.GreatDalmuti;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;
import edu.up.cs301.GameFramework.LocalGame;
import edu.up.cs301.GameFramework.gameConfiguration.*;

public class GDMainActivity extends GameMainActivity {

	// INSTANCE VARIABLES **************************************************************************
	// the port number that this game will use when playing over the network
	private static final int PORT_NUMBER = 2234;
	GDState localGD;
	ArrayList<String> playerNames;

	// METHODS *************************************************************************************

	/**
	 * Create the default configuration for this game:
	 * - one human player vs. one computer player
	 * - minimum of 1 player, maximum of 2
	 * - one kind of computer player and one kind of human player available
	 * 
	 * @return
	 * 		the new configuration object, representing the default configuration
	 */
	@Override
	public GameConfig createDefaultConfig() {
		playerNames  = new ArrayList<String>();
		// Define the allowed player types
		ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();
		
		// a human player player type (player type 0)
		playerTypes.add(new GamePlayerType("Local Human Player") {
			public GamePlayer createPlayer(String name) {
				playerNames.add(name);
				return new edu.up.cs301.GreatDalmuti.GDHumanPlayer(name);
			}});
		
		// a computer player type (player type 1)
		playerTypes.add(new GamePlayerType("Dumb AI") {
			public GamePlayer createPlayer(String name) {
				playerNames.add(name);
				return new GDDumbAI(name);
			}});
		playerTypes.add(new GamePlayerType("Smart AI") {
			public GamePlayer createPlayer(String name) {
				playerNames.add(name);
				return new CDSmartAI(name);
			}});

		// Create a game configuration class for GD:
		// - player types as given above
		// - from 1 to 4 players
		// - name of game is "The Great Dalmuti"
		// - port number as defined above
		GameConfig defaultConfig = new GameConfig(playerTypes, 1, 4,
				"Great Dalmuti", PORT_NUMBER);

		// Add the default players to the configuration
		defaultConfig.addPlayer("Greater Dalmuti", 0); // player 1: a human player
		defaultConfig.addPlayer("Lesser Dalmuti", 1); // player 2: a computer player
		defaultConfig.addPlayer("Lesser Peon", 2); // player 3: a computer player
		defaultConfig.addPlayer("Greater Peon", 3); // player 4: a computer player

		// Set the default remote-player setup:
		// - player name: "Remote Player"
		// - IP code: (empty string)
		// - default player type: human player
		defaultConfig.setRemoteData("Remote Player", "", 0);
		
		// return the configuration
		return defaultConfig;
	} // createDefaultConfig

	/**
	 * create a local game
	 * 
	 * @return
	 * 		the local game, a counter game
	 */
	@Override
	public LocalGame createLocalGame(GameState state) {
		if (state == null || !(state instanceof GDState)) {
			state = new edu.up.cs301.GreatDalmuti.GDState();
		}
		this.localGD = (GDState) state;
		return new edu.up.cs301.GreatDalmuti.GDLocalGame(state);
	} // createLocalGame

} // GDMainActivity class
