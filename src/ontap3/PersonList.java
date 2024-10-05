package ontap3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    // Method to find the student with the highest GPA
    public Student findTopStudent() {
        Student highestGPAStudent = null;
        for (Person person : people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                // Fixed the GPA comparison
                if (highestGPAStudent == null || student.getGpa()> highestGPAStudent.getGpa()) {
                    highestGPAStudent = student;
                }
            }
        }
        return highestGPAStudent;
    }

    // Method to update a person (either a student or a teacher) by ID
    public void updatePerson(String id, String newId, String newName, Date newDob) {
        Person person = findPersonById(id);
        if (person != null) {
            if (person instanceof Student) {
                updateStudentDetails((Student) person);
            } else if (person instanceof Teacher) {
                updateTeacherDetails((Teacher) person);
            }
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    // Method to delete a person by ID
    public void deletePersonById(String id) {
        people.removeIf(person -> person.getId().equals(id));
    }

    // Method to find a person by ID
    Person findPersonById(String id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    // Method to update student details
    private void updateStudentDetails(Student student) {
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

        System.out.print("Enter new GPA : ");
        String gpaString = scanner.nextLine();
        if (!gpaString.isEmpty()) {
            try {
                float newGpa = Float.parseFloat(gpaString);
                student.setGpa(newGpa);
            } catch (NumberFormatException e) {
                System.out.println("Invalid GPA format. GPA not updated.");
            }
        }

        System.out.print("Enter new Major : ");
        String newMajor = scanner.nextLine();
        if (!newMajor.isEmpty()) {
            student.setMajor(newMajor);
        }

        System.out.println("Student details updated successfully.");
    }

    // Method to update teacher details
    private void updateTeacherDetails(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new Full Name : ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            teacher.setFullName(newName);
        }

        System.out.print("Enter new Date of Birth (dd/MM/yyyy) : ");
        String newDobString = scanner.nextLine();
        if (!newDobString.isEmpty()) {
            try {
                Date newDob = DATE_FORMAT.parse(newDobString);
                teacher.setDateOfBirth(newDob);
            } catch (Exception e) {
                System.out.println("Invalid date format. Date not updated.");
            }
        }

        System.out.print("Enter new Department : ");
        String newDepartment = scanner.nextLine();
        if (!newDepartment.isEmpty()) {
            teacher.setDeparment(newDepartment);
        }

        System.out.print("Enter new Teaching Subject : ");
        String newSubject = scanner.nextLine();
        if (!newSubject.isEmpty()) {
            teacher.setTeacherSubject(newSubject);
        }

        System.out.println("Teacher details updated successfully.");
    }

    // Method to display all people (both students and teachers)
    public void displayAllPerson() {
        for (Person person : people) {
            person.displayInfo();
            System.out.println();
        }
    }

    // Method to find teachers by department
    public List<Teacher> findAllTeachersByDepartment(String department) {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDeparment().equalsIgnoreCase(department)) {
                    teachers.add(teacher);
                }
            }
        }
        return teachers;
    }
}
