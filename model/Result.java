package model;

public class Result extends Semester {
    private String grade;
    private double percentage;

    public Result(double percentage, String grade) {
        this.percentage = percentage;
        this.grade = grade;
    }

    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public void viewResult() {
        System.out.println("Percentage: " + percentage + "%");
    }

    public void viewGrade() {
        System.out.println("Grade: " + grade);
    }
}
