package org.example;

public class Game {
    Boolean turn;
    final Integer gameId;
    Board board;
    Player p1;
    Player p2;

    public Game(Integer gameId, String p1, String p2) {
        this.gameId = gameId;
        turn = false;
        board = new Board();
        this.p1 = new Player(p1, 'X');
        this.p2 = new Player(p2, 'O');
    }

    void makeMove() {

    }

    void checkWinner() {

    }

    void playGame() {

    }
}
