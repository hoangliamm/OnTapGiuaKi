package ontap5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private float gpa;
    private String major;

    // Constructor
    public Student(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
    }

    public Student(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, float gpa, String major) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.gpa = gpa;
        this.major = major;
    }

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
        System.out.println("StudentID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + (getDateOfBirth() != null ? DATE_FORMAT.format(getDateOfBirth()) : "N/A"));
        System.out.println("Book Borrow Date: " + (getBookBorrowDate() != null ? DATE_FORMAT.format(getBookBorrowDate()) : "N/A"));
        System.out.println("Book Return Date: " + (getBookReturnDate() != null ? DATE_FORMAT.format(getBookReturnDate()) : "N/A"));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }
}
