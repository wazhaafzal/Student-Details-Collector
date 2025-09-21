package model;

import java.util.HashMap;

public class Semester {
    private HashMap<String, Integer> subjects = new HashMap<>();

    public void addSubject(String subject, int marks) {
        subjects.put(subject, marks);
    }

    public HashMap<String, Integer> getSubjects() {
        return subjects;
    }

    public void subjects() {
        System.out.println("Subjects and Marks:");
        for (String s : subjects.keySet()) {
            System.out.println(s + " -> " + subjects.get(s));
        }
    }

    public void showPayment() {
        System.out.println("Payment details linked with semester (handled in Payment class).");
    }
}
