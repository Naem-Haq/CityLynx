package main.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Signup {
    private List<User> users;

    public Signup(List<User> users) {
        this.users = users;
    }

    public void register(String username, String password) {
        users.add(new Passenger(username, password));
        saveToCSV();
    }

    private void saveToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.csv"))) {
            for (User user : users) {
                writer.println(user.username + "," + user.password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
