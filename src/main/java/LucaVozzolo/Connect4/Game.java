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
            int chosenColumn = columnInputCheck(sc);
            boolean placeCheck = board.checkMove(chosenColumn);
            if (!placeCheck){
                System.out.println("Column " + chosenColumn + " is full! Please select another one!");
                continue;
            }
            int chosenRow = board.placeMove(chosenColumn,playerTurn);
            if (playerTurn == 1){
                playerTurn = 2;
            }
            else{
                playerTurn = 1;
            }
        }


    }
     //function takes players column input and checks if it is valid before returning it to the variable
    public int columnInputCheck(Scanner sc){
        while(true){ //loop until acceptable input
            System.out.println("Enter column (1 to " + (board.getCols()) + ") to place a token: ");
            try{
                int chosenColumn = (sc.nextInt())-1;
                System.out.println(chosenColumn);
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
