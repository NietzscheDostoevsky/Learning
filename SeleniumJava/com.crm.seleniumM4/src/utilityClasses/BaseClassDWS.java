package utilityClasses;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassDWS {
	protected static ChromeDriver driver; 
	
	public static void preCondition() throws InterruptedException {
		driver = new ChromeDriver();
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


