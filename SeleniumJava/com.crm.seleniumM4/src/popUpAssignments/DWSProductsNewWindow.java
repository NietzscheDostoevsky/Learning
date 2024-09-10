package popUpAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DWSProductsNewWindow  extends BaseClassDWS{
	public static void main(String[] args) {
		useChrome();
		Actions actions = new Actions(driver);
		List<WebElement> topBarElements = driver.findElements(By.xpath("//ul[@class='top-menu']/li"));
		for (WebElement link: topBarElements) {
			actions.keyDown(Keys.SHIFT).click(link).perform(); sleep(1000);
			System.out.println("clicked");
		}
		
		postCondition2();
	}
}
