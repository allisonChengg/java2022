/*
 * Allison Cheng 
 * Jewelry: represents piece of jewelry w/ name, 
 * metal + stone type, price, & quantity
 */

public class Jewelry {
	
	private String name;
	private String metal;
	private String stone;
	private int price;
	private int quantity;
	
	public Jewelry(String n, String m, String s, int p, int q) {
		
		if (price < 0) {
			throw new IllegalArgumentException("Invalid price");
		}
		if (quantity < 0) {
			throw new IllegalArgumentException("Invalid quantity");
		}
		
		name = n;
		metal = m;
		stone = s;
		price = p;
		quantity = q;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMetal() {
		return metal;
	}
	
	public String getStone() {
		return stone;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int removeQuantity(int quant) {
		return quantity - quant;
	}
	
	public int addQuantity(int quant) {
		return quantity + quant;
	}
	
	// compares each piece of jewelry based on name
	public int compareTo(Jewelry j) {
		
		int result = name.compareTo(j.getName());
		
		// if pieces don't have the same name, return 
		//calling object position in comparison to Jewelry parameter
		if (result != 0) {
			return result;
		}
		// if pieces have name same, compare the price
		return price - j.getPrice();
	}
	
	public String toString() {
		return "Name: " + name + "\nMetal: " + metal + "\nStone: " + stone + "\nPrice: " + price + "\nQuantity: " + quantity;
	}
}