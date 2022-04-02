package practice;

import java.io.FileWriter;

FileWriter outFile = new FileWriter(newFileName);

while (fileIn.hasNextLine()) {

	String line = fileIn.nextLine();
	
	int posComment = line.indexOf("
	if (posComment >= 0) {
		outFile.write(line.substring(0, posComment) + "\r\n");
	}
	
	else if (posComment == 0) {
		;
	}
