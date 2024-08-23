package utilityClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClassDWS {
	protected static WebDriver driver; 
	
	public static void useChrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		sleep();
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	
	public static void useFirefox()  {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		sleep();
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	
	public static void useEdge()  {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		sleep();
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	
	public static void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("thread pause");
		}
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


