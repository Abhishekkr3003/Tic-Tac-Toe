package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap < Integer, Game > games = new HashMap < > ();
        int counter = 1;
        while (true) {
            if (games.size() == 0)
                System.out.println("No games currently running. Type 0 to start a new game.");
            else {
                System.out.println("Currently running games:");
                System.out.println(games.entrySet().stream().map(Object::toString).collect(Collectors.joining(" | ")));
                System.out.println("Enter game id to choose which game to play, 0 to start new game, -1 to exit.");

            }

            int input = sc.nextInt();
            if (input == 0) {
                // new game
                sc.nextLine();
                System.out.println("Enter the name of player 1:");
                String player1 = sc.nextLine();
                System.out.println("Enter the name of player 2:");
                String player2 = sc.nextLine();
                Game game = new Game(player1, player2);
                int game_id = counter++;
                games.put(game_id, game);
                boolean hasFinished = game.playGame();
                if (hasFinished)
                    games.remove(game_id);
            } else if (input == -1)
                break;
            else {
                if (!games.containsKey(input)) {
                    System.out.println("Invalid input.");
                } else {
                    // continue the game
                    boolean hasFinished = games.get(input).playGame();
                    if (hasFinished)
                        games.remove(input);
                }
            }
        }
    }
}
