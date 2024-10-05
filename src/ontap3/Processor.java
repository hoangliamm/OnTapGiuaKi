package ontap3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person");
            System.out.println("4. Delete person by id");
            System.out.println("5. Find person by id");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine(); // Read input as string
            int choice;
            try {
                choice = Integer.parseInt(input); // Convert input to integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Skip the rest of the loop and prompt again
            }

            switch (choice) {
                case 1:
                    // Add a new student
                    System.out.print("Enter student ID:");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student name:");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student date of birth (dd/MM/yyyy):");
                    Date studentDob;
                    try {
                        studentDob = dateFormat.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        break;
                    }
                    System.out.print("Enter student GPA:");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student major:");
                    String major = scanner.nextLine();
                    Student student = new Student(studentId, studentName, studentDob, gpa, major);
                    personList.addStudent(student);
                    break;
                case 2:
                    // Add a new teacher
                    System.out.print("Enter teacher ID:");
                    String teacherId = scanner.nextLine();
                    System.out.print("Enter teacher name:");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter teacher date of birth (dd/MM/yyyy):");
                    Date teacherDob;
                    try {
                        teacherDob = dateFormat.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        System.out.print("Invalid date format. Please use dd/MM/yyyy.");
                        break;
                    }
                    System.out.print("Enter teaching subject:");
                    String teachingSubject = scanner.nextLine();
                    System.out.print("Enter department:");
                    String department = scanner.nextLine();
                    Teacher teacher = new Teacher(teacherId, teacherName, teacherDob, teachingSubject, department);
                    personList.addTeacher(teacher);
                    break;
                case 3:
                    // Update person
                    System.out.print("Enter person ID to update:");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new ID:");
                    String newId = scanner.nextLine();
                    System.out.print("Enter new name:");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new date of birth (dd/MM/yyyy):");
                    Date newDob;
                    try {
                        newDob = dateFormat.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        break;
                    }
                    personList.updatePerson(updateId, newId, newName, newDob);
                    break;
                case 4:
                    // Delete person by id
                    System.out.print("Enter person ID to delete:");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                    break;
                case 5:
                    // Find person by id
                    System.out.print("Enter person ID to find:");
                    String findId = scanner.nextLine();
                    Person foundPerson = personList.findPersonById(findId);
                    if (foundPerson != null) {
                        foundPerson.displayInfo();
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 6:
                    // Display all students and teachers
                    personList.displayAllPerson();
                    break;
                case 7:
                    // Find the student with the highest GPA
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 8:
                    // Find a teacher by department
                    System.out.print("Enter department to find teachers:");
                    String findDepartment = scanner.nextLine();
                    ArrayList<Teacher> teachers = (ArrayList<Teacher>) personList.findAllTeachersByDepartment(findDepartment);
                    for (Teacher t : teachers) {
                        t.displayInfo();
                    }
                    break;
                case 9:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
