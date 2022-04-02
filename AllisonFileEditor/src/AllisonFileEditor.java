import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Allison Cheng 
 * File Editor: gives users options to edit file
 */

public class AllisonFileEditor {
	
	public static void main(String[] args) {
		String fname = null;
		String[] fileContent = null;
		String[] prevContent = null;
		String word = "";
		Scanner keyboard = new Scanner(System.in);
		
		int userChoice = getChoice();
		
		// continues until user wants to exit
		do {
			System.out.println(userChoice);
			
			if (userChoice == 1) {
				System.out.println("Filename: ");
				fname = keyboard.nextLine();
				fileContent = loadFile(fname);
			}
			else if (userChoice == 2) {
				displayFile(fileContent);
			}
			else if (userChoice == 3) {
				saveFile(fname, fileContent);
			}
			else if (userChoice == 4) {
				System.out.println("Word: ");
				word = keyboard.nextLine();
				findWord(fileContent, word);
			}
			else if (userChoice == 5) {
				System.out.println("Word: ");
				word = keyboard.nextLine();
				highlightAllLines(fileContent, word);
			}
			else if (userChoice == 6) {
				fileContent = undoLastChange(prevContent);
			}
			else {
				System.out.println("This choice isn't supported.");
			}
			
			// saves copy 
			prevContent = new String[fileContent.length];
			prevContent = copyFile(fileContent);
			
			userChoice = getChoice();
		} while(userChoice != 7);	
	}
	
	// gets user's choice
	public static int getChoice() {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("1) Load File");
		System.out.println("2) Display File");
		System.out.println("3) Save File");
		System.out.println("4) Find Word");
		System.out.println("5) Highlight Word");
		System.out.println("6) Undo Last Change");
		System.out.println("7) Exit");
		
		System.out.println("Choice: ");
		int choice = keyboard.nextInt();
		
		return choice;
	}
	
	// builds & returns an array representing all of the lines in file fname, returns array of size 0 if file not found
	public static String[] loadFile(String fname) {
		
		Scanner fileIn = null;
		int numOfLines = 0;
		
		String[] fileArray = null;
		try {
			fileIn = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(-1);
		}
		
		//get the number of lines
		while(fileIn.hasNextLine()) {
			numOfLines++;
			fileIn.nextLine();
		}
		
		fileArray = new String[numOfLines];
		fileIn.close();
		
		try {
			fileIn = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(-1);
		}
		
		int lineLoc = 0;
		while(fileIn.hasNextLine()) {
			fileArray[lineLoc] = fileIn.nextLine();
			lineLoc++;
		}
		
		return fileArray;
	}
	
	// prints all lines in file out to screen
	public static void displayFile(String[] lines) {
		
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
	}
	
	// writes all lines back to file represented by fname
	public static void saveFile(String fname, String[] lines) {
		
		Scanner keyboard = new Scanner(System.in);
		
		try {
			FileWriter outFile = new FileWriter(fname);
			
			for (int i = 0; i < lines.length; i++) {
				outFile.write(lines[i] + "\r\n");
			}
			outFile.close();
			
		} catch (IOException e) {
			System.out.println("IO Issue");
			System.exit(-1);
		}
	}
	
	// prints out all lines that contain word + line number left of line
	public static void findWord(String[] lines, String word) {
		
		for (int i = 0; i < lines.length; i++) {
			String[] words = lines[i].split(" ");
			
			for (int j = 0; j < words.length; j++) {
				if (words[j].equals(word)) {
					System.out.println((i+ 1) + " " + lines[i]);
				}
			}
		}
	}
	
	// capitalizes all occurrences of word in line
	public static String highlightLine(String line, String word) {
		
		String result = "";
		while (line.indexOf(word) >= 0) {
			int indexFound = line.indexOf(word);
			result += line.substring(0, indexFound) + line.substring(indexFound, indexFound + word.length()).toUpperCase();
			line = line.substring(indexFound + word.length());
		}
		// add back anything that didn't match
		result += line;
		
		return result;
	}
	
	// highlights all the words in entire array of lines
	public static void highlightAllLines(String[] lines, String word) {
		
		for (int i = 0; i < lines.length; i++) {
			System.out.println(highlightLine(lines[i], word));
		}
	}
	
	// returns completely new array containing exact same content as lines
	public static String[] copyFile(String[] lines) {
		
		String[] newFileContent = new String[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			newFileContent[i] = lines[i]; 
		}
		return newFileContent;
	}
	
	// undoes previous file edit
	public static String[] undoLastChange(String[] prevContent) {
		
		String[] fileContent = new String[prevContent.length];
		for (int i = 0; i < fileContent.length; i++) {
			fileContent[i] = prevContent[i];
		}
		return fileContent;
	}
	
}