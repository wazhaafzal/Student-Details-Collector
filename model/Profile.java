package model;

public class Profile {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String className;
    private String branch;

    public Profile(String name, int age, String address, String phone, String className, String branch) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.className = className;
        this.branch = branch;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + className);
        System.out.println("Branch: " + branch);
    }
}
