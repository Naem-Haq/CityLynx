package User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Signup {
    private static final String CSV_FILE_PATH = "User.csv";

    public static void addUser(String username, String password) {
        try {
            FileWriter csvWriter = new FileWriter(CSV_FILE_PATH, true);
            csvWriter.append(username);
            csvWriter.append(",");
            csvWriter.append(password);
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
            System.out.println("User registered successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
