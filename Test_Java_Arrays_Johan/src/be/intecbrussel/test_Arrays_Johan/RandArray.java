package be.intecbrussel.test_Arrays_Johan;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandArray {
	// Create a new Scanner object.
	private static Scanner kbd = new Scanner(System.in);
	// Create a new Random object.
	private static Random rand = new Random();

	public static void main(String[] args) {
		// Flag to check if the user has given a right answer.
		boolean rightInput = false;
		// Variable to store the input of the user.
		int length = 0;
		/*
		 * As long the user has given a wrong answer, 
		 * ask for input.
		 */
		while (!rightInput) {
			System.out.print("Hoeveel getallen wil je in de array? ");
			// If the Scanner object has an integer as answer
			if (kbd.hasNextInt()) {
				// Set the answer 
				length = kbd.nextInt();
				// We have to be sure that the user gives a positive number
				if (length > 0) {
					// If it's a positive number set the flag to true.
					rightInput = true;
				} else {
					// Otherwise print the error.
					printError();
				}
			} else {
				// If the Scanner has no integer as answer, print the error
				printError();
			}
			/*
			 *  Because the nextInt method of the Scanner object doesn't put a new line,
			 *  we can force a new line by calling the nextLine method.
			 */
			kbd.nextLine();
		}
		// Create a new array with the length given by the user.
		int[] randomArray = new int[length];
		// Loop through the new array.
		for (int i = 0; i < randomArray.length; i++) {
			/*
			 * Add a new number for every index of the array.
			 * Because we need to have numbers between 25 and 175,
			 * we'll have to get a random number between 0 and 150 and add 25 to it.
			 */
			randomArray[i] = rand.nextInt(150) + 25;
		}
		
		System.out.println(Arrays.toString(randomArray));
	}

	/**
	 * Print the error.
	 */
	private static void printError() {
		System.out.println("Oeps, je hebt een foutieve waarde ingegeven. Gelieve opnieuw te proberen.");
	}

}
