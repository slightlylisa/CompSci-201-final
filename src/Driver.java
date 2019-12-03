//function must only do one thing well. must be able to reuse.




import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Driver {
	
	//create the arraylist. we had to put at the beginning in order for all the functions of the driver class to use it.
	public 	static ArrayList<ErrorTrackingForm> CollectedForms = new ArrayList<>();

	public static void main(String[]args) {

		//before the programs starts, we need to add the files to the array list.
		//write a function that lists all the files in a particular directory
		//filter list of files by formName (pattern "ETF") if it contains etf return it, else 
		
		final File folder = new File(".");
		loadFiles(folder);
		
		while (true)
			menu(); //loop
		
	}
	
	public static void menu() {
		//asks if you want to search,make new form ,or load	
		
		Scanner keyboard= new Scanner(System.in);
		int chooseFunction;
		String formName;
		System.out.println("Which of the following would you like to do?\n1.Make a new error tracking form\n2.Load a form\n3.Search error tracking forms");
		chooseFunction=keyboard.nextInt();
		
		if(chooseFunction == 1) {	//make new form
			
			//adding new form to our collection of forms in an array list. will start new form via constructor
			CollectedForms.add(new ErrorTrackingForm());
			
			//make unique file name
			String formID= "ETF"+QCForm.getStaticReportNum();
			
			//save the form.
			QCFileHandling.save(formID,CollectedForms.get(QCForm.getStaticReportNum()-1));
		}
		//load
		else if(chooseFunction == 2) {			
			System.out.println("What form do you want to load?");
			formName = keyboard.nextLine();
			QCFileHandling.loadFile(formName);
		}
		//search
		else if(chooseFunction == 3) {
		search();
		}
	}
	
	//search function
	public static void search() {
		Scanner keyboard = new Scanner(System.in);
		int searchBy;
		String searchFor;
		String results = "";
		
		//ask user how they would like to search through forms
		System.out.println("How would you like to search? (1-3)\n\n1.Patient Name\n2.MRN\n3.Reported By");
		searchBy=keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("What do you want to search for?");
		searchFor=keyboard.nextLine();
		
		
		
		for(ErrorTrackingForm file: CollectedForms) {			//check all the forms 
			if (searchBy==1) {
				if (searchFor.equalsIgnoreCase(file.getPxName())) {		//user input equals any patient name in the collected forms array
					results += file.getThisReportNum() + ", ";			//if there is a match, the number report form is added to the list
				}
			}
			else if (searchBy==2) {
			
				if (searchFor.equals(Integer.toString(file.getMRN()))) {	//search by mrn
					results += file.getThisReportNum() + ", ";
				}
			}	
			else if (searchBy==3) {		//search by the tech who reported the problem
				if (searchFor.equalsIgnoreCase(file.getReportedBy())) {
					results += file.getThisReportNum() + ", ";
				}
			}
		}
		
		results = results.substring(0, results.length()-2);
		System.out.println("The following forms contain what you searched for: " +results);
	}
	
	public static void loadFiles(final File folder)//directory you are interested in looking in)
	{
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isFile()) { //testing to see if its a file
	            if(fileEntry.getName().contains("ETF")==true) {
		          System.out.println("Loading: "+fileEntry.getName());
	              QCFileHandling.loadFile(fileEntry.getName());
	            }
	        }
	    }
	}
}
