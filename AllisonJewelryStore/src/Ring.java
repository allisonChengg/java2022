/*
 * Allison Cheng
 * Ring: represents a type of Jewelry that 
 * also maintains a carat amount & cut type
 */
public class Ring extends Jewelry {

	private double caratAmount;
	private String cutType;
	
	public Ring(String n, String m, String s, int p, int q, double cA, String cT) {
		super(n, m, s, p, q);
		
		if (caratAmount < 0) {
			throw new IllegalArgumentException("Invalid carat amount");
		}
		caratAmount = cA;
		cutType = cT;
	}
	
	public String toString() {
		return super.toString() + "\nCarat Amount: " + caratAmount + "\nCut Type: " + cutType;
	}
}