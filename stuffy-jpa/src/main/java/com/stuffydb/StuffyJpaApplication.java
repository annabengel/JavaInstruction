package com.stuffydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stuffydb.util.Console;


@SpringBootApplication
public class StuffyJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuffyJpaApplication.class, args);
		
		System.out.println("Hello");
		displayMenu();
		
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get input
			action = Console.getRequiredString("Enter a command:  ");
			
			if (action.equalsIgnoreCase("list")) {
				//displayAllStuffies();
			} else if (action.equalsIgnoreCase("add")) {
				//addStuffy();
			} else if (action.equalsIgnoreCase("del")) {
				//deleteStuffy();
			} else if (action.equalsIgnoreCase("update")) {
				//updateStuffy();
			} else if (action.equalsIgnoreCase("help") ||
					   action.equalsIgnoreCase("menu")) {
				displayMenu();
			} else if (!action.equalsIgnoreCase("exit")){
				System.out.println("Invalid command.");
			}
		}
		
		
		
		
		
		System.out.println("Bye");
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

}
