CREATE DATABASE studentdb;
USE studentdb;

-- Students table
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    address VARCHAR(200),
    phone VARCHAR(20),
    className VARCHAR(50),
    branch VARCHAR(50),
    password VARCHAR(50)
);

-- Results table
CREATE TABLE results (
    resultId INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT,
    percentage DOUBLE,
    grade VARCHAR(5),
    FOREIGN KEY (studentId) REFERENCES students(id)
);

-- Payments table
CREATE TABLE payments (
    paymentId INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT,
    fee DOUBLE,
    status BOOLEAN,
    FOREIGN KEY (studentId) REFERENCES students(id)
);
