package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class RightClickDemoWebShop extends BaseClassDWS {

	public static void main(String[] args) {
		
		useChrome();
		sleep(3000);
		Actions act = new Actions(driver);
		WebElement register = driver.findElement(By.className("ico-register"));
		act.moveToElement(register).build().perform();
		sleep(2000);
		act.contextClick().build().perform();		
		
		sleep(10000);
		postCondition2();
	}

}
