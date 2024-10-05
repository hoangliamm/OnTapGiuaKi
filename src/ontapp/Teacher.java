package ontapp;

import java.text.SimpleDateFormat;

public abstract class Teacher extends Person {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyy");
    private String department;
    private String teacherSubject;
    
    public Teacher() {
    }
    
    public Teacher(String department, String teacherSubject) {
        this.department = department;
        this.teacherSubject = teacherSubject;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getTeacherSubject() {
        return teacherSubject;
    }
    
    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    @Override
    public abstract void addPerson();

    public abstract void updatePerson(String id);

    @Override
    public void displayInfo() {
        System.out.println("Teacher id" + getId());
        System.out.println("department" + getDepartment());
        System.out.println("fullName" + getFullName());
        System.out.println("teacherSubject" + getTeacherSubject());
        System.out.println("dateOfBirth" + DATE_FORMAT.format(getDateOfBirth()));
    }
}
