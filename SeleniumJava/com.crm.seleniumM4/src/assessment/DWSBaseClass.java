package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DWSBaseClass {
	protected static WebDriver driver;
	
	public static void createDriver(String browser) {
		
		if (browser.toLowerCase().contains("chrome"))
			driver = new ChromeDriver();
		else if (browser.toLowerCase().contains("firefox"))
			driver = new FirefoxDriver();
		else if (browser.toLowerCase().contains("edge"))
			driver = new EdgeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);	
		
		if(driver.getCurrentUrl().equals(homeUrl))
			System.out.println("DWS page fetched");
		else
			System.out.println("check home URL again");
	}
	
	public static void dwsLogin() {
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("admin01");
		driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
	}
	
	public static void dwsLogout() {
		driver.findElement(By.className("ico-logout")).click();
	}
	
	public static void postCondition() {
		driver.quit();
	}
	
}
