package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebshopLogin {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String demoWebshopURL = "https://demowebshop.tricentis.com/";
		driver.get(demoWebshopURL);
		
		if(driver.getCurrentUrl().equals(demoWebshopURL)) {
			
			System.out.println("Demo Web Shop Opened");
			Thread.sleep(2000);
			
			
			// go to login page. 
			driver.findElement(By.linkText("Log in")).click();
			String loginURL = "https://demowebshop.tricentis.com/login";
			
			if(driver.getCurrentUrl().equals(loginURL)) {
				System.out.println("On login page");
				Thread.sleep(3000);
				
				// Fill login details. 
				driver.findElement(By.id("Email")).sendKeys("FakeLogin");
				driver.findElement(By.id("Password")).sendKeys("FakePass");
				driver.findElement(By.id("RememberMe")).click();
				
				//Wait and click
				Thread.sleep(3000); 
				driver.findElement(By.className("login-button")).click();
				Thread.sleep(5000);				
			} else {
				System.out.println("Login page not opened");
			}
			
		} else {
			System.out.println("check URL");
			Thread.sleep(5000);
			driver.close();
		}
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
