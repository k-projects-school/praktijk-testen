package be.intecbrussel.test_Arrays_Johan;

import java.util.Arrays;
import java.util.Scanner;


public class Brussel3D {
	// Array with the prices of the materials
	private static final double[] PRICES = {0.05, 0.07, 0.12, 0.2};
	// Array with the names of the materials
	private static final String[] MATERIALS = {"ABS", "PLA", "HOUT", "KOPER"};
	// The amount of meters from when a discount is applied
	private static final int DISCOUNT_FROM_METERS = 100;
	// The discount in percent
	private static final double DISCOUNT_PERCENT = 15;
	// The vat percentage
	private static final double VAT_PERCENT = 21;
	
	// Create a new Scanner object
	private static Scanner kbd = new Scanner(System.in);
	
	// Flag to check the input from the user
	private boolean rightInput = false;
	// The amount of objects that needs to be produced
	private int amountOfObjects;
	// Type of material chosen by the user
	private String material;
	// Amount of meters filament is used per object
	private double metersPerObject;
	// Total meters needed to produce all the objects
	private double totalMeters;
	// The discount price
	private double discountPrice = 0;
	// The total price of the production
	private double totalPrice;
	// The total price without vat and with discount not applied
	private double subTotalPrice;
	// The total price without vat and with discount applied
	private double priceExVat;
	// The total price of the vat that would be applied
	private double vatPrice;
	
	/**
	 * Constructor
	 */
	public Brussel3D() {
		askAmountOfObjects();
		askMatiral();
		askMeters();
		calculateCost();
		printOrder();
	}

	/**
	 * Ask for the amount of objects.
	 */
	private void askAmountOfObjects() {
		while(!rightInput) {
			System.out.print("Hoeveel objecten wilt u laten fabriceren? ");
			// If the user has entered a number
			if (kbd.hasNextInt()) {
				// Store the user input
				amountOfObjects = kbd.nextInt();
				// If the user gave a negative number
				if (amountOfObjects < 0) {
					printError();
				} else {
					rightInput = true;
				}
			} 
			// If the user didn't entered a number
			else {
				printError();
			}
			/*
			 *  Because the nextInt method of the Scanner object doesn't put a new line,
			 *  we can force a new line by calling the nextLine method.
			 */
			kbd.nextLine();
		}
		// Set the flag back to false for next use
		rightInput = false;
	}

	/**
	 * Ask for what type of material the user wants.
	 */
	private void askMatiral() {
		while(!rightInput) {
			System.out.println("Uit welk materiaal mag dit vervaardigd worden? ");
			// Print the filament types and their price
			for (int i = 0; i < PRICES.length; i++) {
				System.out.println(MATERIALS[i] + ": " + PRICES[i] + "€/meter");
			}
			
			// If the user didn't entered a number
			if (!kbd.hasNextInt()) {
				material = kbd.next();
				// If the user gave a wrong filament type
				if (!Arrays.asList(MATERIALS).contains(material.toUpperCase())) {
					printError();
				} else {
					rightInput = true;
				}
			} 
			// If the user entered a number
			else {
				printError();
			}
			/*
			 *  Because the next method of the Scanner object doesn't put a new line,
			 *  we can force a new line by calling the nextLine method.
			 */
			kbd.nextLine();
		}
		// Set the flag back to false for next use
		rightInput = false;
	}

	/**
	 * Ask for how many meters filament a single object needs
	 */
	private void askMeters() {
		while(!rightInput) {
			System.out.print("Hoeveel meter vraagt uw model? ");
			// If the user entered a number
			if (kbd.hasNextDouble()) {
				metersPerObject = kbd.nextDouble();
				// If the user gave a negative number
				if (metersPerObject < 0) {
					printError();
				} else {
					rightInput = true;
				}
			} 
			// If the user didn't entered a number
			else {
				printError();
			}
			/*
			 *  Because the nextDouble method of the Scanner object doesn't put a new line,
			 *  we can force a new line by calling the nextLine method.
			 */
			kbd.nextLine();
		}
		// Set the flag back to false for next use
		rightInput = false;
	}

	private void calculateCost() {
		// Calculate the total meters needed
		totalMeters = metersPerObject * amountOfObjects;
		// Get the material price
		double materialPrice = PRICES[Arrays.asList(MATERIALS).indexOf(material.toUpperCase())];
		// Set the subtotal price
		subTotalPrice = materialPrice * totalMeters;
		// If there is more meters filament needed than the amount is needed to get a discount
		if (totalMeters >= DISCOUNT_FROM_METERS) {
			// Set the discount price
			discountPrice = subTotalPrice * (DISCOUNT_PERCENT / 100);
			// subtract the discount from the subtotal price
			priceExVat = subTotalPrice - discountPrice;
		} else {
			// If there is no discount
			priceExVat = subTotalPrice;
		}
		// Calculate the vat price
		vatPrice = priceExVat * (VAT_PERCENT / 100);
		// Calculate the total price
		totalPrice += priceExVat + vatPrice;
	}

	/**
	 * Print the order.
	 */
	private void printOrder() {
		System.out.println("Materiaal: " + material);
		System.out.printf("Filament: %.2f m/o%n", metersPerObject);
		System.out.println("Aantal objecten: " + amountOfObjects);
		if (discountPrice > 0) {
			System.out.printf("Sub-totaal: %.2f€%n", subTotalPrice);
			System.out.printf("Korting: %.2f€%n", discountPrice);
		}
		System.out.printf("Totaal zonder btw: %.2f€%n", priceExVat);
		System.out.printf("Btw %d%%: %.2f€%n", (int) VAT_PERCENT, vatPrice);
		System.out.printf("Totaal bedrag: %.2f€%n", totalPrice);
	}

	/**
	 * Print the error.
	 */
	private static void printError() {
		System.out.println("Oeps, je hebt een foutieve waarde ingegeven. Gelieve opnieuw te proberen.");
	}

}
