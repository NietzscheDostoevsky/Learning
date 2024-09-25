package qspIFrame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedInMultipleIframe {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/frames/nestedWithMultiple?sublist=3");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='w-full h-96']")));
		driver.switchTo().frame(driver.findElement(By.xpath("(//div[@class='form_container'])[2]/iframe")));
		
		driver.switchTo().frame(driver.findElement(By.xpath("(//div[@class='form-group'])[1]/iframe")));
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("(//div[@class='form-group'])[2]/iframe")));
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("(//div[@class='form-group'])[3]/iframe")));
		driver.findElement(By.id("confirm")).sendKeys("Admin@1234");
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("(//div[@class='form-group'])[4]/iframe")));
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
