package com.reverside;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProcessingPretoriaData  {
	
	public String processingLine2(String lines){
		Scanner scanner1 = new Scanner(lines);
		final StringBuffer stringBuffer1 = new StringBuffer();
		String lines101 = "";  
		String lines1 = "";
 
		while (scanner1.hasNextLine()) {
		 lines101 = scanner1.nextLine();  

		if(lines101.contains("#") || Pattern.matches("name:\\s\\D*", lines101)==true||Pattern.matches("surname:\\s\\D*", lines101)==true || Pattern.matches("dob:\\s\\d{0,2}\\s\\D{0,3}\\s\\d{0,4}", lines101)==true  ||
		lines101.contains("married: yes")	||lines101.contains("married: no")||lines101.contains("gender: male")||lines101.contains("gender: female")){
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
	
public  String dataCleansing (String theContents, int id) throws FileNotFoundException {
	

		 
		  final StringBuffer stringBuffer = new StringBuffer();
          Scanner scanner = new Scanner(theContents);
          final StringBuffer stringBuffer2= new StringBuffer();
          String temp="";
			
	
		  List<String> list = new ArrayList<String>();
		  
		  while (scanner.hasNextLine()) {
	
		  String line = scanner.nextLine();	
		  list.add(line+",");
		  String sublist = list.get(list.size()-1);
		  stringBuffer2.append(sublist);	   	 
		  }
			 
		  String lines =stringBuffer2.toString();
		  lines = lines.substring(2,lines.length()-3);
					
		  String[] linesArray = lines.split("#");
		
		  for(int i=0; i<linesArray.length;i++) {
				
		  String[] splittedArray = linesArray[i].split(",");
		 
		  List<String> list1 = new ArrayList<String>();
		  Collections.addAll(list1,splittedArray);
		  list1.remove("");
		  splittedArray = list1.toArray(new String[list1.size()]);
		  		  
	      temp= splittedArray[2];
		  splittedArray[2]= splittedArray[4];
		  splittedArray[4]= splittedArray[3];
		  splittedArray[3]= temp;
		    
		  for(int y=0; y<splittedArray.length;y++) {splittedArray[y]=splittedArray[y].substring(splittedArray[y].indexOf(":")+1, splittedArray[y].length());}
				
		  splittedArray[3]= splittedArray[3].replaceAll("\\s* \\s*", "-");
		  splittedArray[3]= splittedArray[3].substring(1);
				
		  String initDate = splittedArray[3];
		  TemporalAccessor temporal = DateTimeFormatter.ofPattern("dd-MMM-yyyy").parse(initDate); 
		  splittedArray[3] = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(temporal);
		
		  for(int x=0; x<=1; x++ ) {
		  splittedArray[x]= splittedArray[x].substring(1,2).toUpperCase() +splittedArray[x].substring(2).toLowerCase();
		  }
				
		  if(splittedArray[splittedArray.length-3].contains("female")) {
		  splittedArray[splittedArray.length-3]= "F";
		  }
		  else {splittedArray[splittedArray.length-3]="M";
		  }
		  if(splittedArray[splittedArray.length-1].contains("yes")) {
		  splittedArray[splittedArray.length-1]= "true";
		  }
		  else {splittedArray[splittedArray.length-1]="false";
		  }
		  stringBuffer.append("insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values").append("(").append(id++).append(", ");
		  for (int j = 0; j < splittedArray.length - 1; j++) {
		  stringBuffer.append('\'').append(splittedArray[j].substring(splittedArray[j].indexOf(":")+1,splittedArray[j].length())).append("', ");
		  }
		  stringBuffer.append(splittedArray[splittedArray.length - 1].substring(splittedArray[splittedArray.length - 1].indexOf(":")+1, splittedArray[splittedArray.length - 1].length())).append(")").append(";\n");
		  
		  }
			
		  String output=stringBuffer.toString();
		  System.out.print(output);
		  scanner.close();
		  return output;

}
}


