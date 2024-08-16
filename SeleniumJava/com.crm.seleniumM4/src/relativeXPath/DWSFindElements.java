package relativeXPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DWSFindElements {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
		driver.get(webShopURL);
		WebElement poll = driver.findElement(By.xpath("//strong[text()='Community poll']"));
		
		if(poll.isDisplayed()) {
			System.out.println("Im in demo webshop");
			List<WebElement> commPoll = driver.findElements(By.xpath("//input[@type='radio']"));
			for (WebElement e: commPoll) {
				e.click();
				Thread.sleep(1000);
			}
			
		} else {
			System.out.println("I am not on dws page");
		}
		
		Thread.sleep(5000);
	}
}
