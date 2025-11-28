import java.sql.*;
import java.util.Scanner;

public class VulnerableApp {

	    public static void main(String[] args) {
	        System.out.print("Enter email to search: ");
	        String email = args[0];

	        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
	             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE email = ?")) {

	            // Secure SQL statement using PreparedStatement
	            pstmt.setString(1, email);
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                System.out.println("User: " + rs.getString("name") + " - " + rs.getString("email"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}