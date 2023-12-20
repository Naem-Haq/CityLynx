package com.ise.epic.Map;

import com.ise.epic.Taxi.Taxi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GridMapExampleCLI {
    private static final int ROWS = 16;
    private static final int COLS = 60;

    private char[][] grid;
    private Set<Taxi> available;

    public GridMapExampleCLI() {
        grid = new char[ROWS][COLS];
        initializeGrid();
    }

    public void placeTaxisOnMap(List<Taxi> taxis) {
        if (taxis != null) {
            for (Taxi taxi : taxis) {
                placeTaxiOnMap(taxi);
            }
        } else {
            System.out.println("Error: The taxis are unavailable.");
            // You might want to handle this error appropriately based on your application's requirements.
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
        try (FileReader reader = new FileReader("src/main/java/com/ise/epic/Map/Map")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTaxiLocations(List<Taxi> taxis) {
        initializeGrid(); // Reset the grid to clear previous taxi positions
        placeTaxisOnMap(taxis); // Place taxis on the updated grid
        printGrid(); // Print the updated map with taxis
    }

    public Set<Taxi> getAvailableTaxis(Node pickup, Graph graph, List<Taxi> allTaxis) {
        Set<Taxi> availableTaxis = new HashSet<>();

        for (Taxi taxi : allTaxis) {
            if (taxi.isAvailable()) {
                availableTaxis.add(taxi);
            }
        }

        return availableTaxis;
    }


    public void placeTaxiOnMap(Taxi taxi, int destinationRow, int destinationCol) {
    }

    public Node findNodeByName(String destinationNodeName) {
        return null;
    }

    public Set<Taxi> getAvailableTaxis(Node pickup, Graph graph) {
        return available;
    }
}
