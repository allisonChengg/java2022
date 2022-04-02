/*
 * Allison Cheng
 * MyArrayList: provides client programmers and users the 
 * illusion that the array can shrink & grow dynamically,
 * serves as wrapper class for normal array of integers
 * 
 * Result must be Object type in order for this to compile
 * You can call the methods within the Object class, such as toString & equals
 * You cannot call Jewelry methods without downcasting
 */

public class MyArrayList {
	
	private Object[] array;
	private int numOfActive;
	
	public MyArrayList() {
		array = new Object[10];
		numOfActive = 0;
	}
	
	public MyArrayList(int capacity) {
		array = new Object[capacity];
		numOfActive = 0;
	}
	
	public MyArrayList(MyArrayList other) {
		
		array = new Object[other.array.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = other.array[i];
		}
		numOfActive = 0;
	}
	
	// appends element to end of list, resizes if necessary
	public void add(Object element) {
		
		// if array is full, resize array
		if (numOfActive == array.length) {
			
			Object[] tempArray = new Object[array.length + 1];
			for (int i = 0; i < array.length; i++) {
				tempArray[i] = array[i];
			}
			tempArray[array.length] = element;
			
			array = tempArray;
		}
		// otherwise, just add element to end of array
		else {
			array[numOfActive] = element;
		}
		numOfActive++;
	}
	
	// inserts element at index, slides all elements from 
	//index on to right by one, resizes if necessary
	public void add(int index, Object element) {
		
		isValidRange(index);
		
		if (numOfActive == array.length) {
			
			Object[] tempArray = new Object[array.length + 1];
			
			for (int i = 0; i < index; i++) {
				tempArray[i] = array[i];
			}
			
			for (int i = index + 1; i < array.length; i++) {
				tempArray[i] = array[i - 1];
			}
			array[index] = element;
			
			array = tempArray;
			
		}
		else {
			
			for (int i = numOfActive + 1; i > index; i--) {
				if (i < array.length) {
					array[i] = array[i-1];
				}
			}
			array[index] = element;
		}
		numOfActive++;
	}
	
	// returns element located at index
	public Object get(int index) {
		
		isValidRange(index);
		return array[index];
	}
	
	// returns index of 1st location of element, returns -1 if not found
	public int indexOf(int element) {
		
		for (int i = 0; i < array.length; i++) {
			if(array[i].equals(element)) {
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
	public Object removeIndex(int index) {
		
		Object removedNum = array[index];
		for (int i = index; i < numOfActive; i++) {
			array[i] = array[i + 1];
		}
		numOfActive--;	
		
		return removedNum;
	}
	
	// removes first instance of element in array
	// slides elements past that point to left
	public boolean removeElement(int element) {
	
		// find index of element
		for (int i = 0; i < array.length; i++) {
			
			// if element found, remove & return true
			if (array[i].equals(element)) {
				removeIndex(i);
				return true;
			}
		}
		return false;
	}

	// changes element at given position, returns original value
	public Object set(int index, Object element) {
		
		isValidRange(index);
		
		Object temp = array[index];
		array[index] = element;
		return temp;
	}
	
	// returns total number of active elements
	public int size() {
		return numOfActive;
	}
	
	public void isValidRange(int index) {
		if (index < 0 || index > array.length - 1) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return;
	}
	
	public int getNumOfActive() {
		return numOfActive;
	}
	
	public String toString() {
		
		String s = "";
		for (int i = 0; i < array.length; i++) {
			s += array[i] + " ";
		}
		return s;
	}
}