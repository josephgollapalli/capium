package com.capium.automation.listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.capium.automation.base.SeleniumReusablies;

public class FailedScreenshot implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated catch block
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getName();
			try {
				SeleniumReusablies.takeScreenshot(methodName);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == result.SKIP) {
			String methodName = result.getName();
			try {
				SeleniumReusablies.takeScreenshot(methodName);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
