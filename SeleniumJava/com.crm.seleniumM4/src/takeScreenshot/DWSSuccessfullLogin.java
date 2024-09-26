package takeScreenshot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utilityClasses.BaseClassDWS;

public class DWSSuccessfullLogin extends BaseClassDWS {

	public static void main(String[] args) {
		useChrome();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("positivetestcase@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("positive");
		driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
		try {
			if (driver.findElement(By.className("ico-logout")).getText().equals("Log out"))
				System.out.println("Loging successfull");
		} catch (Exception e) {
			System.out.println("login failed: Bug");
		}
		driver.quit();
	}

}
