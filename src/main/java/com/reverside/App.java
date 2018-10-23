package com.reverside;

import java.io.IOException;

public class App 
{
	  
public static void main( String[] args ) throws IOException
{ 
	 
	String filename = args[0].toLowerCase();
	int id = Integer.parseInt(args[1]);

	String output = "";
	String output1 = "";
	
	ReadFile readFile = new ReadFile();
	String processName= readFile.processFilename(filename);
	String input=readFile.getContents(processName, id);
	
	
	//Customers 1 table
	if (filename.endsWith("capetown.txt")) {
	ProcessingCapeTownData customers1ToSql = new ProcessingCapeTownData();
	output=customers1ToSql.processingLine(input);
	output1=customers1ToSql.dataCleansing(output,id);
	}
	
	
	
	//Customers 2 table
	if (filename.endsWith("johannesburg.txt")) {
	ProcessingJoburgData customers2ToSql2 = new ProcessingJoburgData();
	output=customers2ToSql2.processingLine2(input);
	output1=customers2ToSql2.dataCleansing(output,id);
	}
	
	
	//customers 3 table
	if (filename.endsWith("pretoria.txt")) {		
	ProcessingPretoriaData customers3ToSql3 = new ProcessingPretoriaData();
	output=customers3ToSql3.processingLine2(input);
	output1=customers3ToSql3.dataCleansing(output,id);
	}
	
	WriteFile  writeToFile = new WriteFile ();
	writeToFile.writeToFile(output1, filename);
   
	 
}
}