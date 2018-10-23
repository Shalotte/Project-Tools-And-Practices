package com.reverside;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public  class ReadFile{	   
	
public String processFilename(String filename) {
	
	if(filename.endsWith("pretoria.txt") ==false && filename.endsWith("capetown.txt")==false && filename.endsWith("johannesburg.txt")==false) {
	System.out.printf("File name is not as expected or branch name not found.");
	return null; 
	}

	else { 
	final String sqlFilename= filename.substring(0,filename.length()-3);
	System.out.print(sqlFilename+("sql")+"\n");
	return filename;
	}
	
}
	
public String getContents(String filename, int id) {
      
	StringBuilder contents = new StringBuilder();
	try {
	BufferedReader input =  new BufferedReader(new FileReader(filename));
	
	try {
	String line = null; 
	
	while (( line = input.readLine()) != null){
	              
	contents.append(line);
	contents.append(System.getProperty("line.separator"));
	            
	}
	}
	finally {
	input.close();
	}
	}
	catch (FileNotFoundException e) {
	System.out.println("The file could not be found!");
	}
	catch (IOException ex){
	ex.printStackTrace();
	} 
	        
	return contents.toString();
	     
	
}
}