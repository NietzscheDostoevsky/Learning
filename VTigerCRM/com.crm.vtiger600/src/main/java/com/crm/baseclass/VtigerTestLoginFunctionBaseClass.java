package com.crm.baseclass;

import static com.crm.utility.PropertiesFile.property;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.POM.LoginPage;

/*
 * Provides the base class to test the login functionality using different 
 * combination of username and password. 
 */

public class VtigerTestLoginFunctionBaseClass {
	protected WebDriver driver;
	public static LoginPage ref ;

	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property("url"));
		ref = new LoginPage(driver);
	}

	@BeforeMethod
	public void login() {
		System.out.println("Current URL : " + driver.getCurrentUrl());
	}

	@AfterMethod
	public void logout() {
		driver.get(property("url"));
	}

	@AfterClass
	public void postCondition() {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver; 
	}

}
