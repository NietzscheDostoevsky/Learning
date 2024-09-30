package shadowDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testShadowDOM {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String url = "https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html";
		driver.get(url);
		
		WebElement content = driver.findElement(By.id("content"));
		SearchContext shadowRoot = content.getShadowRoot();
		WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
		System.out.println(textElement.getText());
		driver.quit();
	}
}
