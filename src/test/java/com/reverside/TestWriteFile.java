package com.reverside;

import static org.junit.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

public class TestWriteFile {
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
	private String output1=processingCapeTownData.processingLine(input);
	
	
@Test
public void testWriteToFileP() throws IOException
{   final String output2=processingCapeTownData.dataCleansing(output1,id);
	final String sqlFilename= filename.substring(0,filename.length()-3);
	final FileWriter output = new FileWriter(sqlFilename+("sql"));
	output.write(output2);
	output.close(); 
	assertEquals(output2,processeDataP);
}

@Ignore
@Test
public void testWriteToFileN() throws IOException {
	final String output2=processingCapeTownData.dataCleansing(output1,id);
	final String sqlFilename= filename.substring(0,filename.length()-3);
	final FileWriter output = new FileWriter(sqlFilename+("sql"));
	output.write(output2);
	output.close(); 
	assertEquals(output2,processeDataN);
}
}
