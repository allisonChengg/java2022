
//Represents a person that wants to board a flight
public class Customer {

	private String name;
	private String destination;
	private Time arrival;
	
	public Customer(String n, String d, Time a) {
		name = n;
		arrival = a;
		destination = d;
	}
	
	public Time getArrival() {
		return arrival;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + "\t"+destination+"\t"+arrival;
	}
}