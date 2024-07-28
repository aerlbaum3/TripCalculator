public class Receipt {

    private int id;
    private double amountSpent;
    private String description;

    //constructor
    public Receipt(int id, double amountSpent, String description) {
        this.id = id;
        this.amountSpent = amountSpent;
        this.description = description;
    }

    //getters
    public int getId() {
        return id;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public String getDescription() {
        return description;
    }
}