package com.crm.listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.baseClass.DWSBaseClass;

public class DWSListerner implements ITestListener {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test = report.createTest(name);

	}

	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();

		test.log(Status.PASS, "assertion is passed");
		test.log(Status.INFO, name + " is passed");
	}

	
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		WebDriver d = DWSBaseClass.driver2;
		TakesScreenshot ts = (TakesScreenshot) d;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);

		test.log(Status.FAIL, "assertion is failed");
		test.log(Status.INFO, name + " is failed");

	}

	
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, "assertion is skipped");
		test.log(Status.INFO, name + " is skipped");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter("./ExtentReport/DWSExtentReport.html");
		spark.config().setDocumentTitle("Functinoal Testing");
		spark.config().setReportName("Saurabh");
		spark.config().setTheme(Theme.STANDARD);
		report = new ExtentReports();
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("browser", "chrome 101");
		report.attachReporter(spark);
	}

	
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
