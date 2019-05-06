import java.text.NumberFormat;

public class MonthSelectorApp {

    public static void main(String[] args) {
        System.out.println("Monthly Sales\n");
        
        // declare monthNames and monthSales arrays
        String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August",
        		"September", "October", "November", "December"};
        double[] monthSales = {45000, 32000.08, 30000.87, 28500, 28000, 32000.99, 30000.09, 34000, 
        		20000.90, 18000.77, 50000.67, 75000.56};
        


        // get currency formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        // get one or more months
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            int monthNumber = Console.getInt("Enter month number: ");
            
            // validate input
            if (monthNumber < 1 || monthNumber > monthName.length) {
                Console.displayLine("Invalid month number. Try again.");
                continue;                
            }
            
            // get the index number for the month
            // and display the month name and sales
           int monthIndex = monthNumber - 1;
           	Console.displayLine("Sales for " + monthName[monthIndex] + ": " + 
           			currency.format(monthSales[monthIndex])) ;
           	
            


            // check if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }
        
        // display the total sales for the year
        double sum = 0.0;
       // for (int i=0; i < monthSales.length; i++) {
        //	sum += monthSales[i];

        
       for (double sales : monthSales) {
        	sum += sales; }
        
        
        Console.displayLine("Total Sales: "+currency.format(sum));
        
        Console.displayLine();
    }    

}
