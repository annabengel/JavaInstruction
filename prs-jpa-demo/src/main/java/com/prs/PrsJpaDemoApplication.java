package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.Product;
import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestLineItem;
import com.prs.business.User;
import com.prs.business.Vendor;
import com.prs.db.ProductDB;
import com.prs.db.PurchaseRequestDB;
import com.prs.db.PurchaseRequestLineItemDB;
import com.prs.db.UserDB;
import com.prs.db.VendorDB;
import com.prs.util.Console;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		System.out.println("Hello");
		displayMainMenu();

		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			action = Console.getRequiredString("Enter a command:  ");

		if (action.equalsIgnoreCase("um")) {
			displayUserMenu();
			String option = "";
			while (!option.equalsIgnoreCase("main")) {
				option = Console.getRequiredString("Enter a command:  ");
				if (option.equalsIgnoreCase("list")) {
					displayAllUsers();
				} else if (option.equalsIgnoreCase("add")) {
					addUser();
				} else if (option.equalsIgnoreCase("del")) {
					deleteUser();
				} else if (option.equalsIgnoreCase("help") || option.equalsIgnoreCase("menu")) {
					displayUserMenu();
				} else if (option.equalsIgnoreCase("main")) {
					displayMainMenu();
				} else if (!option.equalsIgnoreCase("main")) {
					System.out.println("Invalid command.");
				}
			}
			} else if (action.equalsIgnoreCase("vm")) {
				displayVendorMenu();
				String option = "";
				while (!option.equalsIgnoreCase("main")) {
					option = Console.getRequiredString("Enter a command:  ");
					if (option.equalsIgnoreCase("list")) {
						displayAllVendors();
					} else if (option.equalsIgnoreCase("add")) {
						addVendor();
					} else if (option.equalsIgnoreCase("del")) {
						deleteVendor();
					} else if (option.equalsIgnoreCase("help") || option.equalsIgnoreCase("menu")) {
							displayVendorMenu();
					} else if (option.equalsIgnoreCase("main")) {
						displayMainMenu();
					} else if (!option.equalsIgnoreCase("main")) {
						System.out.println("Invalid command.");
					}
				}
			} else if (action.equalsIgnoreCase("pm")) {
				displayProductMenu();
				String option = "";
				while (!option.equalsIgnoreCase("main")) {
					option = Console.getRequiredString("Enter a command:  ");
					if (option.equalsIgnoreCase("list")) {
						displayAllProducts();
					} else if (option.equalsIgnoreCase("add")) {
						addProduct();
					} else if (option.equalsIgnoreCase("del")) {
						deleteProduct();
					} else if (option.equalsIgnoreCase("help") || option.equalsIgnoreCase("menu")) {
							displayProductMenu();
					} else if (option.equalsIgnoreCase("main")) {
						displayMainMenu();
					} else if (!option.equalsIgnoreCase("main")) {
						System.out.println("Invalid command.");
					}
				}
			} else if (action.equalsIgnoreCase("prm")) {
				displayPurchaseRequestMenu();
				String option = "";
				while (!option.equalsIgnoreCase("main")) {
					option = Console.getRequiredString("Enter a command:  ");
					if (option.equalsIgnoreCase("list")) {
						displayAllPurchaseRequests();
					} else if (option.equalsIgnoreCase("add")) {
						addPurchaseRequest();
					} else if (option.equalsIgnoreCase("del")) {
						deletePurchaseRequest();
					} else if (option.equalsIgnoreCase("help") || option.equalsIgnoreCase("menu")) {
							displayPurchaseRequestMenu();
					} else if (option.equalsIgnoreCase("main")) {
						displayMainMenu();
					} else if (!option.equalsIgnoreCase("main")) {
						System.out.println("Invalid command.");
					}
				}
			} else if (action.equalsIgnoreCase("lim")) {
				displayPurchaseRequestLineMenu();
				String option = "";
				while (!option.equalsIgnoreCase("main")) {
					option = Console.getRequiredString("Enter a command:  ");
					if (option.equalsIgnoreCase("list")) {
						displayAllPurchaseRequestLines();
					} else if (option.equalsIgnoreCase("add")) {
						addPurchaseRequestLine();
					} else if (option.equalsIgnoreCase("del")) {
						deletePurchaseRequestLine();
					} else if (option.equalsIgnoreCase("help") || option.equalsIgnoreCase("menu")) {
							displayPurchaseRequestLineMenu();
					} else if (option.equalsIgnoreCase("main")) {
						displayMainMenu();
					} else if (!option.equalsIgnoreCase("main")) {
						System.out.println("Invalid command.");
					}
				}
			} else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu")) {
				displayMainMenu();
			} else if (!action.equalsIgnoreCase("exit")) {
				System.out.println("Invalid command.");
			}
		}


		System.out.println("bye");
	}

	public static void displayMainMenu() {
		System.out.println("MAIN MENU");
		System.out.println("===============");
		System.out.println("UM - User Menu");
		System.out.println("VM - Vendor Menu");
		System.out.println("PM - Product Menu");
		System.out.println("PRM - Purchase Request Menu");
		System.out.println("LIM - Purchase Request Line Item Menu");
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
		System.out.println("main      - Back to Main Menu\n");
	}

	private static void displayAllUsers() {
		System.out.println("USER LIST:");
		System.out.println("================");

		List<User> users = UserDB.getAll();

		if (users != null) {
			for (User u : users) {
				System.out.println(u);
			}
		} else {
			System.out.println("users null");
		}

	}

	private static void addUser() {
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

		User u = new User(username, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		if (UserDB.add(u)) {
			System.out.println("User " + u.getId() + " successfully added.");
		} else {
			System.out.println("Error adding product");
		}
	}

	private static void deleteUser() {
		System.out.println("DELETING USER!!");

		String email = Console.getRequiredString("Enter User Email: ");

		User u = UserDB.selectUser(email);
		if (u == null) {
			System.out.println("Invalid code.");
		} else {
			if (UserDB.delete(u)) {
				System.out.println("Delete Success");
			} else {
				System.out.println("Error deleting user");
			}
		}
	}

	public static void displayVendorMenu() {
		System.out.println("VENDOR MENU");
		System.out.println("===============");
		System.out.println("list      - List all vendors");
		System.out.println("add       - Add a vendor");
		System.out.println("del       - Delete a vendor");
		System.out.println("help      - Show this menu");
		System.out.println("main      - Back to Main Menu\n");
	}

	private static void displayAllVendors() {
		System.out.println("VENDOR LIST:");
		System.out.println("================");

		List<Vendor> vendor = VendorDB.getAll();

		if (vendor != null) {
			for (Vendor v : vendor) {
				System.out.println(v);
			}
		} else {
			System.out.println("vendors null");
		}

	}

	private static void addVendor() {
		String code = Console.getRequiredString("Enter Vendor Code: ");
		String name = Console.getRequiredString("Enter Vendor Name: ");
		String address = Console.getRequiredString("Enter Address: ");
		String city = Console.getRequiredString("Enter City: ");
		String state = Console.getRequiredString("Enter state: ");
		String zip = Console.getRequiredString("Enter zip code: ");
		String phoneNumber = Console.getRequiredString("Enter Phone Number (xxx-xxx-xxxx):  ");
		String email = Console.getRequiredString("Enter vendor email: ");
		Boolean isPreApproved;
		if (Console.getChoiceString("Is this vendor pre-approved? (y/n)", "y", "n").equalsIgnoreCase("y")) {
			isPreApproved = true;
		} else {
			isPreApproved = false;
		}

		Vendor v = new Vendor (code, name, address, city, state, zip, phoneNumber, email, isPreApproved);
		if (VendorDB.add(v)) {
			System.out.println("Vendor " + v.getId() + " successfully added.");
		} else {
			System.out.println("Error adding vendor");
		}
	}


	private static void deleteVendor() {
		
		System.out.println("DELETING VENDOR!!");

		String email = Console.getRequiredString("Enter Vendor Email: ");

		Vendor v = VendorDB.selectVendor(email);
		if (v == null) {
			System.out.println("Invalid code.");
		} else {
			if (VendorDB.delete(v)) {
				System.out.println("Delete Success");
			} else {
				System.out.println("Error deleting vendor");
			}
		}

	}

	public static void displayProductMenu() {
		System.out.println("PRODUCT MENU");
		System.out.println("===============");
		System.out.println("list      - List all products");
		System.out.println("add       - Add a product");
		System.out.println("del       - Delete a product");
		System.out.println("help      - Show this menu");
		System.out.println("main      - Back to Main Menu\n");
	}

	private static void displayAllProducts() {
		System.out.println("PRODUCT LIST:");
		System.out.println("================");

		List<Product> product = ProductDB.getAll();

		if (product != null) {
			for (Product p : product) {
				System.out.println(p);
			}
		} else {
			System.out.println("vendors null");
		}

	}

	private static void addProduct() {
		
		// vendor Vendor = ???
		String partNumber = Console.getRequiredString("Enter Part Number: ");
		String name = Console.getRequiredString("Enter Product Name: ");
		double price = Console.getDouble("Enter Price: ");
		String unit = Console.getRequiredString("Enter Unit: ");
		String photoPath = Console.getRequiredString("Enter Photo Path: ");

		Product p = new Product (partNumber, name, price, unit, photoPath);
		if (ProductDB.add(p)) {
			System.out.println("Product " + p.getId() + " successfully added.");
		} else {
			System.out.println("Error adding product");
		}

	}

	private static void deleteProduct() {

	}

	public static void displayPurchaseRequestMenu() {
		System.out.println("PURCHASE REQUEST MENU");
		System.out.println("===============");
		System.out.println("list      - List all purchase requests");
		System.out.println("add       - Add a request");
		System.out.println("del       - Delete a request");
		System.out.println("help      - Show this menu");
		System.out.println("main      - Back to Main Menu\n");
	}

	private static void displayAllPurchaseRequests() {
		System.out.println("PURCHASE REQUEST LIST:");
		System.out.println("================");

		List<PurchaseRequest> request = PurchaseRequestDB.getAll();

		if (request != null) {
			for (PurchaseRequest r : request) {
				System.out.println(r);
			}
		} else {
			System.out.println("requests null");
		}

	}

	private static void addPurchaseRequest() {

	}

	private static void deletePurchaseRequest() {

	}

	public static void displayPurchaseRequestLineMenu() {
		System.out.println("PURCHASE REQUEST LINE ITEM MENU");
		System.out.println("===============");
		System.out.println("list      - List all line items");
		System.out.println("add       - Add a line item");
		System.out.println("del       - Delete a line item");
		System.out.println("help      - Show this menu");
		System.out.println("main      - Back to Main Menu\n");;
	}

	private static void displayAllPurchaseRequestLines() {
		System.out.println("PURCHASE REQUEST LINE LIST:");
		System.out.println("================");

		List<PurchaseRequestLineItem> line = PurchaseRequestLineItemDB.getAll();

		if (line != null) {
			for (PurchaseRequestLineItem l : line) {
				System.out.println(l);
			}
		} else {
			System.out.println("lines null");
		}

	}

	private static void addPurchaseRequestLine() {

	}

	private static void deletePurchaseRequestLine() {

	}

}
