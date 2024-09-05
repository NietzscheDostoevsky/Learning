package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class ClickAction extends BaseClassDWS {
	
	public static void main(String[] args) {
		useChrome();
		sleep(3000);
		Actions act = new Actions(driver);
		WebElement register = driver.findElement(By.id("small-searchterms"));
		register.sendKeys("HAHA");
		
		WebElement clickElement = driver.findElement(By.cssSelector("input[type='submit']"));
		act.moveToElement(clickElement).build().perform();
		sleep(2000);
		act.click().build().perform();		
		
		sleep(10000);
		postCondition2();
	}
}
