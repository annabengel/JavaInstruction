import java.text.NumberFormat;
import java.util.Scanner;

public class tipCalculator {

	public static void main(String[] args) {
		// welcome
		System.out.println("Tip Calculator");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		// prompt user input
		System.out.println("Cost of meal: ");
		double cost = sc.nextDouble();
		
	
		
		// business logic
		for (double d = .15; d <= .25; d += .05) {
			double tipAmount = cost * d;
			double totalAmount = cost + (cost * d);
			
			NumberFormat percent = NumberFormat.getPercentInstance();
			NumberFormat currency = NumberFormat.getCurrencyInstance();
            
			System.out.println(
					percent.format(d)+"\n"+"Tip Amount: "+currency.format(tipAmount)
					+"\n"+"Total Amount: "+currency.format(totalAmount));		
		}
		
		
		
		System.out.println("Continue?(y/n) ");
		choice = sc.next();
		}
		
		// goodbye
		System.out.println("Bye!");

	}

}
