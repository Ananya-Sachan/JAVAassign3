package assignment3;
import java.util.Scanner;
public class Main {
	
	    private static final int MAX_STUDENTS = 100;
	    private static Student1[] students = new Student1[MAX_STUDENTS];
	    private static int studentCount = 0;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        int choice;
	        do {
	            System.out.println("\nMenu:");
	            System.out.println("1. Add Student");
	            System.out.println("2. Display All Students");
	            System.out.println("3. Search by PRN");
	            System.out.println("4. Search by Name");
	            System.out.println("5. Search by Position");
	            System.out.println("6. Update Student");
	            System.out.println("7. Delete Student");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    addStudent(scanner);
	                    break;
	                case 2:
	                    displayAllStudents();
	                    break;
	                case 3:
	                    searchByPRN(scanner);
	                    break;
	                case 4:
	                    searchByName(scanner);
	                    break;
	                case 5:
	                    searchByPosition(scanner);
	                    break;
	                case 6:
	                    updateStudent(scanner);
	                    break;
	                case 7:
	                    deleteStudent(scanner);
	                    break;
	                case 0:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter again.");
	            }
	        } while (choice != 0);

	        scanner.close();
	    }

	 
	    private static void addStudent(Scanner scanner) {
	        if (studentCount < MAX_STUDENTS) {
	            System.out.print("Enter PRN: ");
	            int prn = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            System.out.print("Enter Name: ");
	            String name = scanner.nextLine();
	            System.out.print("Enter DOB: ");
	            String dob = scanner.nextLine();
	            System.out.print("Enter Marks: ");
	            double marks = scanner.nextDouble();

	            students[studentCount] = new Student1(prn, name, dob, marks);
	            studentCount++;
	            System.out.println("Student added successfully.");
	        } else {
	            System.out.println("Cannot add more students. Array is full.");
	        }
	    }
	    
	  
	    private static void displayAllStudents() {
	        if (studentCount == 0) {
	            System.out.println("No students to display.");
	        } else {
	            System.out.println("List of Students:");
	            for (int i = 0; i < studentCount; i++) {
	                System.out.println("Student " + (i + 1) + ":");
	                students[i].display();
	            }
	        }
	    }

	    private static void searchByPRN(Scanner scanner) {
	        System.out.print("Enter PRN to search: ");
	        int prn = scanner.nextInt();
	        boolean found = false;
	        for (int i = 0; i < studentCount; i++) {
	            if (students[i].getPrn() == prn) {
	                System.out.println("Student found:");
	                students[i].display();
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Student with PRN " + prn + " not found.");
	        }
	    }

	    private static void searchByName(Scanner scanner) {
	        scanner.nextLine(); // Consume newline
	        System.out.print("Enter Name to search: ");
	        String name = scanner.nextLine();
	        boolean found = false;
	        for (int i = 0; i < studentCount; i++) {
	            if (students[i].getName().equalsIgnoreCase(name)) {
	                System.out.println("Student found:");
	                students[i].display();
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("Student with Name " + name + " not found.");
	        }
	    }

	    private static void searchByPosition(Scanner scanner) {
	        System.out.print("Enter position (1-" + studentCount + "): ");
	        int position = scanner.nextInt();
	        if (position >= 1 && position <= studentCount) {
	            System.out.println("Student at position " + position + ":");
	            students[position - 1].display();
	        } else {
	            System.out.println("Invalid position.");
	        }
	    }

	    private static void updateStudent(Scanner scanner) {
	        System.out.print("Enter PRN of the student to update: ");
	        int prn = scanner.nextInt();
	        boolean found = false;
	        for (int i = 0; i < studentCount; i++) {
	            if (students[i].getPrn() == prn) {
	                System.out.println("Student found. Enter new details:");
	                System.out.print("Enter Name: ");
	                scanner.nextLine(); // Consume newline
	                String name = scanner.nextLine();
	                System.out.print("Enter DOB: ");
	                String dob = scanner.nextLine();
	                System.out.print("Enter Marks: ");
	                double marks = scanner.nextDouble();

	                students[i] = new Student(prn, name, dob, marks);
	                System.out.println("Student details updated.");
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Student with PRN " + prn + " not found.");
	        }
	    }

	    private static void deleteStudent(Scanner scanner) {
	        System.out.print("Enter PRN of the student to delete: ");
	        int prn = scanner.nextInt();
	        boolean found = false;
	        for (int i = 0; i < studentCount; i++) {
	            if (students[i].getPrn() == prn) {
	                for (int j = i; j < studentCount - 1; j++) {
	                    students[j] = students[j + 1];
	                }
	                studentCount--;
	                System.out.println("Student with PRN " + prn + " deleted.");
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Student with PRN " + prn + " not found.");
	        }
	    }
	}
