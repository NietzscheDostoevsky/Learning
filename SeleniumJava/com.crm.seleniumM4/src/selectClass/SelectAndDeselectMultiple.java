package selectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAndDeselectMultiple {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		String URL = "file:///C:/GitHub/Learning/SeleniumJava/demo.html#";
		driver.get(URL);
		
		Thread.sleep(3000);
		
		WebElement multiSelect = driver.findElement(By.id("multiple_cars"));
		
		Select sel = new Select(multiSelect);
//		sel.selectByVisibleText("Mercedes");
//		sel.selectByVisibleText("BMW");
//		sel.selectByVisibleText("Mini");
		
		WebElement loopSelect = driver.findElement(By.id("standard_cars"));
		Select sel1 = new Select(loopSelect);
		for (int i = 0; i < 12; i++) {
			sel1.selectByIndex(i);
			Thread.sleep(100);
		}
		
		for (int i = 0; i < 12; i++) {
			sel.selectByIndex(i);
			Thread.sleep(200);
		}
		
		Thread.sleep(3000);
		sel.deselectAll();
		
	}

}


