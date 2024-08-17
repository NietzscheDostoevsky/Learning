package multipleElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class forEachLoop {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
	    driver.get(webShopURL);
	    
	    List<WebElement> products = driver.findElements(By.xpath("//ul[@class='top-menu']/li/a"));
	    
	    products.get(products.size()-1).click();
	    driver.navigate().back();
	    Thread.sleep(2000);
	    for(WebElement web : products) {
	    	web.click();
	    	Thread.sleep(2000);
	    	driver.navigate().back();
	    }
	    
	    
	    List<WebElement> loginMenu = driver.findElements(By.xpath("//div[@class='header-links']/ul/li"));
	    for(WebElement web : loginMenu) {
	    	web.click();
	    	Thread.sleep(2000);
	    	driver.navigate().back();
	    }
	    
	    Thread.sleep(5000);
	    driver.close();
	}

}
