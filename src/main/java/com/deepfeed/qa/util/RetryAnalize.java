package com.deepfeed.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.deepfeed.qa.base.TestBase;

public class RetryAnalize extends TestBase implements IRetryAnalyzer {
	static int counter =0;
	static int retrylimit = 3;
	public  boolean retry(ITestResult result)
	{
		if(counter<retrylimit)
		
		{
			counter=counter+1;
			return true;
		}
		return false;
	}

}
