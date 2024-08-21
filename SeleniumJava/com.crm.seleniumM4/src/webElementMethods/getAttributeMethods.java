package webElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getAttributeMethods {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
	    //driver.get(webShopURL);
	    
	    driver.navigate().to(webShopURL);
	    WebElement searchField = driver.findElement(By.name("q"));
	    String attributeValue = searchField.getAttribute("id");
	    System.out.println(attributeValue);
	    
	    String data = "iPhone";
	    searchField.sendKeys(data);
	    if (searchField.getAttribute("value").equals(data))
	    	System.out.println("Succesfully passed the data");
	    else 
	    	System.out.println("data passing unsuccessfull");
	    
	    driver.close();
	}

}
