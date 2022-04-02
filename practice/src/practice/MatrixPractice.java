package practice;

public class MatrixPractice {
	
	public static void main(String[] args) {
		
		int[][] nums = { {1, 2, 3}, 
						 {4, 5, 6}, 
						 {7, 8, 9} };
		
		/*
		// add 10 to all nums in array
		for (int i = 0; i < nums.length; i++) {
			System.out.println();
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(nums[i][j] + " ");
				nums[i][j] += 10;
			}
		}
		*/
		
		// display
		for (int i = 0; i < nums.length; i++) {
			System.out.println();
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
		}
		
		System.out.println();
		System.out.println();
		
		// major (left) diagonal
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i][i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		// minor (right diagonal)
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i][nums.length - i - 1] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		// finds target
		int target = 5;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (nums[i][j] == target) {
					System.out.println("row:" + i + " col: " + j);
				}
			}
		}
		
	}

}
