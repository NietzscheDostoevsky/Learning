package childBrowserPopUp;

/*
 * 	1. Write a script for DWS webpage. 
		a. Open the browser. 
		b. Maximize the browser. 
		c. Enter into DWS website. 
		d. Verify the page by using URL. 
		e. After verification, click all 5 links. 
			Ø FB, twitter, … google. 
				Perform an action, any single action, read all text of RSS. 
 */

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DWSFollowLinksAnyOneAction extends BaseClassDWS {
	public static void main(String[] args) {
				
		useChrome();
		String parentHandle = driver.getWindowHandle();
		List<WebElement> linksElements = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		Actions actions = new Actions(driver);	
		for (WebElement link : linksElements) {
			actions.keyDown(Keys.SHIFT).click(link).perform(); sleep(5000);
			List<String> windows = new ArrayList<String>(driver.getWindowHandles()); 
			driver.switchTo().window(windows.get(1));
			String currentURL = driver.getCurrentUrl();
			System.out.println("Link Opened : " +  currentURL );
			
			try {
				if (currentURL.contains("facebook")) { 
					driver.findElement(By.xpath("//span[text()='Create new account']")).click(); sleep(3000);
					driver.close();
				} else if (currentURL.contains("twitter") || 
						 driver.getCurrentUrl().contains("x.com")) {
					sleep(3000);
					driver.findElement(By.xpath("//span[text()='Create account']")).click(); sleep(5000);
					driver.close();				
				} else if (currentURL.contains("rss")) {
					String webtextString = driver.findElement(By.xpath("/html/body/pre")).getText(); sleep(2000);
					System.out.println(webtextString.substring(0, 100));
					driver.close();
					
				} else if (currentURL.contains("youtube")) {
					driver.findElement(By.id("logo-icon")).click(); sleep(5000);
					driver.close();
					
				} else if (currentURL.contains("google")) {
					driver.findElement(By.id("mce-EMAIL")).sendKeys("fake@email.com"); sleep(5000);
					driver.close();				
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			// Closing unrequired windows. 
			for (var w: driver.getWindowHandles())
				if (!w.equals(parentHandle))
					driver.switchTo().window(w).close();
			
			driver.switchTo().window(parentHandle);
			System.out.println("Switched to : " + driver.getCurrentUrl());
			System.out.println(); sleep(3000);
		}			
		postCondition2();	
	}
}