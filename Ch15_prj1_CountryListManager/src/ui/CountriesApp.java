package ui;

import java.util.ArrayList;
import java.util.List;

import business.Country;
import business.CountryIO;
import util.Console;
import util.StringUtils;

public class CountriesApp {
	// declare class variables
	private static CountryIO c = new CountryIO();

	public static void main(String[] args) {
		System.out.println("Welcome to the Country List Manager.");
		displayMenu();
		
		//perform 1 or more actions
		String action = "";
		while (!action.equalsIgnoreCase("3")) {
			//get input from user
			action = Console.getRequiredString("Enter menu number: ");
			System.out.println();
			
			if (action.equalsIgnoreCase("1")) {
				displayAllCountries();
			} else if (action.equalsIgnoreCase("2")) {
				addCountry();
			} else {
				System.out.println("Error! Not a valid command. \n");
			}
		
		
		System.out.println("Bye");
		}
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("1   - List countries");
		System.out.println("2     - Add a country");
		System.out.println("3    - Exit");
	}

	private static void displayAllCountries() {
		System.out.println("Countries: ");

		List<Country> countries = c.getCountries();
		StringBuilder sb = new StringBuilder();
		for (Country c : countries) {
			sb.append(c.getCountry());
			sb.append("\n");
			
			 
		}
		System.out.println(sb.toString());
		

	}

	private static void addCountry() {
		String name = Console.getRequiredString("Enter country: ");
		List<Country> countries = c.getCountries();
		Country n = new Country();
		if (countries.add(n)) {
			System.out.println("Country " + c.getCountries() + " successfully added.");
		} else {
			System.out.println("Error adding country");
		}
	}

}

