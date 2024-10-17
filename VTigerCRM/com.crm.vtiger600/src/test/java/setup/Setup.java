package setup;

import static com.crm.utility.PropertiesFile.property;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Setup {

	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(property("url"));
	}

	@BeforeMethod
	public void login() {
		driver.findElement(By.name("user_name")).sendKeys(property("username"));
		driver.findElement(By.name("user_password")).sendKeys(property("password"));
		driver.findElement(By.id("submitButton")).click();
	}

	@Test
	public void setup() {
		System.out.println("Login successful");
	}
	
	@AfterMethod
	public void logout()  {
		driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
	}
	
	@AfterClass
	public void postCondition() {
		driver.quit();
	}

}
