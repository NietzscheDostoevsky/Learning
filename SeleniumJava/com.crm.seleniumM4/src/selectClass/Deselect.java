package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Deselect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		String URL = "file:///C:/GitHub/Learning/SeleniumJava/demo.html#";
		driver.get(URL);
		
		Thread.sleep(3000);
		
		WebElement multiSelect = driver.findElement(By.id("multiple_cars"));
		
		Select sel = new Select(multiSelect);
		sel.selectByVisibleText("Jaguar");
		Thread.sleep(3000);
		sel.deselectByVisibleText("Jaguar");
		Thread.sleep(3000);
		sel.selectByIndex(1);
		Thread.sleep(3000);
		sel.deselectByIndex(1);
		Thread.sleep(3000);
		sel.selectByValue("bmw");
		Thread.sleep(3000);
		sel.deselectByValue("bmw");
		
	}

}
