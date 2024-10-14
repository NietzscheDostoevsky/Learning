package com.dws.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.dws.fileutility.PropertiesFile;

public class BaseClass {

	protected WebDriver driver;

	@BeforeClass
	public void preCondition() {
	if(PropertiesFile.property("browser").contains("chrome")) {
		driver = new ChromeDriver(); 
		
	} else if (PropertiesFile.property("browser").contains("firefox")) {
		driver = new FirefoxDriver();
	}  else if (PropertiesFile.property("browser").contains("edge")) {
		driver = new EdgeDriver();
	} 
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	
	}
	
	@BeforeMethod
	public void login() {
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("admin01");
		driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.className("ico-logout")).click();
	}

	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
