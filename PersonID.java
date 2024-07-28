//We created two seperate IDs one for the Trip and One for the Person so they increment separately.

public class PersonID { 
    //fields
    private String name;
    private int personNumber;
    private static int increment = 0;
    private int floater = 1000;
   


    public PersonID(String name) {
        this.name = name;
        increment++;
        this.personNumber = increment + floater;
    }
    public PersonID(String name, int id) {
        this.name = name;
        this.personNumber = id;
        if (increment < id - 1000) {//in case it doesn't increment manually incrementing it
        	increment = id - 1000;
        }
    }


   
    public void setName(String name) {
        this.name = name;
    }


    public int getPersonNumber() {
    	return personNumber;
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