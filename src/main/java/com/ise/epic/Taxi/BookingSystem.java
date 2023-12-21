package com.ise.epic.Taxi;

import com.ise.epic.Map.GridMapExampleCLI;
import com.ise.epic.Map.Graph;
import com.ise.epic.Map.Node;
import com.ise.epic.Taxi.Taxi;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookingSystem {
    public static void main(String[] args) {
        List<Taxi> taxis = loadTaxisFromCSV();
        Graph graph = Graph.loadGraphFromJson("Graph.json");

        GridMapExampleCLI mapExample = new GridMapExampleCLI();
        mapExample.placeTaxisOnMap(taxis);
        mapExample.printGrid();

        Scanner scanner = new Scanner(System.in);

        // Step 1: User picks a destination
        System.out.println("Available destinations:");
        for (Node node : graph.getNodes()) {
            System.out.println(node.getName());
        }
        System.out.print("Pick a destination: ");
        String destinationName = scanner.next();
        Node destination = graph.getNode(destinationName);

        // Step 2: User picks a pickup location
        System.out.println("Available pickup locations:");
        for (Node node : graph.getNodes()) {
            System.out.println(node.getName());
        }
        System.out.print("Pick a pickup location: ");
        String pickupName = scanner.next();
        Node pickup = graph.getNode(pickupName);

        // Step 3: User picks a taxi type
        System.out.println("Available taxi types: Reg, XL, Luxury");
        System.out.print("Pick a taxi type: ");
        String taxiType = scanner.next();

        // Step 4: Map scans for nearby taxis and shows available options
        Set<Taxi> availableTaxis = mapExample.getAvailableTaxis(pickup, graph);
        System.out.println("Available Taxis:");
        for (Taxi taxi : availableTaxis) {
            System.out.println("Taxi ID: " + taxi.getTaxiId() + ", Type: " + taxiType);
        }

        // Step 5: User picks a taxi
        System.out.print("Pick a taxi (enter Taxi ID): ");
        String taxiId = scanner.next();
        Taxi selectedTaxi = findTaxiById(taxiId, availableTaxis);

        // Step 6: Taxi travels to pickup node
        System.out.println("Taxi is on the way to pick you up...");

        // Step 7: Taxi picks up user and brings to the destination node
        System.out.println("Taxi is picking you up...");
        System.out.println("You are now on the way to your destination...");

        // Step 8: User is asked to drop a rating between 1 and 5 stars
        System.out.print("Rate your experience (1 to 5 stars): ");
        int rating = scanner.nextInt();
        System.out.println("Thank you for using our service! Your rating: " + rating);
    }

    private static List<Taxi> loadTaxisFromCSV() {
        // Implement this method to load taxis from CSV
        return null; // Placeholder, modify as needed
    }

    private static Taxi findTaxiById(String taxiId, Set<Taxi> availableTaxis) {
        for (Taxi taxi : availableTaxis) {
            if (taxi.getTaxiId().equals(taxiId)) {
                return taxi;
            }
        }
        return null; // Taxi not found, handle accordingly
    }
}