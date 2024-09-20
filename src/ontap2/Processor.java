package ontap2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private StudentList studentList;
    private Scanner scanner;

    public Processor() {
        studentList = new StudentList();
        scanner = new Scanner(System.in);
    }

    // Display the main menu
    public void displayMenu() {
        System.out.println("===== Student Management System =====");
        System.out.println("1. Add new student");
        System.out.println("2. Display all students");
        System.out.println("3. Find student with highest GPA");
        System.out.println("4. Find all scholarship students");
        System.out.println("5. Calculate total tuition");
        System.out.println("6. Remove student by ID");
        System.out.println("7. Update student by ID");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    // Process user choices
    public void process() {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentList.displayAllStudents();
                    break;
                case 3:
                    findStudentWithHighestGPA();
                    break;
                case 4:
                    findScholarshipStudents();
                    break;
                case 5:
                    calculateTotalTuition();
                    break;
                case 6:
                    removeStudentById();
                    break;
                case 7:
                    updateStudentById();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

    // Add a new student
    private void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter date of birth (dd/MM/yyyy): ");
            String dob = scanner.nextLine();
            System.out.print("Enter GPA: ");
            float gpa = Float.parseFloat(scanner.nextLine());
            System.out.print("Enter major: ");
            String major = scanner.nextLine();

            Date dateOfBirth = DATE_FORMAT.parse(dob); // Parse the date of birth
            Student student = new Student(id, fullName, dateOfBirth, gpa, major);
            studentList.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid GPA format. Please enter a valid number.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Find student with highest GPA
    private void findStudentWithHighestGPA() {
        Student topStudent = studentList.findStudentWithHighestGPA();
        if (topStudent != null) {
            System.out.println("Student with highest GPA:");
            topStudent.displayInfo();
        } else {
            System.out.println("Student list is empty.");
        }
    }

    // Find scholarship students
    private void findScholarshipStudents() {
        System.out.println("Scholarship students:");
        for (Student student : studentList.findScholarshipStudents()) {
            student.displayInfo();
            System.out.println("-----");
        }
    }

    // Calculate total tuition
    private void calculateTotalTuition() {
        double totalTuition = studentList.calculateTotalTuition();
        System.out.println("Total tuition for all students: " + String.format("%,.0f", totalTuition));
    }

    // Remove student by ID
    private void removeStudentById() {
        System.out.print("Enter student ID to remove: ");
        String id = scanner.nextLine();
        studentList.removeStudentById(id);
        System.out.println("Student removed if ID was found.");
    }

    // Update student information by ID
    private void updateStudentById() {
        System.out.print("Enter student ID to update: ");
        String updateId = scanner.nextLine();
        Student updateStudent = studentList.findStudentById(updateId);
        if (updateStudent != null) {
            try {
                System.out.print("Enter new full name: ");
                String newFullName = scanner.nextLine();
                if (!newFullName.isEmpty()) {
                    updateStudent.setFullName(newFullName);
                }

                System.out.print("Enter new GPA: ");
                String newGPAInput = scanner.nextLine();
                if (!newGPAInput.isEmpty()) {
                    float newGPA = Float.parseFloat(newGPAInput);
                    updateStudent.setGpa(newGPA);
                }

                System.out.print("Enter new major: ");
                String newMajor = scanner.nextLine();
                if (!newMajor.isEmpty()) {
                    updateStudent.setMajor(newMajor);
                }

                System.out.print("Enter new date of birth: ");
                String newDOB = scanner.nextLine();
                if (!newDOB.isEmpty()) {
                    Date dateOfBirth = DATE_FORMAT.parse(newDOB);
                    updateStudent.setDateOfBirth(dateOfBirth);
                }

                updateStudent.setScholarship(updateStudent.getGpa() >= 9);

                System.out.println("Student updated successfully!");
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid GPA format. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error updating student: " + e.getMessage());
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.process();
    }
}
