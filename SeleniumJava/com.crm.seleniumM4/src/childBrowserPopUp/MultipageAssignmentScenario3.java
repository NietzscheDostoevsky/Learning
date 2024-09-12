package childBrowserPopUp;
/*
 * 		a. Open
		b. Max
		c. Verify using URL
		d. Click open food site button. 
		e. Maximize only the barbeque nation 
			i. Click the login button 
			ii. Close only the Olive garden italian restaurant. 
Maximize original italian recipes. 
 */

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilityClasses.BaseClassDWS;

public class MultipageAssignmentScenario3 extends BaseClassDWS {
	public static void main(String[] args) {
		String urlString = "C:\\GitHub\\Learning\\SeleniumJava\\MultipleWindow-1.html";
		useChrome(urlString);
		
		WebElement foodSiteButton = driver.findElement(By.cssSelector("[type='button']"));
		if (driver.getCurrentUrl().equals(urlString)) {
			System.out.println("Correct page. ");
		}
		if(foodSiteButton.isEnabled())
			System.out.println("Button is enabled.");
		foodSiteButton.click(); sleep(5000);	
		
		Set<String> foodSites = driver.getWindowHandles();
		for (var site : foodSites) { 
			driver.switchTo().window(site); sleep(1000);
			driver.manage().window().maximize(); sleep(2000);			
			if (driver.getCurrentUrl().contains("barbequenation")) {
				driver.manage().window().maximize(); sleep(3000);
				driver.findElement(By.linkText("LOGIN")).click(); sleep(3000);	
				
			} else if (driver.getCurrentUrl().contains("giallozafferano")) {
				driver.manage().window().maximize(); sleep(3000);
				
			} else if (driver.getCurrentUrl().contains("olivegarden")) {
				driver.close(); sleep(2000);
			}
		}
		
		postCondition2();
	}
}
