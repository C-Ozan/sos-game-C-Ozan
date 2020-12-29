package org.kodluyoruz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter the game board sizes:");
        int sizes = input.nextInt();

        while (sizes < 3 || sizes > 7) {
            System.out.println("Warning.Sizes must be between 3x3 and 7x7.");
            System.out.print("Please Enter the game board sizes:");
            sizes = input.nextInt();
        }

        System.out.println();

        SOSGame sosGame = new SOSGame(sizes);
        sosGame.FillGameBoard(sosGame);

        System.out.print("Nickname:");
        String nickname = input.next();
        Player player1 = new Player(nickname);
        PlayerComputer player2 = new PlayerComputer("Computer");

        sosGame.playGame(player1, player2, sosGame);
    }
}
