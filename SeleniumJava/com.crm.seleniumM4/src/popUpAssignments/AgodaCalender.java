package popUpAssignments;

import org.openqa.selenium.By;

/*
 * Write a script for Agoda application.   
 * Open the browser.  
 * Maximize().  
 * Enter into Agoda webpage.  
 * Verify the page by using URL.  
 * Select a date inside departure date ie.28 sep 2024.  
 * Select a date inside return date 28 jan 2026.  
 * Close the browser.  
 */

import utilityClasses.BaseClassDWS;

public class AgodaCalender extends BaseClassDWS {
	public static void main(String[] args) {
		String url = "https://www.agoda.com/";
		useChrome(url);
		
		if(driver.getCurrentUrl().contains(url))
			System.out.println("Page verified");
		
		// Departure date. 
		driver.findElement(By.id("check-in-box")).click(); sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Sat Sep 28 2024 ']")).click(); sleep(2000);
		
		// Return date. 
		while(true) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='Tue Aug 26 2025 ']")).click();
				break;
				
			} catch (Exception e) {
				System.out.println("Moving calender to next month");
				driver.findElement(By.xpath("//button[@data-selenium='calendar-next-month-button']")).click();
				sleep(1000);
			}	
		}
		
		// close the browser. 
		postCondition2();
	}
}