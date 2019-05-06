import java.util.Scanner;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager!"); 
		System.out.println();

		Scanner sc = new Scanner(System.in);
		 String choice = "y";
		 
	       while (choice.equalsIgnoreCase("y")) {
	    	   String personType = Console.getChoiceString(sc, 
	    			   "Create customer or employee? (c/e): ", "c", "e");
	    	   if(personType.equalsIgnoreCase ("c")) {
	    		   //prompt for input
	    		   Customer c = getCustomer(sc);
	    		   
	    		   System.out.println("You entered a new customer!");
				
				System.out.println(c.toString());
	    		   
	    	   } else if(personType.equalsIgnoreCase("e")) {
	    		   
	    		   Employee e = getEmployee(sc);

	    		   System.out.println("You entered a new employee!");
	    		   System.out.println(e.toString());
	    	   }
	    	   
	    	   choice = Console.getChoiceString(sc, "Continue?", "y", "n");
	    		
	    }
	   

	   System.out.println("Goodbye!");
	   
	      }
	
	public static Customer getCustomer(Scanner sc) {

		String cFirstName = Console.getRequiredString(sc, "Enter the customer's first name: ");
	    String cLastName = Console.getRequiredString(sc, "Enter the customer's last name: ");
	    String cNumber = Console.getRequiredString(sc, "Enter the customer number: ");
	    return new Customer(cFirstName, cLastName, cNumber);

	}  
	
	public static Employee getEmployee(Scanner sc) {
		
		String eFirstName = Console.getRequiredString(sc, "Enter the employee's first name: ");
		String eLastName = Console.getRequiredString(sc, "Enter the employee's last name: ");
		String eSSN = Console.getRequiredString(sc, "Enter the employee's SSN: ");
		return new Employee (eFirstName, eLastName, eSSN);
	}
	
	}


