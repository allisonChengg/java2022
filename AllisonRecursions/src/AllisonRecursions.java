import java.io.*;
import java.util.*;

public class AllisonRecursions {
	
	public static void main(String[] args) {
		System.out.println(series(2));
		
		System.out.println(numUpper("cAtwALK", 7));
		
		System.out.println(intToBinary(0));
		System.out.println(intToBinary(1));
		System.out.println(intToBinary(1000));

		System.out.println(removeDuplicates("ABBCDDDEEFFGG"));
		
		// findFiles(new File("/Users/school/eclipse-workspace/testFolder"), "swap");
	}
	
	public static double series(int n) {
		if (n <= 0) {
			return 0;
		}
		return (double) n / (2 * n + 1) + series(n - 1);
	}
	
	public static int numUpper(String sentence, int length) {
		
		if (length == 0) {
			return 0;
		}
		
		String firstChar = sentence.substring(0,1);
		
		if (firstChar.equals(firstChar.toUpperCase())) {
			return 1 + numUpper(sentence.substring(1), length - 1);
		}
			
		return numUpper(sentence.substring(1), length - 1);
	}
	
	public static String intToBinary(int n) {
		
		if (n == 0) {
			return "0";
		}
		if (n == 1) {
			return "1";
		}
		int remainder = n % 2;
		int quotient = n / 2;
		
		return intToBinary(quotient) + remainder;
	}
	
	public static String removeDuplicates(String sentence) {
		
		// return single character or empty string as base case
		if (sentence.length() < 2) {
			return sentence;
		}
		
		if (sentence.substring(0,1).equals(sentence.substring(1, 2))) {
			return removeDuplicates(sentence.substring(1));
		}
		
		return sentence.substring(0, 1) + removeDuplicates(sentence.substring(1));
	}
	
	public static void findFiles(File fname, String word) {
				
		File[] dirContents = fname.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			
			// if it's a directory, recurse into it
			if (dirContents[i].isDirectory()) {
				findFiles(dirContents[i], word);
			}
			else {
				Scanner fileIn = null;
				
				try {
					fileIn = new Scanner(dirContents[i]);
				} catch(FileNotFoundException e) {
					System.out.println("Not found");
					System.exit(-1);
				}
				while(fileIn.hasNextLine()) {
					String line = fileIn.nextLine();
					
					String[] words = line.split(" ");
					for(int j=0; j< words.length; j++) {
						if (words[j].equals(word)) {
							System.out.println("found: " + dirContents[i].getName());
							return;
						}
					}
				}
			}
		}
	}

}