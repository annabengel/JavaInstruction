package ui;

import java.util.List;

import business.Stuffy;
import db.DAO;
import db.StuffyDB;
import util.Console;
import util.StringUtils;

public class StuffyDispenserApp {
	
	private static DAO<Stuffy> productDAO = new StuffyDB();

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
		System.out.println("help      - Show this menu");
		System.out.println("exit      - Exit this App\n");
	}
	
	private static void displayAllStuffies() {
		System.out.println("STUFFY LIST:");
		System.out.println("================");
		
		//get list of products from text file
		List<Stuffy> products = productDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Stuffy s : products) {
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
		int ID = Console.getInt("Enter stuffy ID: ");
		String type = Console.getRequiredString("Enter stuffy type: ");
		String color = Console.getRequiredString("Enter stuffy color: ");
		String size = Console.getRequiredString("Enter stuffy size: ");
		int limbs = Console.getInt("Enter # of limbs: ");
		
		Stuffy s = new Stuffy(ID, type, color, size, limbs);
		if (productDAO.add(s)) {
			System.out.println("Stuffy " + s.getId() + " successfully added.");
		} else {
			System.out.println("Error adding product");
		}
	}
	
	private static void deleteStuffy() {
		System.out.println("DELETING STUFFY!!");
		
		int ID = Console.getInt("Enter stuffy ID: ");
		// get a product for the code 
		Stuffy s = productDAO.get(ID);
		if (s == null) {
			System.out.println("Invalid code.");
		} else {
			if (productDAO.delete(s)) {
				System.out.println("Delete Success");
			} else {
				System.out.println("Error deleting product");
			}
		}
	}

}
