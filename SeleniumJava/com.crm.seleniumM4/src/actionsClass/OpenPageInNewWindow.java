package actionsClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class OpenPageInNewWindow extends BaseClassDWS {
	public static void main(String[] args) {
		useChrome();
		//WebElement booksElement = driver.findElement(By.linkText("Books"));
		Actions actions = new Actions(driver);
//		sleep(3000);
//		actions.keyDown(Keys.SHIFT).click(booksElement).perform();
		
		
		
		for (int i = 0; i < 8; i++) {actions.keyDown(Keys.TAB).perform(); sleep(300);}
		actions.keyUp(Keys.TAB).perform(); sleep(1000);
		actions.keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).perform();
		postCondition2();
		
	}
}
