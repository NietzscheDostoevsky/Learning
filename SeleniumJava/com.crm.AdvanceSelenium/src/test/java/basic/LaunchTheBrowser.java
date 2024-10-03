package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTheBrowser {
	public static void main(String[] args) {
		//Open the browser. 
		WebDriver driver = new ChromeDriver();
		driver.quit();
		
	}
}
