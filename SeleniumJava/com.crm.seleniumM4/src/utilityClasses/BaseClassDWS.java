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
		sleep(1500);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);	
		
		if(driver.getCurrentUrl().equals(homeUrl))
			System.out.println("DWS page fetched");
		else
			System.out.println("check home URL again");
	}
	
	public static void useChrome(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		sleep(1500);
		String homeUrl = url;
		driver.get(homeUrl);	
		sleep(3000);
		if(driver.getCurrentUrl().equals(homeUrl))
			System.out.println("Home page fetched");
		else
			System.out.println("check home URL again");
	}
	
	public static void useFirefox()  {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		sleep(3000);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	
	public static void useEdge()  {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		sleep(3000);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);		
	}
	
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("thread pause");
		}
	}
	
	public static void postCondition1() {
		System.out.println("Closing browser");
		driver.close();
	}
	
	public static void postCondition2() {
		sleep(5000);
		System.out.println("Quitting session");
		driver.quit();
	}
}


