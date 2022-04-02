import java.io.*;
import java.util.*;

/*
 * AnagramFinder: uses String Frequency to print out all matching anagrams found in text file
 */

public class AnagramFinder {
	
	private StringFrequency[] stringFreq;
	
	public AnagramFinder() {
			
		Scanner fileIn = null;
		int numOfLines = 0;
		
		try {
			fileIn = new Scanner(new File("words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(-1);
		}
		
		// find how many lines in file in order to figure out array size
		while(fileIn.hasNextLine()) {
			numOfLines++;
			fileIn.nextLine();
		}
		
		fileIn.close();
		
		try {
			fileIn = new Scanner(new File("words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(-1);
		}
		
		stringFreq = new StringFrequency[numOfLines];
		
		int index = 0;
		while(fileIn.hasNextLine()) {
			String sentence = fileIn.nextLine();
			stringFreq[index] = new StringFrequency(sentence);
			index++;
		}
			
	}
	
	public void printAnagrams(String startingWord) {
		
		StringFrequency word = new StringFrequency(startingWord);
		for (int i = 0; i < stringFreq.length; i++) {
			if (stringFreq[i].hasSameFreq(word)) {
				System.out.println(stringFreq[i]);
			}
		}
	}
	
}