package utilityClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClassDWS {
	protected static WebDriver driver; 
	
	public static void useChrome() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	
	public static void useFirefox() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	
	public static void useEdge() throws InterruptedException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	

	
	public static void postCondition1() {
		System.out.println("Closing browser");
		driver.close();
	}
	
	public static void postCondition2() {
		System.out.println("Quitting session");
		driver.quit();
	}

}


