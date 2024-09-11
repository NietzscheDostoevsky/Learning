package popUpAssignments;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DWSFollowLinksAndRegister extends BaseClassDWS {
	public static void main(String[] args) {
				
		useChrome();
		int count = 0; 
		List<WebElement> linksElements = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		Actions actions = new Actions(driver);		
		for (WebElement link : linksElements) {
			actions.keyDown(Keys.CONTROL).click(link).perform(); sleep(2000);
			System.out.println("Link Opened : " +  ++count);
		}
		count = 0;
		Set<String> windowSet = driver.getWindowHandles();
		for (String window : windowSet) {
			driver.switchTo().window(window); sleep(1000);
			if (driver.getCurrentUrl().contains("facebook")) { 
				driver.findElement(By.xpath("//span[text()='Create new account']")).click(); sleep(5000);
				driver.close();
			}
			else if (driver.getCurrentUrl().contains("twitter") || 
					 driver.getCurrentUrl().contains("x.com")) {
				driver.findElement(By.xpath("//span[text()='Create account']")).click(); sleep(5000);
				driver.close();
				
			} else driver.close();
			
			System.out.println("Link closed: " + ++count);
		}
		
		for (var win: driver.getWindowHandles()) {
			driver.switchTo().window(win); sleep(2000);
		}
		postCondition2();	
	}
	

}
