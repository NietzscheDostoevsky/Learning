package basics;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {

	public static void main(String[] args) throws InterruptedException {
		
		// Opening the browser.
		ChromeDriver driver = new ChromeDriver();
		
		// maximize the browser. 
		driver.manage().window().maximize();
		
		// Enter into the demo web shop.
		driver.get("https://demowebshop.tricentis.com/");
		// wait 5 seconds before closing the browser. 
		Thread.sleep(5000);
		driver.close();
		
		
	}

}
