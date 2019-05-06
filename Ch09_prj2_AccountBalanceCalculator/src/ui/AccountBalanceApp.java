package ui;

import java.text.NumberFormat;
import java.util.Scanner;

import business.Account;
import business.CheckingAccount;
import business.SavingsAccount;
import util.Console;

public class AccountBalanceApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Account Balance App!");
		
		SavingsAccount sa = new SavingsAccount(1000, .01);
		CheckingAccount ca = new CheckingAccount(1000, 1);
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Starting Balances: ");
		printBalances(sa, ca, cf);
		
		System.out.println("\nEnter Transactions for the Month");
		
		String choice = ("y");
		while (choice.equalsIgnoreCase("y")) {
			String transType = Console.getChoiceString(sc, "Withdrawal or Deposit? (w/d)", "w", "d");
			String acctType=Console.getChoiceString(sc, "Checking or Savings (c/s?)", "c", "s");
			double amt = Console.getDouble(sc, "Amount?", 0, Double.POSITIVE_INFINITY); 
			
		// business logic
			
		Account a; 
		if (acctType.equalsIgnoreCase("c")) {
			a = ca;
		} else {
			a = sa;
		}
			
		if (transType.equalsIgnoreCase("w")) {
			a.withdraw(amt);
		} else { 
			a.deposit(amt);
		}
			
			choice = Console.getChoiceString(sc, "Continue?", "y", "n");
		}
		// subtract checking fee and apply savings interest
		ca.subtractMonthlyFee();
		sa.applyMonthlyPayment();
		
		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking Fee: "+ cf.format(ca.getMonthlyFee()));
		System.out.println("Interest Payment: " + cf.format(sa.getMonthlyInterestPayment()));
		
		System.out.println("Final Balances: ");
		printBalances(sa, ca, cf);
		
		System.out.println("Bye!");

	}
	//must be static since main method is static and cannot call non-static methods
	private static void printBalances(SavingsAccount sa, CheckingAccount ca, NumberFormat cf) {
		System.out.println("Checking Account: " + cf.format(ca.getBalance()));
		System.out.println("Savings Account: "+ cf.format(sa.getBalance()));
	}

}
