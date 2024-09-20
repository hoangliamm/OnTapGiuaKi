package ontap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter student ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter full name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter date of birth (dd-MM-yyyy):");
                    String dob = scanner.nextLine();
                    System.out.println("Enter GPA:");
                    float GPA = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Major: ");
                    String major = scanner.nextLine();
                    try {
                        Date dateOfBirth = dateFormat.parse(dob);
                        Student student = new Student(GPA, major, id, name, dateOfBirth);
                        studentList.addStudent(student);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please try again." + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    Student updateStudent = studentList.findStudentById(updateId);
                    if (updateStudent != null) {
                        System.out.print("Enter new Full Name : ");
                        String newFullName = scanner.nextLine();
                        if (!newFullName.isEmpty()) {
                            updateStudent.setFullName(newFullName);
                        }

                        System.out.print("Enter new GPA : ");
                        String newGPAInput = scanner.nextLine();
                        if (!newGPAInput.isEmpty()) {
                            float newGPA = Float.parseFloat(newGPAInput);
                            updateStudent.setGPA(newGPA);
                        }

                        System.out.print("Enter new Major: ");
                        String newMajor = scanner.nextLine();
                        if (!newMajor.isEmpty()) {
                            updateStudent.setMajor(newMajor);
                        }

                        System.out.print("Enter new Date of Birth (dd-MM-yyyy) : ");
                        String newDOB = scanner.nextLine();
                        if (!newDOB.isEmpty()) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            try {
                                Date dateOfBirth = sdf.parse(newDOB);
                                updateStudent.setDateOfBirth(dateOfBirth);
                            } catch (Exception e) {
                                System.out.println("Invalid date format. Please try again.");
                            }
                        }

                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                }

                case 3 -> {
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                }

                case 4 ->
                    studentList.displayAllStudents();

                case 5 -> {
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                }

                case 6 -> {
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                }

                default ->
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
