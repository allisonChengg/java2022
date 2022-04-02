/*
 * Allison Cheng
 * JewelryStore: represents container for multiple Jewelry objects
 * 
 * Adding ring or necklace object to Jewelry Store works because
 * the ring and necklace objects inherit all instance variables & methods 
 * of the Jewelry class & IS-A Jewelry (Inheritance Transitivity)
 */

public class JewelryStore {
	
	private Jewelry[] jewelryArray = null;
	
	// need to specify default constructor b/c specifying constructor below
	public JewelryStore() {
		
	}
	
	public JewelryStore(JewelryStore j) {
		jewelryArray = new Jewelry[j.jewelryArray.length];
		for (int i = 0; i < jewelryArray.length; i++) {
			jewelryArray[i] = j.jewelryArray[i];
		}
	}
	
	// inserts toAdd into array, maintains array in ascending order by name & price
	// if name & price already exists, just updates quantity
	public void add(Jewelry toAdd) {
		
		if (jewelryArray != null) {
			for (int i = 0; i < jewelryArray.length; i++) {
				if (jewelryArray[i].compareTo(toAdd) == 0) {
					jewelryArray[i].addQuantity(toAdd.getQuantity());
					return;
				}			
			}
		}
		
		// this is the first jewelry to be added
		if (jewelryArray == null) {
			jewelryArray = new Jewelry[1];
			jewelryArray[0] = toAdd;
			return;
		}
				
		Jewelry[] newJewelryArray = new Jewelry[jewelryArray.length + 1];
		for (int i = 0, j = 0; i < newJewelryArray.length - 1; i++) {
			// inserts toAdd in ascending order
			if (jewelryArray[i].compareTo(toAdd) >= 0) {
				newJewelryArray[j++] = toAdd;
			}
			newJewelryArray[j++] = jewelryArray[i];
		}	
		jewelryArray = newJewelryArray;
	}
	
	// sells quant amount of the Jewelry containing the same parameter
	public boolean sell(String name, int price, int quant) {
		
		if (quant < 0 || price < 0) {
			return false;
		}
		
		for (int i = 0; i < jewelryArray.length; i++) {
			if (jewelryArray[i].getName().compareTo(name) == 0) {
				
				// not enough to sell
				if (jewelryArray[i].getQuantity() < quant) {
					return false;
				}
				jewelryArray[i].removeQuantity(quant);
				return true;
			}
		}
		return false;
	}
	
	// removes the Jewelry containing name/price from the array
	public void remove(String name, int price) {
		
		for (int i = 0; i < jewelryArray.length; i++) {
			if (jewelryArray[i].getName().compareTo(name) == 0 && jewelryArray[i].getPrice() == price) {
				Jewelry[] newJewelryArray = new Jewelry[jewelryArray.length - 1];
				
				for (int j = 0, newIndex = 0; j < jewelryArray.length; j++) {
					if (j != i) {
						newJewelryArray[newIndex++] = jewelryArray[j];
					}
				}
				jewelryArray = newJewelryArray;
				return;
			}
		}
		
	}
	
	// prints out all Jewelry in the Store
	public void display() {
		for (int i = 0; i < jewelryArray.length; i++) {
			System.out.println("Name: " + jewelryArray[i].getName() + "\nPrice: " + jewelryArray[i].getPrice() + "\nQuantity: " + jewelryArray[i].getQuantity());
		}
	}
	
	// returns true if name/price exists
	public boolean search(String name, int price) {
		Jewelry target = new Jewelry(name, null, null, price, 0);
		int result = binarySearch(jewelryArray, target);
		
		return result >= 0;
	}
	
	// faster than for-loop search
	public static int binarySearch(Jewelry[] array, Jewelry target) {
		
		int startLoc = 0;
		int endLoc = array.length -1;
		
		while(startLoc <= endLoc) {
			
			int midIndex = (startLoc + endLoc)/2;
			
			// if object has same name & price, it is found
			if(array[midIndex].compareTo(target) == 0) {
				return midIndex;
			}
			else if(array[midIndex].compareTo(target) > 0) {
				endLoc = midIndex - 1;
			}
			else {
				startLoc = midIndex + 1;
			}
		}
		return -1;
	}
}