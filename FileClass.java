import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class FileClass {//created a seperate class for dealing with the files.
	
public static void printAllDataToFile(ArrayList<Person> users, ArrayList<Trip> trips) throws IOException {

		PrintWriter output = new PrintWriter("outputs.txt");//create the outputs.txt file
		output.println(users.size());//get size of the users to know how much to loop through
		for (Person p : users) {
			//add all information of the user onto the file
			output.println(p.getName());
			output.println(p.getID());
			output.println(p.getBalance());
		}
		output.println(trips.size());
		//add all information of trips onto the file
		for (Trip t : trips) {
			output.println(t.getName());
			output.println(t.getID());
			output.println(t.getAmtOwed());
			output.println(t.getNumFriends());
			
			
			ArrayList<Receipt> receipts = t.getReceipts();
			output.println(receipts.size());
			//receipts are part of a trip add all information of receipts
			for (Receipt r : receipts) {
				output.println(r.getAmountSpent());
				output.println(r.getDescription());
				output.println(r.getId());
			}
			ArrayList<Person> people = t.getPeople();
			output.println(people.size());
			//people are part of the trip. Add persons info to the file
			for (Person pe : people) {
				output.println(pe.getID());

			}
		}
		//close the writer file
		output.close();
	}

	public static void readAllDataFromFile(ArrayList<Person> users, ArrayList<Trip> trips) throws FileNotFoundException {
		File output = new File("outputs.txt");
		Scanner reader = new Scanner(output);
		
		//go through each line of the file and read it into the code.
		int amountOfUsers = reader.nextInt();
		
		String name = "";
		int id = 0;
		double balance = 0;
		Person floater;
		
		for (int i = 0; i < amountOfUsers; i++) {
			reader.nextLine();
			name = reader.nextLine();
			id = reader.nextInt();
			balance = reader.nextDouble();
			
			floater = new Person(name, balance, id);
			users.add(floater);
		}
		
		int amountOfTrips = reader.nextInt();
		String tripName = "";
		int tripID;
		double tripTotal = 0;
		int numFriends = 0;
		int idOfSpender = 0;
		Receipt receiptTemp;
		
		for(int j = 0; j < amountOfTrips; j++) {
			reader.nextLine();
			tripName = reader.nextLine();
			tripID = reader.nextInt();
			tripTotal = reader.nextDouble();
			numFriends = reader.nextInt();
			Trip temp = new Trip(tripName, id, numFriends,tripTotal);
			trips.add(temp);
			ArrayList<Receipt> receipts = new ArrayList<Receipt>();
			int amountOfReceipts = reader.nextInt();
			//part of same for loop as trips because a receipt and person is part of a trip.
			for(int n = 0; n < amountOfReceipts; n++) {
				double amntSpent = reader.nextDouble();
				reader.nextLine();//clears the buffer
				String description = reader.nextLine();
				idOfSpender = reader.nextInt();
				receiptTemp = new Receipt(idOfSpender,amntSpent,description);//create a new receipt from file
				receipts.add(receiptTemp);
				temp.setReceipts(receipts);//add it into the trip
			}
			ArrayList<Person> people = new ArrayList<Person>();
			int amountOfPeople = reader.nextInt();
			for(int q = 0; q < amountOfPeople; q++) {
				reader.nextLine();
				int idOfPerson = reader.nextInt();
				Person personTemp = null;
				for (Person person : users) {
					if (idOfPerson == person.getID()) {
						personTemp = person;
					}
				}if(personTemp == null) {
					System.out.println("Person is null");
				}
				people.add(personTemp);
				temp.setPeople(people);
			}
			
			
		}
		
		
		System.out.println();
		reader.close();//close the readFromFile
	}
}
