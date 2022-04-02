import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		
		//int[][] grid = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
		
		// OOC: 10
		int[][] exGrid = { {1, 8, 2}, {0, 4, 3}, {7, 6, 5} };
		
		// OOC: 41
		int[][] exGrid1 = { {13, 2, 10, 3}, {1, 12, 8, 4}, {5, 0, 9, 6}, {15, 14, 11, 7} };
		
		//OOC: 62
		int[][] exGrid2 = { {6, 13, 7, 10}, {8, 9, 11, 0}, {15, 2, 12, 5}, {14, 3, 1, 4} };
		
		
		//Board board = new Board(grid, 0, null);
		
		Board board2 = new Board(exGrid1, 0, null);
		
		System.out.println();
		
		//play(board);
		play(board2);
	}
	
	public static void play(Board b) {
		 
		Scanner keyboard = new Scanner(System.in);
		String entry = "";
		
		while (true) {
			b.print();
			
			System.out.println("Enter the move 1 = L, 2 = R, 3 = U, 4 = D, q quit: ");
			entry = keyboard.nextLine();
			
			if (entry.equals("1")) {
				int[] curTotLoc = b.getTotLoc();
				b = b.swap(curTotLoc[0], curTotLoc[1] - 1);
			}
			else if (entry.equals("2")) {
				int[] curTotLoc = b.getTotLoc();
				b = b.swap(curTotLoc[0], curTotLoc[1] + 1);
			}
			else if (entry.equals("3")) {
				int[] curTotLoc = b.getTotLoc();
				b = b.swap(curTotLoc[0] - 1, curTotLoc[1]);
			}
			else if (entry.equals("4")) {
				int[] curTotLoc = b.getTotLoc();
				b = b.swap(curTotLoc[0] + 1, curTotLoc[1]);
			}
			else {
				return;
			}
			
			if (b.gameOver()) {
				System.out.println("Game completed");
				return;
			}
		
		}
	}
	
}

