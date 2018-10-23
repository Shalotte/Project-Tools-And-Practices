package com.reverside;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test; 

public class TestProcessingCapeTownData {
	
	private String processeDataP = "insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values(400, 'Manmay', 'Mohanty', 'M', '07/03/1983', true);\n" + 
			"insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values(401, 'Marike', 'Fourie', 'F', '30/11/2001', false);"+"\n";
	private String processeDataN="(id, first_name, last_name, gender, date_of_birth, marital_status) values(400, 'Manmay', 'Mohanty', 'M', '07/03/1983', true);\r\n" + 
			"(id, first_name, last_name, gender, date_of_birth, marital_status) values(401, 'Marike', 'Fourie', 'F', '30/11/2001', false);";
	private String filename ="sample_capetown.txt";
	private int id = 400;
	private ReadFile readFile = new ReadFile();
	private String processName= readFile.processFilename(filename);
	private String input=readFile.getContents(processName, id);
	private ProcessingCapeTownData processingCapeTownData = new ProcessingCapeTownData();
	private String output=processingCapeTownData.processingLine(input);

	
	
@Test
public void testDataCleansingP() throws FileNotFoundException {
	final String output1=processingCapeTownData.dataCleansing(output,id);
	assertEquals(output1,processeDataP);	
}

@Ignore
@Test
public void testDataCleansingN() throws FileNotFoundException {
	final String output1=processingCapeTownData.dataCleansing(output,id);
	assertTrue(output1.equals(processeDataN));	
}

}
