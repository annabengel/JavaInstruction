package db;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;

import business.Product;

public class ProductTextFile implements DAO<Product> {

	private List<Product> products = null;
	private Path productsPath = null;
	private File productsFile = null;
	private final String FIELD_SEP = "\t";

	// default constructor; gets called in main: "new ProductTextFile" creates an
	// instance
	// when called, you get access to the product text file.
	public ProductTextFile() {
		// 1. define path to file
		productsPath = Paths.get("products.txt");
		// 2. define the file
		productsFile = productsPath.toFile();
		// 3. Initialize list of products
		products = getAll();
	}

	@Override
	public Product get(String code) {
		for (Product p : products) {
			if (p.getCode().equalsIgnoreCase(code)) {
				// that's our product!
				return p;
			}
		}
		return null; // returned if an invalid code is entered
	}

	@Override
	public List<Product> getAll() {
		// if the products file has already been read, don't read again
		// * if this app supported multiple users, this might be dangerous
		if (products != null) {
			return products;
		}
		
		products = new ArrayList<>(); 
		if (Files.exists(productsPath)) { // this statement will only be executed if the product file exists
			try (BufferedReader in = new BufferedReader(
									 new FileReader(productsFile))) {
				
				//read a line from products.txt
				String line = in.readLine();
				while (line != null) {
					String[] fields = line.split(FIELD_SEP);
					String code = fields[0]; // first field in array
					String desc = fields[1];
					double price = Double.parseDouble(fields[2]);
					// create instance of product from line
					Product p = new Product(code, desc, price);
					// add that product to product list
					products.add(p);
					
					line = in.readLine();
				}
				
			} 
			// this catch was auto generated. IO exception catch will handle
//			catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		else {
			System.out.println(productsPath.toAbsolutePath()+"does not exist.");
			return null;
		}
		return products;
	}

	@Override
	public boolean add(Product t) {
		products.add(t);
		return this.saveAll();
	}

	@Override
	public boolean update(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product t) {
		products.remove(t);
		return saveAll();
	}
	
	//when processing text files we will resave the entire file every time we add, update, delete
	// does not matter if the product variable is declared as p or t 
		// as this instance only lives within this method
	private boolean saveAll() {
		try (PrintWriter out = new PrintWriter(
								new BufferedWriter(
									new FileWriter(productsFile)))) {
			//loop through products list and write a record for every product
			for (Product p : products) {
				out.print(p.getCode() + FIELD_SEP);
				out.print(p.getDescription() + FIELD_SEP);
				out.println(p.getPrice());
			}
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
