package testing;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolSize {
	int cores = Runtime.getRuntime().availableProcessors();
	@Test(priority = 'c', invocationCount = 4, threadPoolSize = 8 )
	public void csk() throws InterruptedException {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Cores: " + cores);
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.get("https://512kb.club/");
		Thread.sleep(2000);
		driver.quit();
	}
}
