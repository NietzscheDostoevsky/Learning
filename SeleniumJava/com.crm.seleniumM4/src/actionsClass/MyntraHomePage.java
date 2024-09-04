package actionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Utility class to create a driver and goto Myntra homepage. 

public class MyntraHomePage {

	protected static WebDriver driver; 
	
	static String myntra = "https://www.myntra.com/";
	
	protected static void getMyntraInChrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(myntra);
		sleep(3000);
	}
	
	protected static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e){
			
		}
	}
}
