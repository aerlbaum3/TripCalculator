
public class ID {
    //fields
    private String name;
    private int number;
    private static int increment = 0;
    private int floater = 1000;


    public ID(String name) {
        this.name = name;
        increment++;
        this.number = increment + floater;
    }
    public ID(String name, int id) {
        this.name = name;
        this.number = id;
        if (floater<id) {
        	floater= id+1;
        }
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
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