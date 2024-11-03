package chapter03;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsByChained {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void testByChained() {
		driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
		List<WebElement> rowsInForm = driver.findElements(new ByChained(By.tagName("form"), By.className("row")));
		System.out.println(rowsInForm.size());
		assertThat(rowsInForm.size()).isEqualTo(1);
	}
	
	@Test
	public void testByAll() {
		driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
		List<WebElement> rowsInForm = driver.findElements(new ByAll(By.tagName("form"), By.className("row")));
		System.out.println(rowsInForm.size());
		assertThat(rowsInForm.size()).isEqualTo(5);
	}
}
