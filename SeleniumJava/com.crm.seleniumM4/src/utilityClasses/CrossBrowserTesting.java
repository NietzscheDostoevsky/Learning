package utilityClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTesting {
	
	public static WebDriver driver;
	
	public static void preCondition(String browser) {
		
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else 
			driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		sleep(3000);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);
		sleep(3000);
	}
	
	public static void postCondition(String status) {
		if(status.equalsIgnoreCase("close"))
			driver.close();
		else
			driver.quit();
	}
	
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("thread pause");
		}
	}
}
	

