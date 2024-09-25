package qspIFrame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefaultPage {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='w-full h-96']")));
		driver.findElement(By.id("username")).sendKeys("user");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().defaultContent();
		confirmLogin(driver);
	}
	
	public static void confirmLogin(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//div[@role='status']"));
			System.out.println("Login verified");
		} catch (Exception e) {
			System.out.println("Login NOT successful");
		}
	}
}
