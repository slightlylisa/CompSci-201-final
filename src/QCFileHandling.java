import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QCFileHandling {

	PrintWriter outputStream=null; //save functions
	Scanner inputStream=null; //load function
	
	//trying to save to the file system. not sure how to integrate into rest of program
	public void save (String fileName, String data) {	//file not found exception is used 
		
		try {
			outputStream = new PrintWriter(fileName); //always will start with empty file. If already exist the file will be rewritten. Otherwise, new file made.
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, could not open file");
			System.exit(0);
		}
		//in week 13 example object were printed out here
		//using outputStream.println("");
		outputStream.println(data);
		
		//put at the end of what is to be saved
		outputStream.close();
		System.out.println("Your response has been recorded.");
	}
	
	
	//could have function that does the toString print to the console.
	//don't have a toString yet.. will see if we need
	
	//recall function
	public String load (String fileName) { //could be String array or other data type
		try {
			inputStream= new Scanner (new File(fileName)); //errorreport1202.txt
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, could not open file");
			System.exit(0);
		}
		String data=""; //goal: add each line to data
		while (inputStream.hasNextLine()) {
			String line=inputStream.nextLine()+"\n"; 
			
			//System.out.println(line); //debugging option
				data=data+line;
					//adding line to data, grow data
								// it is printing extra line because data is empty string so first time around it 
								//prints the extra line. too lazy to fix but could with if statement.
								//fixed it by putting \n after the inputStram.nextLine on line 46
		}
		System.out.println(data);
		inputStream.close();
		return data;
	}
	
}
