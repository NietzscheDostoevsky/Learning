package testcaseExecution1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DWS {
	
	@Parameters("url")
	@Test(groups = "integration", enabled = true)
	public void dws(String url) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		Thread.sleep(2000);
		driver.quit();
	}
}
