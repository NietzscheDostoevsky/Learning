package com.crm.Listeners;

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
import com.crm.baseclass.VtigerOpenLoginPageBaseClass;

public class LoginPageListener implements ITestListener {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		System.out.println("Test passed");
		test.log(Status.PASS, "assertion is passed");
		test.log(Status.INFO, name + "is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		WebDriver driver = ((VtigerOpenLoginPageBaseClass) result.getInstance()).getDriver();

		test.log(Status.FAIL, "assertion is failed");
		test.log(Status.INFO, name + " is failed");

		TakesScreenshot tScreenshot = (TakesScreenshot) driver;
		String from = tScreenshot.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, "assertion is skipped");
		test.log(Status.INFO, name + " is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter("./ExtentReport/LoginPageReport.html");
		spark.config().setDocumentTitle("Functinoal Testing");
		spark.config().setReportName("Saurabh");
		spark.config().setTheme(Theme.DARK);
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
