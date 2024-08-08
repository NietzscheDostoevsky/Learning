package assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Three {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://x.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.close(); 
		
		
	}

}