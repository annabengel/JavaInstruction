package db;
import business.Product;

public interface ProductReader {
	// from page 305 in book
	Product get (String code); // getting product for a code passed in
	String getAll(); // returns a String of some data to print to console
	

}
