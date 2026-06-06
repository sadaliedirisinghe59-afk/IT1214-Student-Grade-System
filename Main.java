import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add a Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search for a Student by ID");
            System.out.println("4. Calculate & Display Average Mark");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentByID();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    break;
			
   			   default:
                  System.out.println("Invalid choice. Please try again.");
			
            }
        } while (choice != 5);
    }

    
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid marks. Please enter a valid number: ");
            scanner.next();
        }
        double marks = scanner.nextDouble();
        
        Student newStudent = new Student(id, name, marks);
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    
    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student s : studentList) {
            s.displayStudent();
        }
    }

    
    private static void searchStudentByID() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.print("Enter Student ID to search: ");
        String searchID = scanner.nextLine();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getStudentID().equalsIgnoreCase(searchID)) {
                System.out.println("\nStudent Found:");
                s.displayStudent();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + searchID + " not found.");
        }
    }

    
    private static void calculateAverage() {
        if (studentList.isEmpty()) {
            System.out.println("No student records to calculate average.");
            return;
        }
        double total = 0;
        for (Student s : studentList) {
            total += s.getMarks();
        }
        double average = total / studentList.size();
        System.out.println("\nTotal Students: " + studentList.size());
        System.out.printf("Average Mark of All Students: %.2f\n", average);
    }
}
