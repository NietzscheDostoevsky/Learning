package envSmoke;

import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTestDependencies {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.close();
	}
}
