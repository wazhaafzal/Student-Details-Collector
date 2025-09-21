package service;

import dao.StudentDAO;
import dao.ResultDAO;
import dao.PaymentDAO;
import model.Student;
import model.Result;
import model.Payment;
import java.util.List;

public class AdminService {
    private StudentDAO studentDAO = new StudentDAO();
    private ResultDAO resultDAO = new ResultDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public List<Student> viewAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void addResult(int studentId, double percentage, String grade) {
        resultDAO.addResult(studentId, percentage, grade);
    }

    public void addPayment(int studentId, double fee, boolean status) {
        paymentDAO.addPayment(studentId, fee, status);
    }
}
