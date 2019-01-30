import java.util.Scanner;

/**
 * CS18000 - Fall 2018
 *
 * Project 2 - Reversi
 *
 * Abstraction of and launcher for a Reversi game
 *
 * @author Imtiaz Karim, karim7@purdue.edu
 * @author Marina Haliem, mwadea@purdue.edu
 * @author Evan Wang, wang3407@purdue.edu
 *
 */
public class Reversi {
	
	/**
	All the Print Statements needed are given here:
	String Draw = "It is a draw.";
	String WhiteWins ="White wins: " + g.WScore + ":" + g.BScore;
	String BlackWins = "Black wins: " + g.BScore + ":" + g.WScore;
	String Exit = "Exiting!";

	String BlackMove = "Place move (Black): row then column: ";
	String BlackSkipping = "Black needs to skip... Passing to white";	
	String InvalidBlackMove = "Invalid move!\nPlace move (Black): row then column: ";
	String BlackScoreShow = "Black: " + g.BScore + " White: " + g.WScore;

	String WhiteSkipping = "White needs to skip... Passing to Black";
	String WhiteMove = "Place move (White): row then column: ";
	String InvalidWhiteMove = "Invalid move!\nPlace move (White): row then column: ";
 	String WhiteScoreShow = "White: " + g.WScore + " Black: " + g.BScore;

	**/
    public static boolean isEmpty(Point[] P) {
        /**
         * TODO: Check whether any valid moves can be played
         * @param P The game board to be checked
         * @return true if there are valid moves; false if there are no valid moves
         */
        return false;
    }

    //Check whether a Point is the Points array or not 

    public static boolean contains(Point[] points, Point p) {
        /**
         * TODO: Check whether the board already contains a point corresponding to a previous move
         * @param points The game board to be checked
         * @param p The point to be checked for validity
         * @return true if the board contains the point; false if the board does not contain the point
         */

        return true;

    }

    public static void start(Game g) {
        /**
         * TODO: Handle input corresponding to the sequence of moves entered by the user
         * TODO: Check the validity of the move, update the board, and print out the updated board after each move
         * TODO: Determine and print out the result after the game is completed
         * @param g The Reversi game currently in play
         */

    }

    public static void main(String[] args) {
        Game b = new Game();
        start(b);
    }
}
