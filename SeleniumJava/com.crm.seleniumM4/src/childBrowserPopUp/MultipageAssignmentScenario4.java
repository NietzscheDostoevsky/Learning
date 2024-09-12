package childBrowserPopUp;

/*
 * 		a. Open
		b. Max
		c. Verify using title. 
		d. After verifucation, click open food site
		e. Get only the child window URLs 
			Close only the child window urls. 
 */

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilityClasses.BaseClassDWS;

public class MultipageAssignmentScenario4 extends BaseClassDWS {
	public static void main(String[] args) {

		String urlString;
		if (System.getProperty("os.name").equals("Linux"))
			urlString = "file:///home/saurabh-singh/Documents/GitHub/Learning/SeleniumJava/MultipleWindow-1.html";
		else 
			urlString = "C:\\GitHub\\Learning\\SeleniumJava\\MultipleWindow-1.html";
		System.out.println(urlString);
		useChrome(urlString);
		
		WebElement foodSiteButton = driver.findElement(By.cssSelector("[type='button']"));
		
		if(foodSiteButton.isEnabled())
			System.out.println("Button is enabled.");
		
		if (driver.getTitle().equals("Multiple popups"))
			System.out.println("Page verified by Title");
		
		String baseWindowHandle = driver.getWindowHandle();
		
		foodSiteButton.click(); sleep(2000);
		
		Set<String> foodSites = driver.getWindowHandles();
		foodSites.remove(baseWindowHandle);
		
		
		for (var site : foodSites) { 
			driver.switchTo().window(site);
			System.out.println(driver.getCurrentUrl());sleep(1000);
			driver.close();
			sleep(2000);
		}
		postCondition2();
	}
}