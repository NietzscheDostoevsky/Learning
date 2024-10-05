package utilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	protected static WebDriver driver;
	protected static ChromeOptions options = new ChromeOptions();
	static {
		 options.addArguments("--headless=new");
	}
	
	public static void useChrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		sleep(1500);
		
	}
	
	public static String getDataFromProperties(String key) {
		
		Properties properties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("./Configure/dwsLogin.properties");
			properties.load(fis);
			return properties.getProperty(key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;

	}
	
	
	public static void useChrome(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		String homeUrl = url;
		driver.get(homeUrl);	
		sleep(3000);
		if(driver.getCurrentUrl().equals(homeUrl))
			System.out.println("Home page fetched");
		else
			System.out.println("check home URL again");
	}
	
	public static void useChromeHeadless() {
		driver = new ChromeDriver(options);
		sleep(1500);
		String homeUrl = "https://demowebshop.tricentis.com/";
		driver.get(homeUrl);	
		
		if(driver.getCurrentUrl().equals(homeUrl))
			System.out.println("DWS page fetched");
		else
			System.out.println("check home URL again");
	}
	
	public static void useChromeHeadless(String url) {
		driver = new ChromeDriver(options);
		sleep(1500);
		String homeUrl = url;
		driver.get(homeUrl);	
		sleep(3000);
		if(driver.getCurrentUrl().equals(homeUrl))
			System.out.println("Home page fetched");
		else
			System.out.println("check home URL again");
	}
	
	public static void useChromeHeadUblock(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("ublockOrigin.crx"));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}
	
	public static void useFirefox()  {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
	}
	
	public static void useEdge()  {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
				
	}
	
	public static void sleep(int ms) {
		try {
			int count = ms/1000;
			System.out.print("Sleeping: " );
			for (int i = count; i >= 0; i--) {
				Thread.sleep(1000);
				System.out.print(i + " ");	
			}
			System.out.println();
		} catch (InterruptedException e) {
			System.out.println("thread pause");
		}
	}
	
	public static void postCondition1() {
		sleep(5000);
		System.out.println("Closing browser");
		driver.close();
	}
	
	public static void postCondition2() {
		sleep(5000);
		System.out.println("Quitting session");
		driver.quit();
	}
}


