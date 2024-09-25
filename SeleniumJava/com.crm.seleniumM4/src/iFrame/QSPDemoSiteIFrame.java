package iFrame;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QSPDemoSiteIFrame {
	public static void main(String[] args) {
		String baseURL = "https://demoapps.qspiders.com/ui/frames?sublist=0";
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
//		driver.findElements(By.xpath("//div[@class='pt-16']/div/ul/li/a")).forEach(page -> {
//			page.click();
//			
//		});
		List<WebElement> pages = driver.findElements(By.xpath("//div[@class='pt-16']/div/ul/li/a"));
		
		//Page 1
		driver.switchTo().frame(0);
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().defaultContent();
		verifyLoginButton(driver);
		
		
		//Page 2
		pages.get(1).click();
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().defaultContent();
		verifyLoginButton(driver);
		
	}
	
	public static boolean verifyLoginButton(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//div[@role='status']"));
			System.out.println("Login successfull");
			return true;
		} catch (Exception e) {
			System.out.println("Wrong credentials");
			return false;
		}
	}
}
