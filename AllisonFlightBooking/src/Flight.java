
public class Flight {
	
	private String name;
	private String destination;
	private Time departureTime;
	private int capacity;
	private int peopleBooked;
	private Customer[] customers;
	
	public Flight(String n, String dest, Time departTime) {
		name = n;
		destination = dest;
		departureTime = departTime;
		
		capacity = (int) (Math.random() * 81 + 30);
		peopleBooked = 0;
		
		customers = new Customer[capacity];
	}
	
	public boolean isFull() {
		return peopleBooked == capacity;
	}
	
	public int canBook(Customer c) {
		if (!isFull()) {
			if (c.getDestination().equals(destination)) {
				return c.getArrival().compareTo(departureTime);
			}
		}
		return 99999;
	}
	
	public void bookFlight(Customer c) {
		customers[peopleBooked] = c;
		peopleBooked++;
	}
	
	public void printPassengerList() {
		System.out.printf("%-20s %-20s %-20s %-20s \n", "Flight: ", name, "Departure Time", departureTime);
		System.out.printf("%-20s %-20s %-20s %-20s \n", "Max Occupancy: ", capacity, "Seats Filled: ", peopleBooked);
		System.out.println();
		
		System.out.printf("%-20s %-20s \n", "Name", "Arrival");
		for (int i = 0; i < peopleBooked; i++) {
			System.out.printf("%-20s %-20s \n", customers[i].getName(), customers[i].getArrival());
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public Time getDepartureTime() {
		return departureTime;
	}
	
	public String toString() {
		return "Name: " + name + " Destination: " + destination + " Departure: " + departureTime;
	}
}