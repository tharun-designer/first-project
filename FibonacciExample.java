import java.util.Scanner;

class Fibonacci {
    private int n;

        public Fibonacci(int n) {
        this.n = n;
    }

    
    public void printFibonacciSeries() {
        int a = 0, b = 1;
        System.out.print("Fibonacci series of " + n + " terms: ");
        for (int i = 1; i <= n; ++i) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
class FibonacciExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms for the Fibonacci series: ");
        int n = scanner.nextInt();
        
        Fibonacci fibonacci = new Fibonacci(n);
        fibonacci.printFibonacciSeries();
        
        scanner.close();
    }
}