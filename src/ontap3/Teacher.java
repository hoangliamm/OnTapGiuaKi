package ontap3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private String deparment;
    private String teacherSubject;

    // Constructor initializing all attributes
    public Teacher(String id, String fullName, Date dateOfBirth, String teacherSubject, String department) {
        super(id, fullName, dateOfBirth);
        this.teacherSubject = teacherSubject;
        this.deparment = department;
    }

    // Getter and Setter for department
    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    // Getter and Setter for teacher subject
    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    // Method to parse date (improved to use the class DATE_FORMAT)
    private static Date parseDate(String dateOfBirthString) {
        try {
            return DATE_FORMAT.parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println("Wrong date format. Using default date.");
            return new Date();
        }
    }

    // Method to display teacher's info
    @Override
    public void displayInfo() {
        System.out.println("Teacher ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + DATE_FORMAT.format(getDateOfBirth()));
        System.out.println("Teaching Subject: " + getTeacherSubject());
        System.out.println("Department: " + getDeparment());
    }
}
