package org.example;

public class Game {
    Boolean turn;
    Board board;
    Player p1;
    Player p2;

    public Game(String p1, String p2) {
        turn = false;
        board = new Board();
        this.p1 = new Player(p1, 'X');
        this.p2 = new Player(p2, 'O');
    }

    void makeMove() {
        // TODO
    }

    Boolean checkWinner() {
        return true; // TODO
    }

    Boolean playGame() {
        makeMove();
        board.displayBoard();
        if (checkWinner() || board.isBoardFull()) {
            return true;
        }
        return false;
    }
}
