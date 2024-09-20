package bookMyShow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	
	static WebDriver driver; 
	static ChromeOptions options = new ChromeOptions();
	
	public static void useChrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize(); sleep(1000);
		String url = "https://in.bookmyshow.com/";
		driver.get(url);
		System.out.println("Got url: " + driver.getCurrentUrl());
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
