package ui;

import java.util.Scanner;

import business.Calculator;
import util.Console;

public class CalculatorApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Bootcamp Calculator App!");

		double result = 0.0;
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			int x = Console.getIntWithinRange("Enter first number: ", 0, Integer.MAX_VALUE);
			String opr = Console.getRequiredString("Operation (+ - * / %)?");
			int y = Console.getIntWithinRange("Enter second number: ", 0, Integer.MAX_VALUE);
			Calculator calc = new Calculator(x,y);
			
			if (opr.equals("+")) {
				result = calc.add();
			} else if (opr.equals("-")) {
				result = calc.subtract();
			} else if (opr.equals("*")) {
				result = calc.multiply();
			} else if (opr.equals("/")) {
				result = calc.divide();
			} else if (opr.equals("%")) {
				result = calc.modulus();
			}
			System.out.println("Result = " + result);
			choice = Console.getRequiredString("Continue? (y/n)");
		}
	}

}
