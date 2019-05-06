
public class Person {
	
	//instance variables
	public String firstName;
	public String lastName;
	
	// 2 constructors 
	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// getters and setters 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//toString override
    public String toString() {
        return ("Name: "+ firstName + " " + lastName);
    }

}
