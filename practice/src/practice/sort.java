package practice;

public class sort {

	public static void main(String[] args) {
		int[] arrayOfInts = {83, 95, 44, 37, 38, 72};
		sort(arrayOfInts);
	}
	
	// insertion sort
	public static void sort(int[] array) {
		int nextElement;
		
		for (int n = 1; n < array.length; n++) {
			nextElement = array[n];
			
			int i = n;
			
			while (i > 0 && nextElement < array[i - 1]) {
				array[i] = array[i - 1];
				i--;
			}
			
			array[i] = nextElement;
			
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
}
