import java.io.*;
import java.util.Scanner;

public class AllFlights {
	
	private Flight[] flights;
	
	public AllFlights(String fileName) {
		
		Scanner fileIn = null;
		int count = 0;
		
		try {
			fileIn = new Scanner(new File(fileName));
			
			// gets number of file lines
			while(fileIn.hasNextLine()) {
				fileIn.nextLine();
				count++;
			}
			
			fileIn.close();
			fileIn = new Scanner(new File(fileName));
			
			// calculates array size
			int flightSize = count / 3;
			flights = new Flight[flightSize];
			
			// builds array of flights
			int flightNum = 0;
			while(fileIn.hasNextLine()) {
				
				String flightName = fileIn.nextLine();
				String destination = fileIn.nextLine();
				int hour = fileIn.nextInt();
				int minute = fileIn.nextInt();
				
				Time t = new Time(hour, minute);
				
				flights[flightNum] = new Flight(flightName, destination, t);
				flightNum++;
				
				if (fileIn.hasNextLine())
					fileIn.nextLine();
			}
			
				fileIn.close();
				
		} catch(FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
			
		} 
			
	}
	
	public void sellTicket(Customer c) {
		int bestFlightIndex = -1;
		int bestWaitTime = -10000;
		for (int i = 0; i < flights.length; i++) {
			if (flights[i].getDestination().equals(c.getDestination())) {
				int thisWait = flights[i].canBook(c);
				// we want the biggest negative wait time, ie: shortest wait
				if (thisWait < 0) {
					if (thisWait > bestWaitTime) {
						bestFlightIndex = i;
						bestWaitTime = thisWait;
					}
				}
			}
		}
		if (bestFlightIndex >= 0) {
			flights[bestFlightIndex].bookFlight(c);
			System.out.printf("Booked on %s !\n", flights[bestFlightIndex].getName());
		} else {
			System.out.println("No flights available");
		}
	}

	public void printManifest() {
		for(int i = 0; i < flights.length ; i++) {
			flights[i].printPassengerList();
		}
	}
	
	public String toString() {
		return "";
	}

}
