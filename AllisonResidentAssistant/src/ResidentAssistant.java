/*
 * Allison Cheng
 * Resident Assistant: represent CollegeStudent responsible for all students
 * living in same dorm, also paid stipend for job
 * 
 * 1) When calling the HeadRA, it calls ResidentAssistant's toString (toString of its superclass)
 * 2) It gave the original board amount, not the true amount reduced by stipend & bonus
 * 3) It calls the HeadRA's getBoard method to return the correct board value
 */

import java.util.NoSuchElementException;

public class ResidentAssistant extends CollegeStudent {
	
	private CollegeStudent[] collegeStudents;
	private double stipend;
	
	public ResidentAssistant(String n, String m, String d, double b) {
		super(n, m, d, b);
		collegeStudents = new CollegeStudent[0];
		stipend = 0.0;
	}
	
	// adds student to RA's list of students
	public void addStudent(CollegeStudent c) {
		
		if (!getDorm().equals(c.getDorm())) {
			throw new IllegalArgumentException("Different dorm");
		}
		
		CollegeStudent[] newCollegeStudents = new CollegeStudent[collegeStudents.length + 1];
		for (int i = 0; i < newCollegeStudents.length - 1; i++) {
			newCollegeStudents[i] = collegeStudents[i];
		}
		newCollegeStudents[newCollegeStudents.length - 1] = c;
		
		collegeStudents = newCollegeStudents;
	}
	
	// removes student from RA's list using student ID
	public void moveOut(int studentID) {
		
		CollegeStudent[] newCollegeStudents = null;
		for (int i = 0; i < collegeStudents.length; i++) {
			
			if (collegeStudents[i].getID() == studentID) {
				
				newCollegeStudents = new CollegeStudent[collegeStudents.length - 1];
				
				for (int j = 0, newIndex = 0; j < collegeStudents.length; j++) {
					if (j != i) {
						newCollegeStudents[newIndex++] = collegeStudents[j];
					}
				}
				collegeStudents = newCollegeStudents;
				return;
			}
		}
		// if here, student ID doesn't exist
		throw new NoSuchElementException("No such student w/ ID");
	}
	
	public double getStipend() {
		double total = 0.0;
		for (int i = 0; i < collegeStudents.length; i++) {
			total += collegeStudents[i].getBoard();
		}
		return total *= 0.05;
	}
	
	public double getBoard() {
		
		double result = super.getBoard() - getStipend();
		if (result < 0.0) {
			result = 0.0;
		}
		return result;
	}
	
	public String toString() {
		
		String studentInfo = "";
		studentInfo += "Stipend: $" + getStipend() + "\n";
		for (int i = 0; i < collegeStudents.length; i++) {
			studentInfo += collegeStudents[i] + "\n";
		}
		return super.toString() + "\n" + studentInfo;
	}
	
}