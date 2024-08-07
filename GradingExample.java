import java.util.Scanner;

class GradingSystem {
    private int[] marks;

    
    public GradingSystem(int[] marks) {
        this.marks = marks;
    }

    
    public void calculateGrade() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        double percentage = (totalMarks / 5.0);

        int gradeCategory = (int) percentage / 10;
        
        System.out.println("Percentage: " + percentage + "%");
        
        switch (gradeCategory) {
            case 10:
            case 9:
            case 8:
            case 7:
                System.out.println("Honors");
                break;
            case 6:
                System.out.println("First Division");
                break;
            case 5:
                System.out.println("Second Division");
                break;
            case 4:
                System.out.println("Third Division");
                break;
            default:
                System.out.println("Failed");
                break;
        }
    }
}

public class GradingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[5];
        
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        
        GradingSystem gradingSystem = new GradingSystem(marks);
        gradingSystem.calculateGrade();
        
        scanner.close();
    }
}