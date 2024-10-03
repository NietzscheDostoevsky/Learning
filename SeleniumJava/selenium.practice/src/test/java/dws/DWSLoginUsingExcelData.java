package dws;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DWSLoginUsingExcelData {
	
	@Test
	public void BrowserTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.quit();
	}
	
	@Test
	public void DWSLoginPage() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/login");
	}
	
}
