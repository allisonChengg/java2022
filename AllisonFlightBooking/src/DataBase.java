import java.util.Scanner;

public class DataBase {
	
	
	public static void main(String[] args) {
	
		/*
		Time t = new Time(2, 40);
		Flight f = new Flight("AA", "Paris", t);
		
		Customer c = new Customer("Joe", "Paris", t);
	
		System.out.println(f);
		
		f.bookFlight(c);
		
		f.printPassengerList();
		*/
		
		System.out.println(System.getProperty("user.dir"));
		String inFile = "/Users/school/eclipse-workspace/AllisonFlightBooking/flights";
		AllFlights a = new AllFlights(inFile);
		
		Scanner keyboard = new Scanner(System.in);
		
		String userInput = "";
		do {
			System.out.println("Menu Options:\nB) Buy a ticket\nL) List all Flights");
			System.out.println("S) Show Manifest\nQ) Quit\n");
			System.out.print("Enter Choice: ");
			
			userInput = keyboard.nextLine().toUpperCase();
			
			if (userInput.equals("B")) {
				System.out.print("Enter customer name: ");
				String custName = keyboard.nextLine();
				System.out.print("Enter destination: ");
				String custDest = keyboard.nextLine();
				System.out.print("Enter arrival time HOUR: ");
				int arriveHour = keyboard.nextInt();
				System.out.print("Enter arrival time MINUTE: ");
				int arriveMinute = keyboard.nextInt();
				
				Customer c = new Customer(custName, custDest, new Time(arriveHour, arriveMinute));
				a.sellTicket(c);
			}
			else if (userInput.equals("L")) {
				System.out.println(a);
			}
			else if (userInput.equals("S")) {
				a.printManifest();
			}
			
		} while (!userInput.equals("Q"));
		
		
		System.out.println("Bye");
	}
	
}
