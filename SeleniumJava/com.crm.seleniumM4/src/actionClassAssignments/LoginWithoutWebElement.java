package actionClassAssignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class LoginWithoutWebElement extends BaseClassDWS {
	public static void main(String[] args) {
		
		useChrome();
		
		Actions actions = new Actions(driver);
		for (int i = 0; i < 3; i++) {actions.keyDown(Keys.TAB).perform(); sleep(300);}
		actions.sendKeys(Keys.ENTER).perform(); sleep(1000);
		actions.sendKeys("fake@email.com").perform(); sleep(500);
		actions.sendKeys(Keys.TAB).perform(); sleep(200);
		actions.sendKeys("fakePass").perform(); sleep(1000);
		actions.sendKeys(Keys.TAB).perform(); sleep(500);
		actions.sendKeys(Keys.SPACE).perform(); sleep(3000);
		postCondition1();
		
	}
}
