package popUp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Used to disable all type of notifications. 
public class AvoidNotificationPopup {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.easemytrip.com");
		Thread.sleep(5000);
		driver.quit();
	}
}
