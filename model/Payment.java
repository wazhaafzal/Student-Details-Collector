package model;
public class Payment extends Profile {
    private double fee;
    private boolean status;

    public Payment(String name, int age, String address, String phone, String className, String branch, double fee, boolean status) {
        super(name, age, address, phone, className, branch);
        this.fee = fee;
        this.status = status;
    }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public void viewStatus() {
        System.out.println("Fee: " + fee + ", Paid: " + (status ? "Yes" : "No"));
    }
}
