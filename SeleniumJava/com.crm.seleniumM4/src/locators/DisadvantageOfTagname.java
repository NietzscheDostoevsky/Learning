package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisadvantageOfTagname {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();		
		String url = "https://demowebshop.tricentis.com/";
		driver.get(url);
		
		String fetched_url = driver.getCurrentUrl();
		if(url.equals(fetched_url)) {
			System.out.println("I am on DWS Website");
			
			Thread.sleep(2000);
			// going to register page by clicking on register
			driver.findElement(By.className("ico-register")).click();
			Thread.sleep(10000);
			
		}
		else {
			System.out.println("I am not on dws websiite");
			driver.close();
		}
		
		driver.close();
		
		

	}

}
