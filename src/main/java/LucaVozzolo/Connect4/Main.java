package LucaVozzolo.Connect4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Connect4!");
        System.out.println("Enter the number of rows in the grid: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns in the grid: ");
        int columns = sc.nextInt();
        System.out.println("Enter the winning row length: ");
        int winningRowLength = sc.nextInt();
    }
}