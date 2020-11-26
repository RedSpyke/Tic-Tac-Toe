package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean closeProgram = false;
        int choice;

        while (!closeProgram) {
            System.out.println();
            System.out.println("\t### Tic-Tac-Toe ###");
            System.out.println();
            System.out.println("Press 1 - New game");
            System.out.println("Press 2 - Exit game");
            System.out.println();

            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()) {
                System.out.println("Wrong input data!");
                input.next();
                System.out.println("Enter your choice: ");
            }
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:      // Start new game
                    newGame();
                    break;
                case 2:      // Quit game
                    closeProgram = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public static void newGame(){
        boolean gameOver = false;

        System.out.println("Who goes first ?  X or O ");
        boolean playerXTurn = false;
        boolean playerOTurn = false;
        char choice = input.next().charAt(0);

        switch (choice){
            case 'x':
                playerXTurn = true;
                break;
            case 'X':
                playerXTurn = true;
                break;
            case 'o':
                playerOTurn = true;
                break;
            case'O':
                playerOTurn = true;
                break;
            default:
                System.out.println("Invalid option!");
                newGame();
                break;
        }

        if(playerXTurn){
            System.out.println("Player X starts the game !");
        }
        else {
            System.out.println("Player O starts the game ! ");
        }
        char [][] matrix = {

//                0   1  (2)  3   4  5   (6)  7  8   9   10  (11)  12  13
                {'-','-','-','-','-','-','-','-','-','-','-','-','-','-'},   // 0
                {'|',' ',' ',' ', '|',' ',' ',' ','|',' ',' ',' ','|'},  // 1
                {'|','-','-','-','*','-','-','-','*','-','-','-','|'},   // 2
                {'|',' ',' ',' ', '|',' ',' ',' ','|',' ',' ',' ','|'},  // 3
                {'|','-','-','-','*','-','-','-','*','-','-','-','|'},   // 4
                {'|',' ',' ',' ', '|',' ',' ',' ','|',' ',' ',' ','|'},  // 5
                {'-','-','-','-','-','-','-','-','-','-','-','-','-','-'}  // 6
        };
        // 1                            2                            3
        matrix [1][2] = '_';         matrix [1][6] = '_';        matrix [1][10] = '_';
        // 4                            5                            6
        matrix [3][2] = '_';         matrix [3][6] = '_';        matrix [3][10] = '_';
        // 7                            8                            9
        matrix [5][2] = '_';         matrix [5][6] = '_';        matrix [5][10] = '_';

        int turns = 0; // turns
        int spaceOption = 0;
        int [] previousOptions = new int[9];
        while (!gameOver){
            // print the board
            for (char[] chars : matrix) {
                for (char aChar : chars) {
                    System.out.print(aChar);
                }
                System.out.println();
            }

            System.out.println("1 , 2 , 3");
            System.out.println("4 , 5 , 6");
            System.out.println("7 , 8 , 9");

            if(playerXTurn){
                System.out.println("Player X turn");
            }
            else {
                System.out.println("Player O turn");
            }

            // check if the option is valid
            boolean validOption = false;
            while (!validOption){
                System.out.print("Enter your choice: ");
                while (!input.hasNextInt()){
                    System.out.println("Wrong input data!");
                    input.next();
                    System.out.println("Enter your choice: ");
                }
                spaceOption  = input.nextInt();

                if(spaceOption < 0 || spaceOption > 9){
                    System.out.println("Invalid option");
                } else{
                    for (int i = 0; i < previousOptions.length; i++) {
                        if(spaceOption == previousOptions[i]){
                            System.out.println("Invalid option");
                            break;
                        }
                        if(i == previousOptions.length - 1){
                            validOption = true;
                        }
                    }
                }
            }
            previousOptions[turns] = spaceOption;
            // valid option
            switch (spaceOption){
                case 1:
                    if(playerXTurn){
                        matrix [1][2] = 'X';
                    }else {
                        matrix [1][2] = 'O';
                    }
                    break;
                case 2:
                    if(playerXTurn){
                        matrix [1][6] = 'X';
                    }else {
                        matrix [1][6] = 'O';
                    }
                    break;
                case 3:
                    if(playerXTurn){
                        matrix [1][10] = 'X';
                    }else {
                        matrix [1][10] = 'O';
                    }
                    break;
                case 4:
                    if(playerXTurn){
                        matrix [3][2] = 'X';
                    }else {
                        matrix [3][2] = 'O';
                    }
                    break;
                case 5: if(playerXTurn){
                    matrix [3][6] = 'X';
                }else {
                    matrix [3][6] = 'O';
                }
                    break;
                case 6:
                    if(playerXTurn){
                        matrix [3][10] = 'X';
                    }else {
                        matrix [3][10] = 'O';
                    }
                    break;
                case 7:
                    if(playerXTurn){
                        matrix [5][2] = 'X';
                    }else {
                        matrix [5][2] = 'O';
                    }
                    break;
                case 8:
                    if(playerXTurn){
                        matrix [5][6] = 'X';
                    }else {
                        matrix [5][6] = 'O';
                    }
                    break;
                case 9:
                    if(playerXTurn){
                        matrix [5][10] = 'X';
                    }else {
                        matrix [5][10] = 'O';
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }

            // check if game is over
            if(matrix [1][2] == matrix [1][6] && matrix [1][2] == matrix [1][10] && matrix [1][2] != '_') {
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;
            }
            else if( matrix [3][2] == matrix [3][6] && matrix [3][2] == matrix [3][10] && matrix [3][2] != '_' ){
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;
            }
            else if(matrix [5][2] == matrix [5][6] && matrix [5][2] == matrix [5][10] && matrix [5][2] != '_'){
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;
            }
            else if(matrix [1][2] == matrix [3][2] && matrix [3][2] == matrix [5][2] && matrix [1][2] != '_'){
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;
            }
            else if (matrix [1][6] == matrix [3][6] && matrix [1][6] == matrix [5][6] && matrix [1][6] != '_' ){
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;

            }
            else if (matrix [1][10] == matrix [3][10] && matrix [1][10] == matrix [5][10] && matrix [1][10] != '_' ){
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;

            }
            else if (matrix [1][10] == matrix [3][6] && matrix [1][10] == matrix [5][2] && matrix [1][10] != '_'){
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;
            }
            else if( matrix [1][2] ==  matrix [3][6] && matrix [1][2] == matrix [5][10] && matrix [1][2] != '_'){
                if(playerXTurn){
                    System.out.println("Player X has won the game !");
                }
                else {
                    System.out.println("Player O has won the game ! ");
                }
                gameOver = true;
            }
            else if(turns == 8){
                System.out.println();
                System.out.println("Draw");
                System.out.println();
                // print the board
                for (char[] chars : matrix) {
                    for (char aChar : chars) {
                        System.out.print(aChar);
                    }
                    System.out.println();
                }
                gameOver = true;
            }
            else{
                System.out.println("No winner yet... ");
            }
            if(gameOver){
                System.out.println("!!! Game over !!!");
            }
            // next turn

            if(playerXTurn){
                playerXTurn = false;
                playerOTurn = true;
            } else {
                playerXTurn = true;
                playerOTurn = false;
            }
            turns++;
        }
    }

}
