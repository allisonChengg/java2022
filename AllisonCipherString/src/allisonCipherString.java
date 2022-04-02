import java.util.Scanner;

public class allisonCipherString {
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a lowercase word: ");
		String word = keyboard.nextLine();
		
		String key = generateKey();
		
		System.out.println(encrypt(word, key));
		
		
	}
	
	public static String generateKey() {
		
		String key = "";
		
		while (key.length() < ALPHABET.length()) {
			
			int randIndex = (int)(Math.random() * ALPHABET.length());
			
			String randChar = ALPHABET.substring(randIndex, randIndex + 1);
			
			// added to key only if doesn't exist
			if (key.indexOf(randChar) < 0) {
				key += randChar;
			}
		}
		
		
		return key;
	}
	
	public static String encrypt(String word, String key) {
		System.out.println("Word:" + word);
		System.out.println("Key:" + key);
		
		String encryptedWord = "";
		for (int i = 0; i < word.length(); i++) {
			int index = key.indexOf(word.substring(i, i + 1));
			encryptedWord += ALPHABET.substring(index, index + 1);
			System.out.println("Encrypted: " + encryptedWord);
		}
		return encryptedWord;
	}
}
