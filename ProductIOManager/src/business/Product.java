package business;

public class Product {
	
	private String code;
	private String description;
	private double price;
	
	//define constructors
	public Product() {
		code = "";
		description = "";
		price = 0.0;
	}

	//generate constructors
	public Product(String code, String description, double price) {
		this.code = code;
		this.description = description;
		this.price = price;
	}
	
	//create getters and setter by auto generation in Source
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override // override parent method
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + "]";
	}
	
	// static method to call. will not use
	public static void aStaticMethod() {
		System.out.println("an arbitrary static method");
	}


}
