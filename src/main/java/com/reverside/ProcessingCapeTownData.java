package com.reverside;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessingCapeTownData{
	
public String processingLine(String lines){
	
	Scanner scanner1 = new Scanner(lines);
	final StringBuffer stringBuffer1 = new StringBuffer();
	String lines101 = "";  
	String lines1 = "";
 
	while (scanner1.hasNextLine()) {
	lines101 = scanner1.nextLine();  
	
	if(lines101.contains(", M,") || lines101.contains(", F,") || lines101.contains(", Y") || lines101.contains(", N")
	|| lines101.split(",")[0].length()>0 && lines101.split(",")[0].split("\\s+").length == 2 && lines101.split(",")[0].split("/").length== 3){
	
	lines1=lines101;
	stringBuffer1.append(lines1).append("\n");
		
	}
	
	else {
	System.out.print("Error:"+" "+lines101+"\n");	
	}

	}
	
	scanner1.close();
	String lines202=stringBuffer1.toString();
	return lines202;
}
	


public  String dataCleansing(String theContents, int id) throws FileNotFoundException {
		Scanner scanner = new Scanner(theContents);
	
		final StringBuffer stringBuffer = new StringBuffer();
	
		while (scanner.hasNextLine()) {
			
	    String line = scanner.nextLine();  
    	    
		String[] splittedArray = line.split(",");
	
		splittedArray[splittedArray.length-1]=splittedArray[splittedArray.length-1].replace("Y", "true");
		splittedArray[splittedArray.length-1]=splittedArray[splittedArray.length-1].replace("N", "false");
		
		splittedArray[0]= splittedArray[0].replace(" ",",");
		 
		String s="";

		for(int i=0;i<splittedArray.length;i++)
		{
		  s=s+splittedArray[i].replace(" ",",");
		}
		
		String[] columns = s.split(",");
		
		stringBuffer.append("insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values").append("(").append(id++).append(", ");
			
		for (int i = 0; i < columns.length - 1; i++) {
				
		stringBuffer.append('\'').append(columns[i]).append("', ");
				  
		}
		stringBuffer.append(columns[columns.length - 1]).append(");").append("\n");
				
		} 
		
		
		String lines=stringBuffer.toString();
		System.out.print(lines);
		scanner.close();
		
		return lines;
}

}
