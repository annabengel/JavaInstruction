package ui;

import java.util.List;

import business.Stuffy;
import db.DAO;
import db.StuffyDB;
import util.Console;
import util.StringUtils;

public class StuffyDispenserApp {
	
	private static DAO<Stuffy> stuffyDAO = new StuffyDB();

	public static void main(String[] args) {
	
		System.out.println("Welcome to the Stuffy Dispenser App!");
		System.out.println("This app will mimic the functionality of a stuffy dispensing machine.\n" +
		"The user will be able to select a stuffy and, hopefully, the app will return one!");
		displayMenu();

		
		// perform 1 or more actions
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get input
			action = Console.getRequiredString("Enter a command:  ");
			
			if (action.equalsIgnoreCase("list")) {
				displayAllStuffies();
			} else if (action.equalsIgnoreCase("add")) {
				addStuffy();
			} else if (action.equalsIgnoreCase("del")) {
				deleteStuffy();
			} else if (action.equalsIgnoreCase("update")) {
				updateStuffy();
			} else if (action.equalsIgnoreCase("help") ||
					   action.equalsIgnoreCase("menu")) {
				displayMenu();
			} else if (!action.equalsIgnoreCase("exit")){
				System.out.println("Invalid command.");
			}
		}
	
		
		System.out.println("Goodbye!");

	}
	
	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("===============");
		System.out.println("list      - List all stuffies");
		System.out.println("add       - Add a stuffy");
		System.out.println("del       - Delete a stuffy");
		System.out.println("update    - Update a stuffy");
		System.out.println("help      - Show this menu");
		System.out.println("exit      - Exit this App\n");
	}
	
	private static void displayAllStuffies() {
		System.out.println("STUFFY LIST:");
		System.out.println("================");
		
		List<Stuffy> stuffy = stuffyDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Stuffy s : stuffy) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(s.getId()), 8));
			sb.append(StringUtils.padWithSpaces(s.getType(), 25));
			sb.append(StringUtils.padWithSpaces(s.getColor(), 25));
			sb.append(StringUtils.padWithSpaces(s.getSize(), 25));
			sb.append(s.getLimbs()); 
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void addStuffy() {
		String type = Console.getRequiredString("Enter stuffy type: ");
		String color = Console.getRequiredString("Enter stuffy color: ");
		String size = Console.getRequiredString("Enter stuffy size: ");
		int limbs = Console.getInt("Enter # of limbs: ");
		
		Stuffy s = new Stuffy (type, color, size, limbs);
		if (stuffyDAO.add(s)) {
			System.out.println("Stuffy " + s.getId() + " successfully added.");
		} else {
			System.out.println("Error adding product");
		}
	}
	
	private static void updateStuffy() {
	      int ID = Console.getInt("Enter stuffy ID to update: ");
	        
	      Stuffy s = stuffyDAO.get(ID);
	        if (s == null) {
	            System.out.println("No Stuffy matches that code.\n");
	            return;
	        } 
	        
	        String color = Console.getRequiredString("Enter stuffy color: ");

	        s.setColor(color);

	        boolean success = stuffyDAO.update(s);
	        if (success) {
	            System.out.println(ID
	                    + " has been updated in the database.\n");
	        } else {
	            System.out.println("Error! Unable to update stuffy.\n");
	        }

	    }


	
	private static void deleteStuffy() {
		System.out.println("DELETING STUFFY!!");
		
		int ID = Console.getInt("Enter stuffy ID: ");
		// get a product for the code 
		Stuffy s = stuffyDAO.get(ID);
		if (s == null) {
			System.out.println("Invalid code.");
		} else {
			if (stuffyDAO.delete(s)) {
				System.out.println("Delete Success");
			} else {
				System.out.println("Error deleting product");
			}
		}
	}

}
