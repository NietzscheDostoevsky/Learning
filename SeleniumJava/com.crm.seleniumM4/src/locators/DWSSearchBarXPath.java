package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DWSSearchBarXPath {
	public static void main(String[] args) throws InterruptedException {
		String expected_result = "https://demowebshop.tricentis.com/";
		ChromeDriver driver = new ChromeDriver();
		//maximize the browser. 
		driver.manage().window().maximize(); 
		// Waiting condition 
		Thread.sleep(3000);
		// enter into dws. 
		driver.get(expected_result);
		String actual_result = driver.getCurrentUrl(); 
		if(expected_result.equals(actual_result)) {
			System.out.println("I'm in dws page");
			WebElement search_field = driver.findElement(By.xpath("//input[@value='Search store']"));
			search_field.sendKeys("iphone");
			Thread.sleep(3000);
			search_field.sendKeys(Keys.RETURN);
			
			Thread.sleep(5000);	
			System.out.println("successfully sent iphone into searchfiled");
			
		}
		else {
			System.out.println("I'm not in dws page");
			driver.close();
		
		}
		
		driver.close();
	}

}
