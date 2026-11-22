package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtility {

    private String url;
    private String user;
    private String password;

    public DatabaseUtility(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public boolean isCustomerEmailPresent(String email) {
        String query = "SELECT email FROM oc_customer WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if a matching row exists
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}