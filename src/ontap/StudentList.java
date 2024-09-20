package ontap;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {

    private ArrayList<Student> studentList;
    Scanner scanner = new Scanner(System.in);

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;

    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sach hoc sinh trong.");
        } else {
            System.out.println("Danh sach tat ca sinh vien vua nhap:");
            for (Student student : studentList) {
                student.displayInfo();
                System.out.println();
            }
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }

        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGPA() > topStudent.getGPA()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}
