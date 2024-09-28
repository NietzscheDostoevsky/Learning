package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityClasses.BaseClassDWS;

public class Scrolling extends BaseClassDWS {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		sleep(3000);
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		sleep(2000);
		js.executeScript("window.scrollBy(0,1500);");
		
		
	}
}
