
package ontap5;

import java.text.SimpleDateFormat;


public abstract class Teacher extends Person{
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
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
    public void displayInfo(){
        System.out.println("Enter teacherID: "+getId());
        System.out.println("Enter fullName Teacher: "+getFullName());
        System.out.println("Enter dateOfBirth: "+DATE_FORMAT.format(getDateOfBirth()));
        System.out.println("Enter department: "+getDepartment());
        System.out.println("Enter subjectTeacher: "+getTeacherSubject());
    }
}
