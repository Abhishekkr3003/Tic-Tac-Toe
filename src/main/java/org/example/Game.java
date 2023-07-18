package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    int makeMove(Player p) {

        System.out.println("Its your turn :" + p.name);
        Scanner in = new Scanner(System.in);

        int numInput;
        while (true) {
            try {

                String inp = in.nextLine();
                if (inp.length() == 1 && inp.charAt(0) == 'q')
                    return 1;

                numInput = Integer.parseInt(inp);
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                    continue;
                } else if (!this.board.isEmpty(numInput)) {
                    System.out.println("Position is already filled. Choose another slot : ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                continue;
            }
            this.board.fillGrid(numInput, Character.toString(p.symbol));
            return 0;
        }
    }

    Boolean checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = board.checkBoard(a);

            //For X winner
            if (line.equals("XXX")) {
                System.out.println("Winner is: " + p1.name);
                return true;
            }

            // For O winner
            else if (line.equals("OOO")) {
                System.out.println("Winner is: " + p2.name);
                return true;
            }
        }
        if (board.isBoardFull()) {
            System.out.println("It's a DRAW!");
            return true;
        }
        return false;
    }

    Boolean playGame() {
        board.displayBoard();
        int val = -8;
        while (true) {
            if (turn) {
                val = makeMove(p1);
            } else {
                val = makeMove(p2);
            }
            turn = !turn;
            board.displayBoard();
            if (checkWinner()) {
                return true;
            } else if (val == 1) {
                return false;
            }
        }
    }
}
