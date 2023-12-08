import java.util.Random;

public class GridMapExampleCLI {
    private static final int ROWS = 16;
    private static final int COLS = 60;
    private static final int MIN_TAXIS = 6;
    private static final int MAX_TAXIS = 15;

    private char[][] grid;

    public GridMapExampleCLI() {
        grid = new char[ROWS][COLS];
        initializeGrid();
    }

    private void initializeGrid() {
        // Fill the grid with roads ('.')
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = '.';
            }
        }

        // Add houses ('H')
        int[] rowsToSetHouse = {0, 1, 2, 13, 14, 15};
        for (int row : rowsToSetHouse) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = 'H';
            }
        }

        // Add existing columns with taxis ('T')
        int[][] columnsToSetTaxi = {{0, 1, 2, 3, 56, 57, 58, 59}};
        for (int colIndex : columnsToSetTaxi[0]) {
            for (int rowIndex = 0; rowIndex < ROWS; rowIndex++) {
                if (colIndex < COLS) {
                    grid[rowIndex][colIndex] = 'H';
                }
            }
        }

        // Add random number of additional taxis
        Random random = new Random();
        int numberOfTaxis = MIN_TAXIS + random.nextInt(MAX_TAXIS - MIN_TAXIS + 1);
        for (int i = 0; i < numberOfTaxis; i++) {
            int randomRow = random.nextInt(ROWS);
            int randomCol = random.nextInt(COLS);
            if (grid[randomRow][randomCol] != 'H') {
                grid[randomRow][randomCol] = 'T';
            } else {
                i--; // Try again for a different empty cell
            }
        }
    }


    private void printGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GridMapExampleCLI example = new GridMapExampleCLI();
        example.printGrid();
    }
}
