package com.reverside;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {

	
public void writeToFile(String line, String filename) throws IOException {
	
	final String sqlFilename= filename.substring(0,filename.length()-3);
	final FileWriter output = new FileWriter(sqlFilename+("sql"));
	output.write(line);
	output.close(); 
	
}
}