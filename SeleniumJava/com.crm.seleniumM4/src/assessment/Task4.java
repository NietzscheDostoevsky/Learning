package assessment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Task4 extends DWSBaseClass {
	public static void main(String[] args) {
		createDriver("chrome");
		dwsLogin();
		
		driver.findElement(By.xpath("//ul[@class='top-menu']/li[5]")).click();
		
		Select sortSelect = new Select(driver.findElement(By.id("products-orderby")));
		List<WebElement> sortOptions = sortSelect.getOptions();
		int index = 0; 
		for (WebElement element : sortOptions) {
			sortSelect.selectByIndex(index++);
			sortSelect = new Select(driver.findElement(By.id("products-orderby")));
		}
		dwsLogout();
		postCondition();
	}
}
