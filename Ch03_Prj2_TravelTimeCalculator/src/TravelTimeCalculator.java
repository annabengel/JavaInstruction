import java.util.Scanner;

public class TravelTimeCalculator {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Travel Time Calculator");
		
		Scanner sc = new Scanner(System.in); 
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		//User input
		
		System.out.println("Enter miles: ");
		double miles = sc.nextDouble();
		
		System.out.println("Enter miles per hour: ");
		double speed = sc.nextDouble();
		
		// Business Logic
		
		int hours = (int) (miles / speed);
		int minutes = (int) ((miles % speed) / speed * 60); 
		
		//Display Results
		System.out.println("Estimated travel time" + "\n" + "--------------------");
		System.out.println("Hours: " + hours);
		System.out.println("Minutes: " + minutes);
		
		System.out.println("Continue?(y/n) ");
		choice = sc.next();
		
		}
		
		//Goodbye
		System.out.println("BYE");

	}

}
