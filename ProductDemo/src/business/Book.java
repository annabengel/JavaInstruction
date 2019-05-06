package business;

public class Book extends Product { // extends product now inherits Product class
	
	//only need to declare attributes of Book
	//define instance variable
	private String author;

	//generate constructor, no parameters
	public Book() {
		super();
	}

	// generate constructor with parameters
	
	public Book(String code, String description, double price, String author) {
		super(code, description, price);
		this.author = author;
	}

	// generate getters and setters; only 1 in this example (author)
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", " + super.toString() + "]";
	}


	}
	

