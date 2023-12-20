package com.ise.epic.User;

import com.ise.epic.Taxi.RegTaxi;
import com.ise.epic.Taxi.Taxi;
import com.ise.epic.Taxi.XLTaxi;
import com.ise.epic.Taxi.LuxuryTaxi;
import com.ise.epic.DataStructures.ArrayListImplementation;

import java.util.List;
import java.util.Scanner;

public class Manager {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static boolean isAdmin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public static void handleAdminOptions(List<Taxi> taxis) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Sign Out");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addVehicle(taxis);
                    break;
                case 2:
                    removeVehicle(taxis);
                    break;
                case 3:
                    System.out.println("Signing out as admin.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addVehicle(List<Taxi> taxis) {
        // Implement logic to add a vehicle to the list (taxis) or update the CSV file
        // For example:
        taxis.add(new RegTaxi("NewTaxi"));
        System.out.println("Vehicle added successfully!");
    }

    private static void removeVehicle(List<Taxi> taxis) {
        // Implement logic to remove a vehicle from the list (taxis) or update the CSV file
        // For example:
        if (!taxis.isEmpty()) {
            taxis.remove(0); // Remove the first taxi as an example
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("No vehicles to remove.");
        }
    }
}
