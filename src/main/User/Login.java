package main.User;
import java.util.List;

public class Login {
    private List<User> users;

    public Login(List<User> users) {
        this.users = users;
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
