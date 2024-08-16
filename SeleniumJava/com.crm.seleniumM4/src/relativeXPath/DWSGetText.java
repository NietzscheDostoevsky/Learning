package relativeXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DWSGetText {
	public static void main(String[] args) throws InterruptedException {
		String expected_result = "https://demowebshop.tricentis.com/";
		ChromeDriver driver = new ChromeDriver();
		//maximize the browser. 
		driver.manage().window().maximize(); 
		// Waiting condition 
		Thread.sleep(3000);
		// enter into dws. 
		driver.get(expected_result);
		String actual_result = driver.getCurrentUrl(); 
		if(expected_result.equals(actual_result)) {
			System.out.println("I'm in dws page");
			//WebElement commPoll = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/strong"));
			WebElement commPoll = driver.findElement(By.linkText("Community poll"));
			System.out.println(commPoll.getText());
			
		}
		else {
			System.out.println("I'm not in dws page");
			driver.close();
		
		}
		
		driver.close();
	}

}
