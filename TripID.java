public class TripID {
    //fields
    private String name;
    private int tripNumber;
    private static int increment = 0;
    private int floater2 = 100;


    public TripID(String name) {
        this.name = name;
        increment++;
        this.tripNumber = increment + floater2;
       
    }
   
    public void setName(String name) {
        this.name = name;
    }

    public int getTripNumber() {
        return tripNumber;
    }
    public String getName() {
        return name;
    }


  
}


// Logic
/*
0 - Don't have a login
1 - Don't remember your login
Otherwise put in your login

0 - Creates a new ID, asks for name and creates an ID, picks the next number
1 - Prints out a list of all the IDs and names
*/