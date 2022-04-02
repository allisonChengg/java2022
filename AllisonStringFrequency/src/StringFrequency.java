/*
 * Allison Cheng
 * String Frequency: counts total number of letters in given word
 */
public class StringFrequency {
	
	public static final int ALPHABET_LENGTH = 26;
	private int[] letterFreq;
	private String word;
	
	 public StringFrequency(String w) {
		 
		 word = w.toUpperCase();
		 
		 letterFreq = new int[ALPHABET_LENGTH];
		 for (int i = 0; i < word.length(); i++) {
			 // ASCII representation starts at 65, offset by 65
			 int index = (int) word.charAt(i) - 65;
			 letterFreq[index]++;
		 }
	 }
	 
	 public StringFrequency(StringFrequency other) {
		 
		 word = other.word;
		 letterFreq = new int[ALPHABET_LENGTH];
		 for (int i = 0; i < letterFreq.length; i++) {
			 letterFreq[i] = other.letterFreq[i];
		 }
	 }
	 
	 public String getWord() {
		 return word;
	 }
	 
	 // checks to see if arrays are the same
	 public boolean hasSameFreq(StringFrequency other) {
		 
		 for (int i = 0; i < letterFreq.length; i++) {
			 if(letterFreq[i] != other.letterFreq[i]) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public String toString() {
		 String result = "Word: " + word;
		 for (int i = 0; i < letterFreq.length; i++) {
			 result += " " + letterFreq[i];
		 }
		 
		 return result;
	 }
	 
}