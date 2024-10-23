package com.crm.baseclass;

import static com.crm.utility.PropertiesFile.property;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.POM.LoginPage;

public class VtigerOpenLoginPage {
	public static WebDriver driver;
	public static WebDriver driver2; 
	public static LoginPage ref ; 

	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver();
		driver2 = driver; 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property("url"));
		ref = new LoginPage(driver); 
	}

	@BeforeMethod
	public void verifyLoginPage() {
		System.out.println("Current URL : " + driver.getCurrentUrl());
	}


	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
