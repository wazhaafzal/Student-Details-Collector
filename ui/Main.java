import java.util.Scanner;

// Profile Class
class Profile {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String studentClass;
    private String branch;

    public Profile(String name, int age, String address, String phone, String studentClass, String branch) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.studentClass = studentClass;
        this.branch = branch;
    }

    public void showDetails() {
        System.out.println("\n----- Student Profile -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + studentClass);
        System.out.println("Branch: " + branch);
    }
}

// Semester Class
class Semester {
    private String[] subjects;
    private double semesterFee;

    public Semester(String[] subjects, double semesterFee) {
        this.subjects = subjects;
        this.semesterFee = semesterFee;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void subjects() {
        System.out.println("\n----- Semester Subjects -----");
        for (String sub : subjects) {
            System.out.println(sub);
        }
    }

    public void showPayment() {
        System.out.println("\nSemester Fee: " + semesterFee);
    }
}

// Result Class
class Result extends Semester {
    private String[] subjectGrades;

    public Result(String[] subjects, double semesterFee, String[] subjectGrades) {
        super(subjects, semesterFee);
        this.subjectGrades = subjectGrades;
    }

    public void viewResult() {
        System.out.println("\n----- Subject-wise Grades -----");
        String[] subjects = getSubjects();
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + " : " + subjectGrades[i]);
        }
    }

    public void viewGrade() {
        double totalPoints = 0;
        for (String g : subjectGrades) {
            totalPoints += gradeToPoint(g);
        }
        double avg = totalPoints / subjectGrades.length;
        System.out.println("Overall Grade: " + pointToGrade(avg));
    }

    // Helper methods to convert grades to points and back
    private double gradeToPoint(String grade) {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0; // F or invalid
        }
    }

    private String pointToGrade(double point) {
        if (point >= 3.5) return "A";
        else if (point >= 2.5) return "B";
        else if (point >= 1.5) return "C";
        else if (point >= 0.5) return "D";
        else return "F";
    }
}

// Edit Class
class Edit extends Profile {
    private int mark;
    private String placement;

    public Edit(String name, int age, String address, String phone, String studentClass, String branch) {
        super(name, age, address, phone, studentClass, branch);
    }

    // Method overloading
    public void addDetails(String placement) {
        this.placement = placement;
        System.out.println("Placement details updated: " + placement);
    }

    public void addDetails(int mark) {
        this.mark = mark;
        System.out.println("Marks added: " + mark);
    }

    public void updateMark(int mark) {
        this.mark = mark;
        System.out.println("Marks updated to: " + mark);
    }

    public void viewEligibility() {
        if (mark >= 50) {
            System.out.println("Eligible for placement.");
        } else {
            System.out.println("Not eligible for placement.");
        }
    }
}

// Payment Class
class Payment extends Profile {
    private double fee;

    public Payment(String name, int age, String address, String phone, String studentClass, String branch, double fee) {
        super(name, age, address, phone, studentClass, branch);
        this.fee = fee;
    }

    public void viewStatus() {
        System.out.println("\nPayment completed with amount: " + fee);
    }
}

// Main Class (Driver Program)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Profile input
        System.out.println("Enter Student Profile Details:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Class: ");
        String studentClass = sc.nextLine();
        System.out.print("Branch: ");
        String branch = sc.nextLine();

        Profile student = new Profile(name, age, address, phone, studentClass, branch);
        student.showDetails();

        // Semester input
        System.out.print("\nEnter number of subjects: ");
        int n = sc.nextInt(); sc.nextLine();
        String[] subjects = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();
        }
        System.out.print("Enter semester fee: ");
        double semesterFee = sc.nextDouble(); sc.nextLine();

        Semester sem = new Semester(subjects, semesterFee);
        sem.subjects();
        sem.showPayment();

        // Result input
        String[] subjectGrades = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade for " + subjects[i] + " (A/B/C/D/F): ");
            subjectGrades[i] = sc.nextLine();
        }
        Result result = new Result(subjects, semesterFee, subjectGrades);
        result.viewResult();
        result.viewGrade();

        // Edit input
        Edit edit = new Edit(name, age, address, phone, studentClass, branch);
        System.out.print("\nEnter marks: ");
        int marks = sc.nextInt(); sc.nextLine();
        edit.addDetails(marks);
        System.out.print("Enter placement company: ");
        String placement = sc.nextLine();
        edit.addDetails(placement);
        edit.updateMark(marks);
        edit.viewEligibility();

        // Payment input
        System.out.print("\nEnter total fee paid: ");
        double fee = sc.nextDouble();
        Payment payment = new Payment(name, age, address, phone, studentClass, branch, fee);
        payment.viewStatus();

        sc.close();
    }
}