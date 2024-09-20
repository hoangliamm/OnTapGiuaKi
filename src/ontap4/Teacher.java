package ontap4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher extends Person {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }

    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
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
        // Implementation for adding a teacher
    }

    @Override
    public void updatePerson(String id) {
        // Implementation for updating teacher info
    }

    private static Date parseDate(String dateOfBirthString) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println("Wrong date format. Using default date.");
            return new Date();
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + DATE_FORMAT.format(getDateOfBirth()));
        System.out.println("Department: " + department);
        System.out.println("Teaching Subject: " + teachingSubject);
    }
}
