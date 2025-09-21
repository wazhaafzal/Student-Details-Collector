package dao;

import model.Payment;
import java.sql.*;

public class PaymentDAO {
    public void addPayment(int studentId, double fee, boolean status) {
        String sql = "INSERT INTO payments(studentId, fee, status) VALUES(?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setDouble(2, fee);
            ps.setBoolean(3, status);
            ps.executeUpdate();
            System.out.println("✅ Payment recorded.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Payment getPayment(int studentId) {
        String sql = "SELECT * FROM payments WHERE studentId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Payment(
                    "N/A", 0, "N/A", "N/A", "N/A", "N/A",
                    rs.getDouble("fee"), rs.getBoolean("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
