/*
 * Allison Cheng
 * CollegeStudent: represents a college student who has 
 * a name, ID #, major, dorm name, & board
 */

public class CollegeStudent {
	
	private static int nextID = 1;
	private int id;
	private String name;
	private String major;
	private String dorm;
	private double board;
	
	public CollegeStudent(String n, String m, String d, double b) {
		
		if (board < 0) {
			throw new IllegalArgumentException("Invalid Board");
		}
		name = n;
		major = m;
		dorm = d;
		board = b;
		id = nextID++;
	}
	
	public int getID() {
		return id;
	}
	
	public String getDorm() {
		return dorm;
	}
	
	public double getBoard() {
		return board;
	}
	
	public double raise() {
		return 1.015 * board;
	}
	
	public String toString() {
		return "Name: " + name + " ID: " + id + " Major: " + major + " Dorm Name: " + dorm + " Board: $" + getBoard();
	}

}