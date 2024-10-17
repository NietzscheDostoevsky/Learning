package iFrame;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DezLearnNestedIframeExample {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String urlString = "https://www.dezlearn.com/nested-iframes-example/";
		driver.manage().window().maximize();
		driver.get(urlString);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('ml-webforms-popup-3672985').remove();");
		js.executeScript("document.getElementById('ml-webforms-popup-3672985-overlay').remove();");

		System.out.println("Removed popup using js");
		
	}
}
