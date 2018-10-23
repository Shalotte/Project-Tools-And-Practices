package com.reverside;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;



public class ProcessingJoburgData{
	 
public String processingLine2(String lines){
	
		Scanner scanner1 = new Scanner(lines);
		final StringBuffer stringBuffer1 = new StringBuffer();
		String lines101 = "";  
		String lines1 = "";

		while (scanner1.hasNextLine()) {
		lines101 = scanner1.nextLine();  
		if(lines101.contains("|\"Married\"|") || lines101.contains("|\"Unmarried\"|") || lines101.contains("|\"Male\"") || lines101.contains("|\"Female\"")
		&& lines101.split("\\|")[0].length()==1 && lines101.split("\\|")[1].length()== 1 && lines101.split("\\|")[3].split("-").length== 3){
		

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
			
public String dataCleansing(String theContents, int id) throws IOException {

	        final StringBuffer stringBuffer = new StringBuffer();
	        Scanner scanner = new Scanner(theContents);
	     
		    while (scanner.hasNextLine()) {
		   
		    String line = scanner.nextLine(); 
			
			String[] splittedArray = line.split(" | ");
			String s="";

			for(int i=0;i<splittedArray.length;i++)
			{
			  s=s+splittedArray[i];
			}
			
			s=s.replace("|",",");
			s = s.replace("\"", "");
			String[] splittedArray2= s.split(",");
			splittedArray2[0]= splittedArray2[0].substring(0, 1).toUpperCase() + splittedArray2[0].substring(1).toLowerCase();
			splittedArray2[1]= splittedArray2[1].substring(0, 1).toUpperCase() +splittedArray2[1].substring(1).toLowerCase();
		
		    String initDate = splittedArray2[2];
		    TemporalAccessor temporal = DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(initDate); 
		    splittedArray2[2] = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(temporal);
			
		    String temp ;
		    temp = splittedArray2[2];
		    splittedArray2[2]=splittedArray2[4];
		    splittedArray2[4]=splittedArray2[3];
		    splittedArray2[3]=temp;
		     
		    splittedArray2[splittedArray2.length-1]=splittedArray2[splittedArray2.length-1].replace("Married", "true");
		    splittedArray2[splittedArray2.length-1]=splittedArray2[splittedArray2.length-1].replace("Unmarried", "false");
		     
		    splittedArray2[splittedArray2.length-3]=splittedArray2[splittedArray2.length-3].replace("Male", "M");
		    splittedArray2[splittedArray2.length-3]=splittedArray2[splittedArray2.length-3].replace("Female", "F");
		
		    stringBuffer.append("insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values").
		    append("(").append(id++).append(", ");
			
		    for (int i = 0; i < splittedArray2.length - 1; i++) {
				
		    stringBuffer.append('\'').append(splittedArray2[i]).append("', ");
				  
		    }
		    stringBuffer.append(splittedArray2[splittedArray2.length - 1]).append(")").append(";\n");
				
	     	}
		    String lines=stringBuffer.toString();
			System.out.print(lines);
			scanner.close();
			return lines;
	    
	
	   	
}
}
