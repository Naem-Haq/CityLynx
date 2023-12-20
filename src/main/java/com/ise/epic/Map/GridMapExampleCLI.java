package com.ise.epic.Map;

import com.ise.epic.Taxi.Taxi;

import java.util.List;
import java.util.Random;
import java.util.Set;

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
            placeTaxiOnMap(taxi);
        }
    }

    public void placeTaxiOnMap(Taxi taxi) {
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

    public void clearGridLocation(int row, int col) {
        grid[row][col] = '.';
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

    public Set<Taxi> getAvailableTaxis(Node pickup, Graph graph) {
        Set<Taxi> o = null;
        return o;
    }

    public void placeTaxiOnMap(Taxi taxi, int destinationRow, int destinationCol) {
    }

    public Node findNodeByName(String destinationNodeName) {
        return null;
    }
}
