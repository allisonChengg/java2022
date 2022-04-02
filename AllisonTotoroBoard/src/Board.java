/*
 * Board represents the n x n grid game with sliding totoro
 */

public class Board {
	
	private int[][] curBoard;
	private int movesMade;
	private Board previousBoard;
	private int[] totLoc;
	
	private int manhattan;
	
	public Board(int[][] board, int moves, Board prev) {
		
		curBoard = new int[board.length][board[0].length];
		totLoc = new int[2];
		
		for (int row = 0; row < curBoard.length; row++) {
			for (int col = 0; col < curBoard[row].length; col++) {
				curBoard[row][col] = board[row][col];
				
				if (board[row][col] == 0) {
					totLoc[0] = row;
					totLoc[1] = col;
				}
			}
		}
		previousBoard = prev;
		
		manhattan = getManhattan();
		
		if(isSolveable()) {
			System.out.println("Solveable");
		}
		else {
			System.out.println("Not Solveable");
		}
	}
	
	// returns new Board object w/ Totoro's location swapped w/ row & col
	public Board swap(int row, int col) {
		
		int[][] newGrid = curBoard;
		newGrid[totLoc[0]][totLoc[1]] = newGrid[row][col];
		newGrid[row][col] = 0;
		
		return new Board(curBoard, movesMade + 1, this);
	}
	
	// prints out contents of board as grid
	public void print() {
		
		for (int row = 0; row < curBoard.length; row++) {
			for (int col = 0; col < curBoard.length; col++) {
				
				if (curBoard[row][col] == 0) {
					System.out.print("T ");
				}
				else {
					System.out.print(curBoard[row][col] + " ");
				}
				
			}
			System.out.println();
		}
	}
	
	// returns true is all board pieces are in correct order
	public boolean gameOver() {
		
		if (manhattan == 0) {
			return true;
		}
		return false;
	}
	
	// checks if puzzle is solveable based off total elements out or order + how many elements out of order
	public boolean isSolveable() {
		
		int outCount = 0;
		
		for (int row = 0; row < curBoard.length; row++) {
			for (int col = 0; col < curBoard[0].length; col++) {
				
				if (curBoard[row][col] != 0) {
					// set start point to do checks
					int newRow = row;
					int newCol = col + 1;
					
					// if at most right col, set starting point to next row
					if (newCol > curBoard.length - 1) {
						newRow++;
						newCol = 0;
					}
					
					// start checking from newRow & newCol
					for (int i = newRow; i < curBoard.length; i++) {
						
						// if at starting row, use newCol instead of starting col
						int startingCol = newCol;
						if (i != row) {
							startingCol = 0;
						}
						for (int j = startingCol; j < curBoard[0].length; j++) {
							if (curBoard[i][j] != 0 && curBoard[i][j] < curBoard[row][col]) {
								outCount++;
							}
						}
					}
				
				}
			}
		}
		
		// checks to see if solveable or not
		if (curBoard.length % 2 == 0) {
			
			if (totLoc[0] % 2 == 0) {
				if (outCount % 2 != 0) {
					return true;
				}
				return false;
			}
			else {
				if (outCount % 2 == 0) {
					return true;
				}
				return false;
			}
		}
		else {
			
			if (outCount % 2 == 0) {
				return true;
			}
			return false;
		}
	}
	
	// determines how close current board is to final solution
	public int getManhattan() {
		
		int result = 0;
		
		// creates final solution
		int[][] perfectBoard = new int[curBoard.length][curBoard[0].length];
						
		int value = 1;
		for (int row = 0; row < perfectBoard.length; row++) {
			for (int col = 0; col < perfectBoard[0].length; col++) {
				perfectBoard[row][col] = value;
				value++;
			}
		}
		perfectBoard[perfectBoard.length - 1][perfectBoard.length - 1] = 0;
		
		// goes through current board to find perfect value location in the perfect board
		for (int row = 0; row < curBoard.length; row++) {
			for (int col = 0; col < curBoard[row].length; col++) {
				
				if (curBoard[row][col] != 0) {
					
					int numValue = curBoard[row][col];
					
					// finds value in perfect board
					boolean done = false;
					for (int i = 0; i < perfectBoard.length && !done; i++) {
						for (int j = 0; j < perfectBoard[0].length && !done; j++) {
							
							if (perfectBoard[i][j] == numValue) {
								// calculates result by comparing w/ abs value
								result += Math.abs(row - i) + Math.abs(col - j);
								done = true;
							}
						}
					}

				}
			}
		}
		
		return result;
	}
	
	public int compareTo(Board other) {

		return (this.manhattan + this.movesMade) - (other.manhattan + other.movesMade);

	}

	public boolean sameTotLoc(Board other) {

		return totLoc[0] == other.totLoc[0] && totLoc[1] == other.totLoc[1];

	}
	
}