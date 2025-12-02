1	import java.sql.*;
2	import java.util.Scanner;
3	
4	public class VulnerableApp {
5	
6	    public static void main(String[] args) {
7	        System.out.print("Enter email to search: ");
8	        String email = args[0];
9	
10	        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
11	             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE email = ?")) {
12	
13	            // Secure SQL statement using PreparedStatement
14	            pstmt.setString(1, email);
15	            ResultSet rs = pstmt.executeQuery();
16	
17	            while (rs.next()) {
18	                System.out.println("User: " + rs.getString("name") + " - " + rs.getString("email"));
19	            }
20	
21	        } catch (SQLException e) {
22	            e.printStackTrace();
23	        }
24	    }
25	}