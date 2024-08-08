package webpageVerification;

import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyByURL {

	public static void main(String[] args) throws InterruptedException {
		//Open the btowser. 
		ChromeDriver driver = new ChromeDriver(); 
		//maximize the browser. 
		driver.manage().window().maximize(); 
		// Waiting condition 
		Thread.sleep(5000);
		// enter into dws. 
		driver.get("https://demowebshop.tricentis.com/");
		

	}

}
