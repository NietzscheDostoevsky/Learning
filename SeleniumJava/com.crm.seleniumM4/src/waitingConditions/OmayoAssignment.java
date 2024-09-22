package waitingConditions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * Assignments.  
 * Write a script for Omayo.blogspot  
 * Open the browser.  
 * Max().  
 * Verify the page by using URL.  
 * Do scroll down action.  
 * Click dropdown menu.  
 * After clicking, click fb option.  
 * Click timer enabled button.  
 * Get the text of the popup, and handle the popup.  
 * Close the browser.  
 * Should not use any Thread.sleep() 
 */

public class OmayoAssignment {
	public static void main(String[] args) {
		String baseURL = "https://omayo.blogspot.com/";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		// Verification
		if(driver.getCurrentUrl().contains(baseURL))
			System.out.println("Page verified");
		
		driver.findElement(By.className("title")).click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		
		driver.findElement(By.className("dropbtn")).click();
		driver.findElement(By.linkText("Facebook")).click();
		driver.navigate().back();
		
		if(driver.findElement(By.id("timerButton")).isEnabled())
			System.out.println("button enabled");
		else 
			System.out.println("button not enalbed yet");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.withMessage("waiting");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("timerButton")));
		driver.findElement(By.id("timerButton")).click();
		System.out.println("popup text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println("Test successfull");
		driver.quit();
		
	}
}
