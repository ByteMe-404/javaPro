
import java.util.*;

public class StudentServices {
    public Scanner scanner = new Scanner(System.in);
    // list of students
    public List<Student> students = new ArrayList<>();

    // add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("student added successfully....");
    }

    // view all student
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("There is no student .");
            return;
        }
        for (Student student : students) {
            student.displayInfo();
        }

    }

    // serach a student by roll number
    public Student serachStudent(int roll) {
        for (Student st : students) {
            if (st.getRoll() == roll) {
                return st;
            }
        }
        return null;
    }

    // delete a student by roll number
    public boolean deleteStudent(int roll) {
        Student student = serachStudent(roll);
        if (student != null) {
            for (Student st : students) {
                if (st.getRoll() == roll) {
                    students.remove(st);
                    return true;
                }
            }
        }
        return false;
    }

    public void updateStudent(int roll) {

        Student student = serachStudent(roll);
        if (student != null) {

            System.out.println("Enter your new name :");
            String name = scanner.nextLine();
            System.out.println("Enter your new age :");
            int age = scanner.nextInt();
            System.out.println("Enter your new Id :");
            int id = scanner.nextInt();
            System.out.println("Enter your new gpa :");
            char gpa = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.println("Enter your new address :");
            String addres = scanner.nextLine();
            
            student.setName(name);
            student.setAge(age);
            student.setGpa(gpa);
            student.setId(id);
            student.setAddress(addres);
        }
    }

}

// update student details
