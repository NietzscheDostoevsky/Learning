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
		String urlString = "C:\\GitHub\\Learning\\SeleniumJava\\MultipleWindow-1.html";
		useChrome(urlString);
		
		WebElement foodSiteButton = driver.findElement(By.cssSelector("[type='button']"));
		if(foodSiteButton.isDisplayed())
			System.out.println("Button is Displayed.");
		foodSiteButton.click(); sleep(2000);
		
		Set<String> foodSites = driver.getWindowHandles();
		for (var site : foodSites) { 
			driver.switchTo().window(site);
			//driver.manage().window().maximize(); sleep(2000);			
			if (driver.getCurrentUrl().contains("olivegarden")) {
				driver.manage().window().maximize(); sleep(3000);
				driver.close();
			}			
		}
		
		postCondition2();
	}
}
