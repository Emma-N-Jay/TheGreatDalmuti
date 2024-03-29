/**
 * This contains the main activity for the Great Dalmuti game.
 *
 * @author Tramanh Best
 * @author Emma Jeppesen
 * @author Alex Burns
 * @author Theresa Wunderlich
 * @version March 19 2024
 */

package edu.up.cs301.GreatDalmuti;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;
import edu.up.cs301.GameFramework.LocalGame;
import edu.up.cs301.GameFramework.gameConfiguration.*;

public class GDMainActivity extends GameMainActivity {

	// INSTANCE VARIABLES **************************************************************************
	// the port number that this game will use when playing over the network
	private static final int PORT_NUMBER = 2234;

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
		
		// Define the allowed player types
		ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();
		
		// a human player player type (player type 0)
		playerTypes.add(new GamePlayerType("Local Human Player") {
			public GamePlayer createPlayer(String name) {
				return new edu.up.cs301.GreatDalmuti.GDHumanPlayer(name);
			}});
		
		// a computer player type (player type 1)
		playerTypes.add(new GamePlayerType("Computer Player 1") {
			public GamePlayer createPlayer(String name) {
				return new edu.up.cs301.GreatDalmuti.GDComputerPlayer1(name);
			}});
		playerTypes.add(new GamePlayerType("Computer Player 2") {
			public GamePlayer createPlayer(String name) {
				return new edu.up.cs301.GreatDalmuti.GDComputerPlayer1(name);
			}});
		playerTypes.add(new GamePlayerType("Computer Player 3") {
			public GamePlayer createPlayer(String name) {
				return new edu.up.cs301.GreatDalmuti.GDComputerPlayer1(name);
			}});

		
		// a computer player type (player type 2)
		playerTypes.add(new GamePlayerType("Computer Player (GUI)") {
			public GamePlayer createPlayer(String name) {
				return new GDComputerPlayerGUI(name);
			}});


		// Create a game configuration class for Counter:
		// - player types as given above
		// - from 1 to 4 players
		// - name of game is "Counter Game"
		// - port number as defined above
		GameConfig defaultConfig = new GameConfig(playerTypes, 1, 4, "Great Dalmuti",
				PORT_NUMBER);

		// Add the default players to the configuration
		defaultConfig.addPlayer("Human", 0); // player 1: a human player
		defaultConfig.addPlayer("Computer 1", 1); // player 2: a computer player
		defaultConfig.addPlayer("Computer 2", 2); // player 3: a computer player
		defaultConfig.addPlayer("Computer 3", 3); // player 4: a computer player

		
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
		if (state == null) state = new edu.up.cs301.GreatDalmuti.GDState(0);
		return new edu.up.cs301.GreatDalmuti.GDLocalGame(state);
	} // createLocalGame

} // GDMainActivity class
