package ontapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Student extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");
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
    abstract public void addPerosn();

    abstract public void updatePerson(String id);

    public void displayInfo() {
        System.out.println("id" + getId());
        System.out.println("fullName" + getFullName());
        System.out.println("gpa" + getGpa());
        System.out.println("major" + getMajor());
        System.out.println("date" + DATE_FORMAT.format(getDateOfBirth()));
    }

}
