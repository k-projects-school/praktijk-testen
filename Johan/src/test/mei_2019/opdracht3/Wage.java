package test.mei_2019.opdracht3;

import java.util.Scanner;

public class Wage {
	// Flag for the while loops
	private boolean wrongEntry = true;
	// Scanner object
	private Scanner kbd = new Scanner(System.in);

	/**
	 * 
	 */
	public void calculate() {
		// Variables to store their respective value
		float 	workedHours = 0,
				overTime = 0,
				hourlyWage = 0,
				wage = 0;
		
		// As long the user gives a wrong value, keep asking for it
		while(wrongEntry) {
			System.out.println("Hoeveel gewone uren heb je gewerkt?");
			workedHours = setValue("Oh oh, je hebt geen nummer ingegeven!");
		}
		// Set the flag back to false, otherwise I should make a new for the same purpose
		wrongEntry = true;
		// As long the user gives a wrong value, keep asking for it
		while(wrongEntry) {
			System.out.println("Hoeveel overuren heb je gewerkt?");
			overTime = setValue("Oh oh, je hebt geen nummer ingegeven!");
		}
		// Set the flag back to false, otherwise I should make a new for the same purpose
		wrongEntry = true;
		// As long the user gives a wrong value, keep asking for it
		while(wrongEntry) {
			System.out.println("Wat bedraagt je brutto urloon?");
			hourlyWage = setValue("Oh oh, je hebt geen geldig bedrag ingegeven!");
		}
		
		// Calculate the wage
		wage = workedHours * hourlyWage;
		// Calculate the overtime wage and add it to the wage
		wage += overTime * (hourlyWage * 1.5);
		
		// Show how much the wage is
		System.out.println("Je totale brutto loon bedraagt: " + wage);
		
		kbd.close();

	}

	/**
	 * Set the value of a variable.
	 * @param message Message to show if the user doesn't gave a right value.
	 * @return the value that will be stored in a variable
	 */
	private float setValue(String message) {
		float value = 0;
		// IF the user gave a float or whole integer
		if (kbd.hasNextFloat() || kbd.hasNextInt()) {
			value = kbd.nextFloat();
			wrongEntry = false;
		} else {
			// Show the given message
			System.out.println(message);
		}
		/*
		 * Because this method runs in a while loop we need to put this here because otherwise the loop 
		 * will go in a merry-loop that prints the question that is printed right before the trigger of 
		 * this method.
		 */
		kbd.nextLine();
		
		return value;
	}

}
