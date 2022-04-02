/*
 * Allison Cheng
 * Rational Class: performs basic operations on rational numbers and simplifies results
 */
public class Rational {
	
	private int numerator;
	private int denominator;
	
	public Rational(int n, int d) {
		numerator = n;
		denominator = d;
		
		// simplifies fractions
		int divisor = gcd(numerator, denominator);
		numerator /= divisor;
		denominator /= divisor;
	}
	
	// adds 2 rational functions together
	public Rational add(Rational other) {
		numerator = (this.numerator * other.denominator) + (this.denominator * other.numerator);
		denominator = (this.denominator * other.denominator);
		
		return new Rational(numerator, denominator);
	}
	
	// subtracts rational functions 
	public Rational subtract(Rational other) {
		numerator = (this.numerator * other.denominator) - (this.denominator * other.numerator);
		denominator = (this.denominator * other.denominator);
		
		return new Rational(numerator, denominator);
	}
	
	// multiplies rational functions
	public Rational multiply(Rational other) {
		
		numerator = this.numerator * other.numerator;
		denominator = this.denominator * other.denominator;
		
		return new Rational(numerator, denominator);
	}
	
	// divides rational functions
	public Rational divide(Rational other) {
		
		numerator = this.numerator * other.denominator;
		denominator = this.denominator * other.numerator;
		
		return new Rational(numerator, denominator);
	}
	
	// finds greatest common divisor
	public int gcd(int numer, int denom) {
		
		int remainder = numer % denom;
		
		if (remainder == 0) {
			return denom;
		}
		return gcd(denom, remainder);	
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}

}