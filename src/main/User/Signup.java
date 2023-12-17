package main.User;

import java.util.List;
import java.util.Scanner;

public class Signup {
    private List<User> users;

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
