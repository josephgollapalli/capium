package com.capium.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.ITestResult;


public class RetryListenerClass implements IRetryAnalyzer, ITestNGListener{
	int intCount=1;
	int maxCount=3;

	
	public boolean retry(ITestResult result) {
		if(intCount <= maxCount)
		{
		    System.out.println("Retrying ");
			intCount++;
			return true;
		}
		return false;
		
	}

}
