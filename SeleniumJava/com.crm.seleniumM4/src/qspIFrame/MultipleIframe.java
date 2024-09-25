package qspIFrame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleIframe {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='w-full h-96']")));
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driver.findElement(By.id("submitButton")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='w-full h-96'])[2]")));
		driver.findElement(By.id("username")).sendKeys("SuperAdmin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("SuperAdmin@1234");
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
