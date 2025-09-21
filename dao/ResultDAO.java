package dao;

import model.Result;
import java.sql.*;

public class ResultDAO {
    public void addResult(int studentId, double percentage, String grade) {
        String sql = "INSERT INTO results(studentId, percentage, grade) VALUES(?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setDouble(2, percentage);
            ps.setString(3, grade);
            ps.executeUpdate();
            System.out.println("✅ Result added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Result getResult(int studentId) {
        String sql = "SELECT * FROM results WHERE studentId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Result(rs.getDouble("percentage"), rs.getString("grade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
