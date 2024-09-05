package actionClassAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import actionsClass.MyntraHomePage;

public class MyntraHoverMainMenu extends MyntraHomePage {
	public static void main(String[] args) {
		getMyntraInChrome();
		
		WebElement navLinks = driver.findElement(By.className("desktop-navLinks"));
		List<WebElement> menu = navLinks.findElements(By.className("desktop-navContent"));
		
		Actions act = new Actions(driver);
		for (WebElement link : menu) {
			act.moveToElement(link).build().perform();
			sleep(1500);
		}
		
		sleep(3000);
		driver.quit();
		
	}
}
