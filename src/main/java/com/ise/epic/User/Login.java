package com.ise.epic.User;

import com.ise.epic.DataStructures.ArrayListImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Login {
    private List<User> users;

    public Login(List<User> users) {
        this.users = users;
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static List<User> loadUsersFromCSV() {
        List<User> users = new ArrayListImplementation<>();
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

    public void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (authenticate(username, password)) {
            System.out.println("Login successful!");
            // Additional logic if needed after successful login
        } else {
            System.out.println("Invalid username or password");
        }
    }
}
