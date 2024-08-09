package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassNameDrawback {

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
			.findElement(By.className("search-box-text"))
			.sendKeys("iPhone");
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
