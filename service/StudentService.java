package service;

import dao.StudentDAO;
import dao.ResultDAO;
import dao.PaymentDAO;
import model.Student;
import model.Result;
import model.Payment;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();
    private ResultDAO resultDAO = new ResultDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();

    public Student login(int id, String password) {
        return studentDAO.getStudent(id, password);
    }

    public Result viewResult(int studentId) {
        return resultDAO.getResult(studentId);
    }

    public Payment viewPayment(int studentId) {
        return paymentDAO.getPayment(studentId);
    }
}
