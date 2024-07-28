import java.util.ArrayList;

public class Trip {
    private TripID id;
    private int numFriends;
    private double amtOwed;
    ArrayList<Receipt> receipts;
    ArrayList<Person> people;
    
    
	public Trip(String name, int numFriends) {
        this.name = name;
		id = new TripID(name);
        this.numFriends = numFriends;
        amtOwed = 0;
        receipts = new ArrayList<>();
        people = new ArrayList<>();
    }
	
	public Trip(String name, int id, int numFriends, double tripTotal) {
		this.name = name;
		this.id = new TripID(name);
		this.amtOwed = tripTotal;
		this.numFriends = numFriends;
		
	}
	
    public ArrayList<Person> getPeople() {//need an arrayList of the people that is on this specific trip
		return people;
	}
	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
	public void setAmtOwed(double amtOwed) {
		this.amtOwed = amtOwed;
	}
	public void setReceipts(ArrayList<Receipt> receipts) {//an arrayList of receipts from this specific trip
		this.receipts = receipts;
	}
	private String name;

    public int getNumFriends() {
		return numFriends;
	}
	public void setNumFriends(int numFriends) {
		this.numFriends = numFriends;
	}

    public void setName(String name) {
		this.name = name;
	}
	public double getAmtOwed() {
        return amtOwed;
    }
    public void addToAmtOwed(double additionalAmountOwed) {
        amtOwed += additionalAmountOwed;
    }
    public int getID() {
        return id.getTripNumber();
    }
    public String getName() {
        return id.getName();
    }
    //not sure if we need this one
    public Person addPerson(String name) {//add person onto this trip if there is room on the trip with just a name;
        if (people.size() < numFriends) {
            Person newPerson = new Person(name, amtOwed/numFriends);
            people.add(newPerson);
            return newPerson;
        } else {
            return null;
        }
    }
    public Person addPerson(Person p) {//add person onto this trip if the trip is not full
        if (people.size() < numFriends) {
           
            people.add(p);
            p.addTotalAmount(amtOwed/numFriends);
            return p;
           
        }
        return null;
        
    }
    public void addReceipt(Receipt newReceipt) {
    	//adding to arrayList
        receipts.add(newReceipt);
        
        Double personalAmountOwed = newReceipt.getAmountSpent()/numFriends;
        for (Person p : people) {
            // The amount on the receipt is divided amongst the amount of people,
            // and the person who laid out the money gets that amount subtracted
            if (p.getID() != newReceipt.getId()) {
                p.addTotalAmount(personalAmountOwed);
            } else {
                p.addTotalAmount(-1*(personalAmountOwed));
            }
            
        }
        addToAmtOwed(newReceipt.getAmountSpent());
    }
    public String printPeople() {
        StringBuilder sb = new StringBuilder();
        for (Person p : people) {
            sb.append("Name: " + p.getName() + " ID: " + p.getID() + "\n");
        }
        return sb.toString();
    }
    public Person findPerson(int id) {
        Person temp = null;
        for (Person person : people) {
            if (id == person.getID()) {
                temp = person;
            }
        }
        return temp;
    }
    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }
}