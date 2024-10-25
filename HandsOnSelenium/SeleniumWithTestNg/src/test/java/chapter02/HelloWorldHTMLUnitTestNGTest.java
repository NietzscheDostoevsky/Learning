package chapter02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloWorldHTMLUnitTestNGTest {
	
	WebDriver driver; 
	
	@BeforeMethod
	public void setup() {
		driver = new HtmlUnitDriver();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit(); 
	}
	
	@Test
	public void test() {
		String url = "https://www.bing.com";
		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);
	}
}
