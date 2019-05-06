import java.util.Scanner;

public class DiceRoller {

	public static void main(String[] args) {
		// declare limit
		final int LIMIT = 6;

		// Welcome
		displayGreetingMessage();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			int die1 = (int) ((Math.random() * 6) + 1);
			int die2 = (int) ((Math.random() * 6) + 1);
			int sum = die1 + die2;

			if(die1==1&&die2==1) {
				System.out.println("Snake eyes!");
			}
				
			else if(die1==6&&die2==6) {
				System.out.println("Box cars!");
			} 
			
			else {
				System.out.println("Die 1: " + die1);
				System.out.println("Die 2: " + die2);
				System.out.println("Total: " + sum);
			}

			System.out.println("Roll again? (y/n)");

			choice = sc.next();
			
			}
		
			System.out.println("BYE!");
			
			}



	private static void displayGreetingMessage() {
        System.out.println("Welcome to the Dice Roller!");
        System.out.println();
	} //closes greeting method
	
	
	} // closes class
  
