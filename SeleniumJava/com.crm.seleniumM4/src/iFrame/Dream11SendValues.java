package iFrame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dream11SendValues {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String baseURL = "https://www.dream11.com/";
		driver.get(baseURL);
		
//		driver.switchTo().frame(0);
//		driver.switchTo().frame("send-sms-iframe");
		driver.switchTo().frame(driver.findElement(By.id("send-sms-iframe")));
		driver.findElement(By.id("regEmail")).sendKeys("7878787878");
//		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("menu_parent")).click();
		
	}
}
