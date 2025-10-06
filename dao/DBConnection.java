import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlAivenConnection {
    public static void main(String[] args) {
        // Aiven MySQL connection details
        String url = "jdbc:mysql://mysql-385ef263-studentdetails.e.aivencloud.com:19375/defaultdb?sslMode=REQUIRED";
        String user = "avnadmin";
        String password = "AVNS_EAAutBimpmf2XpYf-2l";

        try {
            // Load MySQL driver (optional for newer Java, but safe)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to Aiven MySQL
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to Aiven MySQL successfully!");

            // Close connection
            conn.close();
            System.out.println("✅ Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
        }
    }
}
