

import java.util.ArrayList;

public class Display {//created a seperate class for displaying all the menus so doesn't take up the main class

	public static void displayTripIDSpeech() {

		System.out.println();
		System.out.println("Please sign in with your TripID below:");
		System.out.println("If you don't have an ID, enter 0, if you forgot your ID, enter 1");
		System.out.print("TripID: ");

	}
	public static void displayPersonIDSpeech() {

		System.out.println();
		System.out.println("Please sign in with your PersonID below:");
		System.out.println("If you don't have an ID, enter 0, if you forgot your ID, enter 1");
		System.out.print("PersonID: ");

	}
	public static void displayAccountChoice(){
		System.out.println();
		System.out.println("Would you like to:");
		System.out.println("1. Sign into a different account");
		System.out.println("2. Exit");
		System.out.print("Your choice: ");
	}
	public static void displayTripChoice(){
		System.out.println();
		System.out.println("Would you like to:");
		System.out.println("1. Sign into a different trip");
		System.out.println("2. Exit");
		System.out.print("Your choice: ");
	}
	public static void displayListOfReceipts(Trip currTrip) {
		System.out.println();
		ArrayList<Receipt> receipts = currTrip.getReceipts();
		for (int i = 0; i < receipts.size(); i++) {
			System.out.println("Receipt " + (i + 1) + ": " + receipts.get(i).getDescription() + ", "
					+ currTrip.findPerson(receipts.get(i).getId()).getName() + ", $"
					+ receipts.get(i).getAmountSpent());
		}
	}
	public static void displayMenu() {
		System.out.println();
		System.out.println("Would you like to:");
		System.out.println("1. Add a receipt");
		System.out.println("2. Get list of receipts");
		System.out.println("3. Get balance ");
		System.out.println("4. Pay towards amount owed");
		System.out.println("5. Log out");
		System.out.print("What is your choice? ");
	}



}