package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathContainsFunction {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
	    driver.get(webShopURL);
	    
	    // finding the GiftCard from the banner using XPath contains function. 
	    driver.findElement(By.xpath("//a[contains(text(), 'Gift Cards')]")).click();
	    

	}

}
