
public class AllisonPerfectSquare {
	/*
	 * Allison Cheng
	 * Perfect Square: checks to see if numbers within matrix is a perfect square, tested w/ 1 bad matrix & 2 good matrices
	 */
	
	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		
		System.out.println("isPerfect: " + isPerfect(matrix));
		int [][]matrix2 = { {8, 1, 6}, {3, 5, 7}, {4, 9, 2} };
		System.out.println("isPerfect: " + isPerfect(matrix2));
		int [][]matrix3 = { {11, 24, 7, 20, 3}, 
							{4, 12, 25, 8, 16}, 
							{17, 5, 13, 21, 9}, 
							{10, 18, 1, 14, 22}, 
							{23, 6, 19, 2, 15} };
		System.out.println("isPerfect: " + isPerfect(matrix3));

	}
	
	// returns sum of row parameter
	public static int sumRow(int[][] square, int row) {
		
		int sum = 0;
		for (int col = 0; col < square[0].length; col++) {
			sum += square[row][col];
		}
		return sum;
	}
	
	// returns sum of a column
	public static int sumCol(int[][] square, int col) {
		
		int sum = 0;
		for (int row = 0; row < square.length; row++) {
			sum += square[row][col];
		}
		return sum;
	}
	
	// returns sum of diagonal from top left to bottom right
	public static int forwardDiag(int[][] square) {
		
		int sum = 0;
		for (int row = 0; row < square.length; row++) {
			int col = row;
			sum += square[row][col];
		}	
		return sum;
	}
	
	// returns sum of diagonal from top right to bottom left
	public static int backDiag(int[][] square) {
		int sum = 0;
		
		int col = square.length - 1;
		for (int row = 0; row < square.length; row++) {
			sum += square[row][col];
			col--;
		}
		
		return sum;
	}
	
	// checks to make sure each element in from 1 to N^2 & that each element only appears once
	public static boolean isUnique(int[][] square) {
		
		// store & check for unique values in this array
		int[] arrayUnique = new int[square[0].length * square[0].length]; 
		
		for (int row = 0; row < square.length; row++) {
			
			for (int col = 0; col < square[0].length; col++) {
				if ((square[row][col] <= 0) || (square[row][col] > (square.length * square.length))) {
					return false;
				}
				
				// put value 1 in index 0, value 2 in index 1, etc.
				int value = square[row][col];
				int index = value - 1;
				
				// if value is not zero, then it's a duplicate
				if (arrayUnique[index] > 0) {
					return false;
				}
				arrayUnique[index] = value;
			}
		}
		return true;
	}
	
	// checks if matrix is perfect square
	public static boolean isPerfect(int[][] square) {
		int forwardDiagSum = forwardDiag(square);
		int backDiagSum = backDiag(square);
		
		// checks if both diagonals are equal
		if (forwardDiagSum != backDiagSum) {
			return false;
		}
		
		// checks if sum of rows are equal
		for (int row = 0; row < square.length; row++) {
			if (sumRow(square, row) != forwardDiagSum) {
				return false;
			}
		}
		
		// checks if sum of columns are equal
		for (int col = 0; col < square[0].length; col++) {
			if (sumCol(square, col) != forwardDiagSum) {
				return false;
			}
		}
		
		// checks if each number in matrix is different
		if (!isUnique(square)) {
			return false;
		}
		
		return true;
	}
	
}