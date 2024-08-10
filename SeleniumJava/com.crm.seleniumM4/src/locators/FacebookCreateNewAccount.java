package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Create a new account on facebook using selenium 

public class FacebookCreateNewAccount {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		String fbURL = "https://www.facebook.com/";
		driver.get(fbURL);
		
		// verification and continue 
		if(driver.getCurrentUrl().equals(fbURL)) {
			System.out.println("Fabook Opened");
			Thread.sleep(5000);
			
			// locating the new account button 
			
			

			
			
		}
		else {
			System.out.println("Change your URL");
			
		}
		Thread.sleep(5000);
		driver.close();

	}

}
