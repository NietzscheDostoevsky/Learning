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
	public void dws() throws InterruptedException {
		
		String aString = "haha";
		String bString = "hehe";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com");		
		Thread.sleep(2000);
		driver.quit();
		assertEquals(aString, bString);
	}
}
