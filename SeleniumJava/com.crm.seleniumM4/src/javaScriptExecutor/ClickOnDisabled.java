package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityClasses.BaseClassDWS;

public class ClickOnDisabled extends BaseClassDWS{
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.oracle.com/in/java/technologies/downloads/");
		sleep(3000);
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		WebElement jdk =  driver.findElement(By.linkText("jdk-8u421-linux-x64.rpm"));
		js.executeScript("arguments[0].scrollIntoView(false);", jdk);
		sleep(2000);
		jdk.click();
		sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.linkText("Download jdk-8u421-linux-x64.rpm")));
		
	}
}
