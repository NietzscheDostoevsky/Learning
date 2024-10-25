package chapter03;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SessionID {
	
	WebDriver driver; 
	
	@BeforeMethod
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
//		driver = new ChromeDriver();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void testSessionID() {
		driver.get("https://www.google.com/");
		SessionId sessionId = ((RemoteWebDriver) driver ).getSessionId();
		assertThat(sessionId).isNotNull();
		System.out.println(sessionId);
	}
}
