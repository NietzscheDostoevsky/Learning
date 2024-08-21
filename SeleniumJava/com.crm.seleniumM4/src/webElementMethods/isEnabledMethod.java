package webElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isEnabledMethod {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
	    
	    driver.navigate().to(webShopURL);
	    WebElement searchField = driver.findElement(By.id("small-searchterms"));	    
	    
	    if (searchField.isEnabled()) {
	    	System.out.println("Elenebt is enabled....");
	    	searchField.sendKeys("iPHone");
	    } else  {
	    	System.out.println("Element is not seoelcted...");
	    	driver.close();
	    }
	    Thread.sleep(5000);
	    driver.close();
	}

}
