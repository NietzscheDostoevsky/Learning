package testNg;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.listeners.Sample.class)
public class LaunchListerners {

	@Test
	public void google() throws InterruptedException {

		String aString = "haha";
		String bString = "haha";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com");

		driver.quit();
		assertEquals(aString, bString);
	}
	
	@Test
	public void bing() throws InterruptedException {

		String aString = "haha";
		String bString = "hahe";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.bing.com");

		driver.quit();
		assertEquals(aString, bString);
	}
	
	@Test(dependsOnMethods = "bing")
	public void duckduckgo() throws InterruptedException {

		String aString = "haha";
		String bString = "haha";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://duckduckgo.com/");

		driver.quit();
		assertEquals(aString, bString);
	}
}
