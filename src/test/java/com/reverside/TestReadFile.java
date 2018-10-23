package com.reverside;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class TestReadFile {
	
@Test
public void testReadFile() {
	
final String filename="sample_capetown.txt";
final int id = 400;
String expected="Manmay Mohanty, M, 07/03/1983, Y\r\n" + 
		"Marike Fourie, F, 30/11/2001, N\r\n";
ReadFile readFile = new ReadFile();
String processName= readFile.processFilename(filename);
String input=readFile.getContents(processName, id);
assertEquals(input,expected);
}

@Ignore
@Test
public void testReadfile() {
	
final String filename="sample_capetown.txt";
final int id = 400;
String expected="Manmay Mohanty, M, 07/03/1983,Reverside,Y\r\n" + 
		"Marike Fourie, F, 30/11/2001, Reverside,N\r\n";
ReadFile readFile = new ReadFile();
String processName= readFile.processFilename(filename);
String input=readFile.getContents(processName, id);
assertEquals(input,expected);
}

}
