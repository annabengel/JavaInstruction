package ui;
import business.Book;

public class ProductDemoApp {

	public static void main(String[] args) {
		System.out.println("hello");
		
		// create instances of product
		//Product product1 = new Product("java", "Murach's Java Programming",57.50);
		//Product product2 = new Product("mysql", "Murach's MySQL",54.50);
		
		//Product.aStaticMethod(); // no methods to call for Product. until method was created in the Product class
		
		//System.out.println(product1.getCode()+" "+product1.getDescription()+" "+product1.getPrice()+" ");
		//System.out.println(product2.toString());
		
		//Create a book
		Book annasBook = new Book ("java", "Murach's Java Programming", 57.50, "Joel Murach");
		System.out.println(annasBook);
		System.out.println("bye");
	}

}
