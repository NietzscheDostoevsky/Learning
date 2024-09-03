package selectClassAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Assignment :  
 * 		Write a script for demo web shop 
 * 		Open and maximize the browser.  
 * 		Enter into dws.  
 * 		Verify the page by using title.  
 * 		Click the digital downloads.  
 * 		Handle sort by display view as drop down menu.  
 * 		Select all the data from first to last.  
 * 		Close the browser.  
 */

public class DWSDigitalDownloadsSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		if(driver.getTitle().equals("Demo Web Shop")) 
			System.out.println("Page verified ✔️");
		driver.findElement(By.xpath("//ul[@class='top-menu']/li[5]")).click();
		Thread.sleep(3000);
		Select sort = new Select(driver.findElement(By.id("products-orderby")));
		List<WebElement> sortOptions = sort.getOptions();
		int indx = 0;
		for (WebElement ele : sortOptions) {
			sort.selectByIndex(indx++);
			Thread.sleep(2000);
			sort = new Select(driver.findElement(By.id("products-orderby")));
			
		}
		Thread.sleep(5000);
		driver.quit();
		
	}

}
