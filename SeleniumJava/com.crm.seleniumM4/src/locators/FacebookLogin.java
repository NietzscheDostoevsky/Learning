package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// login in facebook using selenium 

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		String fbURL = "https://www.facebook.com/";
		driver.get(fbURL);
		
		// verification and continue 
		if(driver.getCurrentUrl().equals(fbURL)) {
			System.out.println("Fabook Opened");
			Thread.sleep(5000);
			driver.findElement(By.id("email")).sendKeys("Saurabh");
			Thread.sleep(5000);
			WebElement password = driver.findElement(By.id("pass"));
			Thread.sleep(5000);
			password.sendKeys("fakePassword");
			Thread.sleep(5000);
			// would work by sending return key
			//password.sendKeys(Keys.RETURN);
			// won't work because id generated dynamically
			// driver.findElement(By.id("u_0_5_7K")).click();
			
			// won't work because compund classes not allowd
			//driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1")).click(); 
			
			driver.findElement(By.name("login")).click();

			
			
		}
		else {
			System.out.println("Change your URL");
			
		}
		Thread.sleep(5000);
		driver.close();

	}

}
