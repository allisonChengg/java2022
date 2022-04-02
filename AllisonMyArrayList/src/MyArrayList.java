/*
 * Allison Cheng
 * MyArrayList: provides client programmers and users the 
 * illusion that the array can shrink & grow dynamically,
 * serves as wrapper class for normal array of integers
 */

public class MyArrayList {
	
	private int[] intArray;
	private int numOfActive;
	
	public MyArrayList() {
		intArray = new int[10];
		numOfActive = 0;
	}
	
	public MyArrayList(int capacity) {
		intArray = new int[capacity];
		numOfActive = 0;
	}
	
	public MyArrayList(MyArrayList other) {
		
		intArray = new int[other.intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = other.intArray[i];
		}
		numOfActive = 0;
	}
	
	// appends element to end of list, resizes if necessary
	public void add(int element) {
		
		// if array is full, resize array
		if (numOfActive == intArray.length) {
			
			int[] tempArray = new int[intArray.length + 1];
			for (int i = 0; i < intArray.length; i++) {
				tempArray[i] = intArray[i];
			}
			tempArray[intArray.length] = element;
			
			intArray = tempArray;
		}
		// otherwise, just add element to end of array
		else {
			intArray[numOfActive] = element;
		}
		numOfActive++;
	}
	
	// inserts element at index, slides all elements from 
	//index on to right by one, resizes if necessary
	public void add(int index, int element) {
		
		isValidRange(index);
		
		if (numOfActive == intArray.length) {
			
			int[] tempArray = new int[intArray.length + 1];
			
			for (int i = 0; i < index; i++) {
				tempArray[i] = intArray[i];
			}
			
			for (int i = index + 1; i < intArray.length; i++) {
				tempArray[i] = intArray[i - 1];
			}
			intArray[index] = element;
			
			intArray = tempArray;
			
		}
		else {
			
			for (int i = numOfActive + 1; i > index; i--) {
				if (i < intArray.length) {
					intArray[i] = intArray[i-1];
				}
			}
			intArray[index] = element;
		}
		numOfActive++;
	}
	
	// returns element located at index
	public int get(int index) {
		
		isValidRange(index);
		return intArray[index];
	}
	
	// returns index of 1st location of element, returns -1 if not found
	public int indexOf(int element) {
		
		for (int i = 0; i < intArray.length; i++) {
			if(intArray[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	// returns true if list is currently empty
	public boolean isEmpty() {
		return (numOfActive == 0);
	}
	
	// removes value at index & shifts remaining elements down to left
	// returns removed element
	public int removeIndex(int index) {
		
		int removedNum = intArray[index];
		for (int i = index; i < numOfActive; i++) {
			intArray[i] = intArray[i + 1];
		}
		numOfActive--;	
		
		return removedNum;
	}
	
	// removes first instance of element in array
	// slides elements past that point to left
	public boolean removeElement(int element) {
	
		// find index of element
		for (int i = 0; i < intArray.length; i++) {
			
			// if element found, remove & return true
			if (intArray[i] == element) {
				removeIndex(i);
				return true;
			}
		}
		return false;
	}

	// changes element at given position, returns original value
	public int set(int index, int element) {
		
		isValidRange(index);
		
		int temp = intArray[index];
		intArray[index] = element;
		return temp;
	}
	
	// returns total number of active elements
	public int size() {
		return numOfActive;
	}
	
	public void isValidRange(int index) {
		if (index < 0 || index > intArray.length - 1) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return;
	}
	
	public int getNumOfActive() {
		return numOfActive;
	}
	
	public String toString() {
		
		String s = "";
		for (int i = 0; i < intArray.length; i++) {
			s += intArray[i] + " ";
		}
		return s;
	}
}