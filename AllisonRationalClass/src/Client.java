
public class Client {
	
	public static void main(String[] args) {
		Rational first = new Rational(2, 4);
		Rational second = new Rational(3, 4);
		
		Rational addResult = first.add(second);
		System.out.println(addResult);
		
		Rational subResult = first.subtract(second);
		System.out.println(subResult);
		
		Rational multResult = first.multiply(second);
		System.out.println(multResult);
		
		Rational divResult = first.add(second);
		System.out.println(divResult);
	}

}
