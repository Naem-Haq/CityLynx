package com.ise.epic;

import com.ise.epic.Map.GridMapExampleCLI;
import com.ise.epic.Map.Node;
import com.ise.epic.Taxi.*;
import com.ise.epic.User.Login;
import com.ise.epic.User.Signup;
import com.ise.epic.User.User;
import com.ise.epic.DataStructures.ArrayListImplementation;
import static com.ise.epic.User.Login.loadUsersFromCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<User> users = loadUsersFromCSV();
        List<Taxi> taxis = loadTaxisFromCSV();

        Login login = new Login(users);
        Signup signup = new Signup(users);

        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Thanking you for choosing CityLynx. Please choose the following:");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.next();

                    if (login.authenticate(loginUsername, loginPassword)) {
                        System.out.println("Login successful!");

                        // Display the map after successful login
                        GridMapExampleCLI mapExample = new GridMapExampleCLI();
                        mapExample.placeTaxisOnMap(taxis);
                        mapExample.printGrid();

                        handleUserInteraction(scanner, mapExample, taxis);

                        loggedIn = true; // Set the flag to exit the loop after successful login
                    } else {
                        System.out.println("Invalid username or password");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String signupUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String signupPassword = scanner.next();

                    signup.register(signupUsername, signupPassword);
                    System.out.println("Signup successful!");
                    break;

                case 3:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void handleUserInteraction(Scanner scanner, GridMapExampleCLI mapExample, List<Taxi> taxis) {
        System.out.print("Enter destination node: ");
        String destinationNodeName = scanner.next();

        // Find the destination node in the map
        Node destinationNode = mapExample.findNodeByName(destinationNodeName);

        // Prompt user for pickup node (assuming you have a method to find nodes by name)
        System.out.print("Enter pickup node: ");
        String pickupNodeName = scanner.next();
        Node pickupNode = mapExample.findNodeByName(pickupNodeName);

        // Prompt user for taxi type
        System.out.print("Enter taxi type (reg, xl, luxury): ");
        String taxiType = scanner.next();

        // Find available taxis of the specified type
        List<Taxi> availableTaxis = findAvailableTaxis(taxis, taxiType);

        if (availableTaxis.isEmpty()) {
            System.out.println("No available taxis of the specified type.");
            return;
        }

        // Display available taxis
        System.out.println("Available Taxis:");
        for (int i = 0; i < availableTaxis.size(); i++) {
            System.out.println((i + 1) + ". " + availableTaxis.get(i).getTaxiId());
        }

        // Prompt user to choose a taxi
        System.out.print("Choose a taxi (enter the number): ");
        int taxiChoice = scanner.nextInt();

        if (taxiChoice < 1 || taxiChoice > availableTaxis.size()) {
            System.out.println("Invalid taxi choice.");
            return;
        }

        // Book the selected taxi
        Taxi selectedTaxi = availableTaxis.get(taxiChoice - 1);
        System.out.println("Booking taxi: " + selectedTaxi.getTaxiId());

        // Move the taxi to the pickup node
        TaxiMovement.moveTaxi(selectedTaxi, pickupNode, mapExample);

        // Move the taxi to the destination node
        TaxiMovement.moveTaxi(selectedTaxi, destinationNode, mapExample);

        // Display the updated map
        mapExample.printGrid();
    }

    private static List<Taxi> findAvailableTaxis(List<Taxi> allTaxis, String taxiType) {
        List<Taxi> availableTaxis = new ArrayListImplementation<>();
        for (Taxi taxi : allTaxis) {
            if (taxi.getClass().getSimpleName().equalsIgnoreCase(taxiType)) {
                availableTaxis.add(taxi);
            }
        }
        return availableTaxis;
    }


    private static List<Taxi> loadTaxisFromCSV() {
        List<Taxi> taxis = new ArrayListImplementation<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/Drivers.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String driverId = parts[0];
                    String name = parts[1];
                    String taxiType = parts[2];

                    Taxi taxi;
                    switch (taxiType.toLowerCase()) {
                        case "reg":
                            taxi = new RegTaxi(driverId);
                            break;
                        case "xl":
                            taxi = new XLTaxi(driverId);
                            break;
                        case "luxury":
                            taxi = new LuxuryTaxi(driverId);
                            break;
                        default:
                            // Handle invalid taxi type
                            continue;
                    }
                    taxis.add(taxi);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taxis;
    }
}
