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

    int makeMove(Player p) {
        
        System.out.println("Its your turn :" + p.name);
        Scanner in = new Scanner(System.in);

        int numInput;
        while(true){
            try {

                String inp = in.nextLine();
                if(inp.length() == 1 && inp.charAt(0) == 'q')
                    return 1;

                numInput = Integer.parseInt(inp);
                if (!(numInput > 0 && numInput <= 9) ) {
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                    continue;
                }
                else if(!this.board.isEmpty(numInput)){
                    System.out.println("Position is already filled. Choose another slot : ");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                continue;
            }
            this.board.fillGrid(numInput, p.symbol);
            return 0;
        }
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
