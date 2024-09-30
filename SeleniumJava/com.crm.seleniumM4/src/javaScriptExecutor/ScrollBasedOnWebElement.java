package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityClasses.BaseClassDWS;

public class ScrollBasedOnWebElement extends BaseClassDWS {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.redbus.in");
		driver.get("https://www.reddit.com");
		sleep(3000);
		JavascriptExecutor  js = (JavascriptExecutor) driver;
//		WebElement bookTrain =  driver.findElement(By.linkText("Book Train Tickets"));
//		js.executeScript("arguments[0].scrollIntoView(false);", bookTrain);
		//sleep(3000);
		String script = """
					window.scrollBy(0, 100);
				""";
		while(true) {
			js.executeScript(script);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
