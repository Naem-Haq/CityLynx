package main.User;

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
