package com.automation.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer{

	private	int count=0;
	public static final	int max=2;
		
	@Override
	public boolean retry(ITestResult result) {
		
	
		if(count<max) {
			count++;
			return true;
		}
	
		return false;
	}

}
