package edu.up.cs301.GameFramework.infoMessage;

/**
 * The a message from the game to a player that the move just attempted
 * was illegal.
 *
 * @author Steven R. Vegdahl
 * @version July 2013
 *
 */
public class IllegalMoveInfo extends GameInfo {
    //Tag for logging
    //If too many cards based on previous play, no play
    //If no lower cards, no play

    private static final String TAG = "IllegalMoveInfo";
    // to satisfy Serializable interface
    private static final long serialVersionUID = 7165334825841353190L;

}
