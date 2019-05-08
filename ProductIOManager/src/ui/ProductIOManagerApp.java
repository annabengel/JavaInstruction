package ui;

import java.util.List;

import business.Product;
import db.DAO;
import db.ProductDB;
//import db.ProductTextFile;
import util.Console;
import util.StringUtils;

public class ProductIOManagerApp {
	
	// declare this object outside Main method to use throughout Class
	//private static DAO<Product> productDAO = new ProductTextFile(); --> for textfile case
	// for DB:
	private static DAO<Product> productDAO = new ProductDB();
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Product Manager - Text File Edition");
		displayMenu();
		
		// perform 1 or more actions
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get input
			action = Console.getRequiredString("Enter a command:  ");
			
			if (action.equalsIgnoreCase("list")) {
				displayAllProducts();
			} else if (action.equalsIgnoreCase("add")) {
				addProduct();
			} else if (action.equalsIgnoreCase("del")) {
				deleteProduct();
			} else if (action.equalsIgnoreCase("help") ||
					   action.equalsIgnoreCase("menu")) {
				displayMenu();
			} else {
				System.out.println("Invalid command.");
			}
		}
	
		
		
		System.out.println("Bye");

	}
	
	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("===============");
		System.out.println("list      - List all products");
		System.out.println("add       - Add a product");
		System.out.println("del       - Delete a product");
		System.out.println("help      - Show this menu");
		System.out.println("exit      - Exit this App\n");
	}
	
	private static void displayAllProducts() {
		System.out.println("PRODUCT LIST:");
		System.out.println("================");
		
		//get list of products from text file
		List<Product> products = productDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Product p : products) {
			sb.append(StringUtils.padWithSpaces(p.getCode(), 8));
			sb.append(StringUtils.padWithSpaces(p.getDescription(), 40));
			sb.append(p.getPrice()); 
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void addProduct() {
		String code = Console.getRequiredString("Enter product code: ");
		String description = Console.getRequiredString("Enter product description: ");
		double price = Console.getDouble("Enter product price: ");
		
		Product p = new Product(code, description, price);
		if (productDAO.add(p)) {
			System.out.println("Product " + p.getCode() + " successfully added.");
		} else {
			System.out.println("Error adding product");
		}
	}
	
	private static void deleteProduct() {
		System.out.println("DELETE PRODUCT!!");
		
		String code = Console.getRequiredString("Enter product code: ");
		// get a product for the code (adding method to txt file)
		Product p = productDAO.get(code);
		if (p == null) {
			System.out.println("Invalid code.");
		} else {
			if (productDAO.delete(p)) {
				System.out.println("Delete Success");
			} else {
				System.out.println("Error deleting product");
			}
		}
	}

}
