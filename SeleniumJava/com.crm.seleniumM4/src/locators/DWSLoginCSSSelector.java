package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DWSLoginCSSSelector {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String dwsURL = "https://demowebshop.tricentis.com/";
		driver.get(dwsURL);
		
		if(dwsURL.equals(driver.getCurrentUrl())) {
			System.out.println("I in DWS page");
			Thread.sleep(3000);
			
			// locate and click on login 
			driver.findElement(By.linkText("Log in")).click();
			
			String loginURL = "https://demowebshop.tricentis.com/login";
			
			if(driver.getCurrentUrl().equals(loginURL)) {
				System.out.println(" ON login page");
				// fill the login details 
				fillLoginPage(driver);				
				Thread.sleep(3000);
				
				// find and click on login button using CSSSelector
				driver.findElement(By.cssSelector("input[value='Log in']")).click();
				Thread.sleep(5000);
				driver.close();
				
				
			} else {
				System.out.println("Login page not openeed");
			}
			
		} else {
			System.out.println("CHeck URL and try again");
			driver.close();
		}
		
		
	}
	
	public static void fillLoginPage(ChromeDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		
		// Fill login details. 
		driver.findElement(By.id("Email")).sendKeys("FakeLogin@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("FakePass");
		driver.findElement(By.id("RememberMe")).click();
			
	}

}
