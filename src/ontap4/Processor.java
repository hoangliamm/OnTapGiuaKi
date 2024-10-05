package ontap4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Processor {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonList personList = new PersonList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Code to add new student
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String dobString = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();

                    try {
                        Date dob = dateFormat.parse(dobString);
                        personList.addStudent(new Student(studentId,studentName, dob, gpa, major));
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                    }
                    break;

                case 2:
                    // Code to add new teacher
                    System.out.print("Enter Teacher ID: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String teacherDobString = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Teaching Subject: ");
                    String subject = scanner.nextLine();

                    try {
                        Date dob = dateFormat.parse(teacherDobString);
                        personList.addTeacher(new Teacher(teacherId, teacherName, dob, department, subject));
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                    }
                    break;

                case 3:
                    // Update person by id
                    System.out.print("Enter Person ID to Update: ");
                    String updateId = scanner.nextLine();
                    personList.updatePersonById(updateId);
                    break;

                case 4:
                    // Delete person by id
                    System.out.println("Enter Person ID to Delete: ");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                    break;

                case 5:
                    // Display all students and teachers
                    personList.displayAll();
                    break;

                case 6:
                    // Find the student with the highest GPA
                    Student topStudent = personList.findHighestGPAStudent();
                    if (topStudent != null) {
                        System.out.println("Student with the highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 7:
                    // Find teachers by department
                    System.out.println("Enter Department: ");
                    String searchDepartment = scanner.nextLine();
                    List<Teacher> teachers = personList.findTeachersByDepartment(searchDepartment);
                    if (!teachers.isEmpty()) {
                        System.out.println("Teachers in Department " + searchDepartment + ":");
                        for (Teacher teacher : teachers) {
                            teacher.displayInfo();
                        }
                    } else {
                        System.out.println("No teachers found in this department.");
                    }
                    break;

                case 8:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
