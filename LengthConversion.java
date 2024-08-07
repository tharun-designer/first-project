import java.util.Scanner;

public class LengthConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter length in centimeter: ");
        double lengthCm = scanner.nextDouble();
        
        double lengthM = lengthCm / 100;
        double lengthKm = lengthCm / 100000;
        
        System.out.println("Length in meter = " + lengthM + " m");
        System.out.println("Length in kilometer = " + lengthKm + " km");
        
        scanner.close();
    }
}
