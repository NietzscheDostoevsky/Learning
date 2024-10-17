package com.crm.baseclass;

import static com.crm.utility.PropertiesFile.property;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class VtigerBaseClass {
	
	protected WebDriver driver ; 
	
	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property("url"));
	}
	
	@BeforeMethod
	public void login() {
		driver.findElement(By.name("user_name")).sendKeys(property("username"));
		driver.findElement(By.name("user_password")).sendKeys(property("password"));
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void logout()  {
		driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
	}
	
	@AfterClass
	public void postCondition() {
		driver.quit();
	}

}
