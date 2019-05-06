import java.util.Scanner;

public class tableOfPowersApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the squares and cubes table!");
		
		Scanner sc = new Scanner(System.in); 
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		// prompt user input
			System.out.print("Enter an integer: ");
			int n = sc.nextInt(); 
			
		// creating table, 2nd iteration
		String table = "";
		String row = "";
		String header = "Number\tSquared\tCubed\n";
		
		table += header; // table + header = header
		header = "======\t======\t======\n";
		table += header; 

		// business logic & display results are together for the FOR loop
			for (int i = 1; i <= n; i++) {
				int s = i * i; //want i instead of n as i is the incrementer, using n would only give calculations for number user inputs
				int c = i * i * i;
				row = i+"\t"+s+"\t"+c+"\n";
				table += row;
				
			}

				System.out.println(table);
			
			
// 			1st iteration, no table: 			
//			for (int i = 1; i <= n; i++) {
//				int s = i * i; //want i instead of n as i is the incrementer, using n would only give calculations for number user inputs
//				int c = i * i * i;
//

			System.out.println("Continue?(y/n) ");
			choice = sc.next();
			
		}

		// goodbye
		System.out.println("Bye!");

	}

}
