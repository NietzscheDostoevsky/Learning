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

import com.crm.POM.Login;

public class VtigerLogin {

	protected WebDriver driver;

	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property("url"));
	}

	@BeforeMethod
	public void login() {
		Login ref = new Login(driver);
		ref.loginTextfield.sendKeys(property("username"));
		ref.passwordTextfield.sendKeys(property("password"));
		ref.loginButton.click();
	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
	}

	@AfterClass
	public void postCondition() {
		driver.quit();
	}

}
