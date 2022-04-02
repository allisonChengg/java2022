/*
 * Allison Cheng
 * Frequency Sort: sorts array in ascending order based on frequency of each values
 * 
 * Merge Sort (Continued): 
 * Final result of array: numbers sorted in ascending order
 * 
 * Split Array in half
 * Right side sorted first, then left
 * Recombine both halves in order in temp array
 * Empty out any left over elements from one of the two halves
 * Recombine in original array
 * 
 * In the original sort, the left half was sorted first
 * When switching the recursive calls, the right half was sorted first
 * The end result is still the same
 */

public class AllisonFrequencySort {
	
	public static void main(String[] args) {
		int[] data = {4, 0, 1, 2, 0, 3, 3, 0};
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		
		
		int[] array = freqSort(data, 5);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	
	}	
	
	// returns new array of data sorted
	public static int[] freqSort(int[] data, int upper) {
		
		int[] freqArray = new int[upper];
		
		// builds frequency array, increments each value
		for (int i = 0; i < data.length; i++) {
			freqArray[data[i]]++;
		}
		
		// take previous value & add to next value
		for (int i = 1; i < freqArray.length; i++) {
			freqArray[i] += freqArray[i - 1];
		}
		
		int[] newArray = new int[data.length];
		
		// decrements value & puts original value into newArray index in ascending order
		for (int i = 0; i < data.length; i++) {
			freqArray[data[i]]--;
			newArray[freqArray[data[i]]] = data[i];
		}
		
		return newArray;
	}
	
}