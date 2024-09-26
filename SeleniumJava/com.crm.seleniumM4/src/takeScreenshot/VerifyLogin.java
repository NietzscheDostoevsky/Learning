package takeScreenshot;

//Positive testing 
//Checking the correct details log in or not. 

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utilityClasses.BaseClassDWS;

public class VerifyLogin extends BaseClassDWS {
	public static void main(String[] args) {
		useChrome();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("haha@hehe.com");
		driver.findElement(By.id("Password")).sendKeys("password");
		driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
		
		try {
			if (driver.findElement(By.className("validation-summary-errors")).isDisplayed())
				System.out.println("login unsuccessful, login denied");
			
		} catch (Exception e) {
			System.out.println("Bug");
		}
		driver.quit();
	}
}
