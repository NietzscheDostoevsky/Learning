package popUpAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DWSFollowLinksNewWindow extends BaseClassDWS{
	public static void main(String[] args) {
		useChrome();
		sleep(1000);
		if(driver.findElement(By.className("rightside-3")).isDisplayed())
			System.out.println("Page verified by element. ");

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.PAGE_DOWN).perform();sleep(500);
		
		List<WebElement> linksElements = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		System.out.println(linksElements);
		
		int count = 0;
		for (WebElement link : linksElements) {
			//link.click(); 
			sleep(1000);
			actions.keyDown(Keys.SHIFT).click(link).perform(); 
			System.out.println("Clicked link: " + ++count);
			sleep(1000);
		}
		
		postCondition2();
	}

}
