package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class ClickAndHold extends BaseClassDWS {

	public static void main(String[] args) {
		String urlString = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
		useChrome(urlString);
		sleep(1000);
		Actions action = new Actions(driver);
		WebElement rome = driver.findElement(By.id("box6"));
		action.clickAndHold(rome).build().perform();
		WebElement italy = driver.findElement(By.id("box106"));
		sleep(1200);
		action.release(italy).build().perform();
	}

}
