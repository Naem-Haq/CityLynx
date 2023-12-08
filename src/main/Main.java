package main;

import main.Map.GridMapExampleCLI;
import main.User.Login;
import main.User.Signup;
import main.User.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> users = loadUsersFromCSV();
        Login login = new Login(users);
        Signup signup = new Signup(users);

        Scanner scanner = new Scanner(System.in);

        while (true) {
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
                        mapExample.printGrid();
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
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/users.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }

            // Print loaded users
            System.out.println("Loaded users: " + users);

        } catch (IOException e) {
            // Ignore if the file doesn't exist
        }
        return users;
    }
}
