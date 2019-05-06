
public class Employee extends Person {
	// instance variable
	public String ssn;
	
	// constructors
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String ssn) {
		super(firstName, lastName);
		this.ssn = ssn;
	}

	// getter and setter 
	public String getSsn() {
		String part4 = ssn.substring(7);
		ssn = "xxx-xx-" + part4;
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String toString() {
        return ("Name: "+ firstName + lastName + "\n" +
        		"SSN: " + getSsn());
	}
}
