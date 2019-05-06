
public class Customer extends Person {
	// instance variable
	public String customerNumber;
	
	// constructors
	public Customer() {
		super();
	}
	
	public Customer(String firstName, String lastName, String customerNumber) {
		super(firstName, lastName);
		this.customerNumber = customerNumber;
	}

	// getter and setter
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	// toString override
	 public String toString() {
	        return ("Name: "+ firstName + " " + lastName + "\n" +
	        		"Customer Number: " + customerNumber);
	 }
}
