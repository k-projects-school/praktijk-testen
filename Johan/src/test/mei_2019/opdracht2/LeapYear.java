package test.mei_2019.opdracht2;

import java.util.Scanner;

public class LeapYear {
	// Maak een instantie van de Scanner dat we over alle methoden kunnen gebruiken
	private static Scanner kbd = new Scanner(System.in);

	/**
	 * This will check if the given year is a leap year.
	 * @param year
	 */
	public static void checkIfIsLeapYear(int year) {
		boolean isLeapYear;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// If the given year is divisible by 4, 100 and 400 it's a leap year
					isLeapYear = true;
				} else {
					// If the given year is divisible by 4 and 100, but not by 400, it's not a leap year
					isLeapYear = false;
				}
			} else {
				// if the given year is divisible by 4 but not by 100, it's a leap year
				isLeapYear = true;
			}
		} else {
			// If the given year is not divisible by 4, its not a leap year
			isLeapYear = false;
		}
		// Print the result
		System.out.println("Het jaar " + year + " is " + (isLeapYear ? "een" : "geen") + " schrikkeljaar.");
	}
	
	/**
	 * This will asks for the user to give a year.
	 */
	public static int askForYear() {
		// Variable that will hold the given year
		int year = 0;
		// Flag for the while loop
		boolean wrongEntry = true;
		// As long as the user gives a wrong value, keep asking for a year
		while (wrongEntry) {
			// Ask the user for a year
			System.out.println("Van welk jaar wil je weten of het een schrikkeljaar is? Geef het op in volgende notatie yyyy (ex.: 2019)");
			// If the user gave a integer, store it in the year variable
			if (kbd.hasNextInt()) {
				year = kbd.nextInt();
				wrongEntry = false;
			} else {
				// If the user gave something else then a integer, let him know.
				System.out.println("Oh nee, wat je hebt opgegeven is geen jaar getal!!");
			}
			kbd.nextLine();
		}
		// Return the year
		return year;
	}

}
