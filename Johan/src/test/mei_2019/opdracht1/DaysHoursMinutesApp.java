package test.mei_2019.opdracht1;

import java.util.Scanner;

public class DaysHoursMinutesApp {

	public static void main(String[] args) {
		// Set a new Scanner Object
		Scanner kbd = new Scanner(System.in);
		// Variable that will hold the given value of the user
		int minutesToCalculate = 0;
		// Flag for the while loop
		boolean wrongEntry = true;
		// The variables that will hold the calculated time
		int 	hours = 0,
				minutes = 0,
				days = 0;
		
		// As long the user gives a wrong value, keep asking for a new
		while (wrongEntry) {
			System.out.println("Geef het aantal minuten op dat omgerekend moet worden:");
			// If the user gives a right value, store it in the minutesToCalculate variable and set the flag to false
			if (kbd.hasNextInt()) {
				minutesToCalculate = kbd.nextInt();
				wrongEntry = false;
			}
			/*
			 * Because we are in the while loop we need to put this here because otherwise the loop 
			 * will go in a merry-loop that prints the question
			 */
			kbd.nextLine();
		}
		
		// Calculate how many days
		days = minutesToCalculate / 60 / 24;
		// Calculate how many hours
		hours = (minutesToCalculate - (days * 24 * 60)) / 60;
		// Calculate how many minutes
		minutes = ((minutesToCalculate - (days * 24 * 60)) - (hours * 60));
		// Show the result
		System.out.println(days + "dagen, " + hours + " uren, " + minutes + " minuten");
		// Close the Scanner
		kbd.close();

	}

}
