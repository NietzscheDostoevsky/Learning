package testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilityClasses.BaseClass;

public class ReadMultipleDataFromXML extends BaseClass {
	
	@Parameters({"url", "password", "login"})
	@Test(threadPoolSize = 4, invocationCount = 4)
	public void login(String url, String password, String login)  {
		
		useChrome();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		driver.findElement(By.className("ico-login")).click();
//		driver.findElement(By.id("Email")).sendKeys(login);
//		driver.findElement(By.id("Password")).sendKeys(password);
//		driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
		
		driver.quit();
		
	}
}
