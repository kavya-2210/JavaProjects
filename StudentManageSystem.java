import java.util.Scanner;
class Student {
    private int studentId;
    private String name;
    private String course;
    private double marks;

    public Student(int studentId, String name, String course, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    // Getters and setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Course: " + course + ", Marks: " + marks;
    }
}
interface StudentOperations {
    void addStudent(Student student);
    Student getStudentById(int id);
    void updateStudent(int id, String newName, String newCourse, double newMarks);
    void deleteStudent(int id);
    void listAllStudents();
}
class StudentManager implements StudentOperations {
    private static final int MAX = 100;
    private Student[] students = new Student[MAX];
    private int count = 0;

    @Override
    public void addStudent(Student student) {
        if (count < MAX) {
            if (getStudentById(student.getStudentId()) == null) {
                students[count++] = student;
                System.out.println("Student added.");
            } else {
                System.out.println("Student ID already exists.");
            }
        } else {
            System.out.println("Cannot add more students. Array is full.");
        }
    }

    @Override
    public Student getStudentById(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == id) {
                return students[i];
            }
        }
        return null;
    }

    @Override
    public void updateStudent(int id, String newName, String newCourse, double newMarks) {
        Student s = getStudentById(id);
        if (s != null) {
            s.setName(newName);
            s.setCourse(newCourse);
            s.setMarks(newMarks);
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void deleteStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == id) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null;
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    @Override
    public void listAllStudents() {
        if (count == 0) {
            System.out.println("No students found.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(students[i]);
            }
        }
    }
}

class StudentManageSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentOperations manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. List All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    manager.addStudent(new Student(id, name, course, marks));
                    break;

                case 2:
                    System.out.print("Enter ID to View: ");
                    int vid = sc.nextInt();
                    Student s = manager.getStudentById(vid);
                    System.out.println(s != null ? s : "Student not found.");
                    break;

                case 3:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();
                    System.out.print("New Marks: ");
                    double newMarks = sc.nextDouble();
                    manager.updateStudent(uid, newName, newCourse, newMarks);
                    break;

                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    manager.deleteStudent(did);
                    break;

                case 5:
                    manager.listAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }
}
