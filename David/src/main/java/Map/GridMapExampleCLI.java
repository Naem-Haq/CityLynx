package Map;
public class GridMapExampleCLI {
    private static final int ROWS = 16;
    private static final int COLS = 60;
    private boolean[][] grid;
    public GridMapExampleCLI() {
        grid = new boolean[ROWS][COLS];
        initializeGrid();
    }
    private void initializeGrid() {
        //grid[1][1] = true;
        //grid[2][2] = true;
        //grid[3][3] = true;
        int[] rowsToSetLive = {0,1,2,13,14,15};
        for (int row : rowsToSetLive) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = true;
            }
        }
        int[][] columnsToSetLive = {{0,1,2,3,56,57,58,59}};
        for (int colIndex : columnsToSetLive[0]) {
            for (int rowIndex = 0; rowIndex < ROWS; rowIndex++) {
                if (colIndex < COLS) {
                    grid[rowIndex][colIndex] = true;
                }
            }
        }
    }
    private void printGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(grid[row][col] ? "H " : ". ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GridMapExampleCLI example = new GridMapExampleCLI();
        example.printGrid();
    }
}
