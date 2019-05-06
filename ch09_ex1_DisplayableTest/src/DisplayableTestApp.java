public class DisplayableTestApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Displayable Test application\n");

        // create an Employee object and display it	
        Displayable e = new Employee(2, "Smith", "John");
        display (e); // passes this Displayable object to display method
        	
        // TODO: add code that passes this object to the display method below

        Displayable p = new Product("java", "Murach's Java Programming", 57.50);
        display (p);
        // TODO: add code that passes this object to the display method below
        
        System.out.println();        
    }

    private static void display(Displayable d) {
        System.out.println(d.getDisplayText());
    }
}