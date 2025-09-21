package model;

public class Student extends Profile {
    private int id;
    private String password; // for login

    public Student(int id, String name, int age, String address, String phone, String className, String branch, String password) {
        super(name, age, address, phone, className, branch);
        this.id = id;
        this.password = password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public void showDetails() {
        System.out.println("ID: " + id);
        super.showDetails();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", class='" + getClassName() + '\'' +
                ", branch='" + getBranch() + '\'' +
                '}';
    }
}
