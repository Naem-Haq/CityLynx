package main.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private static final String CSV_FILE_PATH = "User.csv";

    public static boolean authenticateUser(String username, String password) {
        List<User> users = readUsersFromCSV();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }

        System.out.println("Invalid username or password.");
        return false;
    }

    private static List<User> readUsersFromCSV() {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String username = data[0].trim();
                    String password = data[1].trim();
                    users.add(new User(username, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
