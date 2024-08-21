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
	    driver.close();
	}

}
