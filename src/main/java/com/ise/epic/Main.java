package com.ise.epic;

import com.ise.epic.Map.GridMapExampleCLI;
import com.ise.epic.Taxi.*;
import com.ise.epic.User.Login;
import com.ise.epic.User.Signup;
import com.ise.epic.User.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    private static List<User> loadUsersFromCSV() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static List<Taxi> loadTaxisFromCSV() {
        List<Taxi> taxis = new ArrayList<>();
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
