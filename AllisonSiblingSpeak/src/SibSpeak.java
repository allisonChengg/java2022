/*
 * Allison Cheng
 * SibSpeak: users gives secret key to change 
 * every English word into encoded Sibling Speak language
 */

import java.util.Scanner;

public class SibSpeak implements Cryptable {
	
	private String key;
	
	// convert English sentence & return sibling speak version
	public String encrypt(String text) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Secret Key: ");
		key = keyboard.nextLine();
		
		return sentToSib(text, key);
		
	}
	
	// converts SibSpeak back to English
	public String decrypt(String text) {
		return sibToEnglish(text, key);
	}
	
	// determines whether word starts with capital letter
	private boolean isCapitalized (String word) {
		
		String firstLetter = word.substring(0, 1);
		
		if (firstLetter.equals(firstLetter.toUpperCase())) {
			return true;
		}
		
		return false;
	}
	
	// capitalizes first letter of word
	private String capitalize(String word) {
		
		return word.toUpperCase().substring(0, 1) + word.substring(1);
	}
	
	// converts english word to Sibling Speak
	private String wordToSib(String word, String key) {
		
		int keyLoc = findFirst(word, key);
		String sibWord;
		
		// finds key in first letter
		if (keyLoc == 0) {
			sibWord = "bruh-" + word;
				
		}
			
		// finds key, but not in first letter
		else if (keyLoc > 0) {
			sibWord = word.substring(keyLoc) + word.substring(0, keyLoc) + "-ya";
		}
			
		// doesn't contain key
		else {
			sibWord = word + "-meh";
		}
		
		// if original word was capitalized, new word needs capitalization
		if (isCapitalized(word)) {
			return capitalize(sibWord.toLowerCase());
		}
		return sibWord;
		
	}
	
	// converts sibSpeak back to english
	private String sibToEnglish(String sib, String key) {
		String[] words = sib.split(" ");
		String english = "";
		for (int i=0; i < words.length; i++) {
			english += sibToWord(words[i], key) + " ";
		}
		return english;
	}
	
	// converts a siblng word 
	private String sibToWord(String sib, String key) {
		String[] words = sib.split("-");
		if (words[0].equals("bruh")) {
			return words[1];
		}
		
		if (words[1].equals("meh")) {
			return words[0];
		}
		
		// the remaining case, NOTE: not enough information to completely decrypt
		// ex: atc can be either: cat or tca 
		return words[0];
	}

	// converts entire sentence to Sibling Speak
	private String sentToSib(String sentence, String key) {
		
		String[] words = sentence.split(" ");
		
		String sibSentence = "";
		
		// goes through all words to create sibling speak sentence
		for (int i = 0; i < words.length; i++) {
			sibSentence += wordToSib(words[i], key) + " ";
		}
		
		return sibSentence;
	}
	
	// finds whether index of secret key letter is found
	private int findFirst(String word, String key) {
		
		// goes through each letter of word to see if exists in key
		for (int i = 0; i < word.length(); i++) {
			
			// try to find lowercase version of the key location
			int keyLoc = key.indexOf(word.substring(i, i + 1).toLowerCase());
			
			if (keyLoc >= 0) {
				return i;
			}
			
			// lowercase wasn't found, try to find with uppercase
			keyLoc = key.indexOf(word.substring(i, i + 1).toUpperCase());
			
			if (keyLoc >= 0) {
				return i;
			}
			
		}
		return -1;
	}
	
}