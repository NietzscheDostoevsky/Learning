package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class LaunchTheBrowser {
	
	@Test
	public void main() {
		System.out.println("open the browser");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
	
	@Test
	public void main2() {
		System.out.println("hahahehe");
	}
}
