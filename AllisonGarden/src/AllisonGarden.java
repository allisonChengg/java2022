import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AllisonGarden {
	
	public static final int SIZE = 8;
	public static final int[] HORZ_DISP = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static final int[] VERT_DISP = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) {
		boolean[][] grid = new boolean[SIZE][SIZE];
		Scanner keyboard = new Scanner(System.in);
		
		fillGarden(grid, keyboard);
		
		String response = "y";
		do {
			printGarden(grid);
			System.out.println("Do you want to see another day (y/n)");
			response = keyboard.nextLine();
			grid = changeGarden(grid);
		} while (response.equals("y"));
		
		
	}
	
	public static void fillGarden(boolean[][] grid, Scanner keyboard) {
		
		System.out.println("Filename: ");
		String filename = keyboard.nextLine();
		
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new File(filename));
		} catch(FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(-1);
		}
		
		while(fileIn.hasNextInt()) {
			int row = fileIn.nextInt();
			int col = fileIn.nextInt();
			grid[row][col] = true;
		}
	}
	
	public static void printGarden(boolean[][] grid) {
		
		for (int row = 0; row < grid.length; row++) {
			
			if (row == 0) {
				System.out.print("  ");
				for (int i = 0; i < grid[0].length; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			System.out.print(row + " ");
			
			for (int col = 0; col < grid[0].length; col++) {
				
				if (grid[row][col] == true) {
					System.out.print("X ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int countNeighbors(boolean[][] grid, int currentRow, int currentCol) {
		int numOfNeighbors = 0;
		
		for (int i = 0; i < VERT_DISP.length; i++) {
			int nextRow = currentRow + VERT_DISP[i];
			int nextCol = currentCol + HORZ_DISP[i];
			
			// make sure cell is legitimate
			if ((nextRow >= 0 && nextRow < grid[0].length) && (nextCol >= 0 && nextCol < grid[0].length)) {
				if (grid[nextRow][nextCol] == true) {
					numOfNeighbors++;
				}
			}
		}
		return numOfNeighbors;
	}
	
	public static boolean[][] changeGarden(boolean[][] grid) {
		boolean[][] newGrid = new boolean[SIZE][SIZE];
		
		for (int row = 0; row < grid.length; row++) {
			
			for (int col = 0; col < grid[0].length; col++) {
				
				int numOfNeighbors = countNeighbors(grid, row, col);
				if (numOfNeighbors <= 1 || numOfNeighbors >= 4) {
					newGrid[row][col] = false;
				}
				else if (numOfNeighbors == 3) {
					newGrid[row][col] = true;
				}
				else {
					newGrid[row][col] = grid[row][col];
				}
			}
		}
		return newGrid;
		
	}

}