import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter word: ");
		String word = keyboard.nextLine();
		
		AnagramFinder anagram = new AnagramFinder();
		anagram.printAnagrams(word);
		
	}
	
}
	
