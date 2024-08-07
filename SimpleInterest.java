import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter principle: ");
        double principle = scanner.nextDouble();
        
        System.out.print("Enter time: ");
        double time = scanner.nextDouble();
        
        System.out.print("Enter rate: ");
        double rate = scanner.nextDouble();
        
        double simpleInterest = (principle * rate * time) / 100;
        System.out.println("Simple Interest = " + simpleInterest);
        
        scanner.close();
    }
}
