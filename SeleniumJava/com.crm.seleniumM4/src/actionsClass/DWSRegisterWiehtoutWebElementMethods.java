package actionsClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DWSRegisterWiehtoutWebElementMethods extends BaseClassDWS {
	public static void main(String[] args) {
		
		useChrome();
		Actions actions = new Actions(driver);
		for (int i = 0; i < 2; i++) {actions.keyDown(Keys.TAB).perform(); sleep(300);}
		actions.sendKeys(Keys.ENTER).perform();
		for (int i = 0; i < 25; i++) {actions.keyDown(Keys.TAB).perform(); sleep(100);}
		actions.sendKeys(Keys.SPACE).perform(); 
		actions.sendKeys(Keys.TAB).perform(); sleep(500);
		actions.sendKeys("fakeFirstName").perform();
		actions.sendKeys(Keys.TAB).perform(); sleep(500);
		actions.sendKeys("fakeLastName").perform();
		actions.sendKeys(Keys.TAB).perform(); sleep(500);
		actions.sendKeys("fake@email.com").perform();
		actions.sendKeys(Keys.TAB).perform(); sleep(500);
		actions.sendKeys("fakePass").perform();
		actions.sendKeys(Keys.TAB).perform(); sleep(500);
		actions.sendKeys("fakePass").perform();
		actions.sendKeys(Keys.TAB).perform(); sleep(500);
		actions.sendKeys(Keys.ENTER); sleep(2000);
		
		
		postCondition2();
	}
}
