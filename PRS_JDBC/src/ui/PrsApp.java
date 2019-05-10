package ui;

import java.util.List;

import business.User;
import db.DAO;
import db.UserDB;
import util.Console;
import util.StringUtils;

public class PrsApp {
	
	private static DAO<User> userDAO = new UserDB();

	public static void main(String[] args) {

		System.out.println("Welcome to the purchase request system!");
		displayUserMenu();
		
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get input
			action = Console.getRequiredString("Enter a command:  ");
			
			if (action.equalsIgnoreCase("list")) {
				displayAllUsers();
			} else if (action.equalsIgnoreCase("add")) {
				addUser();
			} else if (action.equalsIgnoreCase("del")) {
				deleteUser();
			} else if (action.equalsIgnoreCase("help") ||
					   action.equalsIgnoreCase("menu")) {
				displayUserMenu();
			} else if (!action.equalsIgnoreCase("exit")){
				System.out.println("Invalid command.");
			}
		}
	
		

		System.out.println("Goodbye!");

	}

	public static void displayMainMenu() {
		System.out.println("MAIN MENU");
		System.out.println("===============");
		System.out.println("User Menu");
		System.out.println("Vendor Menu");
		System.out.println("Product Menu");
		System.out.println("Purchase Request Menu");
		System.out.println("Purchase Request Line Item Menu");
		System.out.println("help      - Show this menu");
		System.out.println("exit      - Exit this App\n");
	}

	public static void displayUserMenu() {
		System.out.println("USER MENU");
		System.out.println("===============");
		System.out.println("list      - List all users");
		System.out.println("add       - Add a user");
		System.out.println("del       - Delete a user");
		System.out.println("help      - Show this menu");
		System.out.println("exit      - Exit this App\n");
	}
	
	private static void displayAllUsers() {
		System.out.println("USER LIST:");
		System.out.println("================");
		
		List<User> user = userDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (User u : user) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(u.getId()), 8));
			sb.append(StringUtils.padWithSpaces(u.getUserName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getPassword(), 20));
			sb.append(StringUtils.padWithSpaces(u.getFirstName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getLastName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getPhoneNumber(), 20));
			sb.append(StringUtils.padWithSpaces(u.getEmail(), 20));
			sb.append(u.getIsReviewer()); 
			sb.append(u.getIsAdmin());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void addUser() {
		int ID = Console.getInt("Enter User ID: ");
		String username = Console.getRequiredString("Enter Username: ");
		String password = Console.getRequiredString("Enter Password: ");
		String firstName = Console.getRequiredString("Enter First Name: ");
		String lastName = Console.getRequiredString("Enter Last Name: ");
		String phoneNumber = Console.getRequiredString("Enter Phone Number (xxx-xxx-xxxx): ");
		String email = Console.getRequiredString("Enter Email: ");
		Boolean isReviewer;
			if (Console.getChoiceString("Is this a reviewer (y/n)", "y", "n").equalsIgnoreCase("y")) {
				isReviewer = true;
			} else {
				isReviewer = false;
			}
		Boolean isAdmin;
		 if (Console.getChoiceString("Is this an admin? (y/n)", "y", "n").equalsIgnoreCase("y")) {
			 isAdmin = true;
		 } else {
			 isAdmin = false;
		 }
		
		User u = new User(ID, username, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		if (userDAO.add(u)) {
			System.out.println("User " + u.getId() + " successfully added.");
		} else {
			System.out.println("Error adding product");
		}
	}
	
	private static void deleteUser() {
		System.out.println("DELETING USER!!");
		
		int ID = Console.getInt("Enter User ID: ");
	
		User u = userDAO.get(ID);
		if (u == null) {
			System.out.println("Invalid code.");
		} else {
			if (userDAO.delete(u)) {
				System.out.println("Delete Success");
			} else {
				System.out.println("Error deleting user");
			}
		}
	}

}
