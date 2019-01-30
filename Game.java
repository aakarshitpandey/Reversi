import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * CS18000 - Fall 2018
 * <p>
 * Project 2 - Reversi
 * <p>
 * Implementation of the game mechanics in Reversi
 *
 * @author Imtiaz Karim, karim7@purdue.edu
 * @author Marina Haliem, mwadea@purdue.edu
 * @author Evan Wang, wang3407@purdue.edu
 */

public class Game {

    public Point P;
    private final char[][] board;
    public int WScore;
    public int BScore;
    public int remaining;
    private final char boardX[] = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};

    public Game() {
        board = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', 'W', 'B', '_', '_', '_',},
                {'_', '_', '_', 'B', 'W', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},};
    }

    public void displayBoard(Game b) {
        /**
         * TODO: Display the current board along with the current positions of the pieces
         * @param b The game board to be displayed
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j = board[].length - 1) {
                    System.out.println(board[i][j]);
                } else {
                    System.out.print(board[i][j]);
                }
            }
        }
    }

    //There are three cases black win = -1, white win = 1, draw = 0 

    public int gameResult(Point[] whitePlaceableLocations, Point[] blackPlaceableLocations) {
        /**
         * TODO: Update the score and determine the game result
         * @param whitePlaceableLocations Array of possible moves for white
         * @param blackPlaceableLocations Array of possible moves for white
         * @return The integer corresponding to the game result: -1 for black win, 0 for draw, 1 for white win
         */

        if (whitePlaceableLocations.length = 0 && blackPlaceableLocations.length = 0) {
            updateScores();
            if (WScore == BScore) {
                return 0;
            } else if (BScore > WScore) {
                return -1;
            } else {
                return 1;
            } //Compare the number of black and white coins
        }
    }

    public Point[] getPlaceableLocations(char player, char opponent) {
        /**
         * TODO: Check the board for and fill the placeablePositions array with valid moves that the player can make
         * @param player Current player
         * @param opponent player's opponent
         * @return placeablePositions array, with corresponding point for a valid location and (-1,-1) for an invalid location
         */

        Point[] placeablePositions = new Point[64];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player) {
                    int countArr = 0;
                    //check the vertical upwards direction
                    if (i != 0) {
                        l1:
                        for (int k = i - 1; k > 0; k--) {
                            if (board[k][j] == opponent) {
                                break;
                            } else if (board[k][j] == player) {
                                break l1;
                            } else if (board[k][j] == '_' && k != i - 1) {
                                placeablePositions[countArr] = Point(k, j);
                                countArr++;
                            }
                        }
                    }
                    //Check the vertical downward direction
                    if (i != 7) {
                        l1:
                        for (int k = i + 1; k < 7; k++) {
                            if (board[k][j] == opponent) {
                                break;
                            } else if (board[k][j] == player) {
                                break l1;
                            } else if (board[k][j] == '_' && k != i + 1) {
                                placeablePositions[countArr] = Point(k, j);
                                countArr++;
                            }
                        }
                    }
                    //Check the horizontal right direction
                    if (j != 7) {
                        l1:
                        for (int k = j + 1; k < 7; k++) {
                            if (board[i][k] == opponent) {
                                break;
                            } else if (board[i][k] == player) {
                                break l1;
                            } else if (board[i][k] == '_' && k != j + 1) {
                                placeablePositions[countArr] = Point(i, k);
                                countArr++;
                            }
                        }
                    }
                    //Check the horizontal left direction
                    if (j != 0) {
                        l1:
                        for (int k = j - 1; k < 0; k--) {
                            if (board[i][k] == opponent) {
                                break;
                            } else if (board[i][k] == player) {
                                break l1;
                            } else if (board[i][k] == '_' && k != j - 1) {
                                placeablePositions[countArr] = Point(i, k);
                                countArr++;
                            }
                        }
                    }
                    //Check the North-East Direction
                    if (i > 0 || j < 7) {
                        l1:
                        int iAlt = i - 1;
                        for (int k = j + 1; k < 7; k++) {
                            if (board[iAlt][k] == opponent) {
                                break;
                            } else if (board[iAlt][k] == player) {
                                break l1;
                            } else if (board[iAlt][k] == '_' && k != j + 1) {
                                placeablePositions[countArr] = Point(iAlt, k);
                                countArr++;
                            }
                            iAlt = i - 1;
                        }
                    }
                    //Check the North-West Direction
                    if (i > 0 || j > 0) {
                        l1:
                        int iAlt = i - 1;
                        for (int k = j - 1; k < 0; k--) {
                            if (board[iAlt][k] == opponent) {
                                break;
                            } else if (board[iAlt][k] == player) {
                                break l1;
                            } else if (board[iAlt][k] == '_' && k != j - 1) {
                                placeablePositions[countArr] = Point(iAlt, k);
                                countArr++;
                            }
                            iAlt = i - 1;
                        }
                    }
                    //Check the South-West Direction
                    if (i < 7 || j > 0) {
                        l1:
                        int iAlt = i - 1;
                        for (int k = j - 1; k < 0; k--) {
                            if (board[iAlt][k] == opponent) {
                                break;
                            } else if (board[iAlt][k] == player) {
                                break l1;
                            } else if (board[iAlt][k] == '_' && k != j - 1) {
                                placeablePositions[countArr] = Point(iAlt, k);
                                countArr++;
                            }
                            iAlt = i + 1;
                        }
                    }
                    //Check the South-East Direction
                    if (i < 7 || j < 7) {
                        l1:
                        int iAlt = i - 1;
                        for (int k = j + 1; k < 7; k++) {
                            if (board[iAlt][k] == opponent) {
                                break;
                            } else if (board[iAlt][k] == player) {
                                break l1;
                            } else if (board[iAlt][k] == '_' && k != j + 1) {
                                placeablePositions[countArr] = Point(iAlt, k);
                                countArr++;
                            }
                            iAlt = i + 1;
                        }
                    }
                }
            }
        }
        return placeablePositions;
    }

    public void showPlaceableLocations(Point[] locations, char player, char opponent) {
        /**
         * TODO: Display the board with valid moves for the player
         * @param locations Array containing placeable locations for the player
         * @param player Current player
         * @param opponent player's opponent
         */
        int count = 0;
        for (int i = 0; i < locations.length; i++) {
           if(locations[i] != null) {
               count++;
           }
        }
        for (int i = 0; i < count; i++) {
            board[locations[i].x][locations.y] = '*';
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j = board[].length - 1) {
                    System.out.println(board[i][j]);
                } else {
                    System.out.print(board[i][j]);
                }
            }
        }//function not called, might have to change later.

    }

    public void placeMove(Point p, char player, char opponent) {
        /**
         * TODO: Place a piece on the board at the location by the point p and update the board accordingly
         * @param p Point corresponding to the location of the piece to be placed
         * @param player Current player
         * @param opponent player's opponent
         */
        board[p.x][p.y] = player;
    }

    public void updateScores() {
        /**
         * TODO: Update the scores (number of pieces of a player's color) of each player
         */
        WScore = 0;
        BScore = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'W') {
                    WScore++;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'B') {
                    BScore++;
                }
            }
        }
        //counting of coins done
    }
}
