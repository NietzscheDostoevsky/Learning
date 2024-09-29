package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityClasses.BaseClassDWS;

public class ContinuousScrolling extends BaseClassDWS {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/List_of_Hindi_songs_recorded_by_Asha_Bhosle");
		sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Smooth scroll to the bottom of the page using the 'behavior: smooth' option
		String slowScrollScript = """
				window.scrollBy({
				    top: 20,
				    behavior: 'smooth'
				});
		""";

		// Infinite loop with break when end of page is reached
		while (true) {
			js.executeScript(slowScrollScript);
			
			// Check if page has reached the end
			Long scrollPosition = (Long) js.executeScript("return window.pageYOffset + window.innerHeight;");
			Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight;");
			
			if (scrollPosition >= pageHeight) {
				System.out.println("Reached the end of the page.");
				break;
			}
			
			
		}
		sleep(2000);
		driver.quit();
	}
}
