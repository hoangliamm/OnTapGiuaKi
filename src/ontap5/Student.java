package ontap5;

import java.text.SimpleDateFormat;

public abstract class Student extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
    private float gpa;
    private String major;

    public Student() {
    }

    public Student(float gpa, String major) {
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
    public abstract void addPerson();

    public abstract void updatePerson(String id);

    public void displayInfo() {
        System.out.println("Enter studentID: " + getId());
        System.out.println("Enter fullName Student: " + getFullName());
        System.out.println("Enter dateOfBirth: " + DATE_FORMAT.format(getDateOfBirth()));
        System.out.println("Enter gpa: " + getGpa());
        System.out.println("Enter major: " + getMajor());
        System.out.println("Book Borrow Date: " + getBookBorrowDate());
        System.out.println("Book Return Date: " + getBookReturnDate());
        if (isBookOverdue()) {
            System.out.println("Book is Overdue");
        } else {
            System.out.println("Book is Not Overdue");
        }
    }
}
