package test.mei_2019.opdracht2;

public class LeapYearApp {

	public static void main(String[] args) {
		System.out.println("Uitkomst van de opgegeven jaren in de test:");
		LeapYear.checkIfIsLeapYear(1900);
		LeapYear.checkIfIsLeapYear(2008);
		LeapYear.checkIfIsLeapYear(2000);
		LeapYear.checkIfIsLeapYear(1998);
		
		int year = LeapYear.askForYear();
		LeapYear.checkIfIsLeapYear(year);
	}

}
