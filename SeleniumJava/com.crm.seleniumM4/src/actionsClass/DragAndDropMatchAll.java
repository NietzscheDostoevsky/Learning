package actionsClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class DragAndDropMatchAll extends BaseClassDWS {

	public static void main(String[] args) {
		String urlString = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
		useChrome(urlString);
		sleep(1000);
		Actions action = new Actions(driver);
		
		List<WebElement> capitals= driver.findElement(By.id("capitals")).findElements(By.cssSelector("div[class='dragableBox']"));
		List<WebElement> countries= driver.findElement(By.id("countries")).findElements(By.cssSelector("div[class='dragableBoxRight']"));
		System.out.println(capitals.size());
		System.out.println(countries.size());
		
		for (WebElement capital : capitals) {
			if (capital.getAttribute("id").contains("box"))
				for (WebElement country: countries) {
					action.dragAndDrop(capital, country).build().perform(); sleep(1000);
					String capitalId = capital.getAttribute("id");
					String color =  driver.findElement(By.id(capitalId)).getAttribute("style");
					if(color.contains("rgb(0, 255, 0)")) break;					
				}
		}
		sleep(5000);
		postCondition2();
	}

}
