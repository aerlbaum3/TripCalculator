
import java.util.Scanner;

public class Validate {//created a class for validation for efficiency 
	
	
	public static int IntNotNegative(Scanner keyboard) {
		int temp = keyboard.nextInt();
		keyboard.nextLine();
		while (temp<0) {
			System.out.println("invalid please try again.");
			temp = keyboard.nextInt();
			keyboard.nextLine();
			
		}
		return temp;
	}

	public static int IntBetween(Scanner keyboard, int low, int high) {
		int temp = keyboard.nextInt();
		keyboard.nextLine();
		while (temp < low || temp > high) {
			System.out.println("invalid please try again.");
			temp = keyboard.nextInt();
			keyboard.nextLine();
			
		}
		return temp;
	}
	public static double DoubleNotNegative(Scanner keyboard) {
		Double temp = keyboard.nextDouble();
		keyboard.nextLine();
		while (temp<0) {
			System.out.println("invalid please try again.");
			temp = keyboard.nextDouble();
			keyboard.nextLine();
			
		}
		return temp;
		
	}

}