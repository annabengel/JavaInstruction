import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class interestCalculator {

	public static void main(String[] args) {
		//Welcome
		System.out.println("Welcome to the Interest Calculator");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		//Prompt User Input
		System.out.println("Enter loan amount: ");
		String loanAmountString = sc.next();
		BigDecimal loanAmount = new BigDecimal(loanAmountString);
		
		System.out.println("Enter interest rate: ");
		String interestRateString = sc.next();
		BigDecimal interestRate = new BigDecimal(interestRateString);
		
		//Business logic
		BigDecimal interest =loanAmount.multiply(interestRate);
		
		
		//Display Results
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setRoundingMode(RoundingMode.HALF_UP);
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(3);
		
		System.out.println("Loan amount: "+currency.format(loanAmount));
		System.out.println("Interest rate: "+percent.format(interestRate));
		System.out.println("Interest: "+currency.format(interest));
		
		System.out.println("Continue?(y/n) ");
		choice = sc.next();
			
		}
		
		//Goodbye
		System.out.println("BYE!");

	
	}
}
