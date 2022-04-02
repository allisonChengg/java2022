/*
 * Allison Cheng
 * AllQuestions: represents all of the Questions
 */

import java.io.*;
import java.util.*;

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
			String choice1 = fileIn.nextLine();
			String choice2 = fileIn.nextLine();
			String choice3 = fileIn.nextLine();
			String choice4 = fileIn.nextLine();
			int accAnswer = fileIn.nextInt();
			possAnswers.add(choice1);
			possAnswers.add(choice2);
			possAnswers.add(choice3);
			possAnswers.add(choice4);
			
			if (accAnswer < 0 || accAnswer > 3) {
				throw new IllegalArgumentException("Invalid answer");
			}
			
			this.add(new Question(question, possAnswers, accAnswer));
			
			// continues until reach end of file
			if (fileIn.hasNextLine()) {
				fileIn.nextLine();
			}	
		}
		shuffle();
	}
	
	// randomly picks question & moves it to end of list for a random # of times [0,50]
	public void shuffle() {
		
		int numTimes = (int)(Math.random() * 50);
		
		// goes through array and takes question & puts it to back of ArrayList
		for(int i = 0; i < numTimes; i++) {
			int toMove = (int)(Math.random() * this.size());
			Question moveIt = this.remove(toMove);
			this.add(moveIt);
		}
	}
	
}