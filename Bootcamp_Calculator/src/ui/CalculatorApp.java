package ui;

import java.util.Scanner;

import util.Console;

public class CalculatorApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Bootcamp Calculator App!");

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			String equationType = Console.getLongChoiceString(sc, "What equation would you like to perform?\n"
					+ "-Addition(a)\n -Subtraction(s)\n -Multiplication(m)\n -Division(d)\n -Modulus(mod)", 
					"a", "s", "m", "d", "mod");

			// user input
			double x = Console.getDouble(sc, "Enter first number: ");
			
			double y = Console.getDouble(sc, "Enter second number: ");


			double equation = 0;
			if (equationType.equalsIgnoreCase("a")) {
				equation = x + y;
			} else if (equationType.equalsIgnoreCase("s")) {
				equation = (x - y);
			} else if (equationType.equalsIgnoreCase("m")) {
				equation = (x * y);
			} else if (equationType.equalsIgnoreCase("d")) {
				equation = (x / y);
			} else if (equationType.equalsIgnoreCase("mod")) {
				equation = (x % y);
			} else {
				System.out.println("Invalid entry.");

			}

			// display results
			System.out.println("The value is: " + equation);
	    	choice = Console.getChoiceString(sc, "Continue?", "y", "n");

		}

		goodbye();

	}

	public static void goodbye() {
		System.out.println("Goodbye!");
	}
	
}
