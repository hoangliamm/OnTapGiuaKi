package ontapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PersonList {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");
    List<Person> people;

    public PersonList() {
        this.people = new ArrayList<>();
    }

    public void addStudent(Student student) {
        people.add(student);
    }

    public void addTeacher(Teacher teacher) {
        people.add(teacher);
    }

    public void deletePersonById(String id) {
        people.removeIf(person -> person.getId().equals(id));
    }

    public void displayPerson() {
        for (Person person : people) {
            person.displayInfo();
            System.out.println();
        }
    }

    public Student findHighestGPAStudent() {
        Student highestGPAStudent = null;
        for (Person person : people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (highestGPAStudent == null || student.getGpa() > highestGPAStudent.getGpa()) {
                    highestGPAStudent = student;
                }
            }
        }
        return highestGPAStudent;
    }

    public List<Teacher> findTeacherByDepartment(String department) {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    teachers.add(teacher);
                }
            }
        }
        return teachers;
    }

    public Person findPerosnById(String id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    private void updateStudent(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new full Name");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) {
            student.setFullName(newName);
        }
        System.out.println("Enter new dateOfBirth (dd/mm/yyyy): ");
        String newDobstString = sc.nextLine();
        if (newDobstString.isEmpty()) {
            try {
                Date newDob = DATE_FORMAT.parse(newDobstString);
                student.setDateOfBirth(newDob);
            } catch (Exception e) {
                System.out.println("wrong format");
            }
        }
        System.out.println("Enter new GPA: ");
        String gpaString = sc.nextLine();
        if (!gpaString.isEmpty()) {
            try {
                float newGpa = Float.parseFloat(gpaString);
                student.setGpa(newGpa);
            } catch (NumberFormatException e) {
                System.out.println("wrong format!");
            }
        }
        System.out.println("Enter new major: ");
        String newMajor = sc.nextLine();
        if (!newMajor.isEmpty()) {
            student.setMajor(newMajor);
        }
        System.out.println("Student update sucessfully! ");
    }

    private void updatTeacher(Teacher teacher) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new name Teacher: ");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) {
            teacher.setFullName(newName);
        }
        System.out.println("Enter new dateOfBirth (dd/mm/yyyy): ");
        String newDobString = sc.nextLine();
        if (!newDobString.isEmpty()) {
            try {
                Date newDob = DATE_FORMAT.parse(newDobString);
                teacher.setDateOfBirth(newDob);
            } catch (Exception e) {
                System.out.println("wrong format");
            }
        }
        System.out.println("Enter new Department: ");
        String newDepartment = sc.nextLine();
        if (!newDepartment.isEmpty()) {
            teacher.setDepartment(newDepartment);
        }
        System.out.println("Enter new TeacherSubject: ");
        String newTeacherSubject = sc.nextLine();
        if (!newTeacherSubject.isEmpty()) {
            teacher.setTeacherSubject(newTeacherSubject);
        }
    }

    public void updatePerson(String id) {
        Person person = findPerosnById(id);
        if (person != null) {
            if (person instanceof Student) {
                updateStudent((Student) person);
            }else if (person instanceof Teacher) {
                updatTeacher((Teacher) person);
            }
            else {
                System.out.println("Person with id "+ id + " not found");
            }
        }
    }
    
}
