package com.crm.baseclass;

import java.time.Duration;
import static com.crm.utility.PropertiesFile.property;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class VtigerBaseClass {
	
	protected WebDriver driver ; 
	
	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(property("url"));
	}
	
	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
