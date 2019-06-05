package be.intecbrussel.test_Arrays_Johan;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorteren {
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
		System.out.println("Voor sorteren:");
		System.out.println(Arrays.toString(randomArray));
		mergeSort(randomArray, 0, randomArray.length-1);
		System.out.println("Na sorteren:");
		System.out.println(Arrays.toString(randomArray));
		System.out.println("Verschil = " + (randomArray[0] - randomArray[randomArray.length - 1]));
	}

	/**
	 * Print the error.
	 */
	private static void printError() {
		System.out.println("Oeps, je hebt een foutieve waarde ingegeven. Gelieve opnieuw te proberen.");
	}
	/**
	 * Merge sorts an array.
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] array, int left, int right) {
		
		if (left < right) {
			// Get the middle point
			int median = (left + right) / 2;
			// Sort the first half of the array
			mergeSort(array, left, median);
			// Sort the second half of the array
			mergeSort(array, median + 1, right);
			
			// Merge the two halves
			merge(array, left, median, right);
		}
	}
	
	/**
	 * Merge 2 arrays.
	 * @param array
	 * @param left
	 * @param median
	 * @param right
	 */
	public static void merge(int[] array, int left, int median, int right) {
		// Get the sizes of the two subarrays that has to be created
		// sizeLeft is the left size
		int sizeLeft = median - left + 1;
		// pt2 is the right size
		int sizeRight = right - median;
		
		// Create 2 temporary arrays
		// Left partial array
		int[] tempLeft = new int[sizeLeft];
		// Right partial array
		int[] tempRight = new int[sizeRight];
		
		// Copy the data from the original array to the temporary arrays
		for(int leftIndex = 0; leftIndex < sizeLeft; ++leftIndex) {
			tempLeft[leftIndex] = array[left + leftIndex];
		}
		for(int rightIndex = 0; rightIndex < sizeRight; ++rightIndex) {
			tempRight[rightIndex] = array[median + 1 + rightIndex];
		}
		
		/*
		 * Start merging the two temporary arrays in the original array
		 */
		
		// Initial indexes of the two subarrays and the original array
		int rightIndex = 0, leftIndex = 0, originalIndex = left;
		
		/*
		 * Loop through the left and right subarray to create the original merged array
		 */
		while(leftIndex < sizeLeft && rightIndex < sizeRight) {
			/*
			 * If the value of the left temporary array is smaller than the value of the right temporary array,
			 * set the value of the original merged array with the value of the left temporary array
			 */
			if (tempLeft[leftIndex] >= tempRight[rightIndex]) {
				array[originalIndex] = tempLeft[leftIndex];
				leftIndex++;
			} 
			/*
			 * If the value of the right temporary array is smaller than the value of the left temporary array,
			 * set the value of the original merged array with the value of the right temporary array
			 */
			else {
				array[originalIndex] = tempRight[rightIndex];
				rightIndex++;
			}
			originalIndex++;
		}
		
	
		 // If there are items left in the left temporary array, loop trough them to add them to the original array.
		while (leftIndex < sizeLeft) {
			array[originalIndex] = tempLeft[leftIndex];
			leftIndex++;
			originalIndex++;
		}
		 // If there are items left in the right temporary array, loop trough them to add them to the original array.
		while (rightIndex < sizeRight) {
			array[originalIndex] = tempRight[rightIndex];
			rightIndex++;
			originalIndex++;
		}
	}
}
