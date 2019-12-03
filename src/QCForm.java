import java.util.Date;

public class QCForm {
	private Date reportDate; //SimpleDateFormat ft= new SimpleDateFormat("yyyy.MM.dd")
					//ft.format(object name);
	private static int reportNo=0; //don't use for anything else
	private int thisReportNum;

	

	public QCForm () {
		reportNo++;
		thisReportNum = reportNo;

	}
	//mutator
	
	public void setReportDate(Date reportDate) {
		this.reportDate=reportDate;
	}
	
	//accessor
	public Date getReportDate() {
		return reportDate;
	}
	public static int getStaticReportNum() {
		return reportNo;
	}
	public int getThisReportNum() {
		return thisReportNum;
	}
}
