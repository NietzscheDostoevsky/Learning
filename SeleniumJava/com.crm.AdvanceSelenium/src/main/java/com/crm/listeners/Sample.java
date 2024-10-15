package com.crm.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Sample implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		Reporter.log("OntestStart", true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("OntestSuceess", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("OntestFailure", true);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("OntestSkipped", true);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		Reporter.log("OntestFailedButWithSucessPercentage", true);

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("OntestFailedWithTimeout", true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("OnStart", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("OntestFinish", true);

	}
	
	
}
