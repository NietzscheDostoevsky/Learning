package actionsClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class Scrolling extends BaseClassDWS{

	public static void main(String[] args) {
		
		useChrome();
		
		Actions action = new Actions(driver);				sleep(2000);
		action.keyDown(Keys.PAGE_DOWN).build().perform();	sleep(2000);
		action.keyDown(Keys.PAGE_UP).build().perform(); 	sleep(3000);
		postCondition2();
	}

}
