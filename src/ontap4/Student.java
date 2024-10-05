package ontap4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    // Getters and Setters
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        
    }

    @Override
    public void updatePerson(String id) {

    }

    

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + DATE_FORMAT.format(getDateOfBirth()));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }
}
