/*
 * Allison Cheng
 * Stroop Effect: program randomly selects a word that is a color from 
 * the color set & randomly selects the color
 * When the user presses the "Guess" button, the program will
 * inform them whether the current color in JPanel matches the JLabel text
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AllisonStroopEffect extends JFrame implements ActionListener {

	//text value and color value for the label and panel
	private final String[] names = {"Red","Orange","Yellow","Green","Blue","Magenta"};
	private final Color[] colors = {Color.red,Color.orange,Color.yellow,Color.green,Color.blue,Color.magenta};
	
	private int indexName;
	private int indexColor;
	private JPanel colorPanel;
	private JLabel label;
	private int panelColorIndex;
	
	public AllisonStroopEffect() {
		
		// left to right placement of GUI objects
		setLayout(new FlowLayout());
		
		// add buttons
		JButton guess = new JButton("Guess");
		add(guess);
		JButton cycle = new JButton("Cycle");
		add(cycle);
		cycle.addActionListener(this);
		guess.addActionListener(this);
		
		// add label w/ theWord & theColor
		label = new JLabel();
		setRandomizedLabel();
		add(label);
		
		// initialize the JPanel and give it a size, keeps track of color index
		panelColorIndex = indexColor;
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(30, 30));
		colorPanel.setBackground(colors[indexColor]);
		add(colorPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(175, 120);
		setVisible(true);
	}
	
	// makes label color and text different & sets it
	private void setRandomizedLabel() {
		
		Random random = new Random();
		indexName = random.nextInt(names.length);

		// get random color, but must be different from color word
		int indexColor = indexName;
		do {
			indexColor = random.nextInt(colors.length);
		} while (indexColor == indexName);
		
		label.setText(names[indexName]);
		label.setForeground(colors[indexColor]);
	}
	
	//pops up a separate message containing the parameter
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	// handles all button presses
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Cycle")) {
			panelColorIndex++;
			 
			if(panelColorIndex >= colors.length) {
				panelColorIndex = 0;
			}
			colorPanel.setBackground(colors[panelColorIndex]);
		}
		
		// if text is same as panel color, pop up message then call randomize
		if (e.getActionCommand().equals("Guess")) {
			
			if (indexName == panelColorIndex) {
				displayMessage("You guessed right!");
			}
			else {
				displayMessage("You guessed wrong!");
			}	
			setRandomizedLabel();
		}
		
	}
	
	public static void main(String[] args) {
		new AllisonStroopEffect();
	}
	
}