package ontap5;
import java.util.ArrayList;
import java.util.Date;

public class PersonList {
    private ArrayList<Person> personList;

    // Constructor
    public PersonList() {
        personList = new ArrayList<>();
    }

    public void addStudent(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, float gpa, String major) {
        Student student = new Student(id, dateOfBirth, fullName, gpa, major, bookBorrowDate, bookReturnDate);
        personList.add(student);
        System.out.println("Student added successfully.");
    }

    // Method to add a new teacher
    public void addTeacher(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, String department, String teachingSubject) {
        Teacher teacher = new Teacher(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate, department, teachingSubject);
        personList.add(teacher);
        System.out.println("Teacher added successfully.");
    }

    // Method to update a person by ID
    public void updatePersonById(String id) {
        boolean found = false;
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                person.updatePerson(id); // Add necessary input fields or update logic here
                found = true;
                System.out.println("Person with ID " + id + " updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    // Method to delete a person by ID
    public void deletePersonById(String id) {
        boolean removed = personList.removeIf(person -> person.getId().equals(id));
        if (removed) {
            System.out.println("Person with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    // Method to display all students and teachers
    public void displayEveryone() {
        if (personList.isEmpty()) {
            System.out.println("No persons to display.");
        } else {
            for (Person person : personList) {
                person.displayInfo();
                System.out.println();
            }
        }
    }

    // Method to find the student with the highest GPA
    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }
        return topStudent;
    }

    // Method to find teachers by department
    public void findTeachersByDepartment(String department) {
        boolean found = false;
        System.out.println("Teachers in the " + department + " department:");
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equalsIgnoreCase(department)) {
                    teacher.displayInfo();
                    System.out.println();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No teachers found in the " + department + " department.");
        }
    }

    // Method to check if the book is overdue
    public void checkBookBorrowing(String id) {
        boolean found = false;
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                found = true;
                if (person.isBookOverdue()) {
                    System.out.println("Overdue");
                } else {
                    System.out.println("No overdue");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Person with ID " + id + " not found.");
        }
    }
}
