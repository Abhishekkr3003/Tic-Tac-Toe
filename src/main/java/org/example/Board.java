package org.example;

public class Board {
    String[] board;
    // To print out the board.
	/* |---|---|---|
	| 1 | 2 | 3 |
	|-----------|
	| 4 | 5 | 6 |
	|-----------|
	| 7 | 8 | 9 |
	|---|---|---|*/

    void displayBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
            + board[1] + " | " + board[2]
            + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
            + board[4] + " | " + board[5]
            + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
            + board[7] + " | " + board[8]
            + " |");
        System.out.println("|---|---|---|");
    }

    Boolean isBoardFull() {
        boolean isNotFull = false;
        for (int a = 0; a < 9; a++) {
            if (board[a] != "X" || board[a] != "O") {
                isNotFull = true;
                break;
            }
        }
        return isNotFull;
    }
    static  boolean isEmpty(int pos){
	if (board[pos] != "X" || board[pos] != "O") {
	    return true;
	}
	return false;
    }

}
