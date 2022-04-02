import java.io.*;
import java.util.Scanner;

public class Polynomial {
	
	private int[] coeffs;
	
	public Polynomial(int[] coeffs) {
		this.coeffs = new int[coeffs.length];
		
		for (int i = 0; i < coeffs.length; i++) {
			this.coeffs[i] = coeffs[i];
		}
	}
	
	public Polynomial(String fname) {
		
		Scanner fileIn = null;
		
		try {
			fileIn = new Scanner(new File(fname));
		} catch(FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(-1);
		}
		
		int size = fileIn.nextInt();
		coeffs = new int[size];
		int i = 0;
		while(fileIn.hasNextLine()) {
			coeffs[i] = fileIn.nextInt();
			i++;
		}
		
	}
	
	public Polynomial(Polynomial p) {
		this.coeffs = new int[p.coeffs.length];
		
		for (int i = 0; i < coeffs.length; i++) {
			this.coeffs[i] = p.coeffs[i];
		}
	}
	
	public void set(int term, int coef) {
		if(term < 0 || term > coeffs.length - 1) {
			throw new IllegalArgumentException("Term out of bounds");
		}
		coeffs[term] = coef;
	}
	
	public int evaluate(int x) {
		int total = 0;
		for (int i = 0; i < coeffs.length; i++) {
			if(coeffs[i] == 0) {
				continue;
			}
			if (i==0) {
				total += coeffs[i];
				continue;
			}
			
			total += coeffs[i] * Math.pow(x, i);
		}
		return total;
	}
	
	public Polynomial add(Polynomial other) {
		
		int size = coeffs.length;
		if (other.coeffs.length > size) {
			size = other.coeffs.length;
		}
		int[] newArray = new int[size];
		
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = 0;
			
			// handle different length Polynomials
			if (i < coeffs.length) {
				newArray[i] += coeffs[i];
			}
			if (i < other.coeffs.length) {
				newArray[i] += other.coeffs[i];
			}
		}
		
		return new Polynomial(newArray);
	}
	
	public String toString() {
		String result = "";
		for (int i = coeffs.length - 1; i >= 0 ; i--) {
			
			if(coeffs[i] > 0) {
			
				// only need " + " if not first result
				if (result.length() > 0) {
					result += " + ";
				}
				
				if(i == 0) {
					result += coeffs[i];
				}
				else {
					result += coeffs[i] + "x^" + i;
				}
			}
			
		}
		return result;
	}

}