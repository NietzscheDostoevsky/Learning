package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DragAndDrop extends BaseClassDWS{

	public static void main(String[] args) {
		
		String urlString = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
		useChrome(urlString);
		sleep(1000);
		Actions action = new Actions(driver);
		
		int totalBoxes = driver.findElements(By.cssSelector("div[class='dragableBox']")).size();
		
		for (int i = 1; i <= totalBoxes/2; i++) {
			WebElement sourcElement = driver.findElement(By.id("box" + i));
			WebElement targetElement = driver.findElement(By.id("box10" + i));
			dragAndDropBoxes(action, sourcElement, targetElement);
		}
		sleep(5000);
		postCondition2();
	}
	
	public static void dragAndDropBoxes(Actions action, WebElement source, WebElement target) {
		action.dragAndDrop(source, target).build().perform();
		sleep(1500);
	}

}
