package childBrowserPopUp;

/*
 * 		a. Open the browser. 
		b. Maximize the browser. 
		c. After maximize, enter into multiple window page. 
		d. Verify the page by using WebElement 
		e. Click the open food sites. 
		f. Maximize only Olive Garden Italian restaurant page. 
		  Close this page. 
 */

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilityClasses.BaseClassDWS;

public class MultipageAssignmentScenario2 extends BaseClassDWS {
	public static void main(String[] args) {
		String urlString;
		if (System.getProperty("os.name").equals("Linux"))
			urlString = "file:///home/saurabh-singh/Documents/GitHub/Learning/SeleniumJava/MultipleWindow-1.html";
		else 
			urlString = "C:\\GitHub\\Learning\\SeleniumJava\\MultipleWindow-1.html";
		System.out.println(urlString);
		useChrome(urlString);
		
		WebElement foodSiteButton = driver.findElement(By.cssSelector("[type='button']"));
		if(foodSiteButton.isDisplayed())
			System.out.println("Button is Displayed.");
		foodSiteButton.click(); sleep(2000);
		
		Set<String> foodSites = driver.getWindowHandles();
		for (var site : foodSites) { 
			driver.switchTo().window(site);			
			if (driver.getCurrentUrl().contains("olivegarden")) {
				driver.manage().window().maximize(); sleep(3000);
				driver.close();
			}			
		}
		
		postCondition2();
	}
}
