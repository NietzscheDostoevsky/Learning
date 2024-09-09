package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class CtrlClick extends BaseClassDWS {
		public static void main(String[] args) {
			useChrome();
			
			WebElement register =  driver.findElement(By.className("ico-register"));
			
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).click(register).perform();;			
			postCondition2();
		}
}
