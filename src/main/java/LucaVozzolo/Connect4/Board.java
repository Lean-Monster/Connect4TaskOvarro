package LucaVozzolo.Connect4;

public class Board {
    private int rows;
    private int cols;
    private String[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new String[rows][cols];
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public String getGridPos(int row,int column){ //returns token at grid position
        return grid[row][column];
    }

    public void displayBoard(){//method to display the board
        for (int r = 0; r < rows; r++){
            System.out.print("|");
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == null){
                    System.out.print("   |");
                }
                else if (grid[r][c] == "1"){
                    System.out.print(" R |");
                }
                else if (grid[r][c] == "2"){
                    System.out.print(" Y |");
                }
            }
            System.out.println();
        }
        System.out.print("  1" );
        for (int col = 1; col < cols; col++){
            System.out.print("   " + (col + 1));
        }
        System.out.println();
    }

    public boolean checkMove(int column){ //check if token can fit into the grid
        if (grid[0][column] != null){ //checks to see if the column is full first
            return false;
        }
        return true;
    }

    public int placeMove(int column,int playerTurn){
        for (int r = (rows-1); r >=1; r--){ //loop to check first available slot in column starting from the bottom
            if (grid[r][column] == null & playerTurn == 1){
                grid[r][column] = "1";
                return r;
            }
            else if (grid[r][column] == null & playerTurn == 2){
                grid[r][column] = "2";
                return r;
            }
        }
        return -1;
    }

    public boolean isBoardFull(){
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == null){
                    return false;
                }
            }
        }
        return true;
    }
}
