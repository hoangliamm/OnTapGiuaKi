package ontap5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private String department;
    private String teachingSubject;

    // Constructor
    public Teacher(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    // Getters and Setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void addPerson() {
    }

    @Override
    public void updatePerson(String id) {
    }

    @Override
    public void displayInfo() {
        System.out.println("TeacherID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + (getDateOfBirth() != null ? DATE_FORMAT.format(getDateOfBirth()) : "N/A"));
        System.out.println("Book Borrow Date: " + (getBookBorrowDate() != null ? DATE_FORMAT.format(getBookBorrowDate()) : "N/A"));
        System.out.println("Book Return Date: " + (getBookReturnDate() != null ? DATE_FORMAT.format(getBookReturnDate()) : "N/A"));
        System.out.println("Department: " + department);
        System.out.println("Teaching Subject: " + teachingSubject);
    }

}
