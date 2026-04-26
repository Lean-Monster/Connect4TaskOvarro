package LucaVozzolo.Connect4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Connect4!");//simple start menu to set out grid size and win condition
        System.out.println("Enter the number of rows in the grid: ");
        int rows = inputValidator(sc);
        System.out.println("Enter the number of columns in the grid: ");
        int columns = inputValidator(sc);
        System.out.println("Enter the winning row length: ");
        int winningRowLength = inputValidator(sc);
        Game game = new Game(rows, columns, winningRowLength); //creates game object with all specifications
        game.playGame(); //object method to start game
        sc.close();
    }

    public static int inputValidator(Scanner sc){ //validates the inputs in one function
        while (true){
            try{
                int value = sc.nextInt();
                if (value > 0){
                    return value;
                }
                System.out.println("Please enter a valid grid number.");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                sc.next();
            }
        }

    }
}