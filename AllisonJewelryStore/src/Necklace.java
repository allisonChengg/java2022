/*
 * Allison Cheng
 * Necklace: represents a type of Jewelry that 
 * also maintains the length of the necklace chain
 */
public class Necklace extends Jewelry implements Comparable<Necklace> {
	
	private int length;

	public Necklace(String n, String m, String s, int p, int q, int l) {
		super(n, m, s, p, q);
		
		if (length < 0) {
			throw new IllegalArgumentException("Invalid length");
		}
		length = l;
	}
	
	public int compareTo(Necklace other) {
		return other.getLength() - getLength();
	}
	public int getLength() {
		return length;
	}
	public String toString() {
		return super.toString() + "\nLength: " + length;
	}
}