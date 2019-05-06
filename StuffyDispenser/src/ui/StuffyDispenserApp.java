package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Stuffy;
import util.Console;

public class StuffyDispenserApp {

	public static void main(String[] args) {
	
		System.out.println("Welcome to the Stuffy Dispenser App!");
		System.out.println("This app will mimic the functionality of a stuffy dispensing machine.\n" +
		"The user will be able to select a stuffy and, hopefully, the app will return one!");
		
		Scanner sc = new Scanner(System.in);
		// first step: initialization of stuffy list (make the array)
// FIRST ITERATION USING ARRAYS
//		Stuffy[] stuffies = new Stuffy [10]; //Stuffy must be imported from business package
//		stuffies[0] = new Stuffy(1, "Dog", "Blue", "Large", 4);
//		stuffies[1] = new Stuffy(2, "Cat", "Green", "Small", 4);
//		stuffies[2] = new Stuffy(3, "Dragon", "Purple", "Medium", 6);
//		stuffies[3] = new Stuffy(4, "Snail", "Yellow", "X-Large", 1);
//		stuffies[4] = new Stuffy(5, "Platypus", "Blue", "Medium", 4);
//		stuffies[5] = new Stuffy(6, "Octopus", "Purple", "Large", 8);
//		stuffies[6] = new Stuffy(7, "Squirrel", "Brown", "Small", 4);
//		stuffies[7] = new Stuffy(8, "Starfish", "Pink", "X-Large", 5);
//		stuffies[8] = new Stuffy(9, "Lobster", "Red", "Large", 10);
//		stuffies[9] = new Stuffy(10, "Spider", "Clear", "Small", 8);
		
// SECOND ITERATION - ArrayList
		List<Stuffy> stuffies = new ArrayList<>();
		stuffies.add(new Stuffy(1, "Dog", "Blue", "Large", 4));
		stuffies.add(new Stuffy(2, "Cat", "Green", "Small", 4));
		stuffies.add(new Stuffy(3, "Dragon", "Purple", "Medium", 6));
		stuffies.add(new Stuffy(4, "Snail", "Yellow", "X-Large", 1));
		stuffies.add(new Stuffy(5, "Platypus", "Blue", "Medium", 4));
		stuffies.add(new Stuffy(6, "Octopus", "Purple", "Large", 8));
		stuffies.add(new Stuffy(7, "Squirrel", "Brown", "Small", 4));
		stuffies.add(new Stuffy(8, "Starfish", "Pink", "X-Large", 5));
		stuffies.add(new Stuffy(9, "Lobster", "Red", "Large", 10));
		stuffies.add(new Stuffy(10, "Spider", "Clear", "Small", 8));
		
		
		// For Loop to print list of stuffies for user
		//Use basic for loop so indexes are printed
//		for (int i=0; i < stuffies.length; i++) {
//			System.out.println("Stuffy " + i + ": " + stuffies[i]);
//		}		
		
		//Second iteration enhanced for loop
		for (Stuffy s: stuffies) {
			System.out.println(s);
		}
		
		// Loop (while) until user wants to quit
		String choice = "";
		while (!choice.equalsIgnoreCase("x")) {
			choice = Console.getRequiredString(sc, getMenuOptions());
			if(choice.equalsIgnoreCase("s")) {
			
			// 1. Prompt for user input (i.e. "Pick a Stuffy")
			int selectionNbr = Console.getIntWithinRange(sc, "Pick a Stuffy by number(1-10): ", 0, 11);
				
			// 2. Business logic (retrieve a stuffy from the list)
			Stuffy selectedStuffy = null;
			for (Stuffy s: stuffies) {
				//compare ID to selectionNbr
				if (s.getId()==selectionNbr) {
					selectedStuffy = s;
					
				}
			}
				
			// 3. Display the selected Stuffy
			System.out.println("Congratulations, you have a " +selectedStuffy.getSize() + 
			", " + selectedStuffy.getColor() + ", " + selectedStuffy.getType() + " stuffy!");
			}
			
			else if (choice.equalsIgnoreCase("a")) {
				int id = Console.getInt(sc, "Stuffy ID: ");
				String t = Console.getRequiredString(sc, "Stuffy Type: ");
				String c = Console.getRequiredString(sc, "Get color: ");
				String s = Console.getRequiredString(sc, "Stuffy size: ");
				int l = Console.getInt(sc, "Number of limbs: ");
				Stuffy stuffy = new Stuffy(id,t,c,s,l);
				stuffies.add(stuffy);
						 
			}

			
		}
		
		System.out.println("Goodbye!");

	}
	
	private static String getMenuOptions() {
		String s = "Menu Options \n" +
					"S - Search for a Stuffy\n" +
					"A - Add a Stuffy\n" +
					"X - Exit\n";
		return s;
		
	}

}
