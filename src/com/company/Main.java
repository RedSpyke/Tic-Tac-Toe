package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean closeProgram = false;
        int choice;

        while (!closeProgram) {
            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()) {
                System.out.println("Wrong input data!");
                input.next();
                System.out.println("Enter your choice: ");
            }
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:      // Start new game

                    break;   // Quit game
                case 1:

                    break;
                default:
                    System.out.println("Invalid option!");
                    break;

            }
        }

        boolean gameOver = false;
        boolean player1Turn = false;
        boolean player2Turn = false;



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



        while (!gameOver){
            // print the board
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
            // next turn





            // check if game is over
            gameOver = true;


            if(gameOver){
                System.out.println("!!! Game over !!!");
            }

        }

    }
}
