package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(id, name, age, address, phone, className, branch, password) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setString(6, student.getClassName());
            ps.setString(7, student.getBranch());
            ps.setString(8, student.getPassword());
            ps.executeUpdate();
            System.out.println("✅ Student added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(int id, String password) {
        String sql = "SELECT * FROM students WHERE id=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("className"),
                    rs.getString("branch"),
                    rs.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("className"),
                    rs.getString("branch"),
                    rs.getString("password")
                );
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
