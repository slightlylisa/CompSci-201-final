
public class Driver {
	public static void main(String[]args) {
		String name= "This the the data we are testing \nfor the important error tracking program. \nWe are professional people \nall the time";
		QCFileHandling test = new QCFileHandling();
		test.save("name.txt", name);
		
		test.load("name.txt");
	}
}
