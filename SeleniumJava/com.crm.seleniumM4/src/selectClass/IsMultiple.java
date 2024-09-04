package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IsMultiple {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		String URL = "file:///C:/GitHub/Learning/SeleniumJava/demo.html#";
		driver.get(URL);
		
		Thread.sleep(3000);
		
		WebElement multiSelect = driver.findElement(By.id("multiple_cars"));
		Select sel = new Select(multiSelect);
		System.out.println(sel.isMultiple()); // true
		
		if(sel.isMultiple()) {
			sel.selectByIndex(3);
			Thread.sleep(3000);
			sel.deselectByIndex(3);
		} else {
			System.out.println("Not multi select");
		}
		
		driver.quit();
	}


}
