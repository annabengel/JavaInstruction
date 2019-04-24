import java.util.Scanner;	// must be imported 

public class CalculatorApp {

	public static void main(String[] args) {
		// Welcome the user to the program
		System.out.println("Welcome to the Calculator App!");

		//declare a scanner
		Scanner sc = new Scanner(System.in); 
		// define 2 doubles
		System.out.print("Enter int a: ");
		double x = sc.nextInt();
		System.out.print("Enter int b: ");
		double y = sc.nextInt();

		// define sum, difference, product, quotient
		double sum = x + y; // sum = 24
		double difference = x - y; // difference = 18
		double product = x * y; // product = 63
		double quotient = x / y; // quotient = 10.5

		// print results
		System.out.println("Sum: "+sum);
		System.out.println("Difference: "+difference);
		System.out.println("Product: "+product);
		System.out.println("Quotient: "+quotient);
		
		// end program
		System.out.println("Goodbye!");

	}

}
