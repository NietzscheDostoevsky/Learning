package popUpAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/*
 * Write a script for RedBus website.  
 * Open the browser.  
 * Maximize() 
 * Enter into redbus.  
 * Verify the page by using title.  
 * After verification, fill all the details of from and to.  
 * Can choose any details.  
 * In date, click 27 sep and search the bus.
 */

import utilityClasses.BaseClassDWS;

public class RedBusCalender extends BaseClassDWS{
	public static void main(String[] args) {
		String url = "https://www.redbus.in/" ;
		
		useChrome(url);
		if(driver.getTitle().equals("Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus"))
			System.out.println("Page verified by title");
		
		driver.findElement(By.id("src")).sendKeys("Pune"); sleep(2000);  
		driver.findElement(By.id("src")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("dest")).sendKeys("Mumbai"); sleep(2000);  
		driver.findElement(By.id("dest")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("onwardCal")).click(); sleep(2000);  
		driver.findElement(By.xpath("//span[text()=27]")).click();
		
		// Close the browser. 
		postCondition2();
	}

}

//span[contains(text(),'26')]