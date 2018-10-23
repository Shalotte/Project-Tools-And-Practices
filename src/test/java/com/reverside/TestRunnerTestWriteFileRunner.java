package com.reverside;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerTestWriteFileRunner {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(TestWriteFile.class);
		
		for(Failure failure: result.getFailures()){
			System.out.print(failure.toString());
		}
		if(result.wasSuccessful()) {
		System.out.println("All the tests finished succesfully...!");
	}
	}

}
