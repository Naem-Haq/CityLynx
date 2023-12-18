package com.ise.epic.Map;

import com.ise.epic.Taxi.Taxi;

import java.util.List;
import java.util.Random;

public class GridMapExampleCLI {
    private static final int ROWS = 16;
    private static final int COLS = 60;

    private char[][] grid;

    public GridMapExampleCLI() {
        grid = new char[ROWS][COLS];
        initializeGrid();
    }

    public void placeTaxisOnMap(List<Taxi> taxis) {
        for (Taxi taxi : taxis) {
            Random random = new Random();
            int randomRow, randomCol;
            do {
                randomRow = random.nextInt(ROWS);
                randomCol = random.nextInt(COLS);
            } while (grid[randomRow][randomCol] != '.');
            grid[randomRow][randomCol] = 'T';
            // Set taxi location
            taxi.setLocation(randomRow, randomCol);
        }
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
    }

    public void printGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}
