package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathGroupOfIndex {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
	    driver.get(webShopURL);
	    
	    // finding the newsletter and entering text into it . 
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Hello");
	    

	}

}