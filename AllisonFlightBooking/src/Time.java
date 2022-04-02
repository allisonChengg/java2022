
//represents the Time in a single day using military time format
public class Time {

	private int hour;
	private int minute;
	
	public Time(int h, int m) {
		if(h < 0 || h > 23)
			throw new IllegalArgumentException("Invalid hour");
		
		if(m < 0 || m > 59)
			throw new IllegalArgumentException("Invalid minute");
		hour = h;
		minute = m;
	}
	
	public String toString() {
		
		String toReturn = "";
		
		if (hour < 10)
			toReturn += "0";
		toReturn += hour +":";
		
		if (minute < 10)
			toReturn += "0";
		toReturn += minute;
		
		return toReturn;
	}
	
	public int compareTo(Time other) { 
		return (hour  *60 + minute) - (other.hour * 60 + other.minute);
	}
}
