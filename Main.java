


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final DecimalFormat df = new DecimalFormat("0.00");
	static Person currPerson;

	public static void main(String[] args) throws IOException {

		
		ArrayList<Person> users = new ArrayList<>();
		ArrayList<Trip> trips = new ArrayList<>();
		Scanner keyboard = new Scanner(System.in);
		FileClass accessFiles = new FileClass();
		
		//call the readAllDataFromFile method to access the old records
		//accessFiles.readAllDataFromFile(users, trips);

		int trip = 1;
		while (trip == 1) {
			Trip currTrip = null;
			while (currTrip == null) {
				// Sign in or create a specific trip
				Display.displayTripIDSpeech();
				int tripID = Validate.IntNotNegative(keyboard);

				if (tripID == 0) {
					currTrip = createTrip(trips, keyboard, tripID);

				} else if (tripID == 1) {
					currTrip = forgotTrip(trips, keyboard, tripID);
				} else {
					currTrip = findTrip(tripID, trips);
				}
			}

			// Log in to that person's account.
			// Loop that they can switch to a different ID without exiting the trip
			int user = 1;
			while (user == 1) {

				// Each person signs in with an ID so that there are fewer errors in terms of
				// case and repeated names
				//if there are too many people for the trip will return trip is full and displayPersonIDSpeech again
				Display.displayPersonIDSpeech();
				int id = Validate.IntNotNegative(keyboard);

				// Person currPerson;
				if (id == 0) {
					currPerson = createID(keyboard, id, currTrip, users);
					
				} else if (id == 1) {
					currPerson = forgotID(keyboard, id, currTrip, users);
				} else {
					currPerson = findPersonByID(id, currTrip, users);
					
				}
			
				
				
				
				int choice = 0;
				while (choice != 5) {
					Display.displayMenu();
					choice = Validate.IntBetween(keyboard, 0, 6);
					// Menu Handling
					if (choice == 1) {
						addReceipt(keyboard, currPerson, currTrip);
					} else if (choice == 2) {
						Display.displayListOfReceipts(currTrip);
					} else if (choice == 3) {
						System.out.println();
						System.out.println("Your Balance:  $" + df.format(currPerson.getBalance()));
					} else if (choice == 4) {
						payOffDebt(keyboard, currPerson);
					} else if (choice == 5) {
						System.out.println("Bye Bye!");
					}
				}
				Display.displayAccountChoice();
				user = Validate.IntBetween(keyboard, 1, 2);
			}
			Display.displayTripChoice();
			trip = Validate.IntBetween(keyboard, 1, 2);
			if (trip == 2) {
				accessFiles.printAllDataToFile(users, trips);//only print to the file once exit the program
				System.out.println("All done");
			}
		}
	}

	private static Trip findTrip(int tripID, ArrayList<Trip> trips) {
		Trip temp = null;
		for (Trip t : trips) {
			if (tripID == t.getID()) {
				temp = t;
			}
		}
		if (temp == null) {
			System.out.println("There is no trip with that ID");
		}
		return temp;
	}

	public static Trip createTrip(ArrayList<Trip> trips, Scanner keyboard, int tripID) {
		Trip temp = null;

		System.out.print("Whats the name of your trip? ");
		String name = keyboard.nextLine();
		System.out.print("How many people are on the trip? ");
		int numberOffriends = Validate.IntNotNegative(keyboard);

		temp = new Trip(name, numberOffriends);
		trips.add(temp);
		tripID = temp.getID();
		System.out.println("Congratulations! You now have an TripID! Your ID is: " + tripID);
		return temp;

	}

	public static Trip forgotTrip(ArrayList<Trip> trips, Scanner keyboard, int tripID) {
		Trip temp = null;
		for (Trip t : trips) {
			System.out.println("Trip Name: " + t.getName() + " ID: " + t.getID());
		}
		System.out.print("Your TripID: ");
		tripID = Validate.IntNotNegative(keyboard);

		temp = findTrip(tripID, trips);

		return temp;
	}

	public static void payOffDebt(Scanner keyboard, Person currPerson) {
		System.out.print("How much would you like to pay? ");
		Double payAmount = keyboard.nextDouble();
		currPerson.pay(payAmount);
	}

	public static Person createID(Scanner keyboard, int id, Trip currTrip, ArrayList<Person> users) {
		Person temp = null;

		System.out.print("What is your name? ");
		String name = keyboard.nextLine();
		temp = currTrip.addPerson(name);
		users.add(temp);
		if (temp != null) {
			id = temp.getID();
			System.out.println("Congratulations! You now have an ID! Your ID is: " + id);
		} else {
			System.out.println("This trip is full.");
			
			
		}
		return temp;
	}

	public static Person forgotID(Scanner keyboard, int id, Trip currTrip, ArrayList<Person> users) {
		Person temp;
		System.out.println(currTrip.printPeople());
		System.out.print("Your ID: ");
		id = Validate.IntNotNegative(keyboard);

		temp = currTrip.findPerson(id);

		return temp;
	}

	public static Person findPersonByID(int id, Trip currTrip, ArrayList<Person> users) {
		Person temp = null;
		for (Person person : users) {
			if (id == person.getID()) {
				temp = person;
			}
		}
		currTrip.addPerson(temp);

		return temp;
	}

	public static void addReceipt(Scanner keyboard, Person currPerson, Trip currTrip) {
		int id = currPerson.getID();
		System.out.print("How much is the receipt for? ");
		double amount = Validate.DoubleNotNegative(keyboard);

		System.out.print("Describe what you bought: ");
		String description = keyboard.nextLine();
		Receipt receipt = new Receipt(id, amount, description);
		currTrip.addReceipt(receipt);

	}


}

