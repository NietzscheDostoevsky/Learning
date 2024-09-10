package popUpAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DWSHeaderLinksNewTab extends BaseClassDWS{
	public static void main(String[] args) {
		useChrome();
		
		if(driver.findElement(By.className("rightside-3")).isDisplayed())
			System.out.println("Page verified by element. ");
	
		Actions actions = new Actions(driver);
		List<WebElement> headerLinks = driver.findElements(By.xpath("//div[@class='header-links-wrapper']/div/ul/li"));	
		System.out.println("Total elements: " + headerLinks.size());
		for (WebElement link: headerLinks) {
			actions.keyDown(Keys.CONTROL).click(link).perform(); sleep(1000);
			System.out.println("clicked");
		}
		
		postCondition2();
	}
}
