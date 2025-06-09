import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    double marks;

    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    void displayInfo() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name   : " + name);
        System.out.println("Marks  : " + marks);
        System.out.println("---------------------------");
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;
        int choice;

        do {
            System.out.println("====== Student Management Menu ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");
                    int roll = scanner.nextInt();

                    System.out.print("Enter marks: ");
                    double marks = scanner.nextDouble();

                    students[count++] = new Student(name, roll, marks);
                    System.out.println("✅ Student added successfully!\n");
                    break;

                case 2:
                    System.out.println("📋 List of Students:");
                    for (int i = 0; i < count; i++) {
                        students[i].displayInfo();
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = scanner.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].rollNumber == searchRoll) {
                            System.out.println("✅ Student Found:");
                            students[i].displayInfo();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("👋 Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
