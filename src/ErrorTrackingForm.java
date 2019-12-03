import java.util.Date;
import java.util.Scanner;

public class ErrorTrackingForm extends QCForm {

	private boolean plannedVariance; //if false = unplanned, true= planned;
	private boolean isExternal; //if true=external, ask for location. if false = internal
	private int labSection;//
	private String reportedBy; //the person who filled out the error report
	private String pxName; //px= patient
	private int MRN; //medical record number
	private int CID; //container ID
	private String description;
	private String correctiveAction;
	private String investigation; //completed by manager
	private boolean pxCareAffected; 
	private boolean medicalDirectorNotified; //only if pxCareAffected=true
	private String techSig;
	private String managerSig;
	
	
	// constructor
	public ErrorTrackingForm() {
		super();//calls QCForm constructor to increment static int formNo
		newForm();
		//newFormTest();
	}
	
	
	//mutators
	public void setPlannedVariance(char yesorno) {		//changed input parameter to char from boolean
		if ((yesorno=='y')|| (yesorno=='Y')){
			plannedVariance=true;
		}
		else {
			plannedVariance=false;
		}
	}
	public void setIsExternal(String input) {
		if ((input.charAt(0)=='e')||(input.charAt(0))=='E'){
			isExternal=true;
		}
		else {
			isExternal=false;
		}
	}
	public void setLabSection(int labSection) {	
		this.labSection=labSection;									//1.corelab 2.micro 3.mol 4.etccccc
																//how does this work?
	}
	public void setReportedBy(String reportedBy) {
		this.reportedBy=reportedBy;									
	}
	public void setPxName(String pxName) {
		this.pxName=pxName;
	}
	public void setMRN(int MRN) {
		this.MRN=MRN;
	}
	public void setCID(int CID) {
		this.CID=CID;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public void setCorrectiveAction(String correctiveAction) {
		this.correctiveAction=correctiveAction;
	}
	public void setInvestigation(String investigation) {
		this.investigation=investigation;
	}
	public void setPxCareAffected(char yesorno) {
		Scanner keyboard=new Scanner(System.in);
		if ((yesorno=='y')|| (yesorno=='Y')) {
			System.out.print("Was the Medical Director notified(y/n)?");
			setMedicalDirectorNotified(keyboard.nextLine().charAt(0));
		pxCareAffected=true;
		}
		else pxCareAffected = false;
	}
	public void setMedicalDirectorNotified(char yesorno) {
		if ((yesorno=='y')|| (yesorno=='Y')) {
			medicalDirectorNotified=true;
		}
		else medicalDirectorNotified=false;
	}
	public void setTechSig(String techSig) {
		this.techSig=techSig;
	}
	public void setManagerSig(String managerSig) {
		this.managerSig=managerSig;
	}

	//getters
	public String getPlannedVariance() {
		if (plannedVariance=true) {
		return "yes";
		}
		else {
			return "no";
		}
	}
	public String getIsExternal() {				
		if (isExternal=true) {
			return "yes";
			}
			else {
				return "no";
			}
	}
	public String getLabSection() {//1.Core Lab\n\t2.Microbiology\n\t3.Molecular/Biochemistry\n\t4.Blood Bank\n\t5.POCT\n\t6.CLSS
		String labString;
		switch (labSection) {
			case 1: 	labString="Core Lab";
						break;
			case 2: 	labString="Microbiology";
						break;
			case 3: 	labString="Molecular/Biochemistry";
						break;
			case 4: 	labString="Blood Bank";
						break;
			case 5: 	labString="POCT";			//point of care testing
						break;
			case 6: 	labString="CLSS";
						break;
			default:	labString="Invalid selection";
		}
		return labString;
		
	}
	public String getReportedBy() {
		return reportedBy;
	}
	public String getPxName() {
		return pxName;
	}
	public int getMRN() {
		return MRN;
	}
	public int getCID() {
		return CID;
	}
	public String getDescription() {
		return description;
	}
	public String getCorrectiveAction() {
		return correctiveAction;
	}
	public String getInvestigation() {
		return investigation;
	}
	public String getPxCareAffected() {
		if (pxCareAffected=true) {
			return "yes";
		}
		else return "no";
			
	}
	public boolean getMedicalDirectorNotified() {
		return medicalDirectorNotified;
	}
	public String getTechSig() {
		return techSig;
	}
	public String getManagerSig() {
		return managerSig;
	}
	
	public void newForm() {
		//many print and input lines that call the set methods
		
		
		Scanner keyboard= new Scanner(System.in);
		
		System.out.println("Laboratory Medicine Variance Report\n");
		System.out.println("");
		
		//Question #1
		System.out.println("Was this a planned variance (y/n)");
		setPlannedVariance(keyboard.nextLine().charAt(0));
			if (plannedVariance==true) {
				System.out.println("Medical Director pre-appoval required");
				System.out.println("Continue(y/n)?");
				 char yesorno=keyboard.nextLine().charAt(0);							
				if((yesorno=='n')||(yesorno=='N')){		//hit no if you haven't gotten pre-approval
					System.exit(0);
				}
			}
		//Question #2	
		System.out.println("Internal (inside Lab Med) or External?");	
		setIsExternal(keyboard.nextLine());
				
		//Question #3
		System.out.println("Please select the laboratory section(1-6)\n\t1.Core Lab\n\t2.Microbiology\n\t3.Molecular/Biochemistry\n\t4.Blood Bank\n\t5.POCT\n\t6.CLSS");
		setLabSection(keyboard.nextInt());
		keyboard.nextLine();
			
		//Question 4
		System.out.println("Reported By:");
		setReportedBy(keyboard.nextLine());
			
		//Question #5:
		System.out.println("Patient Name:");
		setPxName(keyboard.nextLine());
			
		//Question #6:
		System.out.println("Patient Medical Record Number");
		setMRN(keyboard.nextInt());
		keyboard.nextLine();
			
		//Question#7:
		System.out.println("Patient CID:");
		setCID(keyboard.nextInt());
		keyboard.nextLine();
		
		//Question #8
		System.out.println("Describe what happened:");
		setDescription(keyboard.nextLine());
		
		//Question #9
		System.out.println("Immediate corrective action:");
		setCorrectiveAction(keyboard.nextLine());
		
		//Question #10
		System.out.println("Investigation of variance:");		//to be completed by manager, may not the best place to put this
		setInvestigation(keyboard.nextLine());
		
		//Question #11
		System.out.println("Patient care affected (y/n)");
		setPxCareAffected(keyboard.nextLine().charAt(0));
		
		
		//Question #12
		System.out.print("Technologist signature:");
		setTechSig(keyboard.nextLine());
		
		//Question #13
		System.out.print("Manager signature:");				//to be completed by manager, may not be the best place
		setManagerSig(keyboard.nextLine());
		
	}	
	
	public String toString() {
		
		String output = "";
		output += "1.This was a planned variance: "+getPlannedVariance()+"\n"
				+ "2.This was an external event:"+getIsExternal()+"\n"
				+ "3. Laboratory section:"+getLabSection()+"\n"
				+ "4. Reported by:"+getReportedBy()+"\n"
				+ "5. Patient name: "+getPxName()+"\n"
				+ "6. MRN: "+getMRN()+"\n"
				+ "7. CID:"+getCID()+"\n"
				+ "8. Description: "+getDescription()+"\n"
				+ "9. Corrective Action: "+getCorrectiveAction()+"\n"
				+ "10. Investivation: "+getInvestigation()+"\n"
				+ "11. Was patient care affected: "+getPxCareAffected()+"\n"
				+ "12. Technologist Signature: "+getTechSig()+"\n"
				+ "13. Manager Signature: "+getManagerSig()+"\n";		
		return output;
	}
	
	/*
	public void newFormTest() {
		//many print and input lines that call the set methods
		
		
		Scanner keyboard= new Scanner(System.in);
		Scanner keyboardTwo=new Scanner (System.in);
		
		System.out.println("This is a test form\n");
		
		//Question #1
		System.out.println("Reported By:");
		setReportedBy(keyboard.nextLine());
		
		System.out.println("Patient Name:");
		setPxName(keyboard.nextLine());
		
		//Question #6:
		System.out.println("Patient Medical Record Number");
		setMRN(keyboard.nextInt());
		keyboard.nextLine();
	}
	*/
}
