/*
 * Allison Cheng
 * HeadRA: represents Head Resident Assistant responsible for all
 * other RAs & CollegeStudents living in same dorm, get flat bonus
 */

public class HeadRA extends ResidentAssistant {
	
	private double bonus;
	
	public HeadRA(String n, String m, String d, double b, double bon) {
		super(n, m, d, b);
		bonus = bon;
	}
	
	public double getBoard() {
		return super.getBoard() - bonus;
	}
	
}