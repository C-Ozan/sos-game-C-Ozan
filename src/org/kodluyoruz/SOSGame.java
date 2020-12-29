package org.kodluyoruz;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class SOSGame {

    Scanner input = new Scanner(System.in);
    private String[][] gameBoard;


    public SOSGame(int sizes) {
        this.gameBoard = new String[sizes][sizes];
    }

    public void FillGameBoard(SOSGame SOSGame) {

        for (int i = 0; i < SOSGame.gameBoard.length; i++) {
            for (int j = 0; j < SOSGame.gameBoard.length; j++) {
                SOSGame.gameBoard[i][j] = "-  ";
            }
        }

        for (int i = 0; i < SOSGame.gameBoard.length; i++) {
            for (int j = 0; j < SOSGame.gameBoard.length; j++) {
                System.out.print(SOSGame.gameBoard[i][j]);
            }
            System.out.println();
        }

    }

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void playGame(Player player1, PlayerComputer player2, SOSGame sosGame) {

        int headsOrTails = 0; //(int) (Math.random() * 100) % 2;
        int row = 0;
        int column = 0;

        if (headsOrTails == 0) {
            System.out.println("heads or tails Winner:" + player1.getNickName());
            System.out.println(player1.getNickName() + " Make your move,Enter row and column number and character");

        } else {
            System.out.println("heads or tails Winner:" + player2.getNickName());
            System.out.println(player2.getNickName() + " Make your move");
        }

        for (int i = 0; i < (int) Math.pow(sosGame.gameBoard.length, 2); i++) {


            if (headsOrTails == 0) {
                System.out.print("Row Number:");
                row = input.nextInt();
                System.out.print("Column Number:");
                column = input.nextInt();
                System.out.print("Character:");
                String gameCharacter = input.next();
                boolean check = checkIt(row, column, gameCharacter, sosGame.gameBoard);

                while (!(check)) {


                    System.out.print("Row Number:");
                    row = input.nextInt();

                    System.out.print("Column Number:");
                    column = input.nextInt();
                    System.out.print("Character:");
                    gameCharacter = input.next();
                    check = checkIt(row, column, gameCharacter, sosGame.gameBoard);

                }


                Score(row, column, player1, gameBoard);


            } else {

                //Bilgisayara ait random row ve cols değerler buraya gelecek ve score hesaplanacak

                Score(row, column, player2, sosGame.gameBoard);

            }

        }

    }

    public boolean checkIt(int row, int column, String gameCharacter, String[][] gameBoard) {

        if ((row >= gameBoard.length || column >= gameBoard.length) || (row < 0 && column < 0)) {
            System.out.println("Warning:Check the row and column values.Please again enter the values");
            return false;
        }

        if (!(gameCharacter.equals("S") || gameCharacter.equals("O"))) {
            System.out.println("Warning:Unknown Character.Please again enter the values");
            return false;
        }

        if (gameBoard[row][column].equals("S") || gameBoard[row][column].equals("O")) {
            System.out.println("Warning:You cannot place the character in this field.Please again enter the values");
            return false;
        }

        gameBoard[row][column] = gameCharacter;


        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j] + "\t");
            }
            System.out.println("");
        }

        return true;

    }

    public void Score(int row, int column, Player player1, String[][] gameBoard) {


        float mid = gameBoard.length / 2;

        if (row < mid && column < mid) {

            if (gameBoard[row + 1][column].equals("O") && gameBoard[row + 2][column].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row + 1][column + 1].equals("O") && gameBoard[row + 2][column + 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row][column + 1].equals("O") && gameBoard[row][column + 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            }


        }

        if (row < mid && column > mid) {

            if (gameBoard[row + 1][column].equals("O") && gameBoard[row + 2][column].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row + 1][column - 1].equals("O") && gameBoard[row + 2][column - 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row][column - 1].equals("O") && gameBoard[row][column - 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            }


        }

        if (row > mid && column < mid) {

            if (gameBoard[row - 1][column].equals("O") && gameBoard[row - 2][column].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row - 1][column + 1].equals("O") && gameBoard[row - 2][column + 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row][column + 1].equals("O") && gameBoard[row][column + 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            }
        }


        if (row > mid && column > mid) {

            if (gameBoard[row - 1][column].equals("O") && gameBoard[row - 2][column].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row - 1][column - 1].equals("O") && gameBoard[row - 2][column - 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            } else if (gameBoard[row][column - 1].equals("O") && gameBoard[row][column - 2].equals("S")) {
                player1.setScore(1);
                System.out.println(player1.getScore());
                return;
            }


        }

//1
        if (row == Math.round(mid) && column < mid) {

            if (gameBoard.length - row > 2) {
                if (gameBoard[row - 1][column].equals("O") && gameBoard[row - 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row - 1][column + 1].equals("O") && gameBoard[row - 2][column + 1].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row][column + 1].equals("O") && gameBoard[row][column + 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row + 1][column + 1].equals("O") && gameBoard[row + 2][column + 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row + 1][column].equals("O") && gameBoard[row + 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }
            } else {
                if (gameBoard[row][column + 1].equals("O") && gameBoard[row][column + 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }

            }


        }
//2
        if (column == Math.round(mid) && row > mid) {

            if (gameBoard.length - column > 2) {
                if (gameBoard[row][column - 1].equals("O") && gameBoard[row][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row - 1][column - 1].equals("O") && gameBoard[row - 2][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row - 1][column].equals("O") && gameBoard[row - 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row - 1][column + 1].equals("O") && gameBoard[row - 2][column + 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row][column + 1].equals("O") && gameBoard[row][column + 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }
            } else {
                if (gameBoard[row - 1][column].equals("O") && gameBoard[row - 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }

            }


        }

        //3

        if (row == Math.round(mid) && column > mid) {

            if (gameBoard.length - row > 2) {
                if (gameBoard[row - 1][column].equals("O") && gameBoard[row - 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row - 1][column - 1].equals("O") && gameBoard[row - 2][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row][column - 1].equals("O") && gameBoard[row][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row + 1][column - 1].equals("O") && gameBoard[row + 2][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row + 1][column].equals("O") && gameBoard[row + 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }
            } else {
                if (gameBoard[row][column - 1].equals("O") && gameBoard[row][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }

            }


        }

        //4
        if (row == Math.round(mid) && column > mid) {

            if (gameBoard.length - column > 2) {
                if (gameBoard[row][column - 1].equals("O") && gameBoard[row][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row + 1][column - 1].equals("O") && gameBoard[row + 2][column - 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row + 1][column].equals("O") && gameBoard[row + 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row + 1][column + 1].equals("O") && gameBoard[row + 2][column + 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                } else if (gameBoard[row][column + 1].equals("O") && gameBoard[row][column + 2].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }
            } else {
                if (gameBoard[row + 1][column].equals("O") && gameBoard[row + 2][column].equals("S")) {
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }

            }


        }
//5
        if (row == Math.round(mid) && column == Math.round(mid)) {

            if (gameBoard.length - column > 2) {

                if(gameBoard[row][column - 1].equals("O") && gameBoard[row][column - 2].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }else if(gameBoard[row - 1][column - 1].equals("O") && gameBoard[row - 2][column - 2].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }else if(gameBoard[row - 1][column ].equals("O") && gameBoard[row - 2][column].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }else if(gameBoard[row - 1][column + 1].equals("O") && gameBoard[row - 2][column + 2].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }else if(gameBoard[row ][column + 1].equals("O") && gameBoard[row ][column + 2].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }else if(gameBoard[row + 1][column + 1].equals("O") && gameBoard[row + 2][column + 2].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }else if(gameBoard[row - 1][column ].equals("O") && gameBoard[row - 2][column].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }else if(gameBoard[row + 1][column - 1].equals("O") && gameBoard[row + 2][column - 2].equals("S")){
                    player1.setScore(1);
                    System.out.println(player1.getScore());
                    return;
                }


            }


            System.out.println("Player1:" + player1.getScore());

        }

    }
}



