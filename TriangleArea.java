import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base of the triangle: ");
        double base = scanner.nextDouble();
        
        System.out.print("Enter height of the triangle: ");
        double height = scanner.nextDouble();
        
        double area = 0.5 * base * height;
        System.out.println("Area of the triangle = " + area + " sq. units");
        
        scanner.close();
    }
}
