import java.util.*;

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