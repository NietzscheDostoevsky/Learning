package com.crm.baseclass;

import static com.crm.utility.PropertiesFile.property;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.POM.LoginPage;

public class VtigerOpenLoginPage {
	protected WebDriver driver;
	public LoginPage ref ; 

	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property("url"));
		ref = new LoginPage(driver); 
	}

	@BeforeMethod
	public void verifyLoginPage() {
		assertEquals(driver.getTitle(), "vtiger CRM 5 - Commercial Open Source CRM" );
	}


	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
