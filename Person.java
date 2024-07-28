
import java.util.Scanner;

public class Person {

    // Fields
    private PersonID id;
    private String name;
    private Double totalBalance;

    //Constructors
    public Person(String name) {
        this.name = name;
        totalBalance = 0.00;
        this.id = new PersonID(name);
    }
    public Person(String name, Double totalAmountOwed) {
        this.name=name;
        this.totalBalance=totalAmountOwed;
        this.id = new PersonID(name);
    }
    public Person(String name, Double totalAmountOwed, int id ) {
        this.name=name;
        this.totalBalance=totalAmountOwed;
        this.id = new PersonID (name, id);
    }


    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getBalance() {
        return totalBalance;
    }
    public void setTotalAmount(Double totalAmountOwed) {
        this.totalBalance = totalAmountOwed;
    }
    public int getID(){
        return id.getPersonNumber();
    }


    //add to total amount Owed
    public void addTotalAmount(Double addAmount) {
        totalBalance += addAmount;
    }

    //subtract from total owed
    public void pay(Double payAmount) {
        totalBalance -= payAmount;
    }
}