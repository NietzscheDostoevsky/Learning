package childBrowserPopUp;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * 		a. Open the browser. 
		b. Maximize the browser. 
		c. Enter into Multiple Window Page. 
		d. Check whether that open food sites button is enabled or not. 
		e. Click open food sites. 
			i. It will open 3 windows. 
			ii. Maximize all 3 windows. 
		f. Minimize the parent page. 
			Close the parent page. 
 */

import utilityClasses.BaseClassDWS;

public class MultipageAssignmentScenario1 extends BaseClassDWS {
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
		foodSiteButton.click(); sleep(10000);
		
		Set<String> foodSites = driver.getWindowHandles();
		for (var site : foodSites) { 
			driver.switchTo().window(site);
			driver.manage().window().maximize(); sleep(2000);			
			if (driver.getCurrentUrl().equals(urlString)) {
				driver.manage().window().minimize(); sleep(1000);
				driver.close();
			}			
		}
		postCondition2();
	}
}