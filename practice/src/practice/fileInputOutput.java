package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileInputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("File: ");
		String filename = keyboard.nextLine();
		
		int pos = filename.indexOf(".");
		String newFileName = filename.substring(0, pos) + "_no_comments" + filename.substring(pos);
		
		//System.out.println("Filename: " + newFileName);
		//System.out.println("Working Directory: " + System.getProperty("user.dir"));
		
		Scanner fileIn = null;
		
		try {
			
			fileIn = new Scanner(new File(filename));
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Not found");
			System.exit(-1);
		}
		
		try {
			
			FileWriter outFile = new FileWriter(newFileName);
			
			while (fileIn.hasNextLine()) {
	
				String line = fileIn.nextLine();
				
				int posComment = line.indexOf("//");
				if (posComment >= 0) {
					outFile.write(line.substring(0, posComment) + "\r\n");
				}
				// comment start at beginning, no need to process
				else if (posComment == 0) {
					;
				}
				else {
					outFile.write(line + "\r\n");
				}
			}
			outFile.close();
			
		} catch (IOException e) {
			
			System.out.println("IO Issue");
			System.exit(-1);
		}
		
		
	}

}
