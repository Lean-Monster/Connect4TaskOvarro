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

    public void displayBoard(){
        for (int r = 0; r < rows; r++){
            System.out.print("|");
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == null){
                    System.out.print("  |");
                }
                else if (grid[r][c] == "1"){
                    System.out.print("R  |");
                }
                else if (grid[r][c] == "2"){
                    System.out.print("C  |");
                }
            }
            System.out.println();
        }
        for (int col = 0; col < cols; col++){
            System.out.print("  " + (col + 1));
        }
        System.out.println();
    }
}
