package usingUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilityClasses.BaseClassDWS;

public class DWSFollowLinks extends BaseClassDWS {

	public static void main(String[] args) {
		
		useChrome();
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		for (WebElement link : links) {
			
			String rssLink = "https://demowebshop.tricentis.com/news/rss/1";
			link.click();
			System.out.println("clicked");
			if(rssLink.equals(driver.getCurrentUrl()))
				driver.navigate().back();		
			sleep(2000);
		}
		
		postCondition2();
	}
}
