package actionClassAssignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class OpenBookWithoutWebElement extends BaseClassDWS{
	public static void main(String[] args) {
		useChrome();
		Actions actions = new Actions(driver);
		for (int i = 0; i < 8; i++) {actions.keyDown(Keys.TAB).perform(); sleep(300);}
		actions.sendKeys(Keys.ENTER).perform(); sleep(3000);
		postCondition1();
		
	}
}
