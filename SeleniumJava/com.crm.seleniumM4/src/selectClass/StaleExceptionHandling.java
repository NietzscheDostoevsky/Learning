package selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilityClasses.CrossBrowserTesting;

public class StaleExceptionHandling extends CrossBrowserTesting {

	public static void main(String[] args) throws InterruptedException {
		
		preCondition("chrome");
		if(driver.getTitle().equals("Demo Web Shop")) 
			System.out.println("Page verified ✔️");
		driver.findElement(By.xpath("//ul[@class='top-menu']/li[5]")).click();
		Thread.sleep(3000);
		Select sort = new Select(driver.findElement(By.id("products-orderby")));
		List<WebElement> sortOptions = sort.getOptions();
		int indx = 0;
		for (WebElement ele : sortOptions) {
			sort.selectByIndex(indx++);
			
			//reinitialize to handle stale element exception.
			sort = new Select(driver.findElement(By.id("products-orderby")));
			Thread.sleep(2000);
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
