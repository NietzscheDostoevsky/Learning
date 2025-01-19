package NoKodr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1BasicScript {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://app-staging.nokodr.com/");
		Thread.sleep(3000);
		driver.close(); 
		
		
	}

}
