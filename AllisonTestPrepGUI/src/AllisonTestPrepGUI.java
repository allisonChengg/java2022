/*
 * Allison Cheng
 * Test Prep: helps prepare students for a given test
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class AllisonTestPrepGUI extends JFrame implements ActionListener {
	
	public static final String DEFAULT_INPUT_FILE = "questions.txt";
	public static final int gridWidth = 650;
	public static final int gridHeight = 800;
	private JLabel questionLabel;
	private JTextArea qArea;
	private JList answerChoices;
	private JButton submitButton;
	private JLabel percentageLabel;
	private AllQuestions allQuestions;
	private BufferedImage image;
	private int currQuestionIndex = 0;
	private int totalCorrect = 0;
	
	public AllisonTestPrepGUI(String inFile) {
		
		setSize(gridWidth, gridHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JPanelImageBg("questionpic.jpeg"));
		setLayout(null);
		setTitle("AP Prep");
		
		// question Panel
		questionLabel = new JLabel();
		questionLabel.setBounds(120, 50, 400, 50);
		questionLabel.setHorizontalAlignment(JLabel.CENTER);
		questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		questionLabel.setOpaque(false);
		
		// JTextArea for question
		qArea = new JTextArea();
		qArea.setBounds(120, 125, 400, 200);
		qArea.setEditable(false);
		qArea.setLineWrap(true);
		qArea.setWrapStyleWord(true);
		qArea.setOpaque(true);
		qArea.setBorder(BorderFactory.createTitledBorder("Question"));
		
		//Answer choices JList
		answerChoices = new JList();
		answerChoices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allQuestions = new AllQuestions(inFile);
		
		answerChoices.setBorder(BorderFactory.createTitledBorder("Answer"));
		JScrollPane scrollPane = new JScrollPane(answerChoices);
		scrollPane.setBounds(120, 375, 400, 200);
		
		// JButton for submitting
		submitButton = new JButton("Submit");
		submitButton.setOpaque(false);
		submitButton.setBounds(250, 590, 125, 50);
		submitButton.addActionListener(this);
		
		// percentagePanel
		percentageLabel = new JLabel();
		percentageLabel.setBounds(120, 675, 400, 50);
		percentageLabel.setHorizontalAlignment(JLabel.CENTER);
		percentageLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		percentageLabel.setOpaque(false);
		
		displayInfo();
		
		add(questionLabel);
		add(qArea);
		add(scrollPane);
		add(submitButton);
		add(percentageLabel);
		setVisible(true);
	}
	
	// displays current question number index & correct percentage information
	public void displayInfo() {
		
		// once reach end of questions, components don't need to be updated
		if (currQuestionIndex < allQuestions.size()) {
			
			// show top panel - what question it is
			int currIndexForDisplay = currQuestionIndex + 1;
			String qLMessage = "Question " + currIndexForDisplay + " of " + allQuestions.size();
			questionLabel.setText(qLMessage);
			
			// qArea - show question
			qArea.setText(allQuestions.get(currQuestionIndex).actualQuestion);
			// show answer choices
			answerChoices.setListData(allQuestions.get(currQuestionIndex).possibleAnswers.toArray());
		}
		
		// show current stats -  display percentage correct based on running total
		double percent = 0.0;
		if (currQuestionIndex > 0) {
			percent = (double) (totalCorrect * 100.0) / currQuestionIndex;
		}
		
		String pLMessage = "Percentage Correct: " + percent;
		percentageLabel.setText(pLMessage);
	}
	
	// updates information of JLabels
	public void updateInfo() {
		
		// get selected index
		int userChoice = answerChoices.getSelectedIndex();
		
		// check & display answer
		String message = "Incorrect";
		if (userChoice == allQuestions.get(currQuestionIndex).correctAnswer) {
			message = "Correct";
			totalCorrect++;
		}
		JOptionPane.showMessageDialog(null, message);
		
		// check if at end of the questions
		if (currQuestionIndex + 1 == allQuestions.size()) {
			submitButton.setEnabled(false);
		}
		currQuestionIndex++;
	}
	
	// calls update & display info functions every time submit button pressed
	public void actionPerformed(ActionEvent e) {
		updateInfo();
		displayInfo();
	}

	// arrayList of Question Objects 
	public class AllQuestions extends ArrayList<Question> {
		
		public AllQuestions(String fileName) {
			
			Scanner fileIn = null;
			try {
				fileIn = new Scanner(new File(fileName));
			} catch(FileNotFoundException e) {
				System.out.println("Not found");
				System.exit(-1);
			}
			
			while(fileIn.hasNextLine()) {
				
				ArrayList<String> possAnswers = new ArrayList<String>();
				
				String question = fileIn.nextLine();
				
				int numChoices = 4;
				for (int i = 0; i < numChoices; i++) {
					possAnswers.add(fileIn.nextLine());
				}
				int accAnswer = fileIn.nextInt();
				
				
				if (accAnswer < 0 || accAnswer > 3) {
					throw new IllegalArgumentException("Invalid answer");
				}
				
				this.add(new Question(question, possAnswers, accAnswer));
				
				// continues until reach end of file
				fileIn.nextLine();
			}
			shuffle();
		}
		
		// randomly picks question & moves it to end of list for a random # of times [0,50]
		public void shuffle() {
			
			int numTimes = (int)(Math.random() * 51);
			
			// goes through array and takes question & puts it to back of ArrayList
			for(int i = 0; i < numTimes; i++) {
				int toMove = (int)(Math.random() * this.size());
				Question moveIt = this.remove(toMove);
				this.add(moveIt);
			}
		}
		
	}
	
	// Object of the actual question, possibleAnswers, & the correct answer
	public class Question {
		
		private String actualQuestion;
		private ArrayList<String> possibleAnswers;
		private int correctAnswer;  //[0,3]
			
		public Question(String actual, ArrayList<String> possible, int correct) {
			actualQuestion = actual;
			possibleAnswers = possible;
			correctAnswer = correct;
			//shuffle();
		}
			
		private void shuffle() {
				
			int numTimes = (int)(Math.random() * 50);
				
			for(int i = 0; i < numTimes; i++) {
				int toMove = (int)(Math.random() * 3);
					
				//randomly move one of the first 3 elements to the end
				String moveIt = possibleAnswers.remove(toMove);
				possibleAnswers.add(moveIt);
					
				//correctAnswer IV needs to move along with the possibleAnswer
				if(toMove == correctAnswer)
					correctAnswer = 3;
				else if(toMove < correctAnswer)
					correctAnswer--;

			}
				
		}
			
		public boolean isCorrect(int guess) {
			
			return guess == correctAnswer;
		}
		
		public String toString() {
			String s = actualQuestion + "\n";
			for (int i = 0; i < possibleAnswers.size(); i++) {
				s += possibleAnswers.get(i) + "\n";
			}
			s += correctAnswer;
			
			return s;
		}
	}
	
	// JPanel that has image as the background
	class JPanelImageBg extends JPanel {
		
		private Image bgImage;
		public JPanelImageBg(String imageFile) {
			try {
				bgImage = ImageIO.read(new File(imageFile));
				setLayout(new BorderLayout());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// this will draw the image
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, gridWidth, gridHeight, null);
		}
	}
	
	public static void main(String[] args) {
		
		String inFile = DEFAULT_INPUT_FILE;
		if (args.length > 0) {
			inFile = args[0];
		}
		new AllisonTestPrepGUI(inFile);
	}

}