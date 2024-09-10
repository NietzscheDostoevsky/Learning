package popUp;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class GetWindowHandle extends BaseClassDWS {

	public static void main(String[] args) {
		
		useChrome();
		sleep(2000);
		String parentString = driver.getWindowHandle();
		System.out.println(parentString);
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.PAGE_DOWN).perform();sleep(200);
		actions.keyDown(Keys.PAGE_DOWN).perform();sleep(2000);
		String rss = "https://demowebshop.tricentis.com/news/rss/1";
		
		List<WebElement> linksElements = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		for (WebElement linkElement : linksElements) {
			linkElement.click(); sleep(1000);			
			if(driver.getCurrentUrl().equals(rss))
				driver.navigate().back();
			sleep(500);
		}
		
		
		
		Set<String> childSet = driver.getWindowHandles();
		System.out.println(childSet);
		postCondition2();

	}

}
