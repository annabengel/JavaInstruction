
public class Album extends Product {

	private String artist; 

	public Album() {
		//call constructor of Product superclass & initializes the fields
		super(); 
		// assign a default value of an empty string to artist
		artist = "";
		count++;
		
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public String toString() {
		return super.toString() + " (" + artist + ")";
	}
	
	}

