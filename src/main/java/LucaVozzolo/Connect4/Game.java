package LucaVozzolo.Connect4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Board board;
    private int playerTurn;
    private int winLength;

    public Game(int rows, int cols, int winlength) {
        this.board = new Board(rows,cols);
        this.playerTurn = 1;
        this.winLength = winlength;
    }

    public void playGame(){
        Scanner sc = new Scanner(System.in);
        while(true){ //loop until someone wins or grid is full
            System.out.println("Player " + playerTurn + "'s turn: ");
            board.displayBoard();
            int chosenColumn = columnCheck(sc);
        }


    }
     //function takes players column input and checks if it is valid before returning it to the variable
    public int columnCheck(Scanner sc){
        while(true){ //loop until acceptable input
            System.out.println("Enter column (1 to " + (board.getCols()) + ") to place a token: ");
            try{
                int chosenColumn = sc.nextInt();
                if (chosenColumn < 0 || chosenColumn >= board.getCols()) {
                    System.out.println("Please enter a valid column.");
                }
                else {
                    return chosenColumn;
                }
            } catch (InputMismatchException e){
                System.out.println("Please enter a number.");
                sc.next();
            }

        }
    }
}
