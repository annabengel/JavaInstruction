import java.util.Scanner;

public class factorialCalculatorApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Factorial Calculator!");

		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// prompt user input
			System.out.println("Enter an integer that's greater than 0 and less that 10: ");
			int n = sc.nextInt();

			// business logic
			long result = 1;

	        for (int factor = 2; factor <= n; factor++) {
	            result *= factor;
	        }

				

				System.out.println("The factorial of" + n + "is" + result);

				System.out.println("Continue?(y/n) ");
				choice = sc.next();

			}
			
		System.out.println("Bye!");
		
		}
	

	}
