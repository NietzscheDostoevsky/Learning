package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class OpenPageInNewWindow extends BaseClassDWS {
	public static void main(String[] args) {
		useChrome();
		WebElement booksElement = driver.findElement(By.linkText("Books"));
		Actions actions = new Actions(driver);
		sleep(3000);
		actions.keyDown(Keys.SHIFT).click(booksElement).perform();
		postCondition2();
		
	}
}
