package ontap5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        PersonList personList = new PersonList();
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addNewStudent(personList);
                    break;
                case 2:
                    addNewTeacher(personList);
                    break;
                case 3:
                    updatePersonById(personList);
                    break;
                case 4:
                    deletePersonById(personList);
                    break;
                case 5:
                    personList.displayEveryone();
                    break;
                case 6:
                    findTopStudent(personList);
                    break;
                case 7:
                    findTeachersByDepartment(personList);
                    break;
                case 8:
                    personList.checkBookBorrowing();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add new student");
        System.out.println("2. Add new teacher");
        System.out.println("3. Update person by id");
        System.out.println("4. Delete person by id");
        System.out.println("5. Display all students and teachers");
        System.out.println("6. Find the student with the highest GPA");
        System.out.println("7. Find teachers by department");
        System.out.println("8. Check book borrowing status");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addNewStudent(PersonList personList) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter student date of birth (dd/MM/yyyy): ");
        Date dateOfBirth = parseDate(scanner.nextLine());
        System.out.print("Enter student book borrow date (dd/MM/yyyy): ");
        Date bookBorrowDate = parseDate(scanner.nextLine());
        System.out.print("Enter student book return date (dd/MM/yyyy): ");
        Date bookReturnDate = parseDate(scanner.nextLine());
        System.out.print("Enter student GPA: ");
        float gpa = Float.parseFloat(scanner.nextLine());
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        Student student = new Student(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate, gpa, major);
        personList.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void addNewTeacher(PersonList personList) {
        System.out.print("Enter teacher ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter teacher full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter teacher date of birth (dd/MM/yyyy): ");
        Date dateOfBirth = parseDate(scanner.nextLine());
        System.out.print("Enter teacher book borrow date (dd/MM/yyyy): ");
        Date bookBorrowDate = parseDate(scanner.nextLine());
        System.out.print("Enter teacher book return date (dd/MM/yyyy): ");
        Date bookReturnDate = parseDate(scanner.nextLine());
        System.out.print("Enter teacher department: ");
        String department = scanner.nextLine();
        System.out.print("Enter teacher teaching subject: ");
        String teachingSubject = scanner.nextLine();

        Teacher teacher = new Teacher(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate, department, teachingSubject);
        personList.addTeacher(teacher);
        System.out.println("Teacher added successfully!");
    }

    private static void updatePersonById(PersonList personList) {
        System.out.print("Enter the person ID to update: ");
        String id = scanner.nextLine();
        personList.updatePersonById(id);
        System.out.println("Person updated successfully!");
    }

    private static void deletePersonById(PersonList personList) {
        System.out.print("Enter the person ID to delete: ");
        String id = scanner.nextLine();
        personList.deletePersonById(id);
        System.out.println("Person deleted successfully!");
    }

    private static void findTopStudent(PersonList personList) {
        Student topStudent = personList.findTopStudent();
        if (topStudent != null) {
            System.out.println("The student with the highest GPA:");
            topStudent.displayInfo();
        } else {
            System.out.println("No students found.");
        }
    }

    private static void findTeachersByDepartment(PersonList personList) {
        System.out.print("Enter the department: ");
        String department = scanner.nextLine();
        var teachers = personList.findTeachersByDepartment(department);
        if (!teachers.isEmpty()) {
            System.out.println("Teachers in department: " + department);
            for (Teacher teacher : teachers) {
                teacher.displayInfo();
            }
        } else {
            System.out.println("No teachers found in department: " + department);
        }
    }

    private static Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }
    }
}
