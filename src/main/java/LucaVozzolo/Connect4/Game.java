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

    public void playGame(){//method which acts as the main game loop
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
            int chosenRow = board.placeMove(chosenColumn,playerTurn); //places move while also storing row it was placed on if needed
            if (checkWin(playerTurn)){ //checks and finishes game
                board.displayBoard();
                System.out.println("Player " + playerTurn + " has won!");
                break;
            }
            if (board.isBoardFull()){ //draw check
                board.displayBoard();
                System.out.println("It is a draw!");
                break;
            }
            if (playerTurn == 1){ //switches player turn
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

    public boolean checkWin(int playerTurn){
        String token = "-1";
        if (playerTurn == 1){ //sets token to current players tokens in the grid to check against
            token = "1";
        }
        else if (playerTurn == 2){
            token = "2";
        }
        return checkHorizontal(token) || checkVertical(token) || checkDiagonal(token);//checks each possible win condition
    }

    public boolean checkHorizontal(String token){ //goes through each grid pos checking for players token
        int count = 0;
        for (int row = 0; row < board.getRows(); row++){
            for (int col = 0; col < board.getCols(); col++){
                if (token == board.getGridPos(row,col)){
                    count++; //adds 1 to the count when current players token is found
                }
                else{
                    count = 0;//resets if next token isn't current players
                }
                if (count >= winLength){ //checks if highest streak is equal to or greater than the win condition
                    return true;
                }
            }

        }
        return false;
    }

    public boolean checkVertical(String token){ //same thing as horizontal check but goes through vertically
        int count = 0;
        for (int col = 0; col < board.getCols(); col++){
            for (int row = 0; row < board.getRows(); row++){
                if (token == board.getGridPos(row,col)){
                    count++;
                }
                else{
                    count = 0;
                }
                if (count >= winLength){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonal(String token){
        for (int row = 0; row < board.getRows(); row++){
            for (int col = 0; col < board.getCols(); col++){
                if (countDirection(row,col,token,1,1) >= winLength){//checks top left to bottom right using the row and col direction
                    return true;
                }
                if (countDirection(row,col,token,1,-1) >= winLength){//checks top right to bottom left on this one
                    return true;
                }
            }
        }
        return false;
    }

    public int countDirection(int startRow, int startCol, String token, int rowDirection, int colDirection){//function for counting in set directions(diaganolly)
        int count = 0;
        int row = startRow;
        int col = startCol;
        while (row >= 0 && row <board.getRows() && col >= 0 && col <board.getCols() && board.getGridPos(row,col) == token){//checks if within grid and matches current player token
            count++;
            row += rowDirection; //increases direction so it can move diagonally
            col += colDirection;
        }
        return count;
    }
}
