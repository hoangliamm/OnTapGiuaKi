package ontap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Student extends Abstract {

    private float GPA;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }

    public Student(float GPA, String major, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
    }

    public Student(String id, String fullName, String dateOfBirthString, float gpa, String major) {
        super(id, fullName, parseDate(dateOfBirthString));
        this.GPA = gpa;
        this.major = major;
    }

    private static Date parseDate(String dateOfBirthString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return sdf.parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println("Wrong date format. Using default date.");
            return new Date(); 
        }
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addStudent(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id: ");
        String id = scanner.nextLine();
        student.setId(id);
        System.out.println("Full Name: ");
        String fullName = scanner.nextLine();
        student.setFullName(fullName);
        System.out.println("GPA: ");
        float GPA = Float.parseFloat(scanner.nextLine());
        student.setGPA(GPA);
        System.out.println("DateOfBirth (dd-MM-yyyy): ");
        String dateOfBirthString = scanner.nextLine();
        student.setDateOfBirth(parseDate(dateOfBirthString)); 
        System.out.println("Major: ");
        String major = scanner.nextLine();
        student.setMajor(major);
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        String formattedDate = dateFormat.format(getDateOfBirth()); 
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + formattedDate); 
        System.out.println("GPA: " + GPA);
        System.out.println("Major: " + major);
    }
}
