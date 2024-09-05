package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DoubleClick extends BaseClassDWS {
	
public static void main(String[] args) {
		
	
		String homeURL = "https://demoqa.com/buttons";
		useChrome(homeURL);
		sleep(3000);
		Actions act = new Actions(driver);
		WebElement button = driver.findElement(By.id("doubleClickBtn"));
		act.moveToElement(button).build().perform();
		sleep(5000);
		act.doubleClick().build().perform();
		
		sleep(10000);
		postCondition2();
	}

}
