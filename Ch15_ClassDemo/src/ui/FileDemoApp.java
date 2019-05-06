package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemoApp {

	public static void main(String[] args) {
		System.out.println("Welcome");

		try {
			//create a directory/folder on hard drive
			String dirString = "c:/temp";
			Path dirPath = Paths.get(dirString);
			if (Files.notExists(dirPath)) {
				Files.createDirectories(dirPath);
				System.out.println("Directory created!");
			}
			else {
				System.out.println("Directory already exists.");
			}
			// create a file within the folder
			String fileString = "products.txt";
			Path filePath = Paths.get(dirString, fileString);
			if (Files.notExists(filePath)) {
				Files.createFile(filePath);
				System.out.println(fileString + " successfully created!");
			} 
			else {
				System.out.println(fileString + "not created");	
			}
			System.out.println("File Name: " + filePath.getFileName());
			System.out.println("Absolue Path: " + filePath.toAbsolutePath());
			System.out.println("Is writable: " + Files.isWritable(filePath));		
			//print file info from directory
			System.out.println("Files in a directory...");
			if (Files.deleteIfExists(dirPath) && Files.isDirectory(dirPath)) {
				System.out.println("Directory: " + dirPath.toAbsolutePath());
				System.out.println("Files: ");
				DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
				for (Path p: dirStream) {
					if (Files.isRegularFile(p))
						System.out.println("     " + p.getFileName());
				
			}
		}
			// Write to the file
			Path productsPath = Paths.get("products.txt");
			// Note, this is not the same products.txt as the examples above.
			File productsFile = productsPath.toFile();
			
			//open an output stream
			PrintWriter out = new PrintWriter(
							  new BufferedWriter(
							  new FileWriter(productsFile)));
			
			//write data to the stream
			out.println("java\tMurach's Java Programming\t57.50");
			
			//close input stream to avoid a resource leak
			out.close();
	
			BufferedReader in = new BufferedReader(
								new FileReader(productsFile));
			// read data from the stream and print to console
			String line = in.readLine();
			System.out.println(line);
			
			//close the input stream
			in.close();
		}
			
			catch (IOException e) {
				System.out.println("Invalid file name entered");
				e.printStackTrace();
			}
		
		System.out.println("Goodbye");
	}
}
						
					
					