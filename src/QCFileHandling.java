import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QCFileHandling {

	static PrintWriter outputStream=null; //save functions
	static Scanner inputStream=null; //load function
	
	
	public static void save (String fileName, ErrorTrackingForm data) {	//file not found exception is used 
		
		try {
			outputStream = new PrintWriter(fileName); 
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, could not open file");
			System.exit(0);
		}
		outputStream.println(data.toString());			 
		
		outputStream.close();
		System.out.println("Your response has been recorded.");
	}

	
	//load function
	public static String loadFile (String fileName) { 
		try {
			inputStream= new Scanner (new File(fileName)); 
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, could not open file");
			System.exit(0);
		}
		String data="";
		while (inputStream.hasNextLine()) {
			String line=inputStream.nextLine()+"\n";
			data=data+line;
		}
		//System.out.println(data);
		inputStream.close();
		
		return data; 
		/*
		  You should use this data to create a new Form object and 
		  save that form objec to the form array list.
		*/
	}
}

