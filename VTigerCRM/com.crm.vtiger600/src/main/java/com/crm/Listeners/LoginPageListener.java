package com.crm.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginPageListener implements ITestListener {
	public static ExtentSparkReporter spark; 
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		report.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
	}
	@Override
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter("./ExtentReport/LoginPageReport.html");
		spark.config().setDocumentTitle("Functinoal Testing");
		spark.config().setReportName("Saurabh");
		spark.config().setTheme(Theme.STANDARD);
		report = new ExtentReports();
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("browser", "chrome 101");
		report.attachReporter(spark);
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	} 
	
	
}
