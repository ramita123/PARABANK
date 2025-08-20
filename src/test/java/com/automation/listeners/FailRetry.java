package com.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer{

	private	int count=0;
	public static final	int max=2;
		
	@Override
	public boolean retry(ITestResult result) {

		if(count<max) {
			count++;
			 System.out.println("Retrying " + result.getName() + " attempt " + count);
			return true;
		}
	
		return false;
	}

}
