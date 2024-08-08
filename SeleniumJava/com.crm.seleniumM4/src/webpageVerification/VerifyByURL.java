package webpageVerification;

import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyByURL {

	public static void main(String[] args) throws InterruptedException {
		//Open the browser. 
		String expected_result = "https://demowebshop.tricentis.com/";
		ChromeDriver driver = new ChromeDriver();
		//maximize the browser. 
		driver.manage().window().maximize(); 
		// Waiting condition 
		Thread.sleep(3000);
		// enter into dws. 
		driver.get(expected_result);
		String actual_result = driver.getCurrentUrl(); 
		if(expected_result.equals(actual_result))
			System.out.println("I'm in dws page");
		else
			System.out.println("I'm not in dws page");	
		
		driver.close();
	}

}
