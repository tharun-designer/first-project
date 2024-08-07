import java.util.Scanner;

public class CircleProperties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        
        double diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2);
        
        System.out.println("Diameter = " + diameter + " units");
        System.out.printf("Circumference = %.2f units\n", circumference);
        System.out.printf("Area = %.2f sq. units\n", area);
        
        scanner.close();
    }
}
