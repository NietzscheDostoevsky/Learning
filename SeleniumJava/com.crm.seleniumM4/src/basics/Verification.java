package basics;

import org.openqa.selenium.chrome.ChromeDriver;

public class Verification {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://demowebshop.tricentis.com/";
		driver.get(url);
		
		String resultURL = driver.getCurrentUrl();
		Thread.sleep(3000);
		if (resultURL.equals(url)) {
			System.out.println("I am on DWS page");
			Thread.sleep(5000);
			
		} else {
			System.out.println("I am not on dws page");
		}
		
		Thread.sleep(5000);
		driver.close();
	}

}
