package ontap2;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#,###,###");
    private float gpa;
    private String major;
    private double tuition;
    private boolean scholarship;

    // Default tuition fee is 10,000,000
    private static final double DEFAULT_TUITION = 10000000;

    // Constructor for Student class
    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth); // Call constructor of Person class
        this.gpa = gpa;
        this.major = major;
        this.tuition = DEFAULT_TUITION;
        this.scholarship = gpa >= 9; // Check scholarship condition
        calculateTuition(); // Calculate tuition based on scholarship condition
    }

    // Getters and Setters
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.scholarship = gpa >= 9; // Update scholarship status when GPA changes
        calculateTuition(); // Update tuition when GPA changes
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    // Calculate tuition
    private void calculateTuition() {
        if (scholarship) {
            this.tuition = DEFAULT_TUITION * 0.5; // 50% discount for scholarship
        } else {
            this.tuition = DEFAULT_TUITION; // No discount
        }
    }

    // Parse date from string
    private static Date parseDate(String dateOfBirthString) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirthString);
        } catch (ParseException e) {
            System.out.println("Wrong date format. Using default date.");
            return new Date();
        }
    }


    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + DATE_FORMAT.format(getDateOfBirth()));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Tuition: " + CURRENCY_FORMAT.format(tuition));
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
    }
}
