package shoppersStack;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppersStackLoginRegister {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		String shopperURL = "https://shoppersstack.com/";
		driver.get(shopperURL);
		Thread.sleep(30000);
		driver.findElement(By.id("loginBtn")).click();

	}

}
