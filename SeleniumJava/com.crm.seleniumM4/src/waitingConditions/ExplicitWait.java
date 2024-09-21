package waitingConditions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilityClasses.BaseClassDWS;

public class ExplicitWait extends BaseClassDWS {
	public static void main(String[] args) {
				
		useChrome("https://shoppersstack.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginBtn")));		
		driver.findElement(By.id("loginBtn")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create Account'])")));
		driver.findElement(By.xpath("//span[text()='Create Account'])")).click();
	}
}
