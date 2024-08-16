package relativeXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyUsingWebElementIsDisplayedMethod {
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String webShopURL = "https://demowebshop.tricentis.com/";
		driver.get(webShopURL);
		WebElement poll = driver.findElement(By.xpath("//strong[text()='Community poll']"));
		
		if(poll.isDisplayed()) {
			System.out.println("I am on dws page");
		} else {
			System.out.println("I am not on dws page");
		}
	}
}
