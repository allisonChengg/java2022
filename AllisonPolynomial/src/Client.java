
public class Client {
	
	public static void main(String[] args) {
		int[] array = {4, 0, 2, 1};
		Polynomial p = new Polynomial(array);
		System.out.println(p);
		
		System.out.println(p.evaluate(2));
		
		int[] a1 = {3, 3, 3};
		int[] a2 = {1, 1, 1, 1, 1};
		Polynomial p1 = new Polynomial(a1);
		Polynomial p2 = new Polynomial(a2);
		
		p1 = p1.add(p2);
		System.out.println(p1);
		
	}

}
