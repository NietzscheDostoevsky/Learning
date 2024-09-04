package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String myntra = "https://www.myntra.com/";
		driver.get(myntra);
		
		if (driver.getCurrentUrl().equals(myntra)) {
			System.out.println("I am in myntra page");
			
			Actions act = new Actions(driver);
			Thread.sleep(3000);
			WebElement men = driver.findElement(By.xpath("//a[@data-reactid='21']"));
			act.moveToElement(men).build().perform();
			
			
		} else {
			System.out.println("I am not in myntra page");
			driver.quit();
		}
			

	}

}
