package com.ise.epic.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Signup {
    private List<User> users;
    private static final String USER_FILE_PATH = "users.csv"; // Path to the CSV file

    public Signup(List<User> users) {
        this.users = users;
    }

    public void register(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose a different one.");
                return;
            }
        }

        // If username is unique, add the new user
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("User registration successful!");

        // Update the CSV file
        updateCsvFile();
    }

    private void updateCsvFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE_PATH, true))) {
            // Append the new user information to the CSV file
            User newUser = users.get(users.size() - 1);
            writer.println(newUser.getUsername() + "," + newUser.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error updating the CSV file.");
        }
    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new username: ");
        String username = scanner.next();
        System.out.print("Enter new password: ");
        String password = scanner.next();

        register(username, password);
    }
}
