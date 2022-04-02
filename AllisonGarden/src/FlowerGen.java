import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class FlowerGen extends JFrame implements ActionListener {

	private int GRID_SIZE;
	private BufferedImage image;
	
	private PicPanel[][] allPanels;
	private JButton stepButton;
	private boolean[][] grid;
	
	public final int[] HORZDISP = { 1, 1, 0, -1, -1, -1, 1, 0 }; // neighborhoods
	public final int[] VERTDISP = { 0, 1, 1, 1, -1, 0, -1, -1 };

	public FlowerGen(int gridSize) {
		
		GRID_SIZE = gridSize;
		setSize(800, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Garden");
		getContentPane().setBackground(new Color(18, 145, 15));
		
		// reads in fireflower image
		try {
			image = ImageIO.read(new File("fireflower.jpg"));

		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Could not read in the pic");
			System.exit(0);
		}
		
		allPanels = new PicPanel[GRID_SIZE][GRID_SIZE];
		JPanel gardenPanel = new JPanel();
		gardenPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE, 0, 0));
		gardenPanel.setBounds(20, 20, 600, 600);
		gardenPanel.setOpaque(false);
		gardenPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		PicPanel picPanel;
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				
				picPanel = new PicPanel();
				picPanel.setBorder(BorderFactory.createLineBorder(Color.black));
				picPanel.setBackground(Color.lightGray);
				picPanel.setOpaque(false);
				gardenPanel.add(picPanel);
				allPanels[row][col] = picPanel;
			}
		}
		readLocationInputs();
		
		JButton stepButton = new JButton("Step");
		stepButton.setBounds(650, 250, 60, 40);
		stepButton.addActionListener(this);
		
		add(stepButton);
		add(gardenPanel);
		setVisible(true);
	}
	
	public void readLocationInputs() {

		String filename = "flowerlocs.txt";
		grid = new boolean[GRID_SIZE][GRID_SIZE];

		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(-1);
		}

		while (fileIn.hasNextInt()) {
			int row = fileIn.nextInt();
			int col = fileIn.nextInt();
			grid[row][col] = true;
			allPanels[row][col].addFlower();
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		changeGarden();
	}
	
	public void changeGarden() {
		boolean[][] newGrid = new boolean[grid.length][grid[0].length];
		
		for (int row = 0; row < grid.length; row++) {

			for (int col = 0; col < grid[0].length; col++) {

				int numOfNeighbors = countNeighbors(row, col);
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
		
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] != newGrid[row][col]) {
					allPanels[row][col].setBorder(BorderFactory.createLineBorder(Color.red));
					if (newGrid[row][col]) {
						allPanels[row][col].addFlower();
					} else {
						allPanels[row][col].removeFlower();
					}
				} else {
					allPanels[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
				}
			}
		}
		grid = newGrid;
	}
	
	public int countNeighbors(int currentRow, int currentCol) {
		
		int numOfNeighbors = 0;

		for (int i = 0; i < VERTDISP.length; i++) {
			int nextRow = currentRow + VERTDISP[i];
			int nextCol = currentCol + HORZDISP[i];

			// make sure cell is legitimate
			if ((nextRow >= 0 && nextRow < grid[0].length) && (nextCol >= 0 && nextCol < grid[0].length)) {
				if (grid[nextRow][nextCol] == true) {
					numOfNeighbors++;
				}
			}
		}
		return numOfNeighbors;
	}
	

	class PicPanel extends JPanel {

		private boolean hasFlower = false;

		public void addFlower() {
			hasFlower = true;
			repaint();
		}

		public void removeFlower() {
			hasFlower = false;
			repaint();
		}

		// this will draw the image
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (hasFlower)
				g.drawImage(image, 0, 0, this);
		}
	}
	
	public static void main(String[] args) {
		
		int gridSize = 10;
		if (args.length > 0) {
			gridSize = Integer.parseInt(args[0]);
		}
		new FlowerGen(gridSize);
	}

}