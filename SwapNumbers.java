import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input first number: ");
        double firstNumber = scanner.nextDouble();
        
        System.out.print("Input second number: ");
        double secondNumber = scanner.nextDouble();
        
        double temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
        
        System.out.println("First number after swapping: " + firstNumber);
        System.out.println("Second number after swapping: " + secondNumber);
        
        scanner.close();
    }
}
