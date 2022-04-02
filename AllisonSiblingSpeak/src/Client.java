import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Type: ");
		
		String type = "";
		do {
			type = keyboard.nextLine();
		} while (!(type.equals("SibSpeak") || type.equals("VigenereCrypt") || type.equals("UnstoppableCrypt")));
		
		Cryptable c = null;
		if (type.equals("SibSpeak")) {
		    c = new SibSpeak();
		}
		else if (type.equals("VigenereCrypt")) {
			c = new VigenereCrypt();
		}
		else {
			c = new UnstoppableCrypt();
		}
		convert(c);
	}
	
	// encrypts sentence using user's wanted algorithm
	public static void convert(Cryptable c) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Sentence: ");
		String sentence = keyboard.nextLine();
		
		String encryptedText = c.encrypt(sentence);
		System.out.println(encryptedText);
		
		System.out.println(c.decrypt(encryptedText));
	}
}