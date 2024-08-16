package relativeXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DWSPollContinuousClick {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
		driver.get(webShopURL);
		WebElement poll = driver.findElement(By.xpath("//strong[text()='Community poll']"));
		
		if(poll.isDisplayed()) {
			System.out.println("I am on dws page");
			
			for (int i = 1; i < 5; i++) {
				String pollId = String.format("pollanswers-%d", i);
				
				WebElement options = driver.findElement(By.id(pollId));
				options.click();
				Thread.sleep(1000);
			}
			
		} else {
			System.out.println("I am not on dws page");
		}
		
		Thread.sleep(5000);
	}
}
