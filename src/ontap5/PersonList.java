package ontap5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class PersonList {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private List<Person> people;

    public PersonList() {
        this.people = new ArrayList<>();
    }

    public void addStudent(Student student) {
        people.add(student);
    }

    public void addTeacher(Teacher teacher) {
        people.add(teacher);
    }

    public Student findTopStudent() {
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

    public void updatePersonById(String id) {
        Person person = findPersonById(id);
        if (person != null) {
            if (person instanceof Student) {
                updateStudent((Student) person);
            } else if (person instanceof Teacher) {
                updateTeacher((Teacher) person);
            }
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    public void deletePersonById(String id) {
        people.removeIf(person -> person.getId().equals(id));
    }

    private Person findPersonById(String id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    private void updateStudent(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new Full Name: ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            student.setFullName(newName);
        }

        System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
        String newDobString = scanner.nextLine();
        if (!newDobString.isEmpty()) {
            try {
                Date newDob = DATE_FORMAT.parse(newDobString);
                student.setDateOfBirth(newDob);
            } catch (Exception e) {
                System.out.println("Invalid date format. Date not updated.");
            }
        }

        System.out.print("Enter new GPA: ");
        String gpaString = scanner.nextLine();
        if (!gpaString.isEmpty()) {
            try {
                float newGpa = Float.parseFloat(gpaString);
                student.setGpa(newGpa);
            } catch (NumberFormatException e) {
                System.out.println("Invalid GPA format. GPA not updated.");
            }
        }

        System.out.print("Enter new Major: ");
        String newMajor = scanner.nextLine();
        if (!newMajor.isEmpty()) {
            student.setMajor(newMajor);
        }

        System.out.println("Student details updated successfully.");
    }

    private void updateTeacher(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new Full Name: ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            teacher.setFullName(newName);
        }

        System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
        String newDobString = scanner.nextLine();
        if (!newDobString.isEmpty()) {
            try {
                Date newDob = DATE_FORMAT.parse(newDobString);
                teacher.setDateOfBirth(newDob);
            } catch (Exception e) {
                System.out.println("Invalid date format. Date not updated.");
            }
        }

        System.out.print("Enter new Department: ");
        String newDepartment = scanner.nextLine();
        if (!newDepartment.isEmpty()) {
            teacher.setDepartment(newDepartment);
        }

        System.out.print("Enter new Teaching Subject: ");
        String newSubject = scanner.nextLine();
        if (!newSubject.isEmpty()) {
            teacher.setTeachingSubject(newSubject);
        }

        System.out.println("Teacher details updated successfully.");
    }

    public void displayEveryone() {
        for (Person person : people) {
            person.displayInfo();
            System.out.println();
        }
    }

    public List<Teacher> findTeachersByDepartment(String department) {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equalsIgnoreCase(department)) {
                    teachers.add(teacher);
                }
            }
        }
        return teachers;
    }

    public void checkBookBorrowing() {
        for (Person person : people) {
            if (person.isBookOverdue()) {
                System.out.println(person.getFullName() + ": Overdue");
            } else {
                System.out.println(person.getFullName() + ": No overdue");
            }
        }
    }
}
