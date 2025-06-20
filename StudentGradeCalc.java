import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;
    private int total;
    private double percentage;
    private char grade;

    public Student(String name) {
        this.name = name;
        this.marks = new int[5];
    }

    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks for " + name + ":");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    public void calculateResults() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        percentage = total / 5.0;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else if (percentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
    }

    public void displayResults() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name       : " + name);
        System.out.println("Total Marks: " + total + " / 500");
        System.out.printf("Percentage : %.2f%%\n", percentage);
        System.out.println("Grade      : " + grade);
    }
}

public class StudentGradeCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(name);
        student.inputMarks();
        student.calculateResults();
        student.displayResults();
    }
}
