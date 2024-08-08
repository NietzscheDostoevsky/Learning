package webpageVerification;

import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {
	public static void main(String[] args) {
		String expectedURL = "https://www.redbus.in/";
		ChromeDriver driver = new ChromeDriver(); 
		driver.get(expectedURL);
		driver.manage().window().maximize();
		
		String actualURL = driver.getCurrentUrl(); 
		System.out.println(expectedURL.equals(actualURL) ? "Same Same" : "Not same");

		driver.close();	
		
	}
}
