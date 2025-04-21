
import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private StudentServices studentServices = new StudentServices();

    public void displayMenu() {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentServices.viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.println("Enter your Name :");
        String name = scanner.nextLine();
        System.out.println("Enter your Roll :");
        int roll = scanner.nextInt();
        System.out.println("Enter your Age :");
        int age = scanner.nextInt();
        System.out.println("Enter your Id :");
        int id = scanner.nextInt();
        System.out.println("Enter your gpa :");
        char gpa = scanner.next().charAt(0);
        scanner.nextLine();
        System.out.println("Enter your addresss : ");
        String addres = scanner.nextLine();
        // createing new student
        Student student = new Student(name, age, roll, id, gpa, addres);
        // adding new student
        studentServices.addStudent(student);
    }

    private void searchStudent() {
        System.out.println("Enter the roll you want to serach :");
        int roll = scanner.nextInt();
        Student student = studentServices.serachStudent(roll);
        if (student == null) {
            System.out.println("no student found ");
        } else {
            student.displayInfo();
        }
    }

    private void deleteStudent() {
        System.out.println("Enter the roll you want to delete :");
        int roll = scanner.nextInt();
        boolean res = studentServices.deleteStudent(roll);
        if (res) {
            System.out.println("deleted successfull.....");
        }
    }

    private void updateStudent() {
        System.out.println("Enter the roll you want to update :");
        int roll = scanner.nextInt();
        studentServices.updateStudent(roll);
    }

}
