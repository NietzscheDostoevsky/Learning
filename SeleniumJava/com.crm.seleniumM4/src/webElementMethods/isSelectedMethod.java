package webElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isSelectedMethod {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
	    
	    driver.navigate().to(webShopURL);
	    WebElement excellent = driver.findElement(By.id("pollanswers-1"));
	    excellent.click();
	    
	    
	    if (excellent.isSelected())
	    	System.out.println("Elenebt is selected....");
	    else 
	    	System.out.println("Element is not seoelcted...");
	    
	    driver.close();
	}

}
