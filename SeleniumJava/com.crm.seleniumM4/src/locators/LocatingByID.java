package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByID {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		String url = "https://demowebshop.tricentis.com/";
		
		driver.manage().window().maximize();
		driver.get(url);
		
		if(driver.getCurrentUrl().equals(url)) {
			System.out.println("I am on DWS Website");
			
			Thread.sleep(2000);
			
			driver
			//.findElement(By.className("search-box-text ui-autocomplete-input"))
			// don't use it if there are spaces present in className. 
			// it is showing multiple class names. 
			.findElement(By.id("small-searchterms"))
			.sendKeys("iPhone");
			WebElement search = driver.findElement(By.id("small-searchterms"));
			Thread.sleep(3000);
			search.sendKeys(Keys.RETURN);
			
			Thread.sleep(5000);
			driver.close();
			
		}
		else {
			System.out.println("I am not on dws websiite");
			driver.close();
		}
		
		driver.close();

	}

}
