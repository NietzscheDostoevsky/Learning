package chapter02;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorldChromeTestNgTest {
	
	static final Logger log = getLogger(lookup().lookupClass());
	
	WebDriver driver;
	
	@BeforeClass
	public void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void teradown() {
		driver.quit(); 
	}
	
	@Test
	public void test() {
		String url = "https://www.bing.com";
		driver.get(url);
		String title = driver.getTitle();
		log.debug("The title of {} is {}", url, title);
		
		//verify
		assertThat(title).isEqualTo("Google");
	}
}