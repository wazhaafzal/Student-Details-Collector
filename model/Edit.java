package model;

public class Edit extends Profile {
    public Edit(String name, int age, String address, String phone, String className, String branch) {
        super(name, age, address, phone, className, branch);
    }

    public void addDetails() {
        System.out.println("New details added.");
    }

    public void updateMark() {
        System.out.println("Marks updated.");
    }

    public void viewEligibility() {
        System.out.println("Checking eligibility for placement...");
    }
}
