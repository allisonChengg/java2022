/*
 * Allison Cheng
 * RemoteControl: rectangle with buttons to simulate a remote control
 */
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class AllisonRemoteControl extends JFrame {
	
	public AllisonRemoteControl() {
		
		setLayout(null);
		//setLayout(new GridLayout(3,1));
		setUndecorated(true);
		setSize(250, 500);
		setLocationRelativeTo(null);
		setShape(new RoundRectangle2D.Double(30,30, 200, 450, 10, 10));
		getContentPane().setBackground(Color.black);
				
		// topPanel just have 1 red button
		JPanel topPanel = new JPanel(new GridLayout(1,4));
		JButton redButton = new JButton();
		redButton.setForeground(Color.red);
		redButton.setOpaque(true);
		redButton.setBounds(50, 50, 20, 20);
		topPanel.add(redButton);
		
		// buttonPanel to hold 12 buttons
		int sz = 10;
		JPanel buttonPanel = new JPanel(new GridLayout(4,3,25,25));
		buttonPanel.setOpaque(false);
		buttonPanel.setBounds(40, 80, 180, 200);
		int counter = 1;
		for(int i=0; i<9; i++ ) {
			JButton button = new JButton("" + counter++);
			button.setPreferredSize(new Dimension(sz, sz));
			buttonPanel.add(button);
		}
		JButton button1 = new JButton("-");
		button1.setPreferredSize(new Dimension(sz, sz));
		buttonPanel.add(button1);
		JButton button2 = new JButton("0");
		button2.setPreferredSize(new Dimension(sz, sz));
		buttonPanel.add(button2);
		JButton button3 = new JButton("P");
		button3.setPreferredSize(new Dimension(sz, sz));
		buttonPanel.add(button3);
		
		
		// bottomPanel to hold the 2 JLabels and 4 arrow buttons 
		JPanel bottomPanel = new JPanel(new GridLayout(3,2,30, 2));
		bottomPanel.setBounds(80, 330, 120, 80);
		bottomPanel.setOpaque(false);
		JLabel volLabel = new JLabel("Vol");
		//volLabel.setBounds(80, 270, 100, 100);
		JLabel chlLabel = new JLabel("Chl");
		//chlLabel.setBounds(160, 270, 100, 100);
		bottomPanel.add(volLabel);
		bottomPanel.add(chlLabel);
		
		bottomPanel.add(new BasicArrowButton(SwingConstants.NORTH));
		bottomPanel.add(new BasicArrowButton(SwingConstants.NORTH));
		bottomPanel.add(new BasicArrowButton(SwingConstants.SOUTH));
		bottomPanel.add(new BasicArrowButton(SwingConstants.SOUTH));
		
		//add(topPanel);
		add(redButton);
		add(buttonPanel);
		//add(volLabel);
		//add(chlLabel);
		add(bottomPanel);
		
		//pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AllisonRemoteControl();
	}

}