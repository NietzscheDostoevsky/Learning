package actionsClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class SendValuesWithoutWebElement extends BaseClassDWS {
	
	public static void main(String[] args) {
		 useChrome();
		 
		 Actions actions = new Actions(driver);
		 for (int i = 0; i < 6; i++) { actions.keyDown(Keys.TAB).perform(); sleep(500);}
		 actions.sendKeys("search for this"); sleep(1000);
		 actions.keyDown(Keys.ENTER).perform();  
		 sleep(5000);
		 
		 postCondition2();
	}
}
