package com.ise.epic.Taxi;

import com.ise.epic.Map.GridMapExampleCLI;
import com.ise.epic.Map.Node;

public class TaxiMovement {

    public static void moveTaxi(Taxi taxi, Node destinationNode, GridMapExampleCLI map) {
        if (taxi == null || destinationNode == null || map == null) {
            System.out.println("Invalid input. Cannot move taxi.");
            return;
        }

        // Retrieve current taxi location
        int currentRow = taxi.getLocation().getRow();
        int currentCol = taxi.getLocation().getCol();

        // Retrieve destination node location
        int destinationRow = destinationNode.getLocation().getRow();
        int destinationCol = destinationNode.getLocation().getCol();

        // Move the taxi to the destination
        map.clearGridLocation(currentRow, currentCol);
        map.placeTaxiOnMap(taxi, destinationRow, destinationCol);

        // Update taxi location
        taxi.setLocation(destinationRow, destinationCol);

        // Print the updated map
        map.printGrid();
    }
}
