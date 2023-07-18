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

    boolean isBoardFull() {
        boolean isNotFull = false;
        for (int a = 0; a < 9; a++) {
            if (board[a] != "X" || board[a] != "O") {
                isNotFull = true;
                break;
            }
        }
        return !isNotFull;
    }

    boolean isEmpty(int pos) {
        if (board[pos] != "X" || board[pos] != "O") {
            return true;
        }
        return false;
    }


    void fillGrid(int pos, String value) {
        if (pos < 0 || pos > 8) {
            return;
        }
        board[pos] = value;
    }

    String checkBoard(int a) {
        String line = null;
        switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
        }
        return line;
    }

}
