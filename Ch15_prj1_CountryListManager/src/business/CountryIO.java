package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountryIO { // text file class

	private List<Country> countries = null;
	private Path countriesPath = null;
	private File countriesFile = null;
	private final String FIELD_SEP = "\t";

	public CountryIO() {
		// initialize the class variables
		countriesPath = Paths.get("countries.txt");
		countriesFile = countriesPath.toFile();
		countries = getCountries();

	}

	public List<Country> getCountries() { // getAll
		// if the countries file has already been read, don't read it again
		if (countries != null) {
			return countries;
		}

		countries = new ArrayList<>();
		if (Files.exists(countriesPath)) {
			try (BufferedReader in = new BufferedReader(new FileReader(countriesFile))) {
				// load the array list with Country objects created from
				// the data in the file
				String line = in.readLine();
				while (line != null) {
					String[] fields = line.split(FIELD_SEP);
					String country = fields[0];

					Country c = new Country(country);
					countries.add(c);

					line = in.readLine();

				}
			} catch (IOException e) {
				System.out.println(e);
				return null;

			}
		}
		return countries;
	}
	
	private boolean saveCountries(ArrayList<Country> countries) {
		// save the country objects in the array list to the file
		try (PrintWriter out = new PrintWriter(
								new BufferedWriter(
								new FileWriter(countriesFile)))) {
			for (Country c : countries) {
				out.print(c.getCountry() + FIELD_SEP);

			}
			return true;
		} catch (IOException e) {
			System.out.println(e);
			return false;

		}

	}

}
