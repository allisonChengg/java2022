/*
 * Allison Cheng
 * Comparables will be generic and reusable for comparing any Objects that implements Comparable
 */
public class Client {
	
	public static void main(String[] args) {
		
		Necklace[] n = new Necklace[5];
		n[0] = new Necklace("a", "s", "ss", 1, 2, 4);
		n[1] = new Necklace("b", "s", "ss", 1, 2, 6);
		n[2] = new Necklace("c", "s", "ss", 1, 2, 1);
		n[3] = new Necklace("d", "s", "ss", 1, 2, 4);
		n[4] = new Necklace("e", "s", "ss", 1, 2, 9);
		
		sort(n);
		
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}
	}
	
	// sorts through any Objects that implements Comparable
	public static void sort(Comparable[] c) {

		Comparable nextElement;

		// examine one element at a time & sorts subsets of elements

		for (int n = 1; n < c.length; n++) {

			nextElement = c[n];
			// properly places nextElement in order of subset

			int i = n;

			// shifts elements to the right one at a time until find the correct spot for nextElement
			while (i > 0 && nextElement.compareTo(c[i - 1]) < 0) {

				c[i] = c[i - 1];
				i--;
			}
			c[i] = nextElement;	
		}

	}

}