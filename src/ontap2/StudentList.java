package ontap2;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("The student list is empty.");
        } else {
            System.out.println("List of all students:");
            for (Student student : students) {
                student.displayInfo();
                System.out.println();
            }
        }
    }

    // Find a student by ID
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Find all scholarship students
    public List<Student> findScholarshipStudents() {
        List<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isScholarship()) {
                scholarshipStudents.add(student);
            }
        }
        return scholarshipStudents;
    }

    // Calculate total tuition
    public double calculateTotalTuition() {
        double total = 0;
        for (Student student : students) {
            total += student.getTuition();
        }
        return total;
    }

    // Remove a student by ID
    public void removeStudentById(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    // Find student with highest GPA
    public Student findStudentWithHighestGPA() {
        if (students.isEmpty()) {
            return null;
        }
        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}
