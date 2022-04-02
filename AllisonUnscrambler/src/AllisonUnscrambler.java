/*
 * Allison Cheng
 * AllisonUnscrambler: game that shows user a series of letters
 * that they use to form words in English
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AllisonUnscrambler extends JFrame implements ActionListener {

	private JTextField textField;
	private JLabel scrambledWord;	
	private JTextArea correctGuesses;
	private ArrayList<String> wordList;
	private JLabel guessesLeft;
	private int numOfGuesses = 10;
	
	public AllisonUnscrambler() {
		
		Scanner fileIn = null;
		wordList = new ArrayList<String>();
		
		// adds lists of words from file to ArrayList
		String word = "";
		String filename = "twist.txt";
		try {
			fileIn = new Scanner(new File(filename));
			word = fileIn.nextLine();
			
			while(fileIn.hasNextLine()) {
				wordList.add(fileIn.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			System.exit(-1);
		}
		
		setLayout(new FlowLayout());
		setSize(275, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add scrambledWord
		scrambledWord = new JLabel();
		scrambledWord.setFont(new Font("Comic Sans", Font.PLAIN,18));
		scrambledWord.setText(word);
		add(scrambledWord);
		
		// set textField
		textField = new JTextField(20);
		textField.addActionListener(this);
		textField.setText("Type Here");
		add(textField);  
		
		// makes JTextArea of correct guesses
		correctGuesses = new JTextArea(23, 20);
		add(correctGuesses);
		
		// makes guesses left label
		guessesLeft = new JLabel();
		guessesLeft.setText("Guesses Left: " + numOfGuesses);
		add(guessesLeft);
		
		setVisible(true);
	}
	
	// handles all guesses from user
	public void actionPerformed(ActionEvent ae) {
		
		// gets text from textField & resets textField to blank
		String theGuess = textField.getText();
		textField.setText("");
		
		// if guessed word is 3+ letters & a text file word, add word to correct guesses
		if (theGuess.length() >= 3) {
			for (int i = 0; i < wordList.size(); i++) {
				if (theGuess.equals(wordList.get(i))) {
					correctGuesses.append(theGuess + "\n");
					
					// check if all words have been guessed
					if (wordList.size() == correctGuesses.getText().split("\\n").length) {
						textField.setEnabled(false);
						guessesLeft.setText("You won!");
					}
					return;
				}
			}
		}
		numOfGuesses--;
		guessesLeft.setText("Guesses Left: " + numOfGuesses);
		
		// if user ran out of guesses, disable textField
		if (numOfGuesses <= 0) {
			textField.setEnabled(false);
		}
	}
	
	public static void main(String[] args){
		AllisonUnscrambler d = new AllisonUnscrambler();
	}
}